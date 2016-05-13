/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author s1400674
 */
public class HighPoints {
    private String userName;
    private int points;

    public HighPoints(String userName, int points) {
        this.userName = userName;
        this.points = points;
    }

    public String getUserName() {
        return userName;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return userName + ": " + points;
    }
    
}
