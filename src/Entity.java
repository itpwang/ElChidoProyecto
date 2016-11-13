/**
 * Created by travis on 11/13/16.
 */
public interface Entity {
    /**
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    int taketurn();
    /**
     * This abstract method will allow the
     * {@link Entity} to move on the grid
     */
    void move();
    /**
     * This abstract method will allow the
     * {@link Entity} to look to an adjacent
     * space
     */
    boolean look();
    /**
     * This abstract method will allow the
     * {@link Entity} to attack an adjacent
     * space
     */
    void attack();
}
