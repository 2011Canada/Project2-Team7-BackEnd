package com.mixology.controllers;

import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public ResponseEntity<List<Drinks>> findAllDrinks(){
        return new ResponseEntity<List<Drinks>>(drinkService.findAllDrinks(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Drinks> findDrinkById(@PathVariable int id){
        return new ResponseEntity<Drinks>(drinkService.findDrinkById(id), HttpStatus.OK);

    }

     // -- check the functionality
    @PostMapping
    public ResponseEntity<Drinks> saveDrink(@RequestBody Drinks d){
        return new ResponseEntity<Drinks>(drinkService.saveDrink(d), HttpStatus.OK);
    }

    @GetMapping("/drinkName/{name}")
    public ResponseEntity<Drinks> findDrinksByName(@PathVariable String name){
        return new ResponseEntity<Drinks>(drinkService.findDrinksByName(name), HttpStatus.OK);
    }

    @GetMapping("/creator/{id}")
    public ResponseEntity<List<Drinks>> findByCreator(Users u){
        return new ResponseEntity<List<Drinks>>(drinkService.findByCreator(u), HttpStatus.OK);
    }

    @GetMapping("/degree/{degree}")
    public ResponseEntity<List<Drinks>> findDrinksByDegree(@PathVariable int degree){
        return new ResponseEntity<List<Drinks>>(drinkService.findDrinksByDegree(degree), HttpStatus.OK);

    }

    // --- to do
    @GetMapping("/ingredientName/{ingredientName}")
    public ResponseEntity<List<Drinks>> findDrinksByIngredientName(@PathVariable String ingredientName){
        return new ResponseEntity<List<Drinks>>(drinkService.findDrinksByIngredientName(ingredientName), HttpStatus.OK);

    }

}
