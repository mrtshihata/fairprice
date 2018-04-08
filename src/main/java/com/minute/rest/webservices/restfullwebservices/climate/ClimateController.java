
package com.minute.rest.webservices.restfullwebservices.climate;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.minute.rest.webservices.restfullwebservices.user.UserNotFoundException;
import com.minute.rest.webservices.restfullwebservices.user.Users;


/**
 * @author gtshihata
 *
 */
@RestController
@RequestMapping("/climate")
public class ClimateController {
	
	@Autowired
	private ClimateDaoService service;
	
	@GetMapping("/all")
	public List<Climate> retrieveAllClimates() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Climate retrieveClimate(@PathVariable int id) {
		
		Climate user = service.findOne(id);
		if (user==null) 
			throw new UserNotFoundException("id-"+id);
		
		Resource<Climate> resource = new Resource<Climate>(user);
		ControllerLinkBuilder linkto =  linkTo(methodOn(this.getClass()).retrieveAllClimates());
		resource.add(linkto.withRel("all-climate"));
		
		return user;
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> createClimate(@Valid @RequestBody Climate climates) {
		Climate savedClimate = service.save(climates);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedClimate.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteClimate(@PathVariable int id) {
		
		Climate deletedclimate = service.deleteById(id);
		if (deletedclimate==null) 
			throw new UserNotFoundException("Cannot find "+id);
		else {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(deletedclimate.getId()).toUri();
				return ResponseEntity.noContent().build();
				}
		
	}


}
