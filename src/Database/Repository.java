package Database;

import java.sql.*;


public class Repository {
    private String myDriver;
    private String url;
    private String myUser;
    private String myPassword;
    
    public Repository(String myDriver, String url, 
                        String myUser, String myPassword) {
        this.myDriver = myDriver;
        this.url = url;
        this.myUser = myUser;
        this.myPassword = myPassword;
    }

    public Repository() {
        this("org.apache.derby.jdbc.EmbeddedDriver",
            "jdbc:derby:players","sqluser","sqlpassword");
    }
    
    public java.util.List<CointossDB> getAll() {
        java.util.List<CointossDB> users=new java.util.ArrayList<>();
        Connection con=
                ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if(con==null) return users;
        PreparedStatement sqlQuery=null;
        ResultSet results=null;
        try{
           String myQuery="select userID, username, password, points from players";
           sqlQuery=con.prepareStatement(myQuery);
           results=sqlQuery.executeQuery();
           while(results.next()) {
               users.add(new CointossDB( results.getInt("userID"),
                                        results.getString("username"),
                                        results.getString("password"),
                                        results.getInt("points")
                                      ));  
           }      
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);    
        }
         return users;
    }
    
    public int loginPoints(String currentUser, String currentPass) {
        Connection con=
                ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if(con==null) return -1;
        PreparedStatement sqlQuery=null;
        ResultSet results=null;
        try{
           String myQuery="SELECT points FROM players WHERE username=? AND password=?";
           sqlQuery=con.prepareStatement(myQuery);
           sqlQuery.setString(1, currentUser);
           sqlQuery.setString(2, currentPass);
           results=sqlQuery.executeQuery();
           if(results.next()) {
               return results.getInt("points");  
           }
           else return -1;
        }
        catch(Exception e){
           return -1;
        }
        finally{
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);    
        }
    }
}
