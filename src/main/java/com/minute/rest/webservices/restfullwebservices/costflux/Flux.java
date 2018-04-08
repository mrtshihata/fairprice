
package com.minute.rest.webservices.restfullwebservices.costflux;

/**
 * @author gtshihata
 *
 */
public class Flux {
	
	private Integer id;
	private String state;
	private String city;
	private String street;
	
	
	public Flux() {
		
	}


	public Flux(Integer id, String state, String city, String street) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.street = street;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	@Override
	public String toString() {
		return "Flux [id=" + id + ", state=" + state + ", city=" + city + ", street=" + street + "]";
	}
	
	
	
	
	

}
