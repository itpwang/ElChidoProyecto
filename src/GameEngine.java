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

    private Point[] listOfEnemyLoc = new Point[6];
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


    public enum Direction {
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
        this.player = new Player(new Point(8, 0));
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
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    public void taketurn(){
        playerTurn();
        allEnemiesTurn();
    }

    public void shoot(Direction dir) {
        Point p = player.getPos();
        for (int i = board.map.length; i < 0; i++) {
            if (dir == Direction.UP) {
                if (board.isOOB(p.x - i, p.y) && board.map[p.x + i][p.y].hasEnemy()) {
                    board.map[p.x - i][p.y].killEnemy();
                    break;
                }
            } else if (dir == Direction.DOWN) {
                if (board.isOOB(p.x + i, p.y) && board.map[p.x - i][p.y].hasEnemy()) {
                    board.map[p.x + i][p.y].killEnemy();
                    break;
                }
            } else if (dir == Direction.RIGHT) {
                if (board.isOOB(p.x, p.y + i) && board.map[p.x][p.y + i].hasEnemy()) {
                    board.map[p.x][p.y + i].killEnemy();
                    break;
                }
            } else if (dir == Direction.LEFT) {
                if (board.isOOB(p.x, p.y - i) && board.map[p.x][p.y - i].hasEnemy()) {
                    board.map[p.x][p.y - i].killEnemy();
                    break;
                }
            }
        }
    }

    /**
     * This method returns a boolean value of {@code false} representing the game is over.
     * @return false.
     */
    boolean gameOver(){
        if(gameWon()||!gameLost())
            return true;
        else
            return false;
    }

    boolean gameWon(){
        return gameWon;
    }

    boolean gameLost(){
        // TODO
        return false;
    }

    /**
     * This method represents the turn of the main player of the game.
     */
    public void playerTurn() {
        Direction direction;
        Point pPos = player.getPos();
        //direction = UI.lookPrompt();
        look(UI.lookPrompt());
        int entry = UI.moveOrShootPrompt();
        if(entry==1){
            direction=UI.movePrompt();
            switch(direction)
            {
                case UP:
//                    if(board.getTile(player.getPos()).isRoom())
                    player.moveUp();
                    moveUp(pPos);
                    break;
                case DOWN:
                    if(board.getTile(player.getPos()).isRoom()) gameWon=true;
                    else {
                        player.moveDown();
                        moveDown(pPos);
                    }
                    break;
                case LEFT:
                    player.moveLeft();
                    moveLeft(pPos);
                    break;
                case RIGHT:
                    player.moveRight();
                    moveRight(pPos);
                    break;
            }
            }
        else if(entry == 2){
            shoot(Direction.UP);
        }
            //temp
        board.printGrid(false);
    }
    public void allEnemiesTurn(){
        for(Point i: listOfEnemyLoc){
            enemyTurn(i);
        }
    }
    public void enemyTurn(Point ePos){
        Direction m;
        //check player
        m = rollMove();
        switch(m)
        {
            case UP:
                board.getTile(ePos.x, ePos.y).getEnemy().moveUp();
                moveUp(ePos);
                break;
            case DOWN:
                board.getTile(ePos.x, ePos.y).getEnemy().moveDown();
                moveDown(ePos);
                break;
            case LEFT:
                board.getTile(ePos.x, ePos.y).getEnemy().moveLeft();
                moveLeft(ePos);
                break;
            case RIGHT:
                board.getTile(ePos.x, ePos.y).getEnemy().moveRight();
                moveRight(ePos);
                break;
        }
    }

    public void moveUp(Point pt){
        if(!board.isOOB(pt.x-1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x - 1, pt.y));
            pt.translate(-1,0);
        }
    }

    public void moveDown(Point pt){
        if(!board.isOOB(pt.x+1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x + 1, pt.y));
            pt.translate(1,0);
        }
    }

    public void moveLeft(Point pt){
        if(!board.isOOB(pt.x,pt.y-1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y - 1));
            pt.translate(0,-1);
        }
    }

    public void moveRight(Point pt){
        if(!board.isOOB(pt.x,pt.y+1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y + 1));
            pt.translate(0,1);
        }
    }

    public Direction rollMove() {
        int enemyMove;
        Random rand = new Random();
        enemyMove = rand.nextInt(3);

        switch (enemyMove) {
            case 0:
                return Direction.UP;
            case 1:
                return Direction.DOWN;
            case 2:
                return Direction.LEFT;
            case 3:
                return Direction.RIGHT;
        }
        return Direction.UP;
    }

    public void look(Direction direction){
        Point A  = player.getPos();
        Point B = player.getPos();
        switch(direction){
            case UP: A.translate(-1,0);
                B.translate(-2,0);
                break;
            case DOWN:  A.translate(1, 0);
                B.translate(2, 0);
                break;
            case LEFT:  A.translate(0, -1);
                B.translate(0, -2);
                break;
            case RIGHT:  A.translate(0,1);
                B.translate(0,2);
                break;
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
                listOfEnemyLoc[i]=enemyloc;
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
    public void setPos(Point p)
    {
        if(!board.isOOB(p.x, p.y)) {
            position = p;
        }

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
