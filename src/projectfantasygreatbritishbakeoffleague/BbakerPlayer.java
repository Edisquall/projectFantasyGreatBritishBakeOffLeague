/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

/**
 *
 * @author User
 */
public class BbakerPlayer {
    private String name;
    private double score;
    private String passHash;

    public BbakerPlayer(String pass){
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
