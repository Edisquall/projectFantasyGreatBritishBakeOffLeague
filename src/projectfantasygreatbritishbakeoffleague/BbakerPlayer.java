/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

/**
 *
 * @author Yevhen
 */
public class BbakerPlayer {
    private String name;
    private double score;
    private boolean isNewPlayer;
    private String passHash;
    private boolean isAdmin = false;

    public BbakerPlayer(){
        score = 0;
        passHash = "";
        isNewPlayer = true;
    }

    public boolean getIsNewPlayer() {
        return isNewPlayer;
    }

    public boolean userIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsNewPlayer(boolean isNewPlayer) {
        this.isNewPlayer = isNewPlayer;
    }
    public BbakerPlayer(String pass){
        isAdmin = true;
        passHash = "<<<" + pass + ">>>";
    }
    
    public boolean IsAdmin(String pass){
        return passHash.equals("<<<" + pass + ">>>");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
}
