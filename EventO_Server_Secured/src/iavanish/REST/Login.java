package iavanish.REST;

import iavanish.Database.DatabaseRead;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class Login {
	
    @GET
    @Path("/login")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String login(@QueryParam("rollNo") String rollNo, @QueryParam("password") String password) {
        
    	String response = "";
    	boolean status = DatabaseRead.login(rollNo, password);
        
    	if(status) {
    		response = UtilityClass.constructJSON("login", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("login", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
