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
            readSave(gameState); //test
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readSave(GameState p){
        try{
            FileInputStream fileIn = new FileInputStream("./save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (GameState) in.readObject(); //test
            p.getSavedPlayer(); //test
            in.close();
            fileIn.close();
        }catch(IOException e){
            e.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Save not found");
            c.printStackTrace();
            return;
        }
    }
}