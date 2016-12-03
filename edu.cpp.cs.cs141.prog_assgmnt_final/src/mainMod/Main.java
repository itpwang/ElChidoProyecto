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
         * Creates a new {@link UI} object
         */
        UI ui = new UI();
        
        
        /**
         * Prompts user for input to start new or load game.
         */
        switch (ui.newGameOrLoad()) {
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
        g.changeDebug(ui.startMenu());
        g.printBoard();
        while(!g.gameOver() && !g.isSavingGame()) {
            g.takeTurn();
        }
    }
}