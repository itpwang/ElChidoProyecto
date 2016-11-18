import java.awt.*;
import java.util.*;
import java.awt.Point;
/**
 * This class is in charge of handling all the game logic in the game.
 */
public class GameEngine {

    private static Point pos = new Point(Math.toMapX(0), Math.toMapY(0));

    /**
     * This field represents the grid of the game. Instantiates a new object of type Grid.
     */
    private Grid board = new Grid();
    /**
     * This field represent a Player object that presents that player in the the game.
     */
    private Player player;
    /**
     * This field represents an array of Enemy objects
     */
    private Enemy[] enemies = new Enemy[6];
    /**
     * This field represents the Random object used to randomly generate numbers.
     */
    Random rand = new Random();
    /**
     * This field stores if debug mode is on or off. Modified by {@link #changeDebug(boolean)}
     */
    private boolean debug;
    /**
     * This is the main constructor of the GameEngine class which instantiates a new Player object, Spawns a player object
     * on the grid by using the {@link #setPlayer} method, spawns enemies on the map using the {@link #generateEnemies} method, and
     * spawns power-ups on the grid by using the {@link #generateItems} method.
     */
    private static boolean invincibiliy;
    private static int ammo;
    private static boolean radar;

    public GameEngine()
    {
        this.player = new Player();
        setPlayer();
        generateEnemies();
        generateItems();
        debug = false;
    }
    public void changeDebug(boolean state){
        debug = state;
    }
    /**
     * This method calls the grid class to print the maps of the game.
     */
    public void printMap(){

    }
    /**
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    int taketurn() {

        return 0;
    }

    /**
     * This method returns a boolean value of {@code false} representing the game is over.
     * @return false.
     */
    boolean gameOver() {

        return false;
    }

    /**
     * This method represents the turn of the main player of the game.
     */
    public void turn() {
    }

    /**
     * This method spawns the player object at the default starting point of the grid (bottom left corner).
     */
    public void setPlayer()
    {
        board.map[8][0] = this.player;
    }

    /**
     * This method is in charge of randomly generating enemies on an empty space of the map denoted by the "/" symbol. If the space
     */
    public void generateEnemies()
    {
        int num1, num2;
        Point enemyloc;
        for(int i = 0; i < enemies.length; i++)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol() == '/')
            {
                enemyloc = new Point(num1, num2);
//                board.map[num1][num2].Enemy(enemyloc);
            }
            else
            {
                i--;
            }

        }
    }

    /**
     * This method places {@link Ammo}, {@link Invincibility}, and {@link Radar} power ups on the map. Places a power up on
     * random locations that are empty on the map denoted by a "/" Symbol and if the space on the map are not empty it will
     * keep generating numbers until a space is empty. Once
     */
    public void generateItems()
    {
        int num1, num2;
        boolean ammoPlace = false, invPlace = false, radarPlace = false;
        while(true)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol() == '/')
            {
                if(ammoPlace == false)
                {
                    board.map[num1][num2]= new Ammo();
                    ammoPlace = true;
                }

                else if(invPlace == false)
                {
                    board.map[num1][num2] = new Invincibility();
                    invPlace = true;
                }

                else if(radarPlace == false)
                {
                    board.map[num1][num2] = new Radar();
                    radarPlace = true;
                }
            }
            if(ammoPlace && invPlace && radarPlace)
                break;
        }
    }

    public void printBoard()
    {
        this.board.printGrid(debug);
    }
    public static void invincibiliyOn(){

    }

    public static void addAmmo() {
        ammo = 1;
    }

    public static void radarOn() {
        radar = true;
    }

    public static Point getPos()
    {
        return pos;
    }

    public static void setPos(Point position)
    {
        pos = position;
    }
}
