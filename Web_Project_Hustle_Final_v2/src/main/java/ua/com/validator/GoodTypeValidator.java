package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.hustle.Good_Type;
import ua.com.service.Good_Type_Service;

public class GoodTypeValidator implements Validator {

	private final Good_Type_Service goodTypeService;
	
	
	public GoodTypeValidator(Good_Type_Service goodTypeService) {
		super();
		this.goodTypeService = goodTypeService;
	}
	
	public boolean supports(Class<?> clazz) {
		return Good_Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Good_Type goodType = (Good_Type) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "Can not be empty");
		if(goodTypeService.findByType(goodType.getType())!=null){
			errors.rejectValue("type", "", "Already exists");
		}
		
	}

	
	
}
