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
 * This class represents the enemy and its fields/methods.
 */
public class Enemy extends Entity implements Serializable {

    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    enum moveChoice {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * This field represents the {@link Enemy} position on the grid.
     */
    private Point Epos;

    /**
     * This field is set to {@code true} if the player is
     * alive, and {@code false} if player is dead.
     */
    private boolean alive;

    /**
     * This is {@link Player}'s default constructor.
     * Sets field alive to {@code true}
     */
    public Enemy() { alive = true;}

    /**
     * This method first checks that the {@link Player}
     * has {@link Ammo}. If so, they attack an adjacent square.
     */
    public Enemy(Point p) {
        Epos = p;
    }

    /**
     * These methods set the new position of an entity by adding/subtracting 1
     * to the axis corresponding to the move direction.
     */
    // UP: (x - 1, y)
    public void moveUp()
    {
        setPos(new Point(getPos().x - 1,getPos().y));
    }
    // DOWN: (x + 1, y)
    public void moveDown()
    {
        setPos(new Point(getPos().x + 1,getPos().y));
    }
    // LEFT: (x, y - 1)
    public void moveLeft()
    {
        setPos(new Point(getPos().x,getPos().y - 1));
    }
    // RIGHT: (x, y + 1)
    public void moveRight()
    {
        setPos(new Point(getPos().x,getPos().y + 1));
    }

    /**
     * This method allows checking if {@link Player} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * This method sets {@link #Epos} to a passed in {@link Point} parameter
     * @param point Enemy position
     */
    public void setPoint(Point point){
        Epos = point;
    }

    /**
     * This method gets the {@link Enemy}s location
     * @return Point The enemy location
     */
    public Point getPos()
    {
        return Epos;
    }

    /**
     * This method sets {@link #Epos} to the Point passed as an argument
     * @param p The enemy position
     */
    public void setPos(Point p)
    {
        this.Epos = p;
    }

}
