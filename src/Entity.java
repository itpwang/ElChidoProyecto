import java.awt.*;

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
//    abstract void move(moveChoice e);
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
     * This abstract method allows {@link Entity} to die
     */
    public char returnSymbol()
    {
        return 'C';
    }
    public char returnSymbol(boolean debug) {return debug?'C':'/';}
    abstract Point getPos();
}
