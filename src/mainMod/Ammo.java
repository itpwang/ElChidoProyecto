package mainMod;
import java.awt.Point;

/**
 * This class is in charge of creating an Ammo object which can be randomly spawned
 * on a tile in the grid.
 */
public class Ammo extends Item {
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
     * This method gets the {@link Ammo}'s location on the {@link Grid}  
     * @return position of the Ammo on the map
     */
    public Point getPos()
    {
        return ammoPosition;
    }

    /**
     * This method is used to reset the {@link Player} object ammo to full max ammo (1) and display to the user that they have max ammo.
     */
    public void use() {
        GameEngine.resetAmmo();
        System.out.println("You now have full AMMO ");
        this.exists = false;
    }


}
