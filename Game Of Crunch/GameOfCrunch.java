
/**
 * Lets you play the awesome GameOfCrunch
 * 
 * @author (Shayan Shaikh) 
 * @version (11/10/14)
 */
import java.util.Scanner;
public class GameOfCrunch{
    //Fields
    private Scanner input = new Scanner(System.in);
    private Scanner input2 = new Scanner(System.in); //creates scanners for user input
    private String ans; // the user's input
    private boolean brk = true; //is used to help break out of the main while loop
    private int sticks, randomN; //sticks the user choses and the random number the computer generates
    private int spaces = 21; //holds the spaces or sticks left in the game
    
    //Constructor
    public GameOfCrunch() {
        //reintializes the variables for when the user plays again
        brk = true;
        sticks = 0;
        randomN = 0;
        spaces = 21;
    }
    
    //Main method
    public static void main(String[] args) {
        GameOfCrunch Game = new GameOfCrunch(); // creates new object
        Game.firstOrSecond(); 
        if (Game.ans.equals("first")) {
            while (Game.spaces > 0) {
                Game.playCrunch();
                if (!Game.brk) break; //breaks if there is a winner
            }
        }else if (Game.ans.equals("second")){
            Game.pickSticks();
            Game.printSticksLeft();
            while (Game.spaces > 0) {
                Game.playCrunch();
                if (!Game.brk) break;
            }
        }
        
        Game.playAgain();
        if (Game.ans.equals("yes")) {
            main(new String[] {});
        }else{
            System.out.print("Okay, Bye!");
        }
    }
    
    //Helper Methods
    
    //simplfies the method calling in the main method
    public void playCrunch() {
        getSticks();
        checkIfValid();
        subtractUserSticks();
        printSticksLeft();
        pickSticks();
        printSticksLeft();
    }
    //runs until user decides if they are first or second
    public void firstOrSecond() {
        do {
            System.out.println("Do you want to go first or second?");
            ans = input.nextLine();
        } while (!(ans.equals("first") || ans.equals("second")));
    }
    //uses a random number to pick 1 or 2 sticks and checks if there is a winner
    public void pickSticks() {
        if (brk) {
            randomN = (int) (Math.random() * 2) + 1;
            if (randomN == 1) {
                System.out.println("\nI pick " + randomN + " stick");
            }else{
                System.out.println("\nI pick " + randomN + " sticks");
            }
            getWinner();
            spaces -= randomN;
        }
    }
    //subtracts user's input then checks if there is a winner
    public void subtractUserSticks() {
        spaces -= sticks;
        getWinner();
    }
    //gets the user's number of sticks chosen
    public void getSticks() {
        System.out.println("\nChoose 1 or 2 sticks");
        sticks = input.nextInt();
    }
    //checks if the user's input is either 1 or 2
    public void checkIfValid() {
        while (!(sticks == 1) && !(sticks == 2)) {
            System.out.println("\nCHEATER!!!\n");
            getSticks();
        }
    }
    //prints the number of sticks left with correct grammar
    public void printSticksLeft() {
        if (brk) {
            if (spaces == 1) {
                System.out.println("There is " + spaces + " stick left");
            }else{
                System.out.println("There are " + spaces + " sticks left");
            }
        }
    }
    //checks who the winner is, if there is one
    public void getWinner() {
        if (spaces == 1) {
            System.out.println("You Win!");
            brk = false; //lets us break out of the main while loop if there is a winner
        }
        if (spaces < 1) {
            System.out.println("I Win!");
            brk = false;
        }
    }
    //ask if the user wants to play again
    public void playAgain() {
        do {
            System.out.println("\nDo you want to play again?");
            ans = input2.nextLine();
            System.out.println("");
        } while (!(ans.equals("yes") || ans.equals("no")));
    }
}