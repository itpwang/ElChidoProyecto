
/**
 * Created by travis on 11/14/16.
 */
public class Enemy extends Entity  {
    public char returnSymbol()
    {
        return 'E';
    }
    /**
     * This field stores {@link Player}'s living state
     * If alive {@code true}, if dead {@code false}
     */
    public char returnSymbol(boolean debug) {return debug?'E':'/';}
    private boolean alive;
    /**
     * This is {@link Player}'s default constructor.
     * Sets field alive to {@code true}
     */
    public Enemy(){
        alive=true;
    }
    /**
     * This field stores the {@link Player}'s movement choice
     * on the keypad
     */
    enum moveChoice {UP, DOWN, LEFT, RIGHT};

    /**
     * This method firts checks that the {@link Player}
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
        moveChoice movechoice;

        UI.displayKeypad();
        movechoice = getMoveChoice();

        if(movechoice == moveChoice.LEFT)
        {
            // Move player Left
            // Done from game engine
        }
        if(movechoice == moveChoice.RIGHT)
        {
            // Move player Right
            // Done from game engine
        }
        if(movechoice == moveChoice.UP)
        {
            // Move player Up
            // Done from game engine
        }
        if(movechoice == moveChoice.DOWN)
        {
            // Move player Down
            // Done from game engine
        }
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
        // Design to work with Enemy
    }

    /**
     * This method prompts the user to imput a
     * {@code moveChoice} for the {@link Player}'s
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
     * This method allows checking if {@link Player} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }

}
