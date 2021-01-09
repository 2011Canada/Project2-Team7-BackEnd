package com.mixology.services;

import java.util.ArrayList;
import java.util.List;

import com.mixology.repositories.DrinksDAO;
import com.mixology.repositories.FavoritesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.repositories.UsersDAO;

@Service
public class UserServiceImpl implements UserService{

    private UsersDAO ud;
    DrinksDAO dd;
    FavoritesDAO fd;

    @Autowired
    //public UserServiceImpl(UsersDAO ud, DrinksDAO dd, FavoritesDAO fd) {
    public UserServiceImpl(UsersDAO ud) {
    	this.ud = ud;
       // this.dd = dd;
        //this.fd = fd;
    }

	@Override
	public Users findUsersById(int id) {
		
		return ud.findById(id).get();
	}

	@Override
	public Users registerUser(Users u) {
		
		return ud.saveAndFlush(u);
	}

	/*
	@Override
	public List<Drinks> findAllFavoriteDrinks(int userId) {
		List<Drinks> dList = new ArrayList<>();
		List<Integer> dListId = new ArrayList<>();
		fd.findAllDrinkIdByUserId(userId).forEach(dListId::add);

		for(int i = 0; i < dListId.size(); i++) {
			dList.add(dd.getOne(dListId.get(i)));
		}
		return dList;
    }

	 */


	@Override
	public Users findUsersByUsernameAndPassword(String username, String password) {
		return ud.findByUsernameAndPassword(username, password);
	}



	@Override
	public List<Users> findAllUsers() {
		
		return ud.findAll();
	}
}
