package mainMod;
import java.awt.Point;

/**
 * This class is in charge of creating an Ammo object which can be randomly spawned
 * on a tile in the grid.
 */
public class Ammo extends Item {

    /**
     * This field represents the position of {@link Ammo} on the grid.
     */
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
     * @return Point {@link #ammoPosition}
     */
    public Point getPos()
    {
        return ammoPosition;
    }

    /**
     * This method returns a char value of {@code B} on the grid to represent 
     * the location of the ammo item.
     * 
     * @return char {@code B}
     */
    public void use() {
        GameEngine.resetAmmo();
        System.out.println("You now have full AMMO ");
        this.exists = false;
    }


}
