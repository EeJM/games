package Database;



public class CointossDB {
    
    private final int userID;
    private final String username;
    private final String password;
    private final int points;

    public CointossDB(int userID, String user,String password, int points) {
        this.userID = userID;
        this.username = user;
        this.password = password;
        this.points = points;
    }

    public int getUserID() {
        return userID;
    }

    public String getUser() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "ID=" + userID +" username: " + username + " Points: " + points + " Password: "+password;
    }
    
    

    
}
