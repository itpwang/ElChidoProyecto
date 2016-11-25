package mainMod;
import java.awt.Point;

/**
 * This class is in charge of creating an Ammo object which can be randomly spawned
 * on a tile in the grid.
 */
public class Ammo extends Item{
    private Point ammoPosition;

    /**
     * The {@link Ammo} constructor which allows the {@link Radar}
     * {@link Item} to be randomly spawned in
     * the grid where there is a {@link Tile} object.
     */
    public Ammo(Point p) {
        super(p);
        ammoPosition = p;
        this.exists = true;
    }

    /**
     * This method gets the {@link Ammo}s location
     * @return
     */
    public Point getPos()
    {
        return ammoPosition;
    }

    /**
     * This method returns a char value of {@code B} on the grid to represent 
     * the location of the ammo item.
     * 
     * @return B
     */
    public char returnSymbol()
    {
        return 'B';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code B} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'B':'/';}

    public void use() {
        GameEngine.addAmmo();
        System.out.println("You used the Ammo! ");
        this.exists = false;
    }


}
