/**
 * This abstract class represents a space on the map,
 * represented by {@link Grid}.
 * Can contain {@link Entity} and {@link ItemDrop}
 */
public abstract class Space {
    /**
     * This is a protected field of abstract class {@link Space}
     * It contains an {@link Entity} that will be an enemy.
     */
    protected Entity enemy;
    /**
     * This is a protected field of abstract class {@link Space}
     * It may contain an {@link ItemDrop}
     */
    protected ItemDrop item;

    /**
     * This is the default constructor of abstract class {@link Space}
     * It creates a new {@link NinjaAssassin} in the field {@link #enemy}
     * then calls it to {@link NinjaAssassin#die()} resulting it to return
     * {@code false} if queried with {@link NinjaAssassin#isAlive()}
     */
    public Space(){
        enemy = new NinjaAssassin();
        enemy.die();
    }

    /**
     * This method returns if the {@link #enemy} is dead or alive.
     * @return if field {@link #enemy} is alive(true) or dead(false)
     */
    boolean containsEnemy(){
        return enemy.isAlive();
    }
}