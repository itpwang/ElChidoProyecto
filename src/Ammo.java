/**
 * This class is in charge of creating an Ammo object which can be randomly spawned
 * on a tile in the grid.
 * 
 * Created by Ivan on 11/10/2016.
 */
public class Ammo implements Item, Cell{
	/**
	 * The ammo constructor which allows the ammo item to be randomly spawned in
	 * the grid where there is a {@code Tile} object.
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
}
