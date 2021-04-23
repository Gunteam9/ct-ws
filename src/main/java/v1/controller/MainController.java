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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
		consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
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
			Parent newUser = parentFacade.register(givenUser.getUsername(), givenUser.getPassword(), givenUser.getChild());
			
			HttpHeaders responseHeader = new HttpHeaders();
			responseHeader.setLocation(new URI("http://" + request.getRemoteHost() + "/parent/" + newUser.getUsername()));
			
			return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeader).body(newUser);
		} catch (URISyntaxException e) {
			throw new BadUriException();
		}		
		
	}
	
	@PatchMapping("/child/id")
	public ResponseEntity<Child> updateChild(@PathVariable long id, @RequestBody Child child) {
		childFacade.updateChild(child);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/parent/{login}/child")
	public ResponseEntity<Child> getChildFromParent(@PathVariable String login) {
		Child child = parentFacade.getParent(login).getChild();
		
		return ResponseEntity.ok(child);
	}
	
	@GetMapping("/info")
	public ResponseEntity<Nursery> getInfo() {
		return ResponseEntity.ok(nurseryFacade.getNursery());
	}

}
