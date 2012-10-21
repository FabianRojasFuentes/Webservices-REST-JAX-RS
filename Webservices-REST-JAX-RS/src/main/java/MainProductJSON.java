import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class MainProductJSON
{
	
	public static void main(String[] args)
	{
		
		Client client = Client.create();
		
		//POST
//		WebResource webResource = client.resource("http://127.0.0.1:8080/maven-jax-rs/product");
//
//		String data = "{\"price\":\"1200\",\"productName\":\"G-Funk EP\",\"referenceNumber\":\"8888\",\"brand\":\"Oslo Records\",\"description\":\"Havy BassLine\",\"genre\":\"House\",\"state\":\"IN_STOCK\"}";
//		 
//		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, data);
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
//		 webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
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
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/8888");
//		
//		String data = "{\"price\":\"1200\",\"productName\":\"T-1000 Dance Evolution\",\"referenceNumber\":\"8888\",\"brand\":\"Oslo Records\",\"description\":\"Havy BassLine\",\"genre\":\"House\",\"state\":\"IN_STOCK\"}";
//
//			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, data);
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
//		 webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
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
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/product/8888");
//		 ClientResponse response =
//		 webResource.accept(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class);
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


	}

}
