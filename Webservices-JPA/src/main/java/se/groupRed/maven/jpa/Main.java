package se.groupRed.maven.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



//import se.coredev.maven.model.Order;
//import se.coredev.maven.model.ShoppingCart;

//import se.groupRed.maven.jpa.data.AdminService;
import se.groupRed.maven.jpa.data.OrderService;
import se.groupRed.maven.jpa.data.OrderlineService;
import se.groupRed.maven.jpa.data.ProductService;
import se.groupRed.maven.jpa.data.UserRepository;
import se.groupRed.maven.jpa.data.UserService;
import se.groupRed.maven.model.Address;
//import se.groupRed.maven.model.Admin;
import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;
import se.groupRed.maven.model.Product;
import se.groupRed.maven.model.User;

public class Main
{
	public static void main(String[] args) throws Exception
	{

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });
		
		UserService userService = context.getBean(UserService.class);
//		System.out.println("hej userservice");
		OrderService orderService = context.getBean(OrderService.class);
//		System.out.println("hej orderservice");
//		OrderlineService orderlineService = context.getBean(OrderlineService.class);
		ProductService productService = context.getBean(ProductService.class);
//		System.out.println("hej productservice");
		
		
//		AdminService adminService = context.getBean(AdminService.class);
		
//		User user = new User("hejsan", "bertsson", "Hej12345", "hej@123.com", new Address("Bonde street", "1032", "asdf", "Göteborg", "Sweden", "12345"));
		User user = userService.getUser(1L);
		
		Product product = productService.getProductWithReferenceNumber("123");
		List<Orderline> orderLines = new ArrayList<Orderline>();
		orderLines.add(new Orderline(product, 2));
		System.out.println(orderService.createOrder(new Order("world", "0909", user, orderLines)));
//		
//		userService.addUser(user); userService.addUser(user);
		
		
//		userService.updateUser(user);
//		userService.changeUserState(userService.getUserWithEmail("hej@123.com"));	
//		
//		System.out.println(userService.getUserAtStreet("Bond street"));
//		
//		System.out.println(userService.getUserWithEmail("hej@123.com"));
//		
//		User user = new User("kalle_ny", "bertsson_ny", "Hej123", "hej@123.com", new Address("Bond street", "1032", "asdf", "Stockholm", "Sweden", "12345"));

		
//		
		productService.addProduct("productName", "1000", "brand", "referenceNumber", "description", "genre", "state");
//		productService.addProduct(product2);
//		
//		System.out.println(productService.getProductWithReferenceNumber("123"));

//		Admin admin = new Admin("Iphone", "mac", "Apple@hotmail.com", "123");
//		Admin admin2 = new Admin("Galaxy", "android", "Samsung@hotmail.com", "321");
//		
//
//		adminService.addAdmin(admin);
//		adminService.addAdmin(admin2);
//		adminService.deleteAdmin(admin2);
		
//		User user2 = new User("pelleeeee", "bertsson", "Hej123", "heeeej@123.com", new Address("Bond street", "1032", "asdf", "Stockholm", "Sweden", "12345"));
//


		
		
//		Orderline ordL = new Orderline(productService.getProductWithReferenceNumber("123"), 4);
//		ordL.getTotalPrice();
//		Orderline ordL2 = new Orderline(productService.getProductWithReferenceNumber("321"), 3);
//		ordL2.getTotalPrice();
		
//
//		System.out.println(ordL);
//		
//		Order order = new Order();
////		List<Orderline> orders = order.getProductsOrdered()
//		List<Orderline> orders = new ArrayList<Orderline>();
				
//		System.out.println(ordL2);
//		orders.add(ordL2);
//		orders.add(ordL);
//		
//		System.out.println(order);
//		
//		order.setUser(userService.getUserWithEmail("hej@123.com"));
//		order.setProductsOrdered(orders);
//		orderlineService.saveOrderline(ordL2);
//		orderService.createOrder(order);
		
//		Order order = orderService.getOrderById(1L);
//		order.setState("SHIPPED");
//		
//		orderService.updateOrder(order);
		
//		System.out.println(orderService.getAllOrders());
//		
		
//		orderlineService.saveOrderline(ordL);
//		
//		System.out.println(orderService.getOrderById(1L));
		
//		
//		System.out.println(adminService.getAllAdmins());
	}
}
