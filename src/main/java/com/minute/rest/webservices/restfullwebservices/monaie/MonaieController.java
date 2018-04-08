package com.minute.rest.webservices.restfullwebservices.monaie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monaie")
public class MonaieController {
	
	@Autowired
	private MonaieDaoService service;
	
	@GetMapping("/all")
	public List<Monaie> retriveAllMonaie(){
		return service.findAll();
	}

}
