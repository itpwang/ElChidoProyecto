package mainMod;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tbe UI class represents the user interface. Handles all interactions
 * between user and game.
 */
public class UI {

    /**
     *
     */
    private static int userinput;

    /**
     *
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     *
     */
    public static GameEngine.Direction choice;

    /**
     *
     */
    private GameEngine g = new GameEngine();

    /**
     * This method allows the user to choose
     * to either start a new game, load a game
     * or quit.
     */
    public static int menuSelect(){
        System.out.println("Please choose an option: ");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Quit");

        userinput = takeInput(1,2,3);
        if(userinput == 3)
        {
            //close();
        }

        return userinput;
    }

    /**
     * This method outputs the game description
     * to the screen.
     */
    public static boolean startMenu(){
        System.out.println("*_________________________________*");
        System.out.println("* This is a dungeon crawlser game *");
        System.out.println("*_________________________________*");
        System.out.println("Would you like to run in debug mode?");
        System.out.println("Press 1 for debug mode, 0 for normal mode.");

        userinput = takeInput(0,1);
        if(userinput==1) return true;
        else return false;
    }

    /**
     * This method outputs the keypad options
     * to the screen
     */
    public static void displayKeypad() {
        System.out.println("  Up  : W ");
        System.out.println(" Left : A ");
        System.out.println("Right : D ");
        System.out.println(" Down : S ");
        System.out.println(" Save : P ");
    }

    public static GameEngine.Direction lookPrompt() { //USE SEAN'S FUNCTION THING HERE
        boolean input = false;

        while(input == false)
        {
            System.out.println("Which direction would you like to look?");

            displayKeypad();

            char direction = takeInput('W','A','S','D','P','w','a','s','d','p');

            if (direction == 'W' || direction == 'w')
            {
                choice = GameEngine.Direction.UP;
                input = true;
            }
            else if (direction == 'A' || direction == 'a')
            {
                choice = GameEngine.Direction.LEFT;
                input = true;
            }
            else if(direction == 'D' || direction == 'd')
            {
                choice = GameEngine.Direction.RIGHT;
                input = true;
            }
            else if(direction == 'S' || direction == 's')
            {
                choice = GameEngine.Direction.DOWN;
                input = true;
            }
            else if(direction == 'P' || direction == 'p')
            {
                choice = GameEngine.Direction.SAVE;
                input = true;
            }
        }

        return choice;

    }

    public static int moveOrShootPrompt() {
        boolean input = false;
        int moveShoot = 0;

        while(input == false)
        {
            System.out.println("Would you like to move or shoot?");
            System.out.println("1. Move" );
            System.out.println("2. Shoot");

            moveShoot = takeInput(1,2);

            if(moveShoot == 1 || moveShoot == 2)
            {
                input = true;
            }
        }

        return moveShoot;
    }

    public static  GameEngine.Direction shootPrompt() {
        GameEngine.Direction shootchoice = null;
        boolean input = false;

        while(!input)
        {
            System.out.println("Shoot what direction?");
            displayKeypad();
            char direction = takeInput('W','A','D','S','w','a','s','d');

            if (direction == 'W' || direction == 'w')
            {
                shootchoice = GameEngine.Direction.UP;
                input = true;
            }
            else if (direction == 'A' || direction == 'a')
            {
                shootchoice = GameEngine.Direction.LEFT;
                input = true;
            }
            else if(direction == 'D' || direction == 'd')
            {
                shootchoice = GameEngine.Direction.RIGHT;
                input = true;
            }
            else if(direction == 'S' || direction == 's')
            {
                input = true;
            }
        }

        return shootchoice;
    }

    public static GameEngine.Direction movePrompt() {
        boolean input = false;
        GameEngine.Direction mchoice = null;

        while(!input)
        {
            System.out.println("What direction would you like to move?");
            displayKeypad();

            char direction = takeInput('W','A','D','S','w','a','s','d');

            if (direction == 'W' || direction == 'w')
            {
                mchoice = GameEngine.Direction.UP;
                input = true;
            }
            else if (direction == 'A' || direction == 'a')
            {
                mchoice = GameEngine.Direction.LEFT;
                input = true;
            }
            else if(direction == 'D' || direction == 'd')
            {
                mchoice = GameEngine.Direction.RIGHT;
                input = true;
            }
            else if(direction == 'S' || direction == 's')
            {
                mchoice = GameEngine.Direction.DOWN;
                input = true;
            }
            else
            {
                input = false;
            }
        }

        return mchoice;
    }

    private static int takeInput(int...validInputs) {
        int choice;

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

    public static void roomMoveError() {
        System.out.println("Entering from the wrong side of the room");


    }

    public static void shootHit() {
        System.out.println("Congratulations! You have hit an ninja! " +
                " You are now a murderer.");
    }

    public static void shootMiss() {
        System.out.println("Congratulations! You have missed your shot.");
    }
    public static char newGameorLoad(){

        System.out.println("Do you want to start a new game or load a saved file?");
        System.out.println("Enter [N] for New Game OR [L] for Load ");
        char input = takeInput('L', 'l', 'N', 'n');
        while(input == 'X') {
            input = takeInput('L', 'l', 'N', 'n');
        };
        return input;
    }
}

