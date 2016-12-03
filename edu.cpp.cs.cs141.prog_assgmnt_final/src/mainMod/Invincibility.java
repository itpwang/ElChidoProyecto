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
 * This class is in charge of creating an Invincibility object which can be randomly 
 * spawned on a tile in the grid..
 */
public class Invincibility extends Item implements Serializable {

    /**
     * This field represents the position of {@link Invincibility} on the grid.
     */
    private Point invPosition;

    /**
     * The {@link Invincibility} constructor which allows the {@link Radar}
     * {@link Item} to be randomly spawned in
     * the grid where there is a {@link Tile} object.
     */
    public Invincibility(Point p) {
        super(p);
        invPosition = p;
        this.exists = true;
    }

    /**
     * This method gets the {@link Invincibility}s location
     * @return Point {@link #invPosition}
     */
    public Point getPos()
    {
        return invPosition;
    }

    /**
     * This method uses the invincibility item. Calls the
     * {@link GameEngine#invincibilityOn()} method to set
     * {@link GameEngine#isInvincible} to {@code true}
     */
    public void use() {
        GameEngine.invincibilityOn();
        System.out.println("You are now INVINCIBLE");
        this.exists = false;
    }
}
