/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;  
import java.time.temporal.WeekFields;  
import java.util.Locale; 

/**
 * @author Yevhen
 */
public class BbakerReadWrite {
    
    private String historyDataFile = "FantasyGBBO.csv";
    public String weeklyOutcomesFile = "outcomes.csv";
    public String playersFile = "players.csv";
    public String contestantsFile = "contestants.csv";
    
    private boolean verboseErrors = false;
 
    public void BbakerReadWrite() {
        this.weeklyOutcomesFile = "outcomes_w"+getCurrentWeekNumber()+".csv";
    }
    
    public String getCurrentWeekNumber(){
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int week = date.get(weekFields.weekOfWeekBasedYear());
        return String. valueOf(week);
    }    

    public boolean loadFromFile(String[] _players, String FileName) {
        BufferedReader inputF;
        try {
            inputF = new BufferedReader(new FileReader(FileName));
            String line;
            int Index = 0;
            while ((line = inputF.readLine()) != null) {
                _players[Index] = line;
                Index++;
                //String[] rowData = line.split(csvSplitBy);
                //if (!rowData[0].equalsIgnoreCase("Username")) {
                    // Clear player picks (contestants) by not adding them to the updated content
                //} else {
                    
                //}
            }
            inputF.close();
            return true;
        } catch (Exception e) {
            if(verboseErrors) System.out.println("ERROR [loadFromFile]: " + e);
            return false;
        }
        
    }

    public boolean Save2File(String[] _players, String FileName) {
        BufferedWriter outputF;
        try {
            outputF = new BufferedWriter(new FileWriter(FileName));

            // Count not null strings = count of players
            int totItems = 0;
            for (String p: _players) {           
                if (p!=null ) totItems++;
            }
            
            int cnt = 0;
            //System.out.println(totPlayers);
            for (String p: _players) {           
                if (p!=null ) {
                    outputF.write(p);
                    cnt++;
                    if (cnt<totItems) outputF.newLine();
                } 
            }
            outputF.close();
            return true;
            
        } catch (Exception e) {
            if (verboseErrors) System.out.println("ERROR [Save2File]: " + e);
            return false;
        }
        
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
