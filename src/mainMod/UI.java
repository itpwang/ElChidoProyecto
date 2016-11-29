package mainMod;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tbe UI class represents the user interface. Handles all interactions
 * between user and game.
 */
public class UI {

    /**
     * static int field that represents userInput when prompted.
     */
    private static int userInput;

    /**
     *  Scanner object that is used to take in input from the user.
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     * This field represents an enum from the {@link GameEngine} which represents the direction the user wants the move or look towards.
     */
    public static GameEngine.Direction choice;

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

        userInput = takeInput(0,1);
        if(userInput ==1) return true;
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
        System.out.println(" Save and Quit : P ");
    }

    public static void displayKeypadNoSave(){
        System.out.println("  Up  : W ");
        System.out.println(" Left : A ");
        System.out.println(" Down : S ");
        System.out.println("Right : D ");
    }

    /**
     * This method prompts the user with which direction they would like to move and sets and returns their choice as a enum from the {@link GameEngine} class.
     * @return choice Enumeration for directions
     */
    public static GameEngine.Direction lookPrompt() {
        boolean input = false;

        while(!input)
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

    /**
     * This method displays a prompt to the user to shoot or to move
     * @return int value representing user's choice to move or shoot
     */
    public static int moveOrShootPrompt() {
        boolean input = false;
        int moveShoot = 0;

        while(!input)
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

    /**
     * This method provides a prompt to the user requesting for them to input which direction they would like to move.
     * @return enumeration representing which direction they would like to shoot.
     */
    public static  GameEngine.Direction shootPrompt() {
        GameEngine.Direction shootChoice = null;
        boolean input = false;

        while(!input)
        {
            System.out.println("Shoot what direction?");
            displayKeypad();
            char direction = takeInput('W','A','D','S','w','a','s','d');

            if (direction == 'W' || direction == 'w')
            {
                shootChoice = GameEngine.Direction.UP;
                input = true;
            }
            else if (direction == 'A' || direction == 'a')
            {
                shootChoice = GameEngine.Direction.LEFT;
                input = true;
            }
            else if(direction == 'D' || direction == 'd')
            {
                shootChoice = GameEngine.Direction.RIGHT;
                input = true;
            }
            else if(direction == 'S' || direction == 's')
            {
                input = true;
            }
        }

        return shootChoice;
    }

    /**
     *  This method provides the user with a prompt requesting them to enter which direction they would like to move.
     * @return enumeration representing which direction they would like to shoot.
     */
    public static GameEngine.Direction movePrompt() {
        boolean input = false;
        GameEngine.Direction moveChoice = null;

        while(!input)
        {
            System.out.println("What direction would you like to move?");
            displayKeypadNoSave();

            char direction = takeInput('W','A','D','S','w','a','s','d');

            if (direction == 'W' || direction == 'w')
            {
                moveChoice = GameEngine.Direction.UP;
                input = true;
            }
            else if (direction == 'A' || direction == 'a')
            {
                moveChoice = GameEngine.Direction.LEFT;
                input = true;
            }
            else if(direction == 'D' || direction == 'd')
            {
                moveChoice = GameEngine.Direction.RIGHT;
                input = true;
            }
            else if(direction == 'S' || direction == 's')
            {
                moveChoice = GameEngine.Direction.DOWN;
                input = true;
            }
            else
            {
                input = false;
            }
        }

        return moveChoice;
    }

    /**
     * This method checks whether user input is valid or not.
     * @param validInputs all possible valid inputs
     * @return choice the correct input for the prompt
     */
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

    /**
     * This method checks whether user input is valid or not.
     * @param inputs array of valid inputs
     * @param c the value the user inputted
     * @return boolean valid representing if the input is valid or not
     */
    private static boolean isInputValid(int inputs[], int c) {
        for(int i : inputs)
        {
            if(c == i)
                return true;
        }
        return false;
    }
    /**
     * This method checks whether user input is valid or not.
     * @param validInputs all possible valid char inputs
     * @return choice the correct input for the prompt
     */
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

    /**
     * This method checks whether user input is valid or not.
     * @param inputs array of valid inputs
     * @param c the value the user inputted
     * @return boolean valid representing if the input is valid or not
     */
    private static boolean isInputValid(char inputs[], char c) {
        for(char i : inputs)
        {
            if(c == i)
                return true;
        }
        return false;
    }

    /**
     * This method prompts the user requesting them to enter if they would like to load or save a game.
     * @return input the choice representing if they want to
     */
    public static char newGameOrLoad(){
        System.out.println("Do you want to start a new game or load a saved file?");
        System.out.println("Enter [N] for New Game OR [L] for Load ");
        char input = takeInput('L', 'l', 'N', 'n');
        while(input == 'X') {
            input = takeInput('L', 'l', 'N', 'n');
        }
        return input;
    }
}
