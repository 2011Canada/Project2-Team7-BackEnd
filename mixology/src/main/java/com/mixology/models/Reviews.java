package com.mixology.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="reviews")
public class Reviews {

	@Id
	@Column(name ="reviewid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
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

	public Reviews(int reviewId, String description, int rate, Users author, Drinks drink) {
		super();
		this.reviewId = reviewId;
		this.description = description;
		this.rate = rate;
		this.author = author;
		this.drink = drink;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	public Drinks getDrink() {
		return drink;
	}

	public void setDrink(Drinks drink) {
		this.drink = drink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + rate;
		result = prime * result + reviewId;
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
		Reviews other = (Reviews) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (rate != other.rate)
			return false;
		if (reviewId != other.reviewId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", description=" + description + ", rate=" + rate + ", author="
				+ author + ", drink=" + drink + "]";
	}

	
}