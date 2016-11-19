package cs.cs141.prg_asgn_2;

/**
 * Interface implemented by cs.cs141.prg_asgn_2.Ammo, cs.cs141.prg_asgn_2.Invincibility, cs.cs141.prg_asgn_2.Radar, cs.cs141.prg_asgn_2.Room, cs.cs141.prg_asgn_2.Tile, and cs.cs141.prg_asgn_2.Entity classes.
 * 
 * Created by travis on 11/14/16.
 */
public interface Cell {
	/**
	 * Abstract method which returns the char that represents the object occupying a 
	 * cell on the grid.
	 */
    char returnSymbol();
	char returnSymbol(boolean debug);
}
