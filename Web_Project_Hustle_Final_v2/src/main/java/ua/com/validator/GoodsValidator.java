package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.hustle.Goods;
import ua.com.service.Goods_Service;

public class GoodsValidator implements Validator {

	private final Goods_Service goodService;
	
	public GoodsValidator(Goods_Service goodService) {
		super();
		this.goodService = goodService;
	}
	

	public boolean supports(Class<?> clazz) {
		return Goods.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Goods goods = (Goods) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "madeCountry", "", "Can not be empty");
		
		if(goodService.findByMadeCountry(goods.getMadeCountry())!=null){
			errors.rejectValue("madeCountry", "", "Already exists");
		}
	}

	
	
}
