package mainMod;
import java.awt.Point;

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
        switch(UI.newGameorLoad()){
            case 'N': g = new GameEngine();
                break;
            case 'n':g = new GameEngine();
                break;
            case 'L':g = new GameEngine(SaveEngine.readSave());
                break;
            case 'l':g = new GameEngine(SaveEngine.readSave());
                break;
            default: g=new GameEngine();

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