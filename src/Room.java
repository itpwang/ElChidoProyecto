/**
 * This class is in charge of returning a char
 * representing the location of each room on the grid.
 * 
 * Created by travis on 11/14/16.
 */
public class Room extends Tile {
	
	/**
     * This method returns a char value of
     * {@code R} on the grid to represent
     * the location of a room. 
     * 
	 * @return R
	 */
    public char returnSymbol()
    {
        return 'R';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code R} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'R':'/';}
    public boolean isRoom(){return true;}
}
