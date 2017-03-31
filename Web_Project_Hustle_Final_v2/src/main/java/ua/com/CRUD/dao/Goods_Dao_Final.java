package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.hustle.Good_Models;
import ua.com.hustle.Goods;

public interface Goods_Dao_Final extends JpaRepository<Goods, Integer> , JpaSpecificationExecutor<Goods>{

	Goods findByMadeCountry(String madeCountry);

	
	@Query("select i from Goods i join i.goodModels m where m.id=?1")
	List<Goods> findByModelId(int id);
	


	
}
