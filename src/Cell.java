/**
 * Interface implemented by Ammo, Invincibility, Radar, Room, Tile, and Entity classes.
 * 
 * Created by travis on 11/14/16.
 */
public interface Cell {
	
	/**
	 * Abstract method which returns the char that represents the object occupying a 
	 * cell on the grid.
	 */
    char returnSymbol();
}
