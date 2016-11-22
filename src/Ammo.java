/**
 * This class is in charge of creating an Ammo object which can be randomly spawned
 * on a tile in the grid.
 */
public class Ammo extends Item{
	/**
	 * The ammo constructor which allows the ammo item to be randomly spawned in
	 * the grid where there is a {@link Tile} object.
	 */
    public Ammo()
    {
    }
    /**
     * This method returns a char value of {@code B} on the grid to represent 
     * the location of the ammo item.
     * 
     * @return B
     */
    public char returnSymbol()
    {
        return 'B';
    }
    public char returnSymbol(boolean debug) {return debug?'B':'/';}

    public void use() {
        GameEngine.addAmmo();
    }

}