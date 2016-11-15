/**
 * This class is in charge of creating an Invincibility object which can be randomly 
 * spawned on a tile in the grid..
 */
public class Invincibility implements Item, Cell{
	/**
	 * The Invincibility constructor which allows the Invincibility item to 
	 * be randomly spawned in the grid where there is a {@code Tile} object.
	 */
	public Invincibility(){

    }

    /**
     * This method returns a char value of {@code I} on the grid to represent 
     * the location of the invincibility item.
     * 
     * @return I
     */
    public char returnSymbol()
    {
        return 'I';
    }
}
