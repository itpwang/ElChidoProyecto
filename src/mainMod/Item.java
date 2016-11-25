package mainMod;
import java.awt.Point;
import java.util.Random;

/**
 * Tagging interface implemented by Ammo, Invincibility, and Radar class.
 * 
 * Created by travis on 11/14/16.
 */
public abstract class Item {
    private Point[] itemlocation = new Point[3];
    int i = 0;
    boolean exists = false;

    public Item(Point p)
    {
        itemlocation[i] = p;
        i++;
    }

    /**
     * This method gets the {@link Item}s location
     * @return
     */
    public abstract Point getPos();
    public abstract void use();
}
