import java.util.*;
import java.awt.Point;
/**
 * This class is in charge of handling all the game logic in the game.
 */
public class GameEngine {

    private static Point position = new Point(Math.toMapX(0), Math.toMapY(0));

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
    private static boolean isInvincible = false;

    /**
     * This field is the counter that stores the
     * invincibility for the {@link Player}
     */
    private int invCounter = 0;

    /**
     * This field stores the mmo of the
     * {@link Player}
     */
    private static int playerAmmo;

    private static boolean radar;

    private static boolean gameWon =  false;

    public enum moveChoice {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * This is the constructor for the {@link GameEngine}
     * it instantiates the {@link GameEngine#player},
     * calls the {@link GameEngine#setPlayer()} method,
     * the {@link GameEngine#generateEnemies()} method,
     * and the {@link GameEngine#generateItems()} method.
     * Finally it sets the value of {@link GameEngine#debug}
     * to false;
     *
     */
    public GameEngine(){
        this.player = new Player();
        setPlayer();
        generateEnemies();
        generateItems();
        debug = false;
    }

    /**
     * This method toggles the value of the boolean
     * field {@link GameEngine#debug} to the value passed
     * as a parameter, (either True or False).
     *
     * @param state
     */
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
    int taketurn(){

        return 0;
    }

    /**
     * This method returns a boolean value of {@code false} representing the game is over.
     * @return false.
     */
    boolean gameOver(){
        if(gameWon()||gameLost())
            return true;
        else
            return false;
    }

    boolean gameWon(){
        return gameWon;
    }

    boolean gameLost(){
        if(!player.isAlive())
        return true;
        else return false;
    }

    /**
     * This method represents the turn of the main player of the game.
     */
    public void playerTurn() {
        moveChoice direction;
        direction = UI.lookPrompt();
        look(UI.lookPrompt());

    }

    public void look(moveChoice direction){
        Point A, B = player.getPos();
        A = B;
        switch(direction){
            case UP: A.translate(0,1);
                B.translate(0,2);
            case DOWN:  A.translate(0, -1);
                B.translate(0, -2);
            case LEFT:  A.translate(-1, 0);
                B.translate(-2, 0);
            case RIGHT:  A.translate(1,0);
                B.translate(2,0);
        }
        board.printlookGrid(A,B);
    }
    /**
     * This method spawns the player object at the default starting point of the grid (bottom left corner).
     */
    public void setPlayer()
    {
        board.getTile(8, 0).insertPlayer(this.player);
    }

    /**
     * This method is in charge of randomly generating enemies on an empty space of the map denoted by the "/" symbol. If the space
     */
    public void generateEnemies(){
        int num1, num2;
        Point enemyloc;
        Enemy enemyholder;
        for(int i = 0; i < enemies.length; i++)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol() == '/')
            {
                enemyloc = new Point(num1, num2);
                enemyholder = new Enemy(enemyloc);
                board.getTile(num1, num2).insertEnemy(enemyholder);
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
    public void generateItems(){
        int num1, num2;
        boolean playerAmmoPlace = false, invPlace = false, radarPlace = false;
        while(true)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol() == '/')
            {
                if(playerAmmoPlace == false)
                {
                    board.getTile(num1, num2).insertItem(new Ammo());
                    playerAmmoPlace = true;
                }

                else if(invPlace == false)
                {
                    board.getTile(num1, num2).insertItem(new Invincibility());
                    invPlace = true;
                }

                else if(radarPlace == false)
                {
                    board.getTile(num1, num2).insertItem(new Radar());
                    radarPlace = true;
                }
            }
            if(playerAmmoPlace && invPlace && radarPlace)
                break;
        }
    }

    /**
     * This method prints the {@link GameEngine#board}
     * to the screen (For Debug mode)
     */
    public void printBoard()
    {
        this.board.printGrid(debug);
    }

    /**
     * This method sets the {@link GameEngine#isInvincible}
     */
    public static boolean invincibilityOn()
    {
        isInvincible = true;
        return isInvincible;
    }

    /**
     * This method increments the {@link GameEngine#playerAmmo}
     * by 1
     */
    public static void addAmmo() {
        playerAmmo = 1;
    }

    /**
     * This function checks to see if the
     * {@link GameEngine#playerAmmo} is empty
     *
     * @return ans
     */
    public static boolean playerAmmoEmpty(){
        boolean ans;
        ans = (playerAmmo <= 0)? true : false;
        return ans;
    }

    /**
     * This method sets the value of
     * {@link GameEngine#radar} to true;
     */
    public static void radarOn() {
        radar = true;
    }

    /**
     * This method gets the {@link Player}'s {@link GameEngine#position}
     *
     * @return position
     */
    public static Point getPos()
    {
        return position;
    }

    /**
     * This method sets the {@link Player}'s {@link GameEngine#position}
     */
    public static void setPos(Point p)
    {
        position = p;
    }

    /**
     *
     */
    public static void checkPos(){
        
    }
    public void setGameWon(){
        gameWon=true;
    }
}
