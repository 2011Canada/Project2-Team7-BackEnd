package com.mixology.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Recipes {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int recipeid;

	    @ManyToOne
	    @JoinColumn(referencedColumnName = "drinkid")
	    @JsonBackReference
	    private Drinks drink;

	    @ManyToOne
	    @JoinColumn(referencedColumnName = "ingid")
	    private Ingredients ingredient;

		public Recipes() {
			super();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((drink == null) ? 0 : drink.hashCode());
			result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
			result = prime * result + recipeid;
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
			Recipes other = (Recipes) obj;
			if (drink == null) {
				if (other.drink != null)
					return false;
			} else if (!drink.equals(other.drink))
				return false;
			if (ingredient == null) {
				if (other.ingredient != null)
					return false;
			} else if (!ingredient.equals(other.ingredient))
				return false;
			if (recipeid != other.recipeid)
				return false;
			return true;
		}

		public Recipes(int recipeId, Drinks drink, Ingredients ingredient) {
			super();
			this.recipeid = recipeId;
			this.drink = drink;
			this.ingredient = ingredient;
		}

		public int getRecipeId() {
			return recipeid;
		}

		public void setRecipeId(int recipeId) {
			this.recipeid = recipeId;
		}

		public Drinks getDrink() {
			return drink;
		}

		public void setDrink(Drinks drink) {
			this.drink = drink;
		}

		public Ingredients getIngredient() {
			return ingredient;
		}

		public void setIngredient(Ingredients ingredient) {
			this.ingredient = ingredient;
		}

		@Override
		public String toString() {
			return "Recipes [recipeId=" + recipeid + ", drink=" + drink + ", ingredient=" + ingredient + "]";
		}
	

	    
}
