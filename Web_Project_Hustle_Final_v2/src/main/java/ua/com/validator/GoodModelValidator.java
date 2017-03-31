package ua.com.validator;

import java.util.regex.Pattern;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.dto.form.Good_Model_Form;
import ua.com.service.Good_Models_Service;

public class GoodModelValidator implements Validator{

	private static final Pattern REG = Pattern.compile("^[0-9]+$");
	
	private final Good_Models_Service goodModelService;

	public GoodModelValidator(Good_Models_Service goodModelService) {
		super();
		this.goodModelService = goodModelService;
	}

	public boolean supports(Class<?> clazz) {
		return Good_Model_Form.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Good_Model_Form form = (Good_Model_Form) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelName", "", "Can not be empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can not be empty");

		
		if(!REG.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Only digits here");
		}
		if(errors.getFieldError("price")==null){
			if(goodModelService.findUnique(form.getModelName(), form.getPrice(), form.getGood(), form.getGoodType(), form.getGpuType(), form.getMemoryType(), form.getProccType(), form.getRamType())!=null){
				errors.rejectValue("goodType", "", "Already exists");
			}
		}
		
	}
	
	
}
