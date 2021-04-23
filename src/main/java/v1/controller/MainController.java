package v1.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import v1.config.AppProperties;
import v1.exceptions.BadUriException;
import v1.facade.ChildFacade;
import v1.facade.NurseryFacade;
import v1.facade.ParentFacade;
import v1.model.Child;
import v1.model.Nursery;
import v1.model.Parent;

@RestController
// We also authorize XML because JSON is 🥴
@RequestMapping(
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
		)
@CrossOrigin("*")
public class MainController {
	
	@Autowired
	ParentFacade parentFacade;
	
	@Autowired
	ChildFacade childFacade;
	
	@Autowired
	NurseryFacade nurseryFacade;
	
	@Autowired
	AppProperties appProperties;
	
	@PostMapping("/register")
	public ResponseEntity<Parent> register(@RequestBody Parent givenUser, HttpServletRequest request) {
		try {
			Child child = childFacade.createChild(null, givenUser.getChild().getFirstName(), givenUser.getChild().getDate());
			Parent newUser = parentFacade.register(givenUser.getLogin(), givenUser.getPassword(), child);
			
			HttpHeaders responseHeader = new HttpHeaders();
			responseHeader.setLocation(new URI("http://" + request.getRemoteHost() + "/parent/" + newUser.getLogin()));
			
			return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeader).body(newUser);
		} catch (URISyntaxException e) {
			throw new BadUriException();
		}		
		
	}
	
	@PutMapping("/child/{id}")
	public ResponseEntity<Child> updateChild(@PathVariable long id, @RequestBody Child child) {
		childFacade.updateChild(id, child);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/parent/{login}/child")
	public ResponseEntity<Child> getChildFromParent(@PathVariable String login) {
		Child child = parentFacade.getParent(login).getChild();
		
		return ResponseEntity.ok(child);
	}
	
	
	@GetMapping("/info")
	public ResponseEntity<Nursery> getInfo() {
		// Oui, c'est sur qu'on devrait faire un système pour éviter de renvoyer le mot de passe des admins mais bon, c'est original comme ça aussi non ?
		return ResponseEntity.ok(nurseryFacade.getNursery());
	}

}
