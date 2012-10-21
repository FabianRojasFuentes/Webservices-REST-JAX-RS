import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainProduct
{

	public static void main(String[] args)
	{
		Client client = Client.create();

//		---------------------------------------------------------------------------------------------------------------

		
		// POST
//		WebResource webResource = client.resource("http://127.0.0.1:8080/maven-jax-rs/product");
//
//		String data = "<?xml version=\"1.0\"?>" +
//				 "<product>" +
//				 "<productName>Trance Deluxe T-1000</productName>" +
//				 "<price>500</price>" +
//				 "<brand>Desolat</brand>" +
//				 "<referenceNumber>1230000</referenceNumber>" +
//				 "<description>Good CD</description>" +
//				 "<genre>Trance</genre>" +
//				 "<state>IN_STOCK</state>" +
//				 "</product>";
//		 
//		ClientResponse response = webResource.type(MediaType.APPLICATION_XML_TYPE).post(ClientResponse.class, data);
//
//		if (response.getStatus() == 201)
//		{
//			System.out.println("Status: " + response.getStatus());
//			System.out.println("Address: " + response.getHeaders().get("Location"));
//		} else
//		{
//			System.out.println("Status: " + response.getStatus());
//		}
		
//		---------------------------------------------------------------------------------------------------------------


		 //GET
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/8888");
//		 ClientResponse response =
//		 webResource.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
//		 if (response.getStatus() == 200)
//		 {
//		 String output = response.getEntity(String.class);
//		 System.out.println("Status: " + response.getStatus());
//		 System.out.println(output);
//		 } else
//		 {
//		 System.out.println("Status-code: " + response.getStatus());
//		 }
		
		
//		---------------------------------------------------------------------------------------------------------------


		// PUT
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/09090");
//		 String data = 
//		 "<product>" +
//		 "<productName>Deluxe T</productName>" +
//		 "<price>1560</price>" +
//		 "<brand>Desolat</brand>" +
//		 "<referenceNumber>123</referenceNumber>" +
//		 "<description>Good CD</description>" +
//		 "<genre>Trance</genre>" +
//		 "<state>OUT_OF_STOCK</state>" +
//		 "</product>";
//
//			ClientResponse response = webResource.type(MediaType.APPLICATION_XML_TYPE).put(ClientResponse.class, data);
//		 
//		 		if (response.getStatus() == 200)
//		 		{
//		 			System.out.println("Status: " + response.getStatus());
//		 		} else
//		 		{
//		 			System.out.println("Status: " + response.getStatus());
//		 		}
		 		
//		---------------------------------------------------------------------------------------------------------------


		 //GET ALL
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/all");
//		 ClientResponse response =
//		 webResource.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
//		 if (response.getStatus() == 200)
//		 {
//		 String output = response.getEntity(String.class);
//		 System.out.println("Status: " + response.getStatus());
//		 System.out.println(output);
//		 } else
//		 {
//		 System.out.println("Status-code: " + response.getStatus());
//		 }

//		---------------------------------------------------------------------------------------------------------------

		 		
		// DELETE
		 WebResource webResource =
		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/8888");
		 ClientResponse response =
		 webResource.accept(MediaType.APPLICATION_XML_TYPE).delete(ClientResponse.class);
		 if (response.getStatus() == 200)
		 {
		 String output = response.getEntity(String.class);
		 System.out.println("Status: " + response.getStatus());
		 System.out.println(output);
		 } else
		 {
		 System.out.println("Status-code: " + response.getStatus());
		 }
		 		
//		---------------------------------------------------------------------------------------------------------------


	}

}
