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
     * This {@code Scanner} variable allows the user
     * to input values for their choices in battle
     */
    private transient Scanner input = new Scanner(System.in); // do we need this??

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
      alive=true;
    }

    public int getNumOfLives(){
        return numOfLives;
    }

    public void setNumOfLives(int numOfLives) {
        this.numOfLives = numOfLives;

    }

    public void decLives() {
    	this.numOfLives--;
    }

    public Player(Point p) {
        pPos = p;
    }
    /**
     * This method returns the character
     * string that represents the {@link Player}
     * @return
     */
    public char returnSymbol()
    {
        return 'P';
    }

    /**
     * This method returns the character
     * string that represents the {@link Player}
     * (Debug mode)
     * @return
     */
    public char returnSymbol(boolean debug) {return debug?'P':'P';}

    /**
        * This method firts checks that the {@link Player}
        * has {@link Ammo}. If so, they attack an adjacent square.
        */
    public void attack(/*The argument should be a tile position*/ ){
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


    public void moveUp() {pPos.translate(-1, 0);}


    public void moveDown() {
        pPos.translate(1, 0);
    }


    public void moveLeft() {
        pPos.translate(0, -1);
    }


    public void moveRight() {
        pPos.translate(0, 1);
    }



    /**
        * This method returns a boolean value based
        * on whether the spaces they are looking at
        * are empty or not.
        *
        * @return True/False
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
//    public int taketurn(){
//        int answer;
//
//        UI.displayChoice();
//
//        answer = input.nextInt();
//
//        try {
//        if (answer == 0 || answer == 1 || answer == 2 || answer == 3)
//        {
//        return answer;
//        } else {
//        System.out.println("Invalid Choice");
//        UI.displayChoice();
//        }
//        } catch (InputMismatchException e)
//        {
//        System.out.println("Input must be an integer.");
//        while(input.hasNext() && input.hasNextInt())
//        input.next();
//        }
//        return answer;
//        }

    /**
        * This method checks to see if the player has ammo
        *
        * @return True/False
        */
    private boolean checkAmmo(){
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

    /**
     * This method gets the {@link Player}s location
     * @return
     */
    public Point getPos()
    {
        return new Point(pPos);
    }

    public void setPos(Point p, int x, int y)
    {
        pPos.setLocation(p.getX()+x,p.getY()+y);
    }
}
