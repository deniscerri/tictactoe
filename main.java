
import java.util.Scanner;


public class Main {
    
    public static char[] arr = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) {
        boolean winner = false;
        char p1 = 'X';
        char p2 = 'O';
        int p1score = 0;
        int p2score = 0;
        boolean turn = true;
        int elementCount = 0;
        
        
        

      System.out.println("Who wants to start! 1 for X and 2 for O");
      int t = sc.nextInt();
      if(t == 1){
          turn = true;
      }else if(t == 0){
          turn = false;
      }else{
          System.out.println("Bad Input. X starts\n");
      }
      
      print();
      
       while(!winner){
           char current = (turn) ? p1 : p2;
           
           elementCount++;

           System.out.println(current+" Turn:");
            int value = sc.nextInt();
            
            boolean check = checkSpot(value);
            
            
            while(!check){
                System.out.println("Spot is taken. Try again");
                value = sc.nextInt();
                check = checkSpot(value);
            }

             arr[value] = current;
            
            
            if(checkWinner(current)){
                System.out.println(current+" Wins");
                if(current == 'O'){
                    p2score++;
                }else{
                    p1score++;
                }
                System.out.println("Score --> X:"+p1score+" O:"+p2score);
                winner = true;
                winner = (playagain(winner)) ? true:false;
            }else{
                if(elementCount == 9){
                    System.out.println("Draw!!");
                    winner = true;
                    winner = (playagain(winner)) ? true:false;
                }
                
            }
            
            turn = !turn;
            print();

       }
      
    }
    
    
    public static boolean playagain(boolean winner){
        System.out.println("Do you want to play again? 1 for Yes, 0 for No");
            int willYou = sc.nextInt();
            if(willYou == 1){
                clearTable();
                return false;
            }else{
                return true;
            }
    }
    
    
    public static void clearTable(){
        for(int i  = 0;i < arr.length; i++){
            arr[i] = ' ';
        }
    }
    
    public static void print(){

        System.out.print("-------------\n"+
                        "| "+arr[1]+" | "+arr[2]+" | "+arr[3]+" | \n"+
                        "-------------\n"+
                        "| "+arr[4]+" | "+arr[5]+" | "+arr[6]+" | \n"+    
                        "-------------\n"+
                        "| "+arr[7]+" | "+arr[8]+" | "+arr[9]+" | \n"+        
                        "-------------\n");
        
    }
    
    
    public static boolean checkSpot(int value){

        if(arr[value] == ' '){
            return true;
        }
        return false;
    }
    
    public static boolean checkWinner(int player){
        int win = player+player+player;
        
        
        if(arr[1]+arr[2]+arr[3] == win
        || arr[4]+arr[5]+arr[6] == win
        || arr[7]+arr[8]+arr[9] == win
        || arr[3]+arr[5]+arr[7] == win
        || arr[1]+arr[5]+arr[9] == win
        || arr[1]+arr[4]+arr[7] == win
        || arr[2]+arr[5]+arr[8] == win
        || arr[3]+arr[6]+arr[9] == win){
            return true;
        }
        
        return false;
        
        
    }

}
