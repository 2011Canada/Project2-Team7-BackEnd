package com.mixology.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name ="reviews")
public class Reviews {

	@Id
	@Column(name ="reviewid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private int rate;
	
	
	@ManyToOne
	@JoinColumn(referencedColumnName ="userid")
	private Users author;
	
	@ManyToOne
	@JoinColumn(referencedColumnName ="drinkid")
	private Drinks drink;
	
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reviews(int id, String description, int rate, Users author, Drinks drink) {
		super();
		this.id = id;
		this.description = description;
		this.rate = rate;
		this.author = author;
		this.drink = drink;
	}

	public int getId() {
		return id;
	}

	public void setId(int reviewId) {
		this.id = reviewId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reviews reviews = (Reviews) o;
		return id == reviews.id &&
				rate == reviews.rate &&
				description.equals(reviews.description) &&
				author.equals(reviews.author) &&
				drink.equals(reviews.drink);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, rate, author, drink);
	}

	public Drinks getDrink() {
		return drink;
	}

	public void setDrink(Drinks drink) {
		this.drink = drink;
	}


	@Override
	public String toString() {
		return "Reviews [reviewId=" + id + ", description=" + description + ", rate=" + rate + ", author="
				+ author + ", drink=" + drink + "]";
	}

	
}