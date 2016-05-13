package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                "jdbc:derby:players", "sqluser", "sqlpassword");
    }

    public int loginPoints(String currentUser, String currentPass) {
        Connection con
                = ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if (con == null) {
            return -1;
        }
        PreparedStatement sqlQuery = null;
        ResultSet results = null;
        try {
            String myQuery = "SELECT points FROM players WHERE username=? AND password=?";
            sqlQuery = con.prepareStatement(myQuery);
            sqlQuery.setString(1, currentUser);
            sqlQuery.setString(2, currentPass);
            results = sqlQuery.executeQuery();
            if (results.next()) {
                return results.getInt("points");
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        } finally {
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);
        }
    }

    public int updatePoints(String newPoints, String currentUser) {
        Connection con
                = ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if (con == null) {
            return 1;
        }
        PreparedStatement sqlQuery = null;
        ResultSet results = null;
        try {
            String myQuery = "UPDATE players SET points=? WHERE username=?";
            sqlQuery = con.prepareStatement(myQuery);
            sqlQuery.setString(1, newPoints);
            sqlQuery.setString(2, currentUser);
            sqlQuery.executeUpdate();
            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);
        }
    }

    public int addUser(String newUser, String newPassword) {
        Connection con
                = ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if (con == null) {
            return 1;
        }
        PreparedStatement sqlQuery = null;
        ResultSet results = null;
        try {
            String myQuery = "INSERT INTO players (username, password, points) VALUES (?, ?, 100)";
            sqlQuery = con.prepareStatement(myQuery);
            sqlQuery.setString(1, newUser);
            sqlQuery.setString(2, newPassword);
            sqlQuery.executeUpdate();
            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);
        }
    }

    public int removeUser(String delUser, String delPassword) {
        Connection con
                = ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if (con == null) {
            return 1;
        }
        PreparedStatement sqlQuery = null;
        ResultSet results = null;
        try {
            String myQuery = "DELETE FROM players WHERE username=? AND password=?";
            sqlQuery = con.prepareStatement(myQuery);
            sqlQuery.setString(1, delUser);
            sqlQuery.setString(2, delPassword);
            return sqlQuery.executeUpdate();
        } catch (Exception e) {
            return 0;
        } finally {
            ConnectionControl.closeResults(results);
            ConnectionControl.closeQuery(sqlQuery);
            ConnectionControl.closeConnection(con);
        }
    }

    public List<HighPoints> getHighestPoints() {
        List<HighPoints> pointsit = new ArrayList<>();
        Connection con
                = ConnectionControl.openConnection(myDriver, url, myUser, myPassword);
        if (con != null) {
            PreparedStatement sqlQuery = null;
            ResultSet results = null;
            try {
                String myQuery = "SELECT username, points FROM players ORDER BY points DESC";
                sqlQuery = con.prepareStatement(myQuery);
                results = sqlQuery.executeQuery();
                while (results.next()) {
                    pointsit.add(new HighPoints(results.getString(1),
                            results.getInt(2)));
                }
            } catch (Exception e) {

            } finally {
                ConnectionControl.closeResults(results);
                ConnectionControl.closeQuery(sqlQuery);
                ConnectionControl.closeConnection(con);
            }
        }
        return pointsit;
    }
}
