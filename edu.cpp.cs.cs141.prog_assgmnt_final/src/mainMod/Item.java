/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment Final
 *
 * This is a text-based game where the player has to find a briefcase
 * located in 1 of 9 rooms. Complications include enemies that could kill you.
 * Powerups can also be obtained.
 *
 * Team Destructors
 *   Ivan Wang
 *   Travis Linkey
 *   Sean McCullough
 *   Zach Oeh
 *   Michael Ortega
 *   Andy Rosas
 */
package mainMod;
import java.awt.Point;
import java.io.Serializable;


/**
 * Tagging interface implemented by Ammo, Invincibility, and Radar class.
 *
 */
public abstract class Item implements Serializable {
    private Point[] itemLocation = new Point[3];
    int i = 0;
    boolean exists = false;

    /**
     * Abstract constructor of the item class. Fills the {@link Item#itemLocation}
     * array with the point locations of items and increments {@link Item#i} with
     * each item added.
     *
     * @param p The point location of an item.
     */
    public Item(Point p)
    {
        itemLocation[i] = p;
        i++;
    }

    /**
     * This abstract method gets the {@link Item}s location
     * @return point
     */
    public abstract Point getPos();

    /**
     * This abstract method uses the {@link Item}
     */
    public abstract void use();
}
