import java.util.*;
/**
 * This class is in charge of handling all the game logic in the game.
 */
public class GameEngine {
    /**
     * This field represents the grid of the game. Instantiates a new object of type Grid.
     */
    public Grid board = new Grid();
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
    private boolean debug;
    /**
     * This is the main constructor of the GameEngine class which instantiates a new Player object, Spawns a player object
     * on the grid by using the {@link #setPlayer} method, spawns enemies on the map using the {@link #generateEnemies} method, and
     * spawns power-ups on the grid by using the {@link #generateItems} method.
     */
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
     * on the map is not empty the count is decreased and a random location is choosen again.
     */
    public void generateEnemies()
    {
        int num1, num2;

        for(int i = 0; i < enemies.length; i++)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol() == '/')
            {
                board.map[num1][num2] = new Enemy();
            }
            else
            {
                System.out.print("hello");
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
                    board.map[num1][num2] = new Ammo();
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
    public void printBoard(){
        this.board.printGrid(debug);
    }
}
