package mainMod;
import java.awt.Point;


/**
 * This class is in charge of creating a Radar object which can be randomly spawned
 * on a tile in the grid.
 */
public class Radar extends Item {

    /**
     * This field represents the position of {@link Radar} on the grid.
     */
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
     * @return Point {@link #radPosition}
     */
    public Point getPos()
    {
        return radPosition;
    }

    /**
     * This method returns a char value of {@code O} on the grid to represent 
     * the location of the radar item.
     * 
     * @return char {@code O}
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

    /**
     * This method uses the radar item. Calls the
     * {@link GameEngine#radarOn()} method to set
     * {@link GameEngine#radar} to {@code true}
     */
    public void use() {
        GameEngine.radarOn();
        System.out.println("You now have RADAR! ");
        this.exists = false;
    }
}

