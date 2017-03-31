package ua.com.CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.hustle.User;

public interface User_Dao_Final extends JpaRepository<User, Integer> {


	
	User findByEmail(String email);
	
	User findByMobilePhone(String mobilePhone);
	
	User findByPostCode(int postCode);
	
}
