package iavanish.REST;

import iavanish.Database.DatabaseWrite;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/userRegistration")
public class UserRegistration {
	
    @GET
    @Path("/userRegistration")  
    @Produces(MediaType.APPLICATION_JSON) 
   
    public String userRegistration(@QueryParam("rollNo") String rollNo, @QueryParam("name") String name, @QueryParam("password") String password, @QueryParam("emailID") String emailID) {
        
    	String response = "";
    	boolean status = false;
    	
    	if(UtilityClass.isNotNull(rollNo) && UtilityClass.isNotNull(name) && UtilityClass.isNotNull(password) && UtilityClass.isNotNull(emailID)) {
            status = DatabaseWrite.userRegistration(rollNo, name, password, false, emailID);
    	}
        
    	if(status) {
    		response = UtilityClass.constructJSON("userRegistration", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("userRegistration", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
