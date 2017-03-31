package ua.com.controller.admin;

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

import ua.com.dto.filter.ModelFilter;
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
import ua.com.hustle.Memory;
import ua.com.hustle.Procc_Type;
import ua.com.hustle.Ram_Type;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.service.Memory_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.util.ParamBuilder;
import ua.com.validator.GoodModelValidator;


@Controller
@RequestMapping("/admin/goodModels")
@SessionAttributes("goodModel")
public class Good_Models_Controller {
	
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
	
	
	@RequestMapping("/")
	public String goHome(){
		return "user-hustleMain";
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		status.setComplete();
		return "redirect:/admin/goodModels"+getParams(pageable, filter);
	}
	
	@InitBinder("goodModel")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Good_Type.class, new GoodTypeEditor(goodTypeService));
		binder.registerCustomEditor(GPU_Type.class, new GPU_TypeEditor(gpuTypeService));
		binder.registerCustomEditor(Memory.class, new MemoryEditor(memoryService));
		binder.registerCustomEditor(Procc_Type.class, new ProccTypeEditor(proccTypeService));
		binder.registerCustomEditor(Ram_Type.class, new RamTypeEditor(ramTypeService));
		binder.registerCustomEditor(Goods.class, new GoodsEditor(goodService));
		binder.setValidator(new GoodModelValidator(goodModelService));
	}
	
	@ModelAttribute("filter")
	public ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	@ModelAttribute("goodModel")
	public Good_Model_Form getForm(){
		return new Good_Model_Form();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", goodModelService.findAll(pageable, filter));
		model.addAttribute("goods", goodService.findAll());
		model.addAttribute("goodTypes", goodTypeService.findAll());
		model.addAttribute("gpuTypes", gpuTypeService.findAll());
		model.addAttribute("memories", memoryService.findAll());
		model.addAttribute("proccs", proccTypeService.findAll());
		model.addAttribute("rams", ramTypeService.findAll());
		return "admin-goodModels";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		goodModelService.delete(id);
		return "redirect:/admin/goodModels"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		model.addAttribute("goodModel", goodModelService.findForm(id));
		return show(model, pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("goodModel")@Valid Good_Model_Form goodModel ,BindingResult br, Model model,SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		goodModelService.save(goodModel);
		status.setComplete();
		return "redirect:/admin/goodModels"+getParams(pageable, filter);
	}
	

	private String getParams(Pageable pageable, ModelFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if(!filter.getMax().isEmpty()){
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if(!filter.getMin().isEmpty()){
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		
		if(!filter.getGoodTypesId().isEmpty()){
			for(Integer id: filter.getGoodTypesId()){
				buffer.append("&goodTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getGoodsId().isEmpty()){
			for(Integer id: filter.getGoodsId()){
				buffer.append("&goodsId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getGpuTypesId().isEmpty()){
			for(Integer id: filter.getGpuTypesId()){
				buffer.append("&gpuTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getMemoriesId().isEmpty()){
			for(Integer id: filter.getMemoriesId()){
				buffer.append("&memoriesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getProccTypesId().isEmpty()){
			for(Integer id: filter.getProccTypesId()){
				buffer.append("&proccTypesId=");
				buffer.append(id);
			}
		}
		
		if(!filter.getRamTypesId().isEmpty()){
			for(Integer id: filter.getRamTypesId()){
				buffer.append("&ramTypesId=");
				buffer.append(id);
			}
		}
		
		return buffer.toString();
		
	}
	
	
	
	
	
	

}
