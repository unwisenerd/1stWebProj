package ua.com.controller.user;

import static ua.com.util.ParamBuilder.getParams;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Good_Model_Form;
import ua.com.editor.GPU_TypeEditor;
import ua.com.editor.GoodTypeEditor;
import ua.com.editor.GoodsEditor;
import ua.com.editor.MemoryEditor;
import ua.com.editor.ProccTypeEditor;
import ua.com.editor.RamTypeEditor;
import ua.com.hustle.GPU_Type;
import ua.com.hustle.Good_Type;
import ua.com.hustle.Goods;
import ua.com.hustle.Items;
import ua.com.hustle.Memory;
import ua.com.hustle.Procc_Type;
import ua.com.hustle.Ram_Type;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.service.ItemsService;
import ua.com.service.Memory_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.User_Service;

@Controller
@RequestMapping("/user/searching")
@SessionAttributes("purchaseInfo")
public class SearchingController {

	@Autowired
	private Good_Models_Service goodModelService;
	
	@Autowired
	private Goods_Service goodService;
	
	@Autowired
	private Good_Type_Service goodTypeService;
	
	@Autowired
	private GPU_Type_Service gpuTypeService;
	
	@Autowired
	private Memory_Service memoryService;
	
	@Autowired
	private Procc_Type_Service proccTypeService;
	
	@Autowired
	private Ram_Type_Service ramTypeService;
	
	@Autowired
	private ItemsService itemService;
	
	@Autowired
	private User_Service userService;
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		status.setComplete();
		return "redirect:/user/searching"+getParams(pageable, filter);
	}
	
	@InitBinder("searching")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Good_Type.class, new GoodTypeEditor(goodTypeService));
		binder.registerCustomEditor(GPU_Type.class, new GPU_TypeEditor(gpuTypeService));
		binder.registerCustomEditor(Memory.class, new MemoryEditor(memoryService));
		binder.registerCustomEditor(Procc_Type.class, new ProccTypeEditor(proccTypeService));
		binder.registerCustomEditor(Ram_Type.class, new RamTypeEditor(ramTypeService));
		binder.registerCustomEditor(Goods.class, new GoodsEditor(goodService));
	}
	
	@ModelAttribute("filter")
	public ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	@ModelAttribute("modelFilter")
	public TypeFilter getModelFilter(){
		return new TypeFilter();
	}
	
	//@RequestParam(defaultValue="",required=false) String search
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter, Principal principal ){
//		TypeFilter filter = new TypeFilter();
//		filter.setSearch(search);
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", goodModelService.findAll(pageable, filter));
		//model.addAttribute("page", goodModelService.findAll(modelFilter, pageable));
		
		model.addAttribute("goods", goodService.findAll());
		model.addAttribute("goodTypes", goodTypeService.findAll());
		model.addAttribute("gpuTypes", gpuTypeService.findAll());
		model.addAttribute("memories", memoryService.findAll());
		model.addAttribute("proccs", proccTypeService.findAll());
		model.addAttribute("rams", ramTypeService.findAll());
		
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-searching";
	}
	
	@ModelAttribute("purchaseInfo")
	public Items getForm(){
		return new Items();
	}
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id,@ModelAttribute("cartAdd")Good_Model_Form goodModel, Model model, 
			Pageable pageable,@ModelAttribute("filter") ModelFilter filter,@ModelAttribute("purchaseInfo") Items item, Principal principal,
			SessionStatus status){
		if(principal!=null){
			System.out.println(principal.getName());
			item.setUserName(principal.getName());
			item.setGoodName(goodModelService.findOne(id).getModelName());
			item.setTotalPrice(goodModelService.findOne(id).getPrice()*item.getQuantity());
			item.setFullName(userService.findByEmail(principal.getName()).getFullName());
			item.setDeliveryAddressCountry(userService.findByEmail(principal.getName()).getDeliveryAddressCountry());
			item.setDeliveryAddressCity(userService.findByEmail(principal.getName()).getDeliveryAddressCity());
			item.setDeliveryHomeAddress(userService.findByEmail(principal.getName()).getDeliveryHomeAddress());
			itemService.save(item);
			status.setComplete();
		}
		return "redirect:/user/searching";
	}
	
	
	
	
}
