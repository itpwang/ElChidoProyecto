import java.awt.Point;
import java.util.Random;

/**
 *
 */
public class Enemy extends Entity {


    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    enum moveChoice {
        UP, DOWN, LEFT, RIGHT
    }

    Point Epos;

    Enemy(Point p) {
        Epos = p;
    }

    public char returnSymbol() {
        return 'E';
    }

    /**
     * Overloaded method of {@link #returnSymbol()} Checks if debug mode is on and
     * returns {@code E} if it is {@code true} and {@code /} if {@code false}
     * @param debug
     * @return char representing object
     */
    public char returnSymbol(boolean debug) {
        return debug ? 'E' : '/';
    }

    /**
     * This field stores {@link Player}'s living state
     * If alive {@code true}, if dead {@code false}
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
     * This method firts checks that the {@link Player}
     * has {@link Ammo}. If so, they attack an adjacent square.
     */
    public void attack(/*The argument should be a tile position*/)
    {

    }
    /**
     * * This method rolls the move for the {@link Enemy}
     *
     * @return int
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

    public void moveUp()
    {
        setPos(new Point(getPos().x - 1,getPos().y));
    }

    public void moveDown()
    {
        setPos(new Point(getPos().x + 1,GameEngine.getPos().y));
    }

    public void moveLeft()
    {
        setPos(new Point(getPos().x,GameEngine.getPos().y - 1));
    }

    public void moveRight()
    {
        setPos(new Point(getPos().x,GameEngine.getPos().y + 1));
    }

    /**
     * This method calls the {@code displayChoice} method
     * and returns the respective integer from the
     * users decision
     *
     * @return answer
     */
    public int taketurn(){
        return 0;
        // Design to work with Enemy
    }

    /**
     * This method allows checking if {@link Player} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * This method sets {@link #Epos to a passed in {@link Point}parameter
     * @param point
     */
    public void setPoint(Point point){
        Epos = point;
    }

    public Point getPos()
    {
        return Epos;
    }

    public void setPos(Point p)
    {
        this.Epos = p;
    }

}
