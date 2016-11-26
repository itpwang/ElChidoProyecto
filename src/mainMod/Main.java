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
/**        SaveEngine s = new SaveEngine();
        switch(UI.menuSelect())
        {
            // NEW Game
            case 1:
            {
                g.changeDebug(UI.startMenu());
                g.printBoard();
                while (g.gameOver()) {
                    g.taketurn();
                }
                break;
            }
            // LOAD game
            case 2:
            {
                s.readSave(g.getPlayer());
                g.changeDebug(UI.startMenu());
                g.printBoard();
                while (g.gameOver()) {
                    g.taketurn();
                }
                break;
            }
            default:
                break;
    }*/
        g.changeDebug(UI.startMenu());
        g.printBoard();
        while(!g.gameOver()) {
            g.taketurn();
        }
    }
}