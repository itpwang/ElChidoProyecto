package mainMod;
import java.io.*;

public class SaveEngine {

    public static void writeSave(GameState current){
        try{
            FileOutputStream fileOut = new FileOutputStream("/C:\\Files\\Programming\\Java\\Programs\\CS141\\Github\\ElChidoProyecto\\src\\save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(current);
            out.close();
            fileOut.close();
            System.out.println("Game saved in /C:\\Files\\Programming\\Java\\Programs\\CS141\\Github\\ElChidoProyecto\\src\\save.ser");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

  //  s.writeSave(Point pl, Point en, Point am, Point inv, Point rad)

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