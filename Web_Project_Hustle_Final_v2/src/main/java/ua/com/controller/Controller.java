package ua.com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import ua.com.CRUD.dao.Good_Models_Dao_Final;
import ua.com.hustle.GPU_Type;
import ua.com.hustle.Good_Models;
import ua.com.hustle.Good_Type;
import ua.com.hustle.Goods;

import ua.com.hustle.Memory;
import ua.com.hustle.Procc_Type;
import ua.com.hustle.Ram_Type;
import ua.com.hustle.User;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Good_Models_Service;
import ua.com.service.Good_Type_Service;
import ua.com.service.Goods_Service;
import ua.com.service.Memory_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.User_Service;
import ua.com.serviceImpl.GPU_Type_ServiceImpl;
import ua.com.serviceImpl.Good_Models_ServiceImpl;
import ua.com.serviceImpl.Good_Type_ServiceImpl;
import ua.com.serviceImpl.Goods_ServiceImpl;
import ua.com.serviceImpl.Memory_ServiceImpl;
import ua.com.serviceImpl.Procc_Type_ServiceImpl;
import ua.com.serviceImpl.Ram_Type_ServiceImpl;
import ua.com.serviceImpl.User_ServiceImpl;

public class Controller {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		
		Good_Models_Service goodModelService = (Good_Models_Service) context.getBean(Good_Models_ServiceImpl.class);
		
		Good_Type_Service goodTypeService = (Good_Type_Service) context.getBean(Good_Type_ServiceImpl.class);
		
		Goods_Service goodService = (Goods_Service) context.getBean(Goods_ServiceImpl.class);
		
		GPU_Type_Service gpuTypeService = (GPU_Type_Service) context.getBean(GPU_Type_ServiceImpl.class);
		
		Memory_Service memoryService = (Memory_Service) context.getBean(Memory_ServiceImpl.class);
		
		Procc_Type_Service proccTypeService = (Procc_Type_Service) context.getBean(Procc_Type_ServiceImpl.class);
		
		Ram_Type_Service  ramTypeService = (Ram_Type_Service) context.getBean(Ram_Type_ServiceImpl.class);
		
		User_Service userService = (User_Service) context.getBean(User_ServiceImpl.class);
		
		
		System.out.println(userService.findByEmail("unwisenerd@gmail.com"));
		//userService.save(new User("Joe Tribiani", "iml3g3nd555@gmail.com", "123456qwerty", "+30939842242", 79002));
		
		System.out.println(ramTypeService.findByRamType("16GB DDR4"));
//		
//		System.out.println(memoryService.findByType("512SSD"));
		
		//System.out.println(goodService.findByPrice(983));
		
		//ramTypeService.save(new Ram_Type("16GB DDR4"));
		
		//System.out.println(proccTypeService.findOne(1));
		
		//proccTypeService.save(new Procc_Type("Intel core i7 6900"));
		
		//memoryService.findAll().forEach(System.out::println);
		
		//memoryService.save(new Memory("512SSD"));
		
		
		//gpuTypeService.save(new GPU_Type("Nvidia GeForce 1080"));
		
//		System.out.println(gpuTypeService.findByType("Nvidia GeForce 1080"));
		
		//goodService.save(new Goods(2999, MakinCountry.USA));
		
		
		
		//goodModelService.save(new Good_Models("Oomega"));
		
		//goodModelService.delete("Oomega");
		
//		Good_Models goodModel = goodModelService.findBymodelName("etha");
		
		//DONE
		//goodTypeService.save(new Good_Type("desktop"));
//		
//		System.out.println(goodTypeService.findByType("desktop"));
//		
//		System.out.println(goodModelService.findOne(5));
//		
//		System.out.println(goodModel);
		
		context.close();
		
		
	}

}
