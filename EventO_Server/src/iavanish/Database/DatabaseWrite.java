package iavanish.Database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseWrite extends DatabaseRead {

	public static boolean userRegistration(String rollNo, String name, String password, boolean typeOfUser, String emailID) {
    	
        boolean insertStatus = false;
        Connection connection = null;
        
        try {
            try {
                connection = createConnection();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            Statement stmt = (Statement)connection.createStatement();
            String query = "INSERT into user(RollNo, Name, Password, TypeOfUser, EmailID) values('" + rollNo + "'," + "'" + name + "','" + password + "','" + (typeOfUser ? 1 : 0) + "','" + emailID + "')";
            int records = stmt.executeUpdate(query);
            if(records > 0) {
                insertStatus = true;
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
        
        return insertStatus;
        
    }
	
	public static boolean updateProfile(String rollNo, String name, String password, String emailID) {
    	
        boolean updateStatus = false;
        Connection connection = null;
        
        try {
            try {
                connection = createConnection();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            Statement stmt = (Statement)connection.createStatement();
            String query = "UPDATE user SET Name = " + name + ", Password = " + password + ", EmailID = " + emailID + " WHERE RollNo = " + rollNo;
            int records = stmt.executeUpdate(query);
            if(records > 0) {
                updateStatus = true;
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
        
        return updateStatus;
        
    }
	
	public static boolean addEvent(long eventID, String name, String date, String time, String rollNo) {
    	
        boolean insertStatus = false;
        Connection connection = null;
        
        try {
            try {
                connection = createConnection();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            Statement stmt = (Statement)connection.createStatement();
            String query = "INSERT into event(EventID, Name, Date, Time, rollNo) values('" + eventID + "'," + "'" + name + "','" + date + "','" + time + "','" + rollNo + "')";
            int records = stmt.executeUpdate(query);
            if(records > 0) {
                insertStatus = true;
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
        
        return insertStatus;
        
    }
	
	public static boolean modifyEvent(long eventID, String name, String date, String time) {
    	
        boolean updateStatus = false;
        Connection connection = null;
        
        try {
            try {
                connection = createConnection();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            Statement stmt = (Statement)connection.createStatement();
            String query = "UPDATE event SET Name = " + name + ", Date = " + date + ", Time = " + time + " WHERE EventID = " + eventID;
            int records = stmt.executeUpdate(query);
            if(records > 0) {
                updateStatus = true;
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
        
        return updateStatus;
        
    }
	
	public static boolean deleteEvent(long eventID) {
    	
        boolean deleteStatus = false;
        Connection connection = null;
        
        try {
            try {
                connection = createConnection();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            Statement stmt = (Statement)connection.createStatement();
            String query = "DELETE FROM event WHERE EventID = " + eventID;
            int records = stmt.executeUpdate(query);
            if(records > 0) {
            	deleteStatus = true;
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
        
        return deleteStatus;
        
    }
	
}
