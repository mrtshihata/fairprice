
package com.minute.rest.webservices.restfullwebservices.climate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;



/**
 * @author gtshihata
 *
 */
@Component
public class ClimateDaoService {
	
	private static List<Climate> climate = new ArrayList<>();
	private static int climateCount = 3;
	
	static {
		climate.add(new Climate(1, "Yes", "No"));
	}
	
	public List<Climate> findAll() {
		return climate;
	}
	
	public Climate save(Climate climates) {

		if (climates.getId() == null) {
			climates.setId(++climateCount);
		}
		climate.add(climates);

		return climates;
	}
	
	public Climate findOne(int id) {
		for (Climate climates : climate) {
			if (climates.getId() == id) {
				return climates;
			}
		}
		return null;
	}
	
	public Climate deleteById(int id) {
		Iterator<Climate> iterator = climate.iterator();

		while (iterator.hasNext()) {
			Climate climates = iterator.next();
			if (climates.getId() == id) {
				iterator.remove();
				return climates;
			}
		}
		return null;
	}


}
