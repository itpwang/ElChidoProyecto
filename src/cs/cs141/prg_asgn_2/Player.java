package cs.cs141.prg_asgn_2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Point;

/**
 * Created by travis on 11/13/16.
 */
public class Player extends Entity {

   /**
    * This field holds the value of
    * the direction the {@link Player}
    * is facing
    */
   private moveChoice lookDirection;

   /**
    * This {@code Scanner} variable allows the user
    * to input values for their choices in battle
    */
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
    * This method returns the respective
    * {@link Player}'s character
    *
    * @return char
    */
   public char returnSymbol()
   {
      return 'P';
   }

   /**
    * This field stores {@link Player}'s living state
    * If alive {@code true}, if dead {@code false}
    */
   public char returnSymbol(boolean debug) {return debug?'P':'P';}

   // MOVE FUNCTIONS

   /**
    * This method prompts the user to imput a
    * {@code moveChoice} for the {@link Player}'s
    * Handles exceptions for invalid input
    *
    * @return moveChoice
    */
   private moveChoice getMoveChoice(){
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
 * This method outputs the keypad to the screen
 * and gets user input for the {@code moveChoice}
 *
 */
   public void move(moveChoice m){
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

   /**
    * Moves the {@link Player} Up on
    * {@link Grid} by one tile
    */
   public void moveUp()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x - 1,GameEngine.getPos().y));
   }

   /**
    * Moves the {@link Player} Down on
    * {@link Grid} by one tile
    */
   public void moveDown()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x + 1,GameEngine.getPos().y));
   }

   /**
    * Moves the {@link Player} Left on
    * {@link Grid} by one tile
    */
   public void moveLeft()
   {
      GameEngine.setPos(new Point(GameEngine.getPos().x,GameEngine.getPos().y - 1));
   }

   /**
    * Moves the {@link Player} Right on
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
   public boolean look(moveChoice m){
      this.lookDirection = m;

      if(peekAhead(this.lookDirection))
      {
         System.out.println("Ninja Ahead!");
         return true;
      }
      else
      System.out.println("All clear!");
      return false;
   }

   /**
    * This method firts checks that the {@link Player}
    * has {@link Ammo}. If so, they attack an adjacent square.
    */
   public void attack(/*The argument should be a tile position*/ ){

      moveChoice attackDirection = askDirection();

      if(checkAmmo())
      {
         if(peekAhead(attackDirection)
         {
            // kill enemy
         }
            System.out.println("You shoot nothing!");
      }
   }

   private boolean peekAhead(moveChoice m){

      switch (m)
      {
         case UP:
         {
             if(GameEngine.checkPos(m))
                return true;
            return false;
         }
         case DOWN:
         {
            if(GameEngine.checkPos(m))
               return true;
            return false;
         }
         case LEFT:
         {
            if(GameEngine.checkPos(m))
               return true;
            return false;
         }
         case RIGHT:
         {
            if(GameEngine.checkPos(m))
               return true;
            return false;
         }

      }

      return true;
   }

   /**
    * This method calls the {@code displayChoice} method
    * and returns the respective integer from the
    * users decision
    *
    * @return answer
    */
   public int taketurn(){
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
    * This method checks to see if the player has ammo
    *
    * @return True/False
    */
   private boolean checkAmmo(){
      // total ammo is stored in game engine
      if(GameEngine.ammoEmpty())
         return true;
      else
         return false;
   }

   /**
     * This method allows checking if {@link Player} is alive
     * @return {@code true}if alive ;{@code false} if dead
     */
    public boolean isAlive(){
        return alive;
    }
}
