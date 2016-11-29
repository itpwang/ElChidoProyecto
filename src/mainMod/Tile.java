package mainMod;


import java.io.Serializable;

/**
 * This class is in charge of returning the location of a tile not already occupied by
 * another object.
 */
public class Tile implements Serializable {

    /**
     * This field holds an {@link Enemy} object
     */
    private Enemy enemy = null;

    /**
     * This field holds a {@link Player} object
     */
    private Player player = null;

    /**
     * This field holds an {@link Item} object
     */
    private Item item = null;

    /**
     * This field holds a boolean whether a {@link Tile} is a room or not
     */
    private boolean isRoom = false;

    /**
     * This field holds whether a {@link Tile} has a briefcase or not
     */
    private boolean briefcase = false;

    /**
     * The Tile class constructor. Called by {@link Grid}
     * class to create a multidimensional array of {@code Tile}
     * objects.
     */
    public Tile(){

    }

    /**
     * This method takes in an argument of {@link Item} type and
     * sets the position equal to the {@link #item} field.
     *
     * @param item An item object
     */
    public void insertItem(Item item) {
        this.item = item;
    }

    /**
     * This method takes in an argument of {@link Player} type and
     * sets the position equal to the {@link #player} field.
     *
     * @param player A player object
     */
    public void insertPlayer(Player player) {
        this.player = player;
    }

    /**
     * This method takes in an argument of {@link Enemy} type and
     * sets the position equal to the {@link #enemy} field.
     *
     * @param enemy An enemy object
     */
    public void insertEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * This method returns a char value of {@code /} on the grid to represent
     * the location of an unoccupied tile, {@code E} to represent location of
     * an enemy, {@code P} to represent location of player.
     *
     * @return char representing object
     */
    public char returnSymbol() {
        if (isEmpty()) {
            return '/';
        }       
        else if(isRoom) {
            if(briefcase && GameEngine.getRadar())
                return 'W';
        	return 'R';
        }
        else if (hasEnemy() || hasItem()) {
            return '/';
        }
        else if (hasPlayer()) {
            return 'P';
        }
        return '/';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code ' '}, {@code E}, {@code P}, {@code B}, {@code O}, {@code I}
     * depending on object that occupies the tile if it is {@code true} and
     * {@code /} if {@code false}
     *
     * @param debug {@link GameEngine#debug}
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {
        if(debug) {
            if(hasItem()&&hasEnemy())
            {
                return 'E';
            }
            else if (hasItem()) {
                return displayTypeOfItem();
            }

            else if(isRoom) {
                if(briefcase && GameEngine.getRadar())
                    return 'W';
            	return 'R';
            }       
            else if (hasEnemy()) {
            	return 'E';
            } 
            else if (hasPlayer()) {
                return 'P';
            } 
            else if (isEmpty()) {
                return ' ';
            }
            return ' '; //??
        }
        else return returnSymbol();
    }

    /**
     * This method is called by {@link #returnSymbol(boolean)} and returns
     * {@code O}, {@code I}, {@code B} if there is a value in the {@code item}
     * field.
     *
     * @return char representing object
     */
    private char displayTypeOfItem() {
        if (item instanceof Radar) {
            return 'O';
        } else if (item instanceof Invincibility) {
            return 'I';
        } else if (item instanceof Ammo) {
            return 'A';
        }
        return ' ';
    }

    /**
     * This method checks if {@link Tile} contains an {@link Item}
     *
     * @return boolean {@code true]} if contains {@link Item}, {@code false} if not
     */
    public boolean hasItem() {
        return item!=null;
    }

    /**
     * This method checks if {@link Tile} contains a {@link Player}
     *
     * @return boolean {@code true} if contains {@link Player}, {@code false} if not
     */
    public boolean hasPlayer() {
        return player!=null;
    }

    /**
     * This method sets the fields of {@code enemy}, {@code player}, and {@code item}
     * to null in a {@link Tile} object if {@link #isEmpty()} returns {@code true}
     *
     * @return boolean {@code true} if {@link Tile} is empty, {@code false} if not
     */
    public boolean isEmpty() {
        return enemy == null && player == null && item == null && isRoom == false;
    }

    /**
     * This method checks if {@link Tile} contains an {@link Enemy}
     *
     * @return boolean {@code true} if contains enemy, {@code false} if not
     */
    public boolean hasEnemy() {
        return enemy != null;
    }

    /**
     * This method checks if {@link Tile} contains an {@link Enemy}
     *
     * @return {@code true]} if contains no enemy, {@code false} if it does
     */
    public boolean noEnemy() {
        return enemy == null;
    }

    /**
     * This method kills the enemy be setting {@link #enemy} to {@code null}
     */
    public void killEnemy()
    {
        System.out.println("You kill the Enemy! ");
        this.enemy = null;
    }

    /**
     * This method is used to return an {@link Enemy} object
     * @return Enemy An enemy
     */
    public Enemy getEnemy(){
        return enemy;
    }

    /**
     * This method is used to set {@link #enemy} to the {@link Enemy}
     * passed as an argument
     *
     * @param e An enemy object
     */
    public void setEnemy(Enemy e){
        enemy = e;
    }

    /**
     * This method is used to return the {@link Player} object
     *
     * @return Player The player object
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * This method returns {@code true} if there is a {@link Room} at
     * the location, and {@code false} if not.
     *
     * @return boolean {@code true, false}
     */
    public boolean isRoom(){
    	return isRoom;
    }

    /**
     * This method sets a {@link #briefcase} to return {@code true}
     */
    public void setBriefcase()
    {
        briefcase = true;
    }

    /**
     * This method returns {@code true, false} depending on what a {@link Tile}
     * has in {@link #briefcase}
     *
     * @return boolean {@code true, false}
     */
    public boolean hasBriefcase()
    {
        return briefcase;
    }
    /**
     * This method sets a {@link Room} object at the position if b is {@code true}
     *
     * @param b {@code true, false}
     */
    public void setIsRoom(boolean b) {
    	this.isRoom = b;
    }

    /**
     * This method is used to return an {@link Item} object
     * @return Item An item
     */
    public Item getItem()
    {
        return item;
    }

    /**
     * This method is used to set {@link Item} to {@code null}
     */
    public void setItemNull()
    {
        this.item = null;
    }

}
