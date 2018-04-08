
package com.minute.rest.webservices.restfullwebservices.costflux;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author gtshihata
 *
 */
@Component
public class FluxDaoService {
	
	private static List<Flux> flux = new ArrayList<>();
	private static int fluxCount = 3;
	
	
	static {
		
		flux.add(new Flux(1, "Kinshasa", "Kinshasa", "Nsenga"));		
	}
	
	public List<Flux> findAll(){
		return flux;
	}
	
	public Flux save(Flux fluxe) {
		if (fluxe.getId()==null) {
			fluxe.setId(++fluxCount);
		}
		flux.add(fluxe);
		return fluxe;
	}
	
	public Flux findOne(int id) {
		for(Flux fluxes: flux) {
			if (fluxes.getId()==id) {
				return fluxes;
			}
		}
		return null;
	}
	
	public Flux deleteById(int id) {
		
		Iterator<Flux> iterator = flux.iterator();
		
		while(iterator.hasNext()) {
			Flux fluxe = iterator.next();
			if (fluxe.getId()==id) {
				iterator.remove();
				return fluxe;
			}
		}
		return null;
		
	}

}
