/**
 * This class is in charge of returning the location of a tile not already occupied by 
 * another object.
 * 
 * Created by travis on 11/14/16.
 */
public class Tile implements Cell{
	
	/**
     * This method returns a char value of {@code /} on the grid to represent 
     * the location of an unoccupied tile. 
     * 
	 * @return /
	 */
    public char returnSymbol()
    {
       return '/';
    }
    public char returnSymbol(boolean debug) {return '/';}

}
