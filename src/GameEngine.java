/**
 * Created by Ivan on 11/10/2016.
 */
public class GameEngine {
//    private Grid map;
    private Player player;
    public GameEngine(){
        this.player = new Player();
    }
    public void printMap(){

    }

    /**
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    int taketurn()
    {

        return 0;
    }

//    public boolean gameOver(){
//
//    }
    public void turn(){

    }
}
