package ua.com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Good_Models_Dao_Final;
import ua.com.CRUD.dao.Goods_Dao_Final;
import ua.com.dto.filter.TypeFilter;
import ua.com.hustle.Goods;
import ua.com.service.Goods_Service;

@Service
public class Goods_ServiceImpl implements Goods_Service {

	@Autowired
	private Goods_Dao_Final goodDao;
	@Autowired
	private Good_Models_Dao_Final modelDao;

	public void save(Goods goods) {
		goodDao.save(goods);
	}

	
	public List<Goods> findAll() {
		return goodDao.findAll();
	}

	
	public Goods findOne(int id) {
		return goodDao.findOne(id);
	}

	
	public void delete(int id) {
		modelDao.save(modelDao.findByGoodId(id).stream().peek(e->e.setGood(null)).collect(Collectors.toList()));
		goodDao.delete(id);
		
	}


	public List<Goods> findByModelId(int id) {
		return goodDao.findByModelId(id);
	}


	public Goods findByMadeCountry(String madeCountry) {
		return goodDao.findByMadeCountry(madeCountry);
	}


	@Override
	public Page<Goods> findAll(TypeFilter filter, Pageable pageable) {
		return goodDao.findAll(findByTypeLike(filter), pageable);
	}

	private Specification<Goods> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("madeCountry")), filter.getSearch().toLowerCase()+"%");
		};
	}



	
	










}
