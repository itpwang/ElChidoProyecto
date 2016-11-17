/**
 * This class is in charge of creating a Radar object which can be randomly spawned
 * on a tile in the grid.
 */
public class Radar implements Item, Cell{
	
	/**
	 * The Radar constructor which allows the Radar item to be randomly spawned 
	 * in the grid where there is a {@code Tile} object.
	 */
    public Radar()
    {
    }
    
    /**
     * This method returns a char value of {@code O} on the grid to represent 
     * the location of the radar item.
     * 
     * @return O
     */
    public char returnSymbol()
    {
        return 'O';
    }
    public char returnSymbol(boolean debug) {return debug?'O':'/';}
}

