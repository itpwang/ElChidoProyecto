package mainMod;

/**
 * This class represents the main class in our program. Program
 * is launched here.
 * @author HiThereAndy
 *
 */
public class Main {
	/*
	 * This method creates a new UserInterface object, and calls to it's
	 * constructor with the GameEngine parameter.
	 */
    public static void main(String[] args) {

        GameEngine g;

        switch (UI.newGameorLoad()) {
            case 'N':
                g = new GameEngine();
                break;
            case 'n':
                g = new GameEngine();
                break;
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
        g.changeDebug(UI.startMenu());
        g.printBoard();
        while(!g.gameOver() && !g.isSavingGame()) {
            g.taketurn();
        }


//        if (SaveEngine.readSave() != null){ // for testing for now until we implement the above switch
//        GameEngine gameEngine = new GameEngine(SaveEngine.readSave());
//        }
    }
}