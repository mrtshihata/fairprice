
package com.minute.rest.webservices.restfullwebservices.climate;

import javax.validation.constraints.Size;

/**
 * @author gtshihata
 *
 */
public class Climate {
	
	private Integer id;
	@Size(min=2, message="pluie should have atleast 2 characters can only be Yes or No", max=3)
	private String pluie;
	@Size(min=2, message="chaleur should have atleast 2 characters can only be Yes or No", max=3)
	private String Chaleur;
	
	private Climate() {
		
	}
	
	
	public Climate(Integer id, String pluie, String chaleur) {
		super();
		this.id = id;
		this.pluie = pluie;
		Chaleur = chaleur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPluie() {
		return pluie;
	}


	public void setPluie(String pluie) {
		this.pluie = pluie;
	}


	public String getChaleur() {
		return Chaleur;
	}


	public void setChaleur(String chaleur) {
		Chaleur = chaleur;
	}


	@Override
	public String toString() {
		return "Climate [id=" + id + ", pluie=" + pluie + ", Chaleur=" + Chaleur + "]";
	}
	
	
	

}
