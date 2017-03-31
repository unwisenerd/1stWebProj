package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.method.annotation.ModelFactory;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Good_Model_Form;
import ua.com.hustle.GPU_Type;
import ua.com.hustle.Good_Models;
import ua.com.hustle.Good_Type;
import ua.com.hustle.Goods;
import ua.com.hustle.Memory;
import ua.com.hustle.Procc_Type;
import ua.com.hustle.Ram_Type;

public interface Good_Models_Service {

	void save (Good_Model_Form form);
	List<Good_Models> findAll();
	Good_Models findOne(int id);
	void delete(int id);
	
	Good_Models findBymodelName(String modelName);
	
	
	List<Good_Models> findByTypeId(int id);
	
	List<Good_Models> findByGoodId(int id);

	
	Good_Model_Form findForm(int id);
	
	Good_Models findUnique(String modelName, String price, Goods good, Good_Type goodType
			,GPU_Type gpuType, Memory memoryType, Procc_Type proccType, Ram_Type ramType);
	
	Page<Good_Models> findAll(Pageable pageable, ModelFilter filter);
	
//	Page<Good_Models> findByTypeId(int id, Pageable pageable, ModelFilter filter );
	
	Page<Good_Models> findAll(TypeFilter filter, Pageable pageable);
	
//	Page<Good_Models> findByTypeAll(Pageable pageable, ModelFilter filter);

	

	
}
