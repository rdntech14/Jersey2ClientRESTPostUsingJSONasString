package package1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientRequest;

public class RestCall {
	
	public static void main(String[] args) {

		try {
			getCall();
			putCall();
			postCall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getCall(){
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target("http://localhost:8080");
		
		WebTarget employeeWebTarget = webTarget.path("student/list");

		Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response  = invocationBuilder.get(Response.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output = response.readEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	}
	
	public static void putCall(){
		
		//JSON Body
//		String JSONbody = "{\"indexes\":[0,1,2]}";
		String JSONbody = "{\n" + 
				"	\"id\": 1,\n" + 
				"	\"firstName\": \"Vernon\",\n" + 
				"	\"lastName\": \"Harper\",\n" + 
				"	\"email\": \"1111aaaa@gmail.com\",\n" + 
				"	\"programme\": \"Financial Analysis\",\n" + 
				"	\"courses\": [\n" + 
				"		\"computer1\",\n" + 
				"		\"Statistics\"\n" + 
				"	]\n" + 
				"}";
		
		
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target("http://localhost:8080");
		
		WebTarget employeeWebTarget = webTarget.path("student/1");

		Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response  = invocationBuilder.put(Entity.entity(JSONbody, MediaType.APPLICATION_JSON));

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output = response.readEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	}
	
public static void postCall(){
		
		//JSON Body
//		String JSONbody = "{\"indexes\":[0,1,2]}";
		String JSONbody = "{\n" + 
				"	\"id\": 11113,\n" + 
				"	\"firstName\": \"Vernon\",\n" + 
				"	\"lastName\": \"Harper\",\n" + 
				"	\"email\": \"1113@gmail.com\",\n" + 
				"	\"programme\": \"Financial Analysis\",\n" + 
				"	\"courses\": [\n" + 
				"		\"Accounting\",\n" + 
				"		\"Statistics\"\n" + 
				"	]\n" + 
				"}\n" + 
				"";
		
		
		Client client = ClientBuilder.newClient();

		Response response = client.target("http://localhost:8080")
									.path("student")
									.request()
									.post(Entity.entity(JSONbody, MediaType.APPLICATION_JSON),Response.class);
		
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output = response.readEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	}
	
}