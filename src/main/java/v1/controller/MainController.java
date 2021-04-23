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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import v1.config.AppProperties;
import v1.exceptions.BadUriException;
import v1.facade.UserFacade;
import v1.model.User;

@RestController
// We also authorize XML because JSON is 🥴
@RequestMapping(
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
		consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
		)
@CrossOrigin("*")
public class MainController {
	
	@Autowired
	UserFacade userFacade;
	
	@Autowired
	AppProperties appProperties;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User givenUser, HttpServletRequest request) {
		try {
			User newUser = userFacade.register(givenUser.getUsername(), givenUser.getPassword());
			
			HttpHeaders responseHeader = new HttpHeaders();
			responseHeader.setLocation(new URI("http://" + request.getRemoteHost() + "/user/" + newUser.getUsername()));
			
			return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeader).body(newUser);
		} catch (URISyntaxException e) {
			throw new BadUriException();
		}		
		
	}

}
