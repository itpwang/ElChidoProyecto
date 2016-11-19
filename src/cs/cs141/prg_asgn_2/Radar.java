package cs.cs141.prg_asgn_2;

/**
 * This class is in charge of creating a cs.cs141.prg_asgn_2.Radar object which can be randomly spawned
 * on a tile in the grid.
 */
public class Radar extends Item{
	
	/**
	 * The cs.cs141.prg_asgn_2.Radar constructor which allows the cs.cs141.prg_asgn_2.Radar item to be randomly spawned
	 * in the grid where there is a {@code cs.cs141.prg_asgn_2.Tile} object.
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

    @Override
    public void use() {
        GameEngine.radarOn();
    }
}

