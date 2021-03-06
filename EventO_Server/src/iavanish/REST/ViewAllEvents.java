package iavanish.REST;

import iavanish.Database.DatabaseRead;
import iavanish.Database.Event;
import iavanish.Database.UtilityClass;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/viewAllEvents")
public class ViewAllEvents {
	
    @GET
    @Path("/viewAllEvents")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String viewAllEvents() {
        
    	String response = "";
    	List <Event> events = DatabaseRead.viewAllEvents();
        
    	response = UtilityClass.constructJSON(events, true);
        
        return response;
 
    }
 
}