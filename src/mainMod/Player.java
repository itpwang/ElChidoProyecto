package mainMod;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Point;

public class Player extends Entity implements Serializable{

    private int numOfLives = 3;
    private boolean validMove;

    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    private moveChoice lookDirection;

    /**
     * This point stores the position of the
     * {@link Player}
     */
    private Point pPos;

    /**
     * This field stores {@link Player}'s living state
     * If alive {@code true}, if dead {@code false}
     */
    private boolean alive;

    /**
     * This is {@link Player}'s default constructor.
     * Sets field alive to {@code true}
     */
    public Player(){
      alive = true;
    }

    /**
     * This method gets the {@link Player}'s remaining lives.
     * @return Lives left
     */
    public int getNumOfLives(){
        return numOfLives;
    }

    /**
     * This method sets the {@link Player}'s remaining lives.
     * @param numOfLives Player's lives left
     */
    public void setNumOfLives(int numOfLives) {
        this.numOfLives = numOfLives;
    }

    /**
     * This method incrementally decreases {@link Player#numOfLives} by 1 each
     * time a {@link Player} loses a life.
     */
    public void decLives() {
    	this.numOfLives--;
    }

    /**
     * This method sets {@link Player#pPos} to the argument passed
     *
     * @param p Player position
     */
    public Player(Point p) {
        pPos = p;
    }

    /**
     * This method returns the character
     * string that represents the {@link Player}
     *
     * @return char {@code P}
     */
    public char returnSymbol()
    {
        return 'P';
    }

    /**
     * This method returns the character
     * string that represents the {@link Player}
     *
     * @param debug {@link GameEngine#debug}
     * @return char {@code P}
     */
    public char returnSymbol(boolean debug) {return debug?'P':'P';}

    /**
     * These methods set the new position of an entity by adding/subtracting 1
     * to the axis corresponding to the move direction.
     */
    // UP: (x - 1, y)
    public void moveUp() {pPos.translate(-1, 0);}
    // DOWN: (x + 1, y)
    public void moveDown() {
        pPos.translate(1, 0);
    }
    // LEFT: (x, y - 1)
    public void moveLeft() {
        pPos.translate(0, -1);
    }
    // RIGHT: (x, y + 1)
    public void moveRight() {
        pPos.translate(0, 1);
    }

    /**
     * This method returns a boolean value based
     * on whether the spaces they are looking at
     * are empty or not.
     *
     * @return boolean {@code true, false}
     */
    public boolean look(moveChoice m){
        this.lookDirection = m;

        if(peekAhead())
        {
        System.out.println("Ninja Ahead!");
        return true;
        }
        else
        System.out.println("All clear!");
        return false;
        }

    /**
     * This method checks the adjacent space
     *
     * @return boolean {@code true}
     */
    private boolean peekAhead(){
        // Checks the look spaces
        // done from game engine
        return true;
        }

    /**
        * This method calls the {@code displayChoice} method
        * and returns the respective integer from the
        * users decision
        *
        * @return answer
        */

    /**
     * This method checks to see if the player has ammo
     *
     * @return boolean {@code true, false}
     */
    private boolean checkAmmo(){
        // total ammo is stored in game engine
        return true;
    }

    /**
     * This method allows checking if {@link Player} is alive
     * @return boolean {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * This method gets the {@link Player}s location
     * @return Point Player position
     */
    public Point getPos()
    {
        return new Point(pPos);
    }
    /**
     * This method sets the {@link Player}'s location.
     * @param p Player position
     */
    public void setPlayerPos(Point p)
    {
        pPos.setLocation(p.getX(),p.getY());
    }
}
