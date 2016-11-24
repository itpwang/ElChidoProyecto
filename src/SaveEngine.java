import java.io.*;

/**
 * Created by Zach on 11/23/2016.
 */
public class SaveEngine {

    public static void writeSave(Player p){
        try{
            FileOutputStream fileOut = new FileOutputStream("/C:\\Files\\Programming\\Java\\Programs\\CS141\\Github\\ElChidoProyecto\\src\\save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.println("Game saved in /C:\\Files\\Programming\\Java\\Programs\\CS141\\Github\\ElChidoProyecto\\src\\save.ser");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readSave(Player p){
        try{
            FileInputStream fileIn = new FileInputStream("/C:\\Files\\Programming\\Java\\Programs\\CS141\\Github\\ElChidoProyecto\\src\\save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Player) in.readObject();
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