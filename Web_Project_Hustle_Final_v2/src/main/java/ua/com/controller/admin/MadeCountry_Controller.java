package ua.com.controller.admin;

import static ua.com.util.ParamBuilder.getParams;

import javax.validation.Valid;

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
import ua.com.hustle.Goods;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.validator.GoodsValidator;


@Controller
@RequestMapping("/admin/goodCountries")
@SessionAttributes("madeCountry")
public class MadeCountry_Controller {
	
	@Autowired
	private Goods_Service goodService;
	
	@Autowired
	private Good_Type_Service goodTypeService;
	
	@Autowired
	private Good_Models_Service goodModelService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("madeCountry")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new GoodsValidator(goodService));
	}
	
	@ModelAttribute("madeCountry")
	public Goods getForm(){
		return new Goods();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/goodCountries"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", goodService.findAll(filter, pageable));
		return "admin-goodCountries";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("madeCountry", goodService.findOne(id));
		return show(model, pageable, filter);
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){		
		goodService.delete(id);
		return "redirect:/admin/goodCountries"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("madeCountry")@Valid Goods goods,BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		goodService.save(goods);
		status.setComplete();
		return "redirect:/admin/goodCountries"+getParams(pageable, filter);
		
	}

	
	
}
