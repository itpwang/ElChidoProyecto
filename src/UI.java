/**
 * Tbe UI class represents the user interface. Handles all interactions
 * between user and game.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private GameEngine G;
    private int userinput;
    private static Scanner scan = new Scanner(System.in);

    /**
     * Constructor for UI takes a {@link GameEngine}
     * for an argument. instantiates the game, and
     * creates a scan variable to input data.
     * Lastly, calls the {@link #startMenu} method
     */
    public UI(GameEngine game) {
        this.G = game;
        scan = new Scanner(System.in);
        startMenu();
    }

    public static GameEngine.Direction choice;

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
        G.printBoard();
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
    public static void displayChoice() {
        System.out.println("0. Look");
        System.out.println("1. Move");
        System.out.println("2. Shoot");
        System.out.println("3. Quit");
    }

    /**
     * This method outputs the keypad options
     * to the screen
     */
    public static void displayKeypad() {
        System.out.println("Press the following" +
                " Keys to choose a direction:");
        System.out.println("  Up  : W ");
        System.out.println(" Left : A ");
        System.out.println("Right : D ");
        System.out.println(" Down : S ");
    }

    public static GameEngine.Direction lookPrompt() { //USE SEAN'S FUNCTION THING HERE
        System.out.println("Which direction would you like to look?");
        displayKeypad();
        String direction = scan.nextLine();
        //GameEngine.Direction choice;

        if (direction.equals("W"))
            choice = GameEngine.Direction.UP;
        else if (direction.equals("A"))
            choice = GameEngine.Direction.LEFT;
        else if(direction.equals("D"))
            choice = GameEngine.Direction.RIGHT;
        else if(direction.equals("S"))
            choice = GameEngine.Direction.DOWN;


        return choice;

    }

    public static int moveOrShootPrompt() {
        System.out.println("Would you like to move or shoot?");
        System.out.println("1. Move" );
        System.out.println("2. Shoot");

        int moveShoot = takeInput();
        scan.nextLine();

        return moveShoot;
    }

    public static GameEngine.Direction movePrompt() {
        System.out.println("What direction would you like to move?");
        displayKeypad();


        char direction = takeInput('W','A','D','S','w','a','s','d');


        GameEngine.Direction mchoice;

        if (direction == 'W' || direction == 'w')
            mchoice = GameEngine.Direction.UP;
        else if (direction == 'A' || direction == 'a')
            mchoice = GameEngine.Direction.LEFT;
        else if(direction == 'D' || direction == 'd')
            mchoice = GameEngine.Direction.RIGHT;
        else if(direction == 'S' || direction == 's')
            mchoice = GameEngine.Direction.DOWN;

        else mchoice = GameEngine.Direction.UP;

        return mchoice;
    }

    private static int takeInput(int...validInputs) {
        int choice = 0;
        try
        {
            choice = scan.nextInt();
            if(!isInputValid(validInputs, choice))
                throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: Invalid input");
            scan.nextLine();
            choice = -1;
        }
        return choice;
    }

    private static boolean isInputValid(int inputs[], int c) {
        for(int i : inputs)
        {
            if(c == i)
                return true;
        }
        return false;
    }

    private static char takeInput(char...validInputs) {
        char choice;

        try
        {
            choice = scan.next().charAt(0);
            if(!isInputValid(validInputs, choice))
                throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: Invalid input");
            scan.nextLine();
            choice = 'X';
        }
        return choice;
    }

    private static boolean isInputValid(char inputs[], char c) {
        for(char i : inputs)
        {
            if(c == i)
                return true;
        }
        return false;
    }


}