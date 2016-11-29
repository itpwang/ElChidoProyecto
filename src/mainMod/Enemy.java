package mainMod;
import java.awt.Point;
import java.io.Serializable;
import java.util.Random;

/**
 *
 */
public class Enemy extends Entity implements Serializable {

    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    enum moveChoice {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * This field represents the {@link Enemy} position on the grid.
     */
    Point Epos;

    /**
     * This field is set to {@code true} if the player is
     * alive, and {@code false} if player is dead.
     */
    private boolean alive;

    /**
     * This is {@link Player}'s default constructor.
     * Sets field alive to {@code true}
     */
    public Enemy() {
        alive = true;
    }

    /**
     * This method first checks that the {@link Player}
     * has {@link Ammo}. If so, they attack an adjacent square.
     */
    public Enemy(Point p) {
        Epos = p;
    }

//    public char returnSymbol() {
//        return 'E';
//    }

    /**
     * This field stores {@link Player}'s living state
     * If alive {@code true}, if dead {@code false}
     */
//    public char returnSymbol(boolean debug) {
//        return '/';
////        return debug ? 'E' : '/';
//    }
    public void attack(/*The argument should be a tile position*/)
    {

    }

    /**
     * This method rolls a random value 0 - 3 to determine the
     * move direction of {@link Enemy}
     *
     * @return moveChoice The direction the enemy will move.
     */
    public moveChoice rollMove () {
        int enemyMove;
        Random rand = new Random();
        enemyMove = rand.nextInt(3);

        switch (enemyMove) {
            case 0:
                return moveChoice.UP;
            case 1:
                return moveChoice.DOWN;
            case 2:
                return moveChoice.LEFT;
            case 3:
                return moveChoice.RIGHT;
        }
            return moveChoice.UP;
    }

    /**
     * This method outputs the keypad to the screen
     * and gets user input for the {@code moveChoice}
     *
     * @param m The move direction of an entity
     */
    public void move(Entity.moveChoice m){

        switch(m)
        {
            case UP:
                moveUp();
                break;

            case DOWN:
                moveDown();
                break;

            case LEFT:
                moveLeft();
                break;

            case RIGHT:
                moveRight();
                break;
        }
    }

    /**
     * These methods set the new position of an entity by adding/subtracting 1
     * to the axis corresponding to the move direction.
     */
    // UP: (x - 1, y)
    public void moveUp()
    {
        setPos(new Point(getPos().x - 1,getPos().y));
    }
    // DOWN: (x + 1, y)
    public void moveDown()
    {
        setPos(new Point(getPos().x + 1,getPos().y));
    }
    // LEFT: (x, y - 1)
    public void moveLeft()
    {
        setPos(new Point(getPos().x,getPos().y - 1));
    }
    // RIGHT: (x, y + 1)
    public void moveRight()
    {
        setPos(new Point(getPos().x,getPos().y + 1));
    }

    /**
     * This method allows checking if {@link Player} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * This method sets {@link #Epos} to a passed in {@link Point} parameter
     * @param point Enemy position
     */
    public void setPoint(Point point){
        Epos = point;
    }

    /**
     * This method gets the {@link Enemy}s location
     * @return Point The enemy location
     */
    public Point getPos()
    {
        return Epos;
    }

    /**
     * This method sets {@link #Epos} to the Point passed as an argument
     * @param p The enemy position
     */
    public void setPos(Point p)
    {
        this.Epos = p;
    }

}
