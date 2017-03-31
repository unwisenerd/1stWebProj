package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.hustle.GPU_Type;
import ua.com.hustle.Good_Type;

public interface Good_Type_Dao_Final extends JpaRepository<Good_Type, Integer>, JpaSpecificationExecutor<Good_Type> {

	Good_Type findByType(String type);
	
	@Query("select i from Good_Type i join i.goodModels m where m.id=?1")
	List<Good_Type> findByModelId(int id);
}
