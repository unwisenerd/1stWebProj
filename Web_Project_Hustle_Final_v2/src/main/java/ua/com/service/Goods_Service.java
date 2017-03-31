package ua.com.service;

import java.util.List;







import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.hustle.Good_Type;
import ua.com.hustle.Goods;

public interface Goods_Service {

	void save (Goods goods);
	List<Goods> findAll();
	Goods findOne(int id);
	void delete(int id);
	
	Goods findByMadeCountry(String madeCountry);
	
	List<Goods> findByModelId(int id);


	Page<Goods> findAll(TypeFilter filter, Pageable pageable);

	
}
