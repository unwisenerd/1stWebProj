//package ua.com.hustle;
//
//import java.beans.Expression;
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//
//
//
//
//public class Main {
//	
//	private static final Scanner sc = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		
//		while(true){
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//			
//			EntityManager manager = factory.createEntityManager();
//			
//			Good_Models_Dao controller_Models = new Good_Models_Dao(manager);
//			
//			Goods_Dao controller_Goods = new Goods_Dao(manager);
//			
//			//MakinCountry mk = MakinCountry.USA;
//			
//			System.out.println("Press 1 to add good model to data base");
//			System.out.println("Press 2 to show all models from data base");
//			System.out.println("Press 3 to find certain model from data base");
//			System.out.println("Press 4 to delete certain model from data base");
//			System.out.println("Press 5 to add price to certain good");
//			System.out.println("Press 6 to connect model and price");
//			System.out.println("Press 7 to show all prices");
//			System.out.println("Press 8 to fing good by price");
//			System.out.println("Press 9 to delete certain price");
//			System.out.println("10 to annotation show all models");
//			System.out.println("11 to find one model by annotation");
//			System.out.println("12 to Criteria Api usage test");
//			System.out.println("13 to join test");
//			System.out.println("14 to select with agr function");
//			System.out.println("15 to delete connection");
//			
//			switch (sc.next()) {
//			case "1":
//				System.out.println("Enter good model name");
//				
//				controller_Models.save(new Good_Models(sc.next()));
//				
//				System.out.println("Entered good was succesfully added");
//				break;
//
//			case "2":
//				controller_Models.findAll().forEach(System.out::println);
//				break;
//				
//			case "3":
//				System.out.println("Enter model's name ");
//				
//				System.out.println(controller_Models.findOne(sc.next()));
//				
//				break;
//				
//			case "4":
//				System.out.println("Enter good you want to delete");
//				
//				controller_Models.delete(sc.next());
//				
//				System.out.println("Entered good was succesfully deleted");
//				break;
//				
//			case "5":
//				System.out.println("Enter price you want to add");
//				
//				controller_Goods.savePrice(new Goods(sc.nextInt(), MakinCountry.USA));
//				//controller_Goods.saveCountry();
//				
//				System.out.println("Entered price was succesfully added");
//				break;
//				
//			case "6":
//				System.out.println("Enter model name");
//				String modelName = sc.next();
//				
//				System.out.println("Enter good price");
//				int modelPrice = sc.nextInt();
//				
//				controller_Models.addModelToGood(modelName, modelPrice);
//				
//				System.out.println("Model and price were sucessfully connected");
//				
//				break;
//				
//			case "7":
//				
//				controller_Goods.findAll().forEach(System.out::println);
//				
//				break;
//				
//			case "8":
//				
//				System.out.println("Enter good's price ");
//				
//				System.out.println(controller_Goods.findOneByPrice(sc.nextInt()));
//				
//				break;
//				
//			case "9":
//				System.out.println("Enter price you want to delete");
//				
//				controller_Goods.delete(sc.nextInt());
//				
//				System.out.println("Entered price was succesfully deleted");
//				break;
//				
//			case "10":				
//				
//				List<Good_Models>  models = manager.createNamedQuery("findAll").getResultList();
//				models.forEach(System.out::println);
//				
//				break;
//				
//			case "11":				
//				System.out.println("Enter model's name");
//				
//				Good_Models model = (Good_Models) manager.createNamedQuery("findByModelName").setParameter("param", sc.next()).getSingleResult();
//				
//				System.out.println(model);
//				
//				break;
//				
//			case "12":				
//			
//				criteriaParamSearch();
//				
//				break;
//				
//			case "13":				
//				
//				joinTest();
//				
//				break;
//				
//			case "14":				
//				
//				selectWithAgrFunc();
//				
//				break;
//				
//			case "15":				
//				
//				controller_Models.deleteConnectionGoodPrice("omega", 999);
//				
//				break;
//			default:
//				sc.close();
//				break;
//			}
//			
//			
//			
//			manager.close();
//			
//			factory.close();
//		}
//		
//		
//		
//	}
//	
//	public static void criteriaParamSearch(){
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		
//		EntityManager manager = factory.createEntityManager();
//		
//		
//			
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		
//		CriteriaQuery<Goods> modelCriteriaQuery = builder.createQuery(Goods.class);
//		
//		Root<Goods> modelsRoot = modelCriteriaQuery.from(Goods.class);
//		
//		javax.persistence.criteria.Expression<Integer> expression = modelsRoot.get("price");
//
//		//Predicate predicateModel = builder.lessThan(expression, 999);
//		
//		Predicate predicateModel = builder.between(expression, 899,1999);
//		
//		// dlia bagatioh Predicate pd = builder.and(predicateModel , predicateElse);
// 		
//		modelCriteriaQuery.where(predicateModel);
//		
//		List<Goods> modelsList = manager.createQuery(modelCriteriaQuery).getResultList();
//		
//		modelsList.forEach(System.out::println);
//		
//		manager.close();
//		
//		factory.close();
//		
//	}
//	
//	public static void joinTest(){
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		
//		EntityManager manager = factory.createEntityManager();
//		
//		List<Good_Models> goodModels = manager.createQuery("SELECT i FROM Good_Models i JOIN i.goods c WHERE c.price =:param", Good_Models.class).
//				setParameter("param", 1999).getResultList();
//		
//		goodModels.forEach(System.out::println);
//				
//		Good_Models goodModels1 = manager.createQuery("SELECT DISTINCT c FROM Good_Models c LEFT JOIN FETCH c.goods WHERE c.id=:param", Good_Models.class).
//				setParameter("param", 6).getSingleResult();		
//		
//		System.out.println("= "+goodModels1);
//				
//		manager.close();
//		
//		factory.close();
//	}
//	
//	public static void selectWithAgrFunc(){
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		
//		EntityManager manager = factory.createEntityManager();
//		
//		//manager.getTransaction().begin();
//		
//		int maxPrice = manager.createQuery("Select max(i.price) FROM Goods i",Integer.class).getSingleResult();
//		
//		System.out.println("max price = "+maxPrice);
//		
//		int minPrice = manager.createQuery("Select min(i.price) FROM Goods i", Integer.class).getSingleResult();
//		
//		System.out.println("min price = "+minPrice);
//		
//		double avrPrice = manager.createQuery("Select avg(i.price) FROM Goods i", Double.class).getSingleResult();
//		
//		System.out.println("avr price = "+avrPrice);
//		
//		long countPrice = manager.createQuery("Select count(i.id) FROM Goods i", Long.class).getSingleResult();
//		
//		System.out.println("count price = "+countPrice);
//		
//		//manager.getTransaction().commit();
//		
//		manager.close();
//		
//		factory.close();
//	}
//
//}
