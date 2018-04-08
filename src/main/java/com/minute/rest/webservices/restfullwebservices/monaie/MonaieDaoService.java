package com.minute.rest.webservices.restfullwebservices.monaie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MonaieDaoService {
	
	private static List<Monaie> Currency = new ArrayList<>();
	
	static {
		Currency.add(new Monaie(1 , "DRC Congo"));
	}
	
	public List<Monaie> findAll(){
		return Currency;
	}
	

}
