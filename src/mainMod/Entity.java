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
     * {@link Entity} to attack an adjacent
     * space
     */
    abstract void attack();

    /**
     * This abstract method returns {@code true}
     * if {@link Entity} is alive and {@code false}
     * if not.
     * @return {@code true} if alive {@code false} if not
     */
    abstract boolean isAlive();

    /**
     * This method returns the character
     * string that represents the {@link Entity}
     *
     * @return
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
     * @return
     */
    public char returnSymbol(boolean debug) {return debug?'C':'/';}
    abstract Point getPos();
}
