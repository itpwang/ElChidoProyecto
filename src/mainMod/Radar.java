package mainMod;
import java.awt.Point;


/**
 * This class is in charge of creating a Radar object which can be randomly spawned
 * on a tile in the grid.
 */
public class Radar extends Item {

    private Point radPosition;

    /**
     * The {@link Radar} constructor which allows the {@link Radar}
     * {@link Item} to be randomly spawned in
     * the grid where there is a {@link Tile} object.
     */
    public Radar(Point p) {
        super(p);
        radPosition = p;
        this.exists = true;
    }

    /**
     * This method gets the {@link Radar}s location
     * @return
     */
    public Point getPos()
    {
        return radPosition;
    }

    /**
     * This method returns a char value of {@code O} on the grid to represent 
     * the location of the radar item.
     * 
     * @return O
     */
    public char returnSymbol()
    {
        return 'O';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code O} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'O':'/';}

    public void use() {
        GameEngine.radarOn();
        System.out.println("You now have RADAR! ");
        this.exists = false;
    }
}

