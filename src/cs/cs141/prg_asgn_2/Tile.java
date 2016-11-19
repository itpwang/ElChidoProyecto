package cs.cs141.prg_asgn_2;

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

    public Tile(){

    }

    public void insertItem(Item item) {
        this.item = item;
    }

    public void insertPlayer(Player player) {
        this.player = player;
    }

    public void insertEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    /**
     * This method returns a char value of {@code /} on the grid to represent
     * the location of an unoccupied tile.
     *
     * @return /
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

    public char returnSymbol(boolean debug) {
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

    private char displayTypeOfItem() {
        if (item instanceof Radar) {
            return 'R';
        } else if (item instanceof Invincibility) {
            return 'I';
        } else if (item instanceof Ammo) {
            return 'A';
        }
        return ' ';
    }

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

    public boolean hasItem() {
        return enemy == null && player == null;
    }

    public boolean hasPlayer() {
        return enemy == null && item == null;
    }

    public boolean isEmpty() {
        return enemy == null && player == null && item != null;
    }

    public boolean hasEnemy() {
        return player == null && item == null;
    }


}