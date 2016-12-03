/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment Final
 *
 * This is a text-based game where the player has to find a briefcase
 * located in 1 of 9 rooms. Complications include enemies that could kill you.
 * Powerups can also be obtained.
 *
 * Team Destructors
 *   Ivan Wang
 *   Travis Linkey
 *   Sean McCullough
 *   Zach Oeh
 *   Michael Ortega
 *   Andy Rosas
 */
package mainMod;

/**
 * This class represents the main class in our program. Program
 * is launched here.
 */
public class Main {
	/*
	 * This method creates a new UserInterface object, and calls to it's
	 * constructor with the GameEngine parameter.
	 */
    public static void main(String[] args) {

        /**
         * Creates a new {@link GameEngine} object.
         */
        GameEngine g;

        /**
         * Prompts user for input to start new or load game.
         */
        switch (UI.newGameOrLoad()) {
            // NEW Game
            case 'N':
                g = new GameEngine();
                break;
            case 'n':
                g = new GameEngine();
                break;
            // LOAD Game
            case 'L':
                try{g = new GameEngine(SaveEngine.readSave());
                }catch (NullPointerException e){
                    System.out.println("Starting a new game . . .");
                    g = new GameEngine();
                }
                break;
            case 'l':
                try{g = new GameEngine(SaveEngine.readSave());
                }catch (NullPointerException e){
                    System.out.println("Starting a new game . . .");
                    g = new GameEngine();
                }
                break;
            default:
                g = new GameEngine();

        }

        /**
         * While {@link GameEngine#gameOver()} and {@link GameEngine#isSavingGame()}
         * return false the player will be able to continue taking turns.
         */
        g.changeDebug(UI.startMenu());
        g.printBoard();
        while(!g.gameOver() && !g.isSavingGame()) {
            g.takeTurn();
        }
    }
}