package com.czmud.omikujiform;

public class Omikuji {
	private int years;
	private String city;
	private String person;
	private String profession;
	private String animal;
	private String statement;
	
	public Omikuji(int years, String city, String person, String profession, String animal, String statement) {
		this.years = years;
		this.city = city;
		this.person = person;
		this.profession = profession;
		this.animal = animal;
		this.statement = statement;
	}
	
	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	
}
