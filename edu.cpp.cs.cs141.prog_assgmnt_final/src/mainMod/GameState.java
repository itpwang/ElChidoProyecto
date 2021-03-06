/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment Final
 *
 * This is a text-based game where the player has to find a briefcase
 * located in 1 of 9 rooms. Complications include enemies that could kill you.
 * Powerups can also be obtained.
 *
 * Team Destructors
 *   Ivan Wang
 *   Travis Linkey
 *   Sean McCullough
 *   Zach Oeh
 *   Michael Ortega
 *   Andy Rosas
 */
package mainMod;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class holds the current state of the game when a save is made and will be
 * used to instantiate a GameEngine object.
 */
public class GameState implements Serializable {

    /**
     * This field holds whether debug is {@code true, false}
     */
    private Boolean savedDebug;

    /**
     * This field holds whether invincible is on or off {@code true, false}
     */
    private Boolean savedIsInvincible;

    /**
     * This field holds the remaining steps of invincibility
     */
    private Integer savedInvCounter;

    /**
     * This field holds the player's total ammo
     */
    private Integer savedPlayerAmmo;

    /**
     * This field holds whether the {@link Radar} is on or off {@code true, false}
     */
    private Boolean savedRadar;

    /**
     * This field holds an array of the {@link Enemy}'s remaining.
     */
    private Enemy[] savedEnemies;
    /**
     * This field stores an {@link ArrayList} of
     * {@link Item}s
     */
    private ArrayList<Item> savedItems;

    /**
     * This field holds the {@link Player} object
     */
    private Player savedPlayer;

    /**
     * This field holds the {@link Grid} object.
     */
    private Grid savedBoard;
    /**
     * The GameState constructor that sets the fields to the
     * value of the {@link ArrayList} objects that are passed.
     * @param gameObjects
     */
    public GameState(ArrayList gameObjects) {
        savedPlayer = (Player) gameObjects.get(0);
        savedBoard = (Grid) gameObjects.get(1);
        savedEnemies = (Enemy[]) gameObjects.get(2);
        savedItems = (ArrayList<Item>) gameObjects.get(3);
        savedIsInvincible = (Boolean) gameObjects.get(4);
        savedInvCounter = (Integer) gameObjects.get(5);
        savedPlayerAmmo = (Integer) gameObjects.get(6);
        savedRadar = (Boolean) gameObjects.get(7);
        savedDebug = (Boolean) gameObjects.get(8);
    }

    /**
     * This method returns the {@link Player} object that was saved.
     *
     * @return Player The saved player
     */
    public Player getSavedPlayer() {
        return savedPlayer;
    }

    /**
     * This method returns the boolean value {@code true, false}
     * of {@link #savedDebug}that was saved
     *
     * @return boolean {@code true, false}
     */
    public Boolean getSavedDebug() {
        return savedDebug;
    }

    /**
     * This method returns the boolean value {@code true, false}
     * of {@link #savedIsInvincible}that was saved
     *
     * @return boolean {@code true, false}
     */
    public Boolean getSavedIsInvincible() {
        return savedIsInvincible;
    }

    /**
     * This method returns the {@link #savedInvCounter} value that was saved.
     *
     * @return int Saved invincibility counter
     */
    public Integer getSavedInvCounter() {
        return savedInvCounter;
    }

    /**
     * This method returns the {@link #savedPlayerAmmo} value that was saved.
     *
     * @return int Saved player ammo
     */
    public Integer getSavedPlayerAmmo() {
        return savedPlayerAmmo;
    }

    /**
     * This method returns the boolean value {@code true, false}
     * of {@link #savedRadar}that was saved
     *
     * @return boolean {@code true, false}
     */
    public Boolean getSavedRadar() {
        return savedRadar;
    }

    /**
     * This method returns an array of {@link Enemy} objects that was saved.
     *
     * @return Enemy[] Array of saved enemy objects
     */
    public Enemy[] getSavedEnemies() {
        return savedEnemies;
    }

    /**
     * This method returns the state of the {@link Grid} object that was saved.
     *
     * @return Grid The saved grid object
     */
    public Grid getSavedBoard() {
        return savedBoard;
    }

    /**
     * This method returns an {@link ArrayList} of
     * {@link Item} objects from {@link #savedItems}
     *
     * @return ArrayList<Item> Saved item objects
     */
    public ArrayList<Item> getSavedItems() { return savedItems;}

}