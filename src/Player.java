import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by travis on 11/13/16.
 */
public class Player implements Entity {
   private Scanner input = new Scanner(System.in);
   enum moveChoice {UP, DOWN, LEFT, RIGHT};

   public void attack()
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

   private boolean peekAhead()
   {
      // Checks the adjacent spaces
      // done from game engine
      return true;
   }

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

   private moveChoice getMoveChoice()
   {
      String answer;
      char movechoice;

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

   private boolean checkAmmo()
   {
      // total ammo is stored in game engine
      return true;
   }
}
