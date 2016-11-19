package cs.cs141.prg_asgn_2;

import java.awt.Point;

/**
 *
 */
public class Enemy extends Enemy  {

    /**
     * This field holds the {@link Enemy}'s
     * position
     */
    Point Epos;

    /**
     * This constructor sets the {@link Enemy#Epos}
     * to the {@code Point} passed as an parameter
     *
     * @param p
     */
    Enemy(Point p)
    {
       Epos = p;
    }

    /**
     * This method gets the {@link Enemy}'s
     * position
     *
     * @return Point
     */
    public Point getPos()
    {
        return Epos;
    }

    /**
     * This method sets the {@link Enemy}'s
     * position
     */
    public void setPos(Point p)
    {
       this.Epos = p;
    }

    /**
     * This method returns the respective
     * {@link Enemy}'s character
     *
     * @return char
     */
    public char returnSymbol()
    {
        return 'E';
    }

    /**
     * This field stores {@link Enemy}'s living state
     * If alive {@code true}, if dead {@code false}
     */
    public char returnSymbol(boolean debug) {return debug?'E':'/';}

    /**
     * This field represents if the {@link Enemy}
     * is alive
     */
    private boolean alive;

    /**
     * This is {@link }'s default constructor.
     * Sets field alive to {@code true}
     */
    public Enemy(){
        alive=true;
    }

    /**
     * This field stores the {@link Enemy}'s movement choice
     * on the keypad
     */
    enum moveChoice {UP, DOWN, LEFT, RIGHT};

    /**
     * This method firts checks that the {@link Enemy}
     * has {@link Ammo}. If so, they attack an adjacent square.
     */
    public void attack(/*The argument should be a tile position*/ )
    {
        if(checkAmmo())
        {
            if(peekAhead())
            {
                // kill enemy
            }
            else
                System.out.println("You shoot nothing!");
        }
    }

    /**
     * This method outputs the keypad to the screen
     * and gets user input for the {@code moveChoice}
     *
     */
    public void move()
    {
        moveChoice m;

        UI.displayKeypad();
        m = getMoveChoice();

        if(m == moveChoice.LEFT)
        {
            moveLeft();
        }
        else if(m == moveChoice.RIGHT)
        {
            moveRight();
        }
        else if(m == moveChoice.UP)
        {
            moveUp();
        }
        else if(m == moveChoice.DOWN)
        {
            moveDown();
        }
    }

    /**
     * Moves the {@link Enemy} Up on
     * {@link Grid} by one tile
     */
    public void moveUp()
    {
        GameEngine.setPos(new Point(GameEngine.getPos().x - 1,GameEngine.getPos().y));
    }

    /**
     * Moves the {@link Enemy} Down on
     * {@link Grid} by one tile
     */
    public void moveDown()
    {
        GameEngine.setPos(new Point(GameEngine.getPos().x + 1,GameEngine.getPos().y));
    }

    /**
     * Moves the {@link Enemy} Left on
     * {@link Grid} by one tile
     */
    public void moveLeft()
    {
        GameEngine.setPos(new Point(GameEngine.getPos().x,GameEngine.getPos().y - 1));
    }

    /**
     * Moves the {@link Enemy} Right on
     * {@link Grid} by one tile
     */
    public void moveRight()
    {
        GameEngine.setPos(new Point(GameEngine.getPos().x,GameEngine.getPos().y + 1));
    }
    /**
     * This method returns a boolean value based
     * on whether the spaces they are looking at
     * are empty or not.
     *
     * @return True/False
     */
    public boolean look()
    {
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
     */
    private boolean peekAhead()
    {
        // Checks the adjacent spaces
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
    public int taketurn()
    {
        return 0;
        // Design to work with cs.cs141.prg_asgn_2.Enemy
    }

    /**
     * This method prompts the user to imput a
     * {@code moveChoice} for the {@link Enemy}'s
     * Handles exceptions for invalid input
     *
     * @return moveChoice
     */
    private moveChoice getMoveChoice()
    {
        // Make move random
        return moveChoice.RIGHT;
    }

    /**
     * This method checks to see if the player has ammo
     *
     * @return True/False
     */
    private boolean checkAmmo()
    {
        // total ammo is stored in game engine
        return true;
    }

    /**
     * This method allows checking if {@link Enemy} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * This method sets {@link #location} to a passed in {@link Point}parameter
     * @param point
     */
    public void setPoint(Point point){
        Epos = point;
    }

}
