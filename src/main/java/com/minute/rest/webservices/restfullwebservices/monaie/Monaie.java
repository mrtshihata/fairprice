package com.minute.rest.webservices.restfullwebservices.monaie;

public class Monaie {
	
	private Integer id;
	private String pays;
	
	
	public Monaie() {
		
	}


	public Monaie(Integer id, String pays) {
		super();
		this.id = id;
		this.pays = pays;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	@Override
	public String toString() {
		return "Monaie [id=" + id + ", pays=" + pays + "]";
	}
	
	

}
