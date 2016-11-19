package cs.cs141.prg_asgn_2;

/**
 * This class is in charge of creating an cs.cs141.prg_asgn_2.Invincibility object which can be randomly
 * spawned on a tile in the grid..
 */
public class Invincibility extends Item{
	/**
	 * The cs.cs141.prg_asgn_2.Invincibility constructor which allows the cs.cs141.prg_asgn_2.Invincibility item to
	 * be randomly spawned in the grid where there is a {@code cs.cs141.prg_asgn_2.Tile} object.
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

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code I} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'I':'/';}

    public void use() {
        GameEngine.isIsInvicible();
    }
}
