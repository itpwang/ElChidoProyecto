/**
 * Created by travis on 11/13/16.
 */
public abstract class Entity implements Cell{
    /**
     * This abstract method will allow the
     * {@link Entity} to move on the grid
     */
    abstract void move();
    /**
     * This abstract method will allow the
     * {@link Entity} to look to an adjacent
     * space
     */
    abstract boolean look();
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
    abstract char returnSymbol();
}
