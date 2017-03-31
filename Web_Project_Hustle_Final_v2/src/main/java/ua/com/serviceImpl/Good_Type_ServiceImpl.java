package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.CRUD.dao.Good_Type_Dao_Final;
import ua.com.dto.filter.TypeFilter;
import ua.com.hustle.Good_Models;
import ua.com.hustle.Good_Type;
import ua.com.service.FileWriter;
import ua.com.service.FileWriter.Folder;
import ua.com.service.Good_Type_Service;

@Service
public class Good_Type_ServiceImpl implements Good_Type_Service{

	@Autowired
	private Good_Type_Dao_Final goodTypeDaoFinal;
	
	@Autowired
	private FileWriter fileWriter;

	public void save(Good_Type goodType) {
		
		MultipartFile file = goodType.getFile();
		
		goodType = goodTypeDaoFinal.saveAndFlush(goodType);
		
		if(fileWriter.write(Folder.GOODTYPES, file, goodType.getId())){
			goodType.setVersion(goodType.getVersion()+1);
			
			goodTypeDaoFinal.save(goodType);
		}
		
		
	}



	public List<Good_Type> findAll() {
		return goodTypeDaoFinal.findAll();
	}



	public Good_Type findOne(int id) {
		return goodTypeDaoFinal.findOne(id);
	}



	public void delete(int id) {
		
		goodTypeDaoFinal.delete(id);
	}
	
	public Good_Type findByType(String type) {
		return goodTypeDaoFinal.findByType(type);
	}



	public List<Good_Type> findByModelId(int id) {
		return goodTypeDaoFinal.findByModelId(id);
	}



	@Override
	public Page<Good_Type> findAll(TypeFilter filter, Pageable pageable) {
		return goodTypeDaoFinal.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Good_Type> findByTypeLike(TypeFilter filter){
		return (root, query, cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
