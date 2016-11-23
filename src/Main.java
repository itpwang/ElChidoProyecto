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
        g.changeDebug(UI.startMenu());
        g.printBoard();
        while(!g.gameOver()) {
            g.taketurn();
        }
    }
}