package com.minute.rest.webservices.restfullwebservices.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author gtshihata
 *
 */
@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<Users> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public Users retrieveUser(@PathVariable int id) {
		
		Users user = service.findOne(id);
		if (user==null) 
			throw new UserNotFoundException("id-"+id);
		
		Resource<Users> resource = new Resource<Users>(user);
		ControllerLinkBuilder linkto =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkto.withRel("all-users"));
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
		Users savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		
		Users deleteduser = service.deleteById(id);
		if (deleteduser==null) 
			throw new UserNotFoundException("Cannot find "+id);
		else {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(deleteduser.getId()).toUri();
				return ResponseEntity.noContent().build();
				}
		
	}
	
	
	
	
}
