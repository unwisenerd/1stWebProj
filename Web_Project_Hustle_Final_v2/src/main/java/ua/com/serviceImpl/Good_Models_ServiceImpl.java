package ua.com.serviceImpl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;




import ua.com.CRUD.dao.Good_Models_Dao_Final;
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
import ua.com.service.FileWriter;
import ua.com.service.Good_Models_Service;
import ua.com.service.FileWriter.Folder;
import ua.com.specifications.GoodModelSpecifications;

@Service
public class Good_Models_ServiceImpl implements Good_Models_Service {
 

	
	@Autowired
	private Good_Models_Dao_Final goodModelDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public void save(Good_Model_Form form) {

		Good_Models entity = new Good_Models();
		
		entity.setId(form.getId());
		
		entity.setModelName(form.getModelName());
		
		entity.setPrice(new Integer(form.getPrice()));
		
		entity.setGood(form.getGood());
		
		entity.setGoodType(form.getGoodType());
		
		entity.setGpuType(form.getGpuType());
		
		entity.setMemoryType(form.getMemoryType());
		
		entity.setProccType(form.getProccType());
		
		entity.setRamType(form.getRamType());
		
		goodModelDao.save(entity);
		
		entity = goodModelDao.saveAndFlush(entity);
		
	
		
		if(fileWriter.write(Folder.GoodModels, form.getFile(),entity.getId())){
			
			entity.setVersion(form.getVersion()+1);
			
			goodModelDao.save(entity);
		}


	}

	public List<Good_Models> findAll() {
		return goodModelDao.findAll();
		
	}

	
	public Good_Models findOne(int  id) {
		
		return goodModelDao.findOne(id);
		
	}

	
	public void delete(int id) {

		goodModelDao.delete(id);
		
	}

	public Good_Models findBymodelName(String modelName) {
		return goodModelDao.findBymodelName(modelName);
	}

	public List<Good_Models> findByTypeId(int id) {
		return goodModelDao.findByTypeId(id);
	}

	public List<Good_Models> findByGoodId(int id) {
		return goodModelDao.findByGoodId(id);
	}

	public Good_Model_Form findForm(int id) {
		Good_Models entity = findOne(id);
		
		Good_Model_Form form = new Good_Model_Form();
		
		form.setPrice(String.valueOf(entity.getPrice()));
		
		form.setId(entity.getId());
		
		form.setModelName(entity.getModelName());
		
		form.setGood(entity.getGood());
		
		form.setGoodType(entity.getGoodType());
		
		form.setGpuType(entity.getGpuType());
		
		form.setMemoryType(entity.getMemoryType());
		
		form.setProccType(entity.getProccType());
		
		form.setRamType(entity.getRamType());
		
		return form;
	}

	public Good_Models findUnique(String modelName, String price, Goods good,
			Good_Type goodType, GPU_Type gpuType, Memory memoryType,
			Procc_Type proccType, Ram_Type ramType) {
		return goodModelDao.findUnique(modelName, new Integer(price), good.getId(), goodType.getId(), gpuType.getId(), memoryType.getId(), proccType.getId(), ramType.getId());
	}

	@Override
	public Page<Good_Models> findAll(Pageable pageable, ModelFilter filter) {
		return goodModelDao.findAll(new GoodModelSpecifications(filter), pageable);
	}

	@Override
	public Page<Good_Models> findAll(TypeFilter filter, Pageable pageable) {
		return goodModelDao.findAll(findByModelNameLike(filter), pageable);
	}
	
	private Specification<Good_Models> findByModelNameLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("modelName")), filter.getSearch().toLowerCase()+"%");
		};
	}

//	@Override
//	public Page<Good_Models> findByTypeId(int id, Pageable pageable,
//			ModelFilter filter) {
//		return goodModelDao.findByTypeId(id, new GoodModelSpecifications(filter), pageable);
//	}





	
	
	
	
	


	
}
