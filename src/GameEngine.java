import java.util.*;

/**
 * Created by Ivan on 11/10/2016.
 */
public class GameEngine {
    public Grid board = new Grid();
    private Player player;
    private Enemy[] enemies = new Enemy[6];
    Random rand = new Random();

    public GameEngine()
    {
        this.player = new Player();
        setPlayer();
        generateEnemies();
        generateItems();
    }

    public void printMap(){

    }

    /**
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    int taketurn() {

        return 0;
    }

    boolean gameOver() {

        return false;
    }

    public void turn() {
    }

    public void setPlayer()
    {
        board.map[8][0] = this.player;
    }

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
}
