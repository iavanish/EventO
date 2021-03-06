package iavanish.REST;

import iavanish.Database.DatabaseWrite;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/addEvent")
public class AddEvent {
	
    @GET
    @Path("/addEvent")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String addEvent(@QueryParam("eventID") long eventID, @QueryParam("name") String name, @QueryParam("date") String date, @QueryParam("time") String time, @QueryParam("rollNo") String rollNo) {
        
    	String response = "";
    	boolean status = false;
    	
    	if(UtilityClass.isNotNull(name) && UtilityClass.isNotNull(date) && UtilityClass.isNotNull(time) && UtilityClass.isNotNull(rollNo)) {
            status = DatabaseWrite.addEvent(eventID, name, date, time, rollNo);
    	}
        
    	if(status) {
    		response = UtilityClass.constructJSON("addEvent", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("addEvent", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
