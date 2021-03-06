package iavanish.REST;

import iavanish.Database.DatabaseWrite;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/updateProfile")
public class UpdateProfile {
	
    @GET
    @Path("/updateProfile")  
    @Produces(MediaType.APPLICATION_JSON) 
   
    public String updateProfile(@QueryParam("rollNo") String rollNo, @QueryParam("name") String name, @QueryParam("password") String password, @QueryParam("emailID") String emailID) {
        
    	String response = "";
    	boolean status = false;
    	
    	if(UtilityClass.isNotNull(rollNo) && UtilityClass.isNotNull(name) && UtilityClass.isNotNull(password) && UtilityClass.isNotNull(emailID)) {
            status = DatabaseWrite.updateProfile(rollNo, name, password, emailID);
    	}
        
    	if(status) {
    		response = UtilityClass.constructJSON("updateProfile", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("updateProfile", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
