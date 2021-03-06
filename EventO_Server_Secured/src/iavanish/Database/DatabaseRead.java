package iavanish.Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseRead {

	@SuppressWarnings("finally")
	public static Connection createConnection() {
    	
        Connection connection = null;
        
        try {
            Class.forName(Constants.dbClass);
            connection = (Connection)DriverManager.getConnection(Constants.dbURL, Constants.dbUser, Constants.dbPassword);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return connection;
        }
        
    }

    public static boolean login(String rollNo, String password) {
    	
        boolean isUserAvailable = false;
        Connection connection = null;
        
        try {
            
        	try {
                connection = createConnection();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Statement stmt = (Statement)connection.createStatement();
            
            String query = "SELECT * FROM user WHERE RollNo = '" + rollNo + "' AND Password = " + "'" + password + "'";

            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                isUserAvailable = true;
            }
            
        }
        
        catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
            	try {
            		connection.close();
            	}
            	catch(SQLException sqlE) {
            		sqlE.printStackTrace();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        }
        
        return isUserAvailable;
        
    }    
    
    public static List <User> viewAllUsers() {

    	List <User> users = new ArrayList <User> ();
    	
        Connection connection = null;
        
        try {
            
        	try {
                connection = createConnection();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Statement stmt = (Statement)connection.createStatement();
            
            String query = "SELECT * FROM user";

            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	User temp = new User(rs.getString(1), rs.getString(2), rs.getBoolean(4), rs.getString(5));
            	users.add(temp);
            }
            
        }
        
        catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
            	try {
            		connection.close();
            	}
            	catch(SQLException sqlE) {
            		sqlE.printStackTrace();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        }
        
        return users;
        
    }
    
    public static List <Event> viewAllEvents() {

    	List <Event> events = new ArrayList <Event> ();
    	
        Connection connection = null;
        
        try {
            
        	try {
                connection = createConnection();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Statement stmt = (Statement)connection.createStatement();
            
            String query = "SELECT * FROM event";

            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	Event temp = new Event(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            	events.add(temp);
            }
            
        }
        
        catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
            	try {
            		connection.close();
            	}
            	catch(SQLException sqlE) {
            		sqlE.printStackTrace();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        }
        
        return events;
        
    }
    
    public static User getUserDetails(String rollNo) {

    	User user = null;
    	
        Connection connection = null;
        
        try {
            
        	try {
                connection = createConnection();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Statement stmt = (Statement)connection.createStatement();
            
            String query = "SELECT * FROM user WHERE RollNo = '" + rollNo + "'";

            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()) {
            	User temp = new User(rs.getString(1), rs.getString(2), rs.getBoolean(4), rs.getString(5));
            	user = temp;
            }
            
        }
        
        catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
            	try {
            		connection.close();
            	}
            	catch(SQLException sqlE) {
            		sqlE.printStackTrace();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        }
        
        return user;
        
    }
    
}
