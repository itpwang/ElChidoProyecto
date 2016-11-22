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
        g.printMap();
        Player p = new Player();

        //Print position
        System.out.println(g.getPos());

        //Check movements

        System.out.println("Left");
        p.moveLeft();
        System.out.println(g.getPos());

        System.out.println("Right");
        p.moveRight();
        System.out.println(g.getPos());

        System.out.println("Up");
        p.moveUp();
        System.out.println(g.getPos());

        System.out.println("Down");
        p.moveDown();
        System.out.println(g.getPos());

        UI ui= new UI(new GameEngine());
        while(ui.running()){
            ui.gameMove();
        }

    }
}