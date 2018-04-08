package com.minute.rest.webservices.restfullwebservices.distancerate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.minute.rest.webservices.restfullwebservices.costflux.Flux;

/**
 * @author gtshihata
 *
 */
@Component
public class DistanceRateDaoService {
	
	private static List<DistanceRate> distance = new ArrayList<>();
	private static int rateCount = 3;
	
	
	static {
		
		distance.add(new DistanceRate(1, "20", "2h", "1234", 1, 0, 1, 0, 1, 0, 1, 1));		
	}
	
	public List<DistanceRate> findAll(){
		return distance;
	}
	
	public DistanceRate save(DistanceRate rate) {
		if (rate.getId()==null) {
			rate.setId(++rateCount);
		}
		distance.add(rate);
		return rate;
	}
	
	public DistanceRate findOne(int id) {
		for(DistanceRate fluxes: distance) {
			if (fluxes.getId()==id) {
				return fluxes;
			}
		}
		return null;
	}
	
	public DistanceRate deleteById(int id) {
		
		Iterator<DistanceRate> iterator = distance.iterator();
		
		while(iterator.hasNext()) {
			DistanceRate rate = iterator.next();
			if (rate.getId()==id) {
				iterator.remove();
				return rate;
			}
		}
		return null;
		
	}


}
