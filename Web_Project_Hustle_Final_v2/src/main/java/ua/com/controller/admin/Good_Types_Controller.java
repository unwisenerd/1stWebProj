package ua.com.controller.admin;

import javax.validation.Valid;
import static ua.com.util.ParamBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.dto.filter.TypeFilter;
import ua.com.hustle.Good_Type;
import ua.com.service.Good_Type_Service;
import ua.com.validator.GoodTypeValidator;


@Controller
@RequestMapping("/admin/goodTypes")
@SessionAttributes("goodType")
public class Good_Types_Controller {
	
	@Autowired
	private Good_Type_Service goodTypeService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("goodType")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new GoodTypeValidator(goodTypeService));
	}
	
	
	@ModelAttribute("goodType")
	public Good_Type getForm(){
		return new Good_Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/goodTypes"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", goodTypeService.findAll(filter, pageable));
		return "admin-goodTypes";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("goodType", goodTypeService.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		goodTypeService.delete(id);
		return "redirect:/admin/goodTypes"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("goodType") @Valid Good_Type goodType,BindingResult br, Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		goodTypeService.save(goodType);
		status.setComplete();
		return "redirect:/admin/goodTypes"+getParams(pageable, filter);
	}
	
	

}
