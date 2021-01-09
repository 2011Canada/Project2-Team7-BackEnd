package com.mixology.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.repositories.UsersDAO;

@Service
public class UserServiceImpl implements UserService{

    private UsersDAO ud;
    //DrinksDAO dd;
    //FavoritesDAO fd;

    @Autowired
    //public UserServiceImpl(UsersDAO ud, DrinksDAO dd, FavoritesDAO fd) {
    public UserServiceImpl(UsersDAO ud) {
    	this.ud = ud;
       // this.dd = dd;
        //this.fd = fd;
    }

	@Override
	public Users findUsersById(int id) {
		
		return ud.getOne(id);
	}

	@Override
	public Users registerUser(Users u) {
		
		return ud.saveAndFlush(u);
	}

	@Override
	public Users findUsersByUsernameAndPassword(String username, String password) {
		
		return new Users();
		//return ud.findByUsernameAndPassword(username, password);
	}

	
	
	@Override
	public List<Drinks> findAllFavoriteDrinks(int userId) {
		
		return new  ArrayList<>();
		
//		List<Drinks> dList = new ArrayList<>();
//		List<Integer> dListId = new ArrayList<>();
//		fd.findAllDrinkIdByUserId(userId).forEach(dListId::add);
//		
//		for(int i = 0; i < dListId.size(); i++) {
//			dList.add(dd.getOne(dListId.get(i)));
//		}
//		
//		return dList;
//		
//		}
	}

	@Override
	public List<Users> findAllUsers() {
		
		return ud.findAll();
	}
}
