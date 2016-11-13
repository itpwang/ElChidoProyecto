/**
 * Created by Ivan on 11/10/2016.
 */
import java.util.Scanner;

public class UI {
    private GameEngine G;
    private int userinput;
    private Scanner scan;
    public UI(GameEngine game){
        this.G = game;
        scan = new Scanner(System.in);
        startMenu();
    }
    public void menuSelect(){
        System.out.println("");
        scan.nextInt();

    }
    public void gameMove(){
        G.printMap();
    }

    public void startMenu(){
        System.out.println("*_________________________________*");
        System.out.println("* This is a dungeon crawlser game *");
        System.out.println("*_________________________________*");

        menuSelect();
    }

    public static void displayChoice()
    {
        System.out.println("0. Look");
        System.out.println("1. Move");
        System.out.println("2. Shoot");
        System.out.println("3. quit");
    }

    public static void displayKeypad()
    {
        System.out.println("Press the following Keys to choose a direction:");
        System.out.println("  Up  : W ");
        System.out.println(" Left : A ");
        System.out.println("Right : D ");
        System.out.println(" Down : S ");
    }

}