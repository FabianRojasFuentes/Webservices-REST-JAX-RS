import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class MainUser
{
	
	public static void main(String[] args)
	{
		Client client = Client.create();

		// POST
//		WebResource webResource = client.resource("http://127.0.0.1:8080/maven-jax-rs/user");
//		
//		String data = "{\"state\":\"Active\",\"lastName\":\"Svensson\",\"firstName\":\"Karl\",\"co\":\"co\",\"phone\":\"555555\",\"street\":\"Gongvagen\",\"password\":\"pass\",\"postal\":\"123454\",\"city\":\"Sthlm\",\"email\":\"hej@1234.com\",\"country\":\"Swe\"}";
//
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
		
		// GET	
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/user/hej@1234.com");
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
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/user/hej@1234.com");
//		String data = "{\"state\":\"Active\",\"lastName\":\"Karlsson\",\"firstName\":\"Karl\",\"co\":\"co\",\"phone\":\"555555\",\"street\":\"Gongvagen\",\"password\":\"pass\",\"postal\":\"123454\",\"city\":\"Sthlm\",\"email\":\"hej@1234.com\",\"country\":\"Swe\"}";
//
//			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, data);
//		 
//		 		if (response.getStatus() == 200)
//		 		{
//		 			System.out.println("Status: " + response.getStatus());
//		 			
//		 		} else
//		 		{
//		 			System.out.println("Status: " + response.getStatus());
//		 		}
		
//		---------------------------------------------------------------------------------------------------------------
		
		 //GET ALL
//		 WebResource webResource =
//		 client.resource("http://127.0.0.1:8080/maven-jax-rs/user/all");
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
		 WebResource webResource =
		 client.resource("http://127.0.0.1:8080/maven-jax-rs/user/hej@1234.com");
		 ClientResponse response =
		 webResource.accept(MediaType.APPLICATION_JSON_TYPE).delete(ClientResponse.class);
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
