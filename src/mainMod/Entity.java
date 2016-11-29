package mainMod;

import java.awt.Point;


/**
 * This is an abstract class representing an {@link Entity}
 * that can be in {@link Grid}. Super class to {@link Enemy}
 * and {@link Player}
 */
public abstract class Entity{
    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    public enum moveChoice {UP, DOWN, LEFT, RIGHT};

    /**
     * This abstract method returns {@code true}
     * if {@link Entity} is alive and {@code false}
     * if not.
     * @return boolean {@code true} if alive {@code false} if not
     */
    abstract boolean isAlive();
    /**
     * Abstract method to return the position of an entity.
     * @return Point Entity location
     */
    abstract Point getPos();
}
