/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfantasygreatbritishbakeoffleague;
 
/**
 * @author Yevgen
 */
public class BbakerMainLogic {
    
    BbakerReadWrite rwFile =  new BbakerReadWrite();

    private int MaxPlayersCount = 100;
    private String[] players = new String[MaxPlayersCount];
    private String[] predictions = new String[MaxPlayersCount];
    private String[] contestants = new String[MaxPlayersCount];
    
    public int totalPlayersCount = 0;
    public int totalContestantsCount = 0;

    public BbakerMainLogic(){
        //System.out.println("Init BbakerMainLogic");
        InitPlayers();
        InitContestants();
    }    

    public void InitPlayers(){
        if (!LoadPlayers()) InitPlayersTest();
        CountPlayers();
    }

    public void InitContestants(){
        if (!LoadContestants()) InitContestantsTest();
        CountContestants();
    }
    
    public void CountPlayers(){
        totalPlayersCount = 0;
        for (String c: players ) {           
            if (c!=null ) totalPlayersCount++;
        }        
    }
    
    public void CountContestants(){
        totalContestantsCount = 0;
        for (String p: contestants) {           
            if (p!=null ) totalContestantsCount++;
        }        
    }    
    
    public void InitPlayersTest(){
        // FORMAT: PlayerName, TotalScore
        players[0] = "John,10";
        players[1] = "James,6";
        players[2] = "Sam,2";
        CountPlayers();
    }

    public void InitContestantsTest(){
        // FORMAT: ContestantName, type, points
        // type can be:
        // active - still in list
        // eliminated
        
        int ind = 0;
        contestants[ind] = "Dan,active,1";
        contestants[++ind] = "Josh,active,20";
        contestants[++ind] = "Matty,active,30";
        contestants[++ind] = "Tasha,active,20";
        contestants[++ind] = "Cristy,eliminated,0";
        CountContestants();
    }
    
    public boolean LoadPlayers(){  // Load players from file
       return rwFile.loadFromFile(players, rwFile.playersFile);
    }    
 
    public boolean SavePlayers(){  // Save players 2 file
        return rwFile.Save2File(players, rwFile.playersFile);
    }     
    
    public boolean LoadContestants(){  // Load players from file
       return rwFile.loadFromFile(contestants, rwFile.contestantsFile);
    }    
 
    public boolean SaveContestants(){  // Save players 2 file
        return rwFile.Save2File(contestants, rwFile.contestantsFile);
    }   
    
    public void ShowPlayersTable(){
        if (totalPlayersCount==0) {
            System.out.println("No players found");
            return;
        }
        // List players
        int cnt=0;
        String csvSplitBy = ",";
        System.out.println("#\tName\t\tPoints\t");
        System.out.println("-----------------------------------");
        for (String p: players) {
            if (p!=null ) {
                cnt++;
                int indName = 0, indPoints = 1;
                String[] playerData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + playerData[indName] + "\t\t" + playerData[indPoints]);
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Total players: " + totalPlayersCount + "\n");        
    }    
    
    
    public void ShowContestantsTable() {
        if (totalContestantsCount==0) {
            System.out.println("No contestants found");
            return;
        }
        // List players
        int cnt=0;
        String csvSplitBy = ",";
        System.out.println("#\tName\t\tState\t\tPoints\t");
        System.out.println("---------------------------------------------------");
        for (String p: contestants) {
            if (p!=null ) {
                cnt++;
                int indName = 0, indState = 1, indPoints = 2;
                String[] ContestantData = p.split(csvSplitBy);
                System.out.println(cnt + "\t" + ContestantData[indName] + "\t\t" + ContestantData[indState] + "\t\t" + ContestantData[indPoints] );
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Total contestants: " + totalContestantsCount + "\n");          
    }
    
    public void makeWeeklyOutcome(){
        //weekly 
    }
    
    public void updatePlayersPredictions(){
         //Recalculate users scores after admin update contestants data
                  
//        Weekly points awarded up to and including episode nine:
//            Correct nomination of the Best Baker = 4 points
//            If your nominated Best Baker is eliminated, then 1 point will be deducted from your total
//            Correct weekly nomination of baker to leave = 3 points
//            If your nominated baker to leave is the Best Baker 1 point will be deducted from your total.
//            Correct nomination of the winner of that week’s technical round = 2 points
//
//        Points awarded at the end of the final episode of the series:
//            Overall winner chosen after episode one and before episode two = 7 points
//            The other two finalists chosen after episode one and before episode two = 2 points each
//            Winner of the final episode, chosen after episode nine = 4 points
//            No technical round or elimination nominations for the final episode
         
         
     }
     
     public void getUserPredictions(String UserName){
        System.out.println(UserName + "'s  predictions:");
        System.out.println("------------------------\n");
        rwFile.readPlayerDatafromFile(UserName);
     }
     
     public void getAllUsersScore(){
        ShowPlayersTable();
     }

     public void getAllContestants(){
        ShowContestantsTable();
     }     
     
     
    public void doUserPrediction(String UserName){
        System.out.println(UserName + ", lets make a prediction!");
        System.out.println("---------------------------------\n");

        //
                
        // is Player new and has not selected contestants to bid ?
        // Get list of contestants

    }  

    public void AdminEnterData(){
        //LINE FORMAT: date,ContestantName,awardedpoints

        System.out.println("AdminEnterData");
        System.out.println("---------------------------------\n");
        // make admin input data then write to file
        String data = " ";
        rwFile.AdminWriteContentantsData2File(data);
        updatePlayersPredictions();
    }      
    
}
