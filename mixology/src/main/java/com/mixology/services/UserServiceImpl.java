package com.mixology.services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.repositories.DrinksDAO;
import com.mixology.repositories.FavoritesDAO;
import com.mixology.repositories.UsersDAO;

@Service
public class UserServiceImpl implements UserService{

    UsersDAO ud;
    DrinksDAO dd;
    FavoritesDAO fd;

    @Autowired
    public UserServiceImpl(UsersDAO ud, DrinksDAO dd, FavoritesDAO fd) {
        this.ud = ud;
        this.dd = dd;
        this.fd = fd;
    }

	@Override
	public Users findUsersById(int id) {
		// TODO Auto-generated method stub
		return ud.getOne(id);
	}

	@Override
	public Users registerUser(Users u) {
		// TODO Auto-generated method stub
		return ud.saveAndFlush(u);
	}

	@Override
	public Users findUsersByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return ud.findByUsernameAndPassword(username, password);
	}

	
	
	@Override
	public List<Drinks> findAllFavoriteDrinks(int userId) {
		// TODO Auto-generated method stub
		
		List<Drinks> dList = new ArrayList<>();
		List<Integer> dListId = new ArrayList<>();
		fd.findAllDrinkIdByUserId(userId).forEach(dListId::add);
		
		for(int i = 0; i < dListId.size(); i++) {
			dList.add(dd.getOne(dListId.get(i)));
		}
		
		return dList;
		
		}

}
