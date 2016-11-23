/**
 * This class is in charge of returning the location of a tile not already occupied by
 * another object.
 * <p>
 * Created by travis on 11/14/16.
 */
public class Tile {
    private Enemy enemy = null;
    private Player player = null;
    private Item item = null;

    /**
     * The Tile class constructor. Called by {@link Grid}
     * class to create a multidimensional array of {@code Tile}
     * objects.
     */
    public Tile(){

    }

    /**
     * This method takes in an argument of {@link Item} type and
     * sets the position equal to the {@code item} field.
     * @param item
     */
    public void insertItem(Item item) {
        this.item = item;
    }

    /**
     * This method takes in an argument of {@link Player} type and
     * sets the position equal to the {@code player} field.
     * @param player
     */
    public void insertPlayer(Player player) {
        this.player = player;
    }

    /**
     * This method takes in an argument of {@link Enemy} type and
     * sets the position equal to the {@code enemy} field.
     * @param enemy
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
        } else if (hasEnemy()) {
            return 'E';
        } else if (hasPlayer()) {
            return 'P';
        }
        return '/';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code ' '}, {@code E}, {@code P}, {@code B}, {@code O}, {@code I}
     * depending on object that occupies the tile if it is {@code true} and
     * {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {
        if(debug) {
            if (isEmpty()) {
                return ' ';
            } else if (hasEnemy()) {
                return 'E';
            } else if (hasPlayer()) {
                return 'P';
            } else if (hasItem()) {
                displayTypeOfItem();
            }
            return ' '; //??
        }
        else return returnSymbol();
    }

    /**
     * This method is called by {@link #returnSymbol(boolean)} and returns
     * {@code O}, {@code I}, {@code B} if there is a value in the {@code item}
     * field.
     * @return char representing object
     */
    private char displayTypeOfItem() {
        if (item instanceof Radar) {
            return 'O';
        } else if (item instanceof Invincibility) {
            return 'I';
        } else if (item instanceof Ammo) {
            return 'B';
        }
        return ' ';
    }

    /**
     *
     * @return
     */
    private int typeOfPowerUp() {
        if (item instanceof Radar) {
            return 1;
        } else if (item instanceof Invincibility) {
            return 0;
        } else if (item instanceof Ammo) {
            return -1;
        }
        return -999;//?
    }

    /**
     * This method sets the fields of {@code enemy} and {@code player}
     * to null in a {@link Tile} object if {@link #hasItem()} returns {@code true}
     *
     * @return {@code null} for {@code enemy} and {@code player} fields
     */
    public boolean hasItem() {
        return enemy == null && player == null;
    }

    /**
     * This method sets the fields of {@code enemy} and {@code item}
     * to null in a {@link Tile} object if {@link #hasPlayer()} returns {@code true}
     *
     * @return {@code null} for {@code enemy} and {@code item} fields
     */
    public boolean hasPlayer() {
        return enemy == null && item == null;
    }

    /**
     * This method sets the fields of {@code enemy}, {@code player}, and {@code item}
     * to null in a {@link Tile} object if {@link #isEmpty()} returns {@code true}
     *
     * @return {@code null} for {@code enemy} and {@code player} fields
     */
    public boolean isEmpty() {
        return enemy == null && player == null && item == null;
    }

    /**
     * This method sets the fields of {@code player} and {@code item}
     * to null in a {@link Tile} object if {@link #hasEnemy()} returns {@code true}
     *
     * @return {@code null} for {@code player} and {@code item} fields
     */
    public boolean hasEnemy() {
        return player == null && item == null && enemy != null;
    }

    public void killEnemy(){this.enemy = null;}
    public Enemy getEnemy(){
        return enemy;
    }
    public void setEnemy(Enemy e){
        enemy = e;
    }
    public Player getPlayer(){
        return player;
    }
    public boolean isRoom(){return false;}
    public Item getItem(){
        return item;
    }
}
