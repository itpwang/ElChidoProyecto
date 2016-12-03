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
import java.io.*;

/**
 * This class handles all of the saving and loading for
 * the game. Saving is done by serializing the {@link GameState}
 * class which holds all of the {@link GameEngine} objects.
 */
public class SaveEngine {


    /**
     * This method writes the {@link GameState} to a file in
     * the current directory and display the current directory
     * the file has been saved in.
     *
     * @param gameState GameState
     */
    public static void writeSave(GameState gameState){
        try{

            File newSaveFile = new File("./save.ser");
            if (!newSaveFile.exists()) {
                newSaveFile.createNewFile();
            }

            FileOutputStream fileOut = new FileOutputStream("./save.ser");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("File saved " + newSaveFile.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method reads the save.ser files which contains serialized {@link GameEngine} objects.
     * @return loadedGameSave GameState serialized object
     */
    public static GameState readSave() {
        try {
            FileInputStream fileIn = new FileInputStream("./save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameState loadedGameSave = (GameState) in.readObject();
            in.close();
            fileIn.close();
            return loadedGameSave;
        } catch (FileNotFoundException f){
            System.out.println("No game save was found.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Save not found");
            c.printStackTrace();
            return null;
        }

    }
}