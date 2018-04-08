
package com.minute.rest.webservices.restfullwebservices.costflux;

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

import com.minute.rest.webservices.restfullwebservices.climate.Climate;
import com.minute.rest.webservices.restfullwebservices.user.UserNotFoundException;

/**
 * @author gtshihata
 *
 */
@RestController
@RequestMapping("/flux")
public class FluxController {
	
	@Autowired
	private FluxDaoService service;
	
	@GetMapping("/all")
	public List<Flux> retrieveAllFlux(){
		return service.findAll();
	} 
	
	
	@GetMapping("/{id}")
	public Flux retrieveAllFlux(@PathVariable int id) {
		
		Flux fluxe = service.findOne(id);
		if (fluxe==null) 
			throw new UserNotFoundException("id-"+id);
		
		Resource<Flux> resource = new Resource<Flux>(fluxe);
		ControllerLinkBuilder linkto =  linkTo(methodOn(this.getClass()).retrieveAllFlux());
		resource.add(linkto.withRel("all-climate"));
		return fluxe;
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> createFlux(@Valid @RequestBody Flux fluxes) {
		Flux savedClimate = service.save(fluxes);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedClimate.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFlux(@PathVariable int id) {
		
		Flux deletedclimate = service.deleteById(id);
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
