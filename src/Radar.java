/**
 * This class is in charge of creating a Radar object which can be randomly spawned
 * on a tile in the grid.
 */
public class Radar extends Item{
	
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

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code O} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'O':'/';}

    @Override
    public void use() {
        GameEngine.radarOn();
    }
}

