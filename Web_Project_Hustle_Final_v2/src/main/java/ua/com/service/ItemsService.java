package ua.com.service;

import java.util.List;

import ua.com.hustle.Items;
import ua.com.hustle.User;



public interface ItemsService {

	void save (Items item);
	List<Items> findAll();
	Items findOne(int id);
	void delete(int id);
	
	List<Items> findByUserName(String username);
	
	List<Items> findByPurchaseStatus(int status);
	
	List<Items> findByUserNameAndPurchaseStatus(String username , int status);
}
