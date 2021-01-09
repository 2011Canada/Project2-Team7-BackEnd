package com.mixology.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Drinks {

	@Id
	@Column(name ="drinkid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drinkId;
	
	@Column(name ="drinkname")
	private String name;
	
	@Column(name ="drinkdegree")
	private int degree;
	
	@ManyToOne
	@JoinColumn(referencedColumnName ="userid")
	private Users drinkCreator;
	
	public Drinks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drinks(int drinkId, String name, int degree, Users drinkCreator) {
		super();
		this.drinkId = drinkId;
		this.name = name;
		this.degree = degree;
		this.drinkCreator = drinkCreator;
	}

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Users getDrinkCreator() {
		return drinkCreator;
	}

	public void setDrinkCreator(Users drinkCreator) {
		this.drinkCreator = drinkCreator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + degree;
		result = prime * result + ((drinkCreator == null) ? 0 : drinkCreator.hashCode());
		result = prime * result + drinkId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drinks other = (Drinks) obj;
		if (degree != other.degree)
			return false;
		if (drinkCreator == null) {
			if (other.drinkCreator != null)
				return false;
		} else if (!drinkCreator.equals(other.drinkCreator))
			return false;
		if (drinkId != other.drinkId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Drinks [drinkId=" + drinkId + ", name=" + name + ", degree=" + degree + ", drinkCreator=" + drinkCreator
				+ "]";
	}


}
