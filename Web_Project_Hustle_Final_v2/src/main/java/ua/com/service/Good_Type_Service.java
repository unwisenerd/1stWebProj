package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.hustle.Good_Type;

public interface Good_Type_Service {

	void save (Good_Type goodType);
	List<Good_Type> findAll();
	Good_Type findOne(int id);
	void delete(int id);
	
	Good_Type findByType(String type);
	
	List<Good_Type> findByModelId(int id);
	
	Page<Good_Type> findAll(TypeFilter filter, Pageable pageable);
}
