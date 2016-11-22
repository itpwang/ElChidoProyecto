/**
 * This class is in charge of creating an Invincibility object which can be randomly 
 * spawned on a tile in the grid..
 */
public class Invincibility extends Item{
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

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code I} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {return debug?'I':'/';}

    public void use() {
        GameEngine.invincibilityOn();
    }
}
