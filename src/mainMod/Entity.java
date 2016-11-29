package mainMod;

import java.awt.Point;


/**
 * Created by travis on 11/13/16.
 */
public abstract class Entity{
    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    public enum moveChoice {UP, DOWN, LEFT, RIGHT};

    /**
     * This abstract method will allow the
     * {@link Entity} to move on the grid
     */
 /**   abstract void move(moveChoice e);

    /**
     * This abstract method will allow the
     * {@link Entity} to attack an adjacent
     * space
     */
    abstract void attack();

    /**
     * This abstract method returns {@code true}
     * if {@link Entity} is alive and {@code false}
     * if not.
     * @return boolean {@code true} if alive {@code false} if not
     */
    abstract boolean isAlive();

    /**
     * This method returns the character
     * string that represents the {@link Entity}
     *
     * @return char {@code C} for the character
     */
    public char returnSymbol()
    {
        return 'C';
    }
    /**
     * This method returns the character
     * string that represents the {@link Entity}
     * (Debug mode)
     *
     * @param debug {@link GameEngine#debug}
     * @return char {@code C} if {@param debug}
     * is {@code true} and {@code /} if {@param debug}
     * is {@code false}
     */
    public char returnSymbol(boolean debug) {return debug?'C':'/';}

    /**
     * Abstract method to return the position of an entity.
     * @return Point Entity location
     */
    abstract Point getPos();
}
