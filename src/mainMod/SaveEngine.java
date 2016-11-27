package mainMod;
import java.io.*;

public class SaveEngine {

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

    public static GameState readSave() {
        try {
            FileInputStream fileIn = new FileInputStream("./save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameState loadedGameSave = (GameState) in.readObject();
            in.close();
            fileIn.close();
            return loadedGameSave;
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