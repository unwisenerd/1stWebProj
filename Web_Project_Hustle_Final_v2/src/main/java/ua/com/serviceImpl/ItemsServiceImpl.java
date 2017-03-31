package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Items_Dao_Final;
import ua.com.hustle.Items;
import ua.com.hustle.User;
import ua.com.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	Items_Dao_Final itemsDaoFinal;
	
	@Override
	public void save(Items item) {
		
		itemsDaoFinal.save(item);
	}

	@Override
	public List<Items> findAll() {
		return itemsDaoFinal.findAll();
	}

	@Override
	public Items findOne(int id) {
		return itemsDaoFinal.findOne(id);
	}

	@Override
	public void delete(int id) {
		itemsDaoFinal.delete(id);
	}

	@Override
	public List<Items> findByUserName(String username) {
		return itemsDaoFinal.findByUserName(username);
	}

	@Override
	public List<Items> findByPurchaseStatus(int status) {
		return itemsDaoFinal.findByPurchaseStatus(status);
	}

	@Override
	public List<Items> findByUserNameAndPurchaseStatus(String username,	int status) {
		return itemsDaoFinal.findByUserNameAndPurchaseStatus(username, status);
	}

}
