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
            return '/';
        } else if (hasPlayer()) {
            return 'P';
        }
        return '/';
    }

    public char returnSymbol(boolean debug) {
        if(debug) {
            if (hasItem()) {
                displayTypeOfItem();
            } else if (hasEnemy()) {
                return 'E';
            } else if (hasPlayer()) {
                return 'P';
            } else if (isEmpty()) {
                return ' ';
            }
            return ' '; //??
        }
        else return returnSymbol();
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

//    private int typeOfPowerUp() {
//        if (item instanceof Radar) {
//            return 1;
//        } else if (item instanceof Invincibility) {
//            return 0;
//        } else if (item instanceof Ammo) {
//            return -1;
//        }
//        return -999;//?
//    }

    public boolean hasItem() {
        return enemy == null && player == null && item !=null;
    }

    public boolean hasPlayer() {
        return enemy == null && item == null && player !=null;
    }

    public boolean isEmpty() {
        return enemy == null && player == null && item == null;
    }

    public boolean hasEnemy() {
        return player == null && item == null && enemy != null;
    }
    public boolean noEnemy() {
        return enemy == null;
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
