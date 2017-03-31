package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.hustle.Good_Type;
import ua.com.service.Good_Type_Service;

public class GoodTypeEditor extends PropertyEditorSupport {

	private final Good_Type_Service goodTypeService;

	public GoodTypeEditor(Good_Type_Service goodTypeService) {
		this.goodTypeService = goodTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Good_Type goodType = goodTypeService.findOne(Integer.valueOf(text));
		setValue(goodType);
	}
	
	
	
}
