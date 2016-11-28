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

        GameEngine g = new GameEngine();
//        SaveEngine s = new SaveEngine();
//        switch(UI.menuSelect())
//        {
//            // NEW Game
//            case 1:
//            {
//                g.changeDebug(UI.startMenu());
//                g.printBoard();
//                while (g.gameOver()) {
//                    g.taketurn();
//                }
//            }
//            // LOAD game
//            case 2:
//            {
//                s.readSave(g.getPlayer());
//                g.changeDebug(UI.startMenu());
//                g.printBoard();
//                while (g.gameOver()) {
//                    g.taketurn();
//                }
//            }
//            default:
//                break;
//    }
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