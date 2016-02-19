package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionControl {
    
    public static Connection openConnection(String driver, String url,
                                        String dbUser, String dbPass) {
        try{
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(url,dbUser,dbPass);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection connectionToBeClosed) {
        if(connectionToBeClosed!=null) {
            try{
                connectionToBeClosed.close();
            }
            catch(Exception e){
                //Nothing to do
            }
        }   
    }
    
    public static void closeResults(ResultSet results) {
        if(results!=null){
            try{
                results.close();
            }
            catch(Exception e) {
                //Nothing to do
            }
        }
    }
    
    public static void closeQuery(Statement ourQuery) {
        if(ourQuery!=null){
            try{
                ourQuery.close();
            }
            catch(Exception e) {
              //Nothing to do 
            }
        }
        
        
    }
    
}
