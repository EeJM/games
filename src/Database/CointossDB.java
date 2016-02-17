package Database;



public class CointossDB {
    
    private final int userID;
    private final String user;
    private final int points;

    public CointossDB(int userID, String user, int points) {
        this.userID = userID;
        this.user = user;
        this.points = points;
    }

    public int getUserID() {
        return userID;
    }

    public String getUser() {
        return user;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "ID=" + userID +": " + user + "S." + points;
    }
    
    

    
}
