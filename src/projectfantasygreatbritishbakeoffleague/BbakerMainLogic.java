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
     
     public void getAllUsersPredictions(){
        System.out.println("All users' predictions:");
        System.out.println("----------------------\n");
        rwFile.readAllPlayerDatafromFile();
     }
     
    public void doUserPrediction(String UserName){
        System.out.println(UserName + " lets make a prediction!");
        System.out.println("---------------------------------\n");
        rwFile.writePlayerData2File(UserName);
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
