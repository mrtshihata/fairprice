
package com.minute.rest.webservices.restfullwebservices.distancerate;

/**
 * @author gtshihata
 *
 */
public class DistanceRate {
	
	private Integer id;
	private String distance;
	private String time_estimated;
	private String price;
	private Integer climate_id;
	private Integer from_address_id;
	private Integer monaies_id;
	private Integer price_id;
	private Integer rarete_id;
	private Integer temps_id;
	private Integer tension_politiques_id;
	private Integer to_address_id;
	
	
	public DistanceRate() {
	
	}


	public DistanceRate(Integer id, String distance, String time_estimated, String price, Integer climate_id,
			Integer from_address_id, Integer monaies_id, Integer price_id, Integer rarete_id, Integer temps_id,
			Integer tension_politiques_id, Integer to_address_id) {
		super();
		this.id = id;
		this.distance = distance;
		this.time_estimated = time_estimated;
		this.price = price;
		this.climate_id = climate_id;
		this.from_address_id = from_address_id;
		this.monaies_id = monaies_id;
		this.price_id = price_id;
		this.rarete_id = rarete_id;
		this.temps_id = temps_id;
		this.tension_politiques_id = tension_politiques_id;
		this.to_address_id = to_address_id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		this.distance = distance;
	}


	public String getTime_estimated() {
		return time_estimated;
	}


	public void setTime_estimated(String time_estimated) {
		this.time_estimated = time_estimated;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Integer getClimate_id() {
		return climate_id;
	}


	public void setClimate_id(Integer climate_id) {
		this.climate_id = climate_id;
	}


	public Integer getFrom_address_id() {
		return from_address_id;
	}


	public void setFrom_address_id(Integer from_address_id) {
		this.from_address_id = from_address_id;
	}


	public Integer getMonaies_id() {
		return monaies_id;
	}


	public void setMonaies_id(Integer monaies_id) {
		this.monaies_id = monaies_id;
	}


	public Integer getPrice_id() {
		return price_id;
	}


	public void setPrice_id(Integer price_id) {
		this.price_id = price_id;
	}


	public Integer getRarete_id() {
		return rarete_id;
	}


	public void setRarete_id(Integer rarete_id) {
		this.rarete_id = rarete_id;
	}


	public Integer getTemps_id() {
		return temps_id;
	}


	public void setTemps_id(Integer temps_id) {
		this.temps_id = temps_id;
	}


	public Integer getTension_politiques_id() {
		return tension_politiques_id;
	}


	public void setTension_politiques_id(Integer tension_politiques_id) {
		this.tension_politiques_id = tension_politiques_id;
	}


	public Integer getTo_address_id() {
		return to_address_id;
	}


	public void setTo_address_id(Integer to_address_id) {
		this.to_address_id = to_address_id;
	}


	@Override
	public String toString() {
		return "DistanceRate [id=" + id + ", distance=" + distance + ", time_estimated=" + time_estimated + ", price="
				+ price + ", climate_id=" + climate_id + ", from_address_id=" + from_address_id + ", monaies_id="
				+ monaies_id + ", price_id=" + price_id + ", rarete_id=" + rarete_id + ", temps_id=" + temps_id
				+ ", tension_politiques_id=" + tension_politiques_id + ", to_address_id=" + to_address_id + "]";
	}
	
	
	
	
	

}
