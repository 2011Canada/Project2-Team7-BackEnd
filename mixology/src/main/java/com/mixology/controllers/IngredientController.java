package com.mixology.controllers;
import com.mixology.models.Drinks;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipes;
import com.mixology.models.Users;
import com.mixology.services.DrinkService;
import com.mixology.services.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	private IngredientService is;

    @Autowired
    public IngredientController(IngredientService is) {
        this.is = is;
    }
    
    @GetMapping
    public ResponseEntity<List<Ingredients>> findAllIngredients(){
        return new ResponseEntity<List<Ingredients>>(is.findAllIngredients(), HttpStatus.OK);
    }
    
    @GetMapping("/drink/{drinkId}")
    public ResponseEntity<List<Ingredients>> findIngredientsByDrinkId(@PathVariable int drinkId){
        return new ResponseEntity<List<Ingredients>>(is.findIngredientsByDrinkId(drinkId), HttpStatus.OK);
    }
 
//    @PostMapping
//    public ResponseEntity<Drinks> saveDrink(@RequestBody Drinks d){
//        return new ResponseEntity<Drinks>(drinkService.saveDrink(d), HttpStatus.OK);
//    }
//    
//    @PostMapping
//    public ResponseEntity<Drinks> saveDrink(@RequestBody Drinks d){
//        return new ResponseEntity<Drinks>(drinkService.saveDrink(d), HttpStatus.OK);
//    }
    
   

    
}
