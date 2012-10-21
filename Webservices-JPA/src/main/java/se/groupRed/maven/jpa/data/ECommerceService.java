package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.groupRed.maven.model.Address;
import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Product;
import se.groupRed.maven.model.User;

@Service
public final class ECommerceService
{

	@Autowired
	private final ProductService productService;
	@Autowired
	private final UserService userService;
	@Autowired
	private final OrderService orderService;

	public ECommerceService(ProductService productService, UserService userService, OrderService orderService)
	{

		this.productService = productService;
		this.userService = userService;
		this.orderService = orderService;

	}

	// USER
	public User getUser(final String email)
	{
		return userService.getUserWithEmail(email);
	}
	
	public User getUserById(final Long id)
	{
		return userService.getUser(id);
	}

	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	public void addUser(String firstName, String lastName, String password, String email, String street, String postal,
			String co, String city, String country, String phone)
	{
		userService.addUser(firstName, lastName, password, email, street, postal, co, city, country, phone);
	}

	public void deleteUser(String email)
	{
		String state = "INACTIVE";
		userService.deleteUser(email, state);
	}

	public void updateUser(String firstName, String lastName, String password, String email, String street,
			String postal, String co, String city, String country, String phone)
	{
		userService.updateUser(new User(firstName, lastName, password, email, new Address(street, postal, co, city,
				country, phone)));
	}

	public boolean checkUser(String email)
	{
		return userService.checkUser(email);
	}
	
	public boolean checkUserWithId(Long id){
		return userService.checkUserWithId(id);
	}

	// PRODUCT
	public Product getProductById(final Long id)
	{
		return productService.getProduct(id);
	}
	
	public Product getProduct(final String referenceNumber)
	{
		return productService.getProductWithReferenceNumber(referenceNumber);
	}

	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}

	public void addProduct(String productName, String price, String brand, String referenceNumber, String description,
			String genre, String state)
	{
		productService.addProduct(productName, price, brand, referenceNumber, description, genre, state);
	}

	public void updateProduct(String productName, String price, String brand, String referenceNumber,
			String description, String genre, String state)
	{
		productService
				.updateProduct(new Product(productName, price, brand, referenceNumber, description, genre, state));
	}

	public void deleteProduct(String referenceNumber)
	{
		String state = "DELETED";
		productService.deleteProduct(referenceNumber, state);
	}

	public boolean checkProduct(String referenceNumber)
	{
		return productService.checkProduct(referenceNumber);
	}

	// ORDER

	public boolean checkOrderWithRefAndUserId(String ref, Long userId)
	{
		return orderService.checkOrderWithRefAndUserId(ref, userId);
	}
	
	public List<Order> getAllOrders(Long id)
	{
		return orderService.getAllOrders(id);
	}

	public boolean checkOrder(String referenceNumber)
	{
		return orderService.checkOrder(referenceNumber);
	}

	public Order getOrder(String referenceNumber, Long id)
	{
		return orderService.getOrderByReferenceNumberAndUserId(referenceNumber, id);
	}

	public void addOrder(Order order)
	{
		orderService.createOrder(order);
	}

	public void updateOrder(String referenceNumber, String state, Long userId)
	{
		orderService.updateOrder(state, referenceNumber, userId);
	}

	public void deleteOrder(String referenceNumber, Long userId)
	{

		orderService.deleteOrder(referenceNumber, userId);
	}
	
	public Order getOrderByReferenceNumber(final String referenceNumber){
		
		return orderService.getOrderByReferenceNumber(referenceNumber);
	}
	
	public void setUserOrderRelation(long orderId, long userId){
		orderService.setetUserOrderRelation(orderId, userId);
	}

}
