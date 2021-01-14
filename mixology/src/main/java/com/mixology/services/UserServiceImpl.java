package com.mixology.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mixology.models.Favorites;
import com.mixology.repositories.DrinksDAO;
import com.mixology.repositories.FavoritesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.repositories.UsersDAO;

@Service
public class UserServiceImpl implements UserService {

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
        return ud.findById(id).get();
    }

    @Override
    public Users registerUser(Users u) {

        return ud.saveAndFlush(u);
    }


	@Override
	public List<Drinks> findAllFavoriteDrinks(int userId) {
		List<Drinks> dList = new ArrayList<>();
		List<Integer> dListId = new ArrayList<>();
        List<Favorites> fList = fd.findByUserId(userId);

        //System.out.println("fList: " + fList);
        for(int i =0;i< fList.size();i++){
            dListId.add(fList.get(i).getDrink().getId());
        }
       // System.out.println("dListId: " + dListId);
		for(int i = 0; i < dListId.size(); i++) {
			dList.add(dd.getOne(dListId.get(i)));
		}
		return dList;
	}

    @Override
    public Favorites addFavoriteDrink(Favorites f) {
    	fd.save(f);
    	int favId = f.getFavoriteId();
    	updateFavorite(f.getDrink().getId(), f.getUser().getId(), favId);
    	fd.flush();
    	return f;
    }

    public void updateFavorite(int drinkId, int userId, int favId) {
    	//System.out.println("user: " + userId + " drinkId: " + drinkId);
    	fd.updateFavorites(drinkId, userId, favId);
    }
    
    @Override
    public Users findUsersByUsernameAndPassword(String username, String password) {
        return ud.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Users> findAllUsers() {
        return ud.findAll();
    }


}
