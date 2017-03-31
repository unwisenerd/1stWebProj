package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.dto.filter.ModelFilter;
import ua.com.hustle.Good_Models;
import ua.com.specifications.GoodModelSpecifications;

public interface Good_Models_Dao_Final extends JpaRepository<Good_Models, Integer >, JpaSpecificationExecutor<Good_Models> {

	Good_Models findBymodelName(String modelName);
	
	
	
	@Query("select i from Good_Models i  where i.goodType.id=?1")
	List<Good_Models> findByTypeId(int id);
	
	@Query("select i from Good_Models i  where i.good.id=?1")
	List<Good_Models> findByGoodId(int id);
	
	@Query("select a from Good_Models a LEFT JOIN FETCH a.goodType LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH a.memoryType LEFT JOIN FETCH a.proccType LEFT JOIN FETCH a.ramType LEFT JOIN FETCH a.good")
	List<Good_Models> findAll();
	
	@Query("select a from Good_Models a LEFT JOIN FETCH a.goodType LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH a.memoryType LEFT JOIN FETCH a.proccType LEFT JOIN FETCH a.ramType LEFT JOIN FETCH a.good where a.id=?1")
	Good_Models findOne(int id);
	
	@Query("SELECT a FROM Good_Models a WHERE a.modelName=?1 and a.price=?2 and a.good.id=?3 and a.goodType.id=?4 and a.gpuType.id=?5 and a.memoryType.id=?6 and a.proccType.id=?7 and a.ramType.id=?8")
	Good_Models findUnique(String modelName, int price, int goodId, int goodTypeId
			,int gpuTypeId, int memoryTypeId, int proccTypeId, int ramTypeId);
	
//	@Query(value="SELECT a FROM Good_Models a LEFT JOIN FETCH a.good LEFT JOIN FETCH a.goodType LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH a.memoryType LEFT JOIN FETCH a.proccType LEFT JOIN FETCH a.ramType",
//			countQuery="SELECT count(a.id) FROM Good_Models a")
//	Page<Good_Models> findAll(Pageable pageable);
	
//	@Query("select i from Good_Models i  where i.goodType.id=?1")
//	Page<Good_Models> findByTypeId(int id,GoodModelSpecifications filter, Pageable pageable );
	
}
