/**
 * Tbe UI class represents the user interface. Handles all interactions
 * between user and game.
 */
import java.util.Scanner;
public class UI {
    private GameEngine G;
    private int userinput;
    private Scanner scan;

    /**
     * Constructor for UI takes a {@link GameEngine}
     * for an argument. instantiates the game, and
     * creates a scanner variable to input data.
     * Lastly, calls the {@link #startMenu} method
     */
    public UI(GameEngine game)
    {
        this.G = game;
        scan = new Scanner(System.in);
        startMenu();
    }

    public enum moveChoice {UP, DOWN, LEFT, RIGHT};

    public moveChoice choice;

    /**
     * This method allows the user to choose
     * to either start a new game, load a game
     * or quit.
     */
    public void menuSelect(){
        System.out.println("");
        scan.nextInt();
    }

    /**
     * This method will print the {@link Grid}
     */
    public void gameMove()
    {
        G.printMap();
    }

    /**
     * This method outputs the game description
     * to the screen.
     */
    public void startMenu(){
        System.out.println("*_________________________________*");
        System.out.println("* This is a dungeon crawlser game *");
        System.out.println("*_________________________________*");
        System.out.println("Would you like to run in debug mode?");
        System.out.println("Press 1 for debug mode, 0 for normal mode.");
        userinput=scan.nextInt();
        if(userinput==0) G.changeDebug(false);
        else G.changeDebug(true);
        G.printBoard();
        menuSelect();
    }
    /**
     * This method outputs the choices for actions during
     * the game
     */
    public static void displayChoice()
    {
        System.out.println("0. Look");
        System.out.println("1. Move");
        System.out.println("2. Shoot");
        System.out.println("3. Quit");
    }

    /**
     * This method outputs the keypad options
     * to the screen
     */
    public static void displayKeypad()
    {
        System.out.println("Press the following" +
                " Keys to choose a direction:");
        System.out.println("  Up  : W ");
        System.out.println(" Left : A ");
        System.out.println("Right : D ");
        System.out.println(" Down : S ");
    }
    public moveChoice lookPrompt() {
        System.out.println("Which direction would you like to look?");
        displayKeypad();
        String direction = scan.nextLine();

        if (direction == "W")
            choice = moveChoice.UP;
        else if (direction == "A")
            choice = moveChoice.LEFT;
        else if(direction == "D")
            choice = moveChoice.RIGHT;
        else if(direction == "S")
            choice = moveChoice.DOWN;


        return choice;

    }

    public void moveOrShootPrompt() {
        System.out.println("Would you like to move or shoot?");
        System.out.println("1. Move" );
        System.out.println("2. Shoot");
        int moveShoot = scan.nextInt();

        if(moveShoot == 1){
            //call move() method
        }
        else if(moveShoot==2){
            //call shoot() method
        }

    }

}