import javax.ws.rs.core.MultivaluedMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.groupRed.maven.model.Product;
import se.groupRed.maven.model.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;



//import se.coredev.maven.model.Order;
//import se.coredev.maven.model.ShoppingCart;

import se.groupRed.maven.jpa.data.ECommerceService;



public class Main
{
	public static void main(String[] args) throws Exception
	{

//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });
//		ECommerceService ec = context.getBean(ECommerceService.class);

		Client client = Client.create();
		WebResource webResource = client.resource("http://127.0.0.1:8080/maven-jax-rs/product");
		
		//GET GET GET
//		String s = webResource.accept("application/json").get(String.class);
		
		//POST POST POST
		
		String data = "{\"productName\":\"Metallica\",\"price\":\"10\",\"brand\":\"Fade To Black\",\"referenceNumber\":\"111\",\"description\":\"Fade To Black\",\"genre\":\"MUSIC\",\"state\":\"IN STOCK\"}";
		

		
		// POST POST POST - Product
//		String data = "<?xml version=\"1.0\"?>" + 
//		"<product>" + 
//			"<productName>HEJHE321321321hgjfhjkJHEJ</productName>" + 
//			"<price>1000</price>" + 
//			"<brand>brand</brand>" + 
//			"<referenceNumber>5432112312321</referenceNumber>" +
//			"<description>description</description>" + 
//			"<genre>genre</genre>" +
//			"<state>state</state>" +
//		"</product>";

		
	
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);

	
	}
}
