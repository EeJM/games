package Database;

import java.sql.*;


public class Repository {
    private String ajuri;
    private String url;
    private String kayttaja;
    private String salasana;
    
    public Repository(String ajuri, String url, 
                        String kayttaja, String salasana) {
        this.ajuri = ajuri;
        this.url = url;
        this.kayttaja = kayttaja;
        this.salasana = salasana;
    }

    public Repository() {
        this("org.apache.derby.jdbc.EmbeddedDriver",
            "jdbc:derby:players","sqluser","sqlpassword");
    }
    
    public java.util.List<CointossDB> haeKaikki() {
        java.util.List<CointossDB> users=new java.util.ArrayList<>();
        Connection yhteys=
                YhteydenHallinta.avaaYhteys(ajuri, url, kayttaja, salasana);
        if(yhteys==null) return users;
        PreparedStatement hakulause=null;
        ResultSet tulosjoukko=null;
        try{
           String hakuSql="select userID, username, password, points from players";
           hakulause=yhteys.prepareStatement(hakuSql);
           tulosjoukko=hakulause.executeQuery();
           while(tulosjoukko.next()) {
               users.add(new CointossDB( tulosjoukko.getInt("userID"),
                                        tulosjoukko.getString("username"),
                                        tulosjoukko.getString("password"),
                                        tulosjoukko.getInt("points")
                                      ));  
           }      
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(hakulause);
            YhteydenHallinta.suljeYhteys(yhteys);    
        }
         return users;
    }//haeKaikki loppu
    
    public int loginPoints(String currentUser, String currentPass) {
        Connection yhteys=
                YhteydenHallinta.avaaYhteys(ajuri, url, kayttaja, salasana);
        if(yhteys==null) return -1;
        PreparedStatement hakulause=null;
        ResultSet tulosjoukko=null;
        try{
           String hakuSql="SELECT points FROM players WHERE username=? AND password=?";
           hakulause=yhteys.prepareStatement(hakuSql);
           hakulause.setString(1, currentUser);
           hakulause.setString(2, currentPass);
           tulosjoukko=hakulause.executeQuery();
           if(tulosjoukko.next()) {
               return tulosjoukko.getInt("points");  
           }
           else return -1;
        }
        catch(Exception e){
           return -1;
        }
        finally{
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(hakulause);
            YhteydenHallinta.suljeYhteys(yhteys);    
        }
    }
    
    
}
