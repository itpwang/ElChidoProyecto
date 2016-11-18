import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Point;

/**
 * Created by travis on 11/13/16.
 */
public class Player extends Entity {

   public char returnSymbol()
   {
      return 'P';
   }
   /**
    * This {@code Scanner} variable allows the user
    * to input values for their choices in battle
    */
   public char returnSymbol(boolean debug) {return debug?'P':'P';}
   private Scanner input = new Scanner(System.in);
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
   public void move(moveChoice m)
   {
      moveChoice movechoice;

      UI.displayKeypad();
      movechoice = getMoveChoice();

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

   public void moveUp()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x - 1,GameEngine.getPos().y));
   }

   public void moveDown()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x + 1,GameEngine.getPos().y));
   }

   public void moveLeft()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x,GameEngine.getPos().y - 1));
   }

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
      int answer;

      UI.displayChoice();

      answer = input.nextInt();

      try {
         if (answer == 0 || answer == 1 || answer == 2 || answer == 3)
         {
            return answer;
         } else {
            System.out.println("Invalid Choice");
            UI.displayChoice();
         }
      } catch (InputMismatchException e)
      {
         System.out.println("Input must be an integer.");
         while(input.hasNext() && input.hasNextInt())
            input.next();
      }
      return answer;
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
      String answer;
      char movechoice;

      UI.displayKeypad();
      answer = input.next();
      movechoice = answer.charAt(0);

      try {
         if (movechoice == 'A' )
         {
           return moveChoice.LEFT;
         }
         else if(movechoice == 'D')
         {
            return moveChoice.RIGHT;
         }
         else if(movechoice == 'W')
         {
            return moveChoice.UP;
         }
         else if(movechoice == 'S')
         {
            return moveChoice.DOWN;

         } else {
            System.out.println("Invalid Choice");
            UI.displayKeypad();
         }
      } catch (InputMismatchException e)
      {
         System.out.println("Input must be an integer.");
         while(input.hasNext() && input.hasNextInt())
            input.next();
      }

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
