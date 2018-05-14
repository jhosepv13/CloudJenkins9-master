package com.bazan.gestion.model;

public class Departament {

	String name;
	String description;
	String city;
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param city
	 */
	
	public Departament(String name, String description, String city) {
		super();
		this.name = name;
		this.description = description;
		this.city = city;
	}

	public Departament() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Departament [name=" + name + ", description=" + description
				+ ", city=" + city + "]";
	}
	
}
