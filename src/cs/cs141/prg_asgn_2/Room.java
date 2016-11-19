package cs.cs141.prg_asgn_2;

/**
 * This class is in charge of returning a char representing the location of each room on the grid.
 * 
 * Created by travis on 11/14/16.
 */
public class Room extends Tile {
	
	/**
     * This method returns a char value of {@code R} on the grid to represent 
     * the location of a room. 
     * 
	 * @return R
	 */
    public char returnSymbol()
    {
        return 'R';
    }
    public char returnSymbol(boolean debug) {return debug?'R':'/';}
}
