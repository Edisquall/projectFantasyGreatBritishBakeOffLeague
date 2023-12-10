/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

import java.time.LocalDate;  
import java.time.temporal.WeekFields;  
import java.util.Locale; 

/**
 *
 * @author User
 */
public class BbakerReadWrite {
    
    private String historyDataFile = "FantasyGBBO.csv";
    public String weeklyOutcomesFile = "outcomes.csv";

    public void BbakerReadWrite() {
        this.weeklyOutcomesFile = "outcomes_w"+getCurrentWeekNumber()+".csv";
    }
    
    public String getCurrentWeekNumber(){
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int week = date.get(weekFields.weekOfWeekBasedYear());
        return String. valueOf(week);
    }    
    
    public String getWeeklyOutcomesFile() {
        return weeklyOutcomesFile;
    }

    public void setWeeklyOutcomesFile(String weekString) {
        this.weeklyOutcomesFile = weekString;
    }
    
    public boolean writePlayerData2File(String playerName){
        // LINE FORMAT: PlayerName,ContestantName,Prediction,TotalScore
        
        return true;
    }

    public String readPlayerDatafromFile(String playerName){
        
        System.out.println(getCurrentWeekNumber());
        return playerName;
    }    
    
    public boolean writeAllPlayersData2File(){
        // FORMAT LINE: PlayerName, ContestantName, prediction, totalPoints
        
        return true;
    }

    public String readAllPlayerDatafromFile(){
        return "ALL";
    }    

    public boolean AdminWriteContentantsData2File(String data){
        // LINE FORMAT: ContestantName,currecntStatus
        return true;
    }   
    
    public String AdminReadContentantsDatafromFile(){
        return "ALL";
    }     

    
}
