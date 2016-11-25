package mainMod;
import java.util.*;
import java.awt.Point;

/**
 * This class is in charge of handling all the game logic in the game.
 */
public class GameEngine {

    /**
     * This is an array of {@link Point}s that stores the
     * locations of each of the north facing {@link Tile}s
     * of the {@link Room}s
     */
    private static Point [] enterRoom = {
            new Point(0,1), new Point(0,3), new Point(0,5),
            new Point(3,1), new Point(3,3), new Point(3,5),
            new Point(6,1), new Point(6,3), new Point(6,5)}; // make private and make getter

    /**
     * this field represents the location of the {@link Player}
     */
    private static Point position = new Point(mainMod.Math.toMapX(0), mainMod.Math.toMapY(0));

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
     * This field holds the position of the {@link Enemy}s
     * as an array of {@link Point}s
     */
    private Point[] listOfEnemyLoc = new Point[6];

    private Item[] items = new Item[3];

    private Point[] listOfItemLoc = new Point[3];

    /**
     * This field holds the position of the {@link Room}s
     * as an array of {@link Point}s
     */
    private Point[] rooms = {new Point(1, 1), new Point(1, 4), new Point(1, 7), new Point(4, 1), new Point(4, 4), new Point(4, 7), new Point(7, 1), new Point(7, 4), new Point(7, 7)};

    /**
     * This field represents the Random object used to randomly generate numbers.
     */
    Random rand = new Random();

    /**
     * This field stores if debug mode is on or off. Modified by {@link #changeDebug(boolean)}
     */
    public static boolean debug;

    /**
     * This boolean field tells us whether
     * the {@link Player} is invinsible
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

    /**
     * This field
     */
    private static boolean gameWon =  false;

    private Point roomplace = new Point();

    /**
     * This enumerated field creates the values
     * UP,DOWN,LEFT,RIGHT.
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT, SAVE
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
        generateBriefcase();
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
        timeDelay(1000);
        allEnemiesTurn();
        board.printGrid(debug);
    }

    /**
     * This method shoots the {@link Enemy}
     * in the {@link GameEngine.Direction}
     * that the {@link Player} chooses
     *
     * @param dir
     */
    public void shoot(Direction dir) {

        Point p = player.getPos();

        for (int i = 0; i < board.map.length; i++) {

            if (dir == Direction.UP) {
                if (!board.isOOB(p.x - i, p.y) && board.map[p.x - i][p.y].hasEnemy()) {
                    board.map[p.x - i][p.y].killEnemy();
                    break;
                }
            } else if (dir == Direction.DOWN) {
                if (!board.isOOB(p.x + i, p.y) && board.map[p.x + i][p.y].hasEnemy()) {
                    board.map[p.x + i][p.y].killEnemy();
                    break;
                }
            } else if (dir == Direction.RIGHT) {
                if (!board.isOOB(p.x, p.y + i) && board.map[p.x][p.y + i].hasEnemy()) {
                    board.map[p.x][p.y + i].killEnemy();
                    break;
                }
            } else if (dir == Direction.LEFT) {
                if (!board.isOOB(p.x, p.y - i) && board.map[p.x][p.y - i].hasEnemy()) {
                    board.map[p.x][p.y - i].killEnemy();
                    break;
                }
            }
        }
    }

    /**
     *
     * @return
     */
    boolean gameWon(){
        return gameWon;
    }

    boolean gameLost(){
        // TODO
        return false;
    }

    /**
     * This method represents the turn of the main {@link Player} of the game.
     */
    public void playerTurn() {
        Direction direction;
        Point pPos = player.getPos();

        look(UI.lookPrompt());
        int entry = UI.moveOrShootPrompt();

        if(entry == 1)
        {
            while(board.validMove(pPos, direction=UI.movePrompt())){
                timeDelay(1000);
                switch (direction) {
                    case UP:
                        player.moveUp();
                        moveUp(pPos);
                        checkPos(pPos);
                        break;
                    case DOWN:
                        if (board.getTile(player.getPos()).isRoom()) gameWon = true;
                        else {
                            player.moveDown();
                            moveDown(pPos);
                            checkPos(pPos);
                        }
                        break;
                    case LEFT:
                        player.moveLeft();
                        moveLeft(pPos);
                        checkPos(pPos);
                        break;
                    case RIGHT:
                        player.moveRight();
                        moveRight(pPos);
                        checkPos(pPos);
                        break;
                }
                break;
            }
        }
        else if(entry == 2){
            direction=UI.shootPrompt();
            shoot(direction);
        }
    }

    public void enemyTurn(Point ePos){
        Direction movement;
        while(board.validMove(ePos,movement = rollMove())) {
            switch (movement) {
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
            break;
        }
    }

    /**
     * This method causes the enemies at each {@link Point} in the array {@link #listOfEnemyLoc}
     * to take an {@link #enemyTurn(Point)}
     */
    public void allEnemiesTurn(){
//        for(int i = 0; i>listOfEnemyLoc.length;i++){
//            enemyTurn(listOfEnemyLoc[i]);
//        }
        for(int i= 0; i<board.getRowLen();i++){
            for(int j=0;i<board.getColLen();j++){
                if(board.getTile(i,j).hasEnemy()){
                    enemyTurn(new Point(i,j));
                }
            }
        }

    }

    /**
     * This method swaps the tile at {@link Point} pt with the tile going up
     * provided it is valid.
     * @param pt
     */
    public void moveUp(Point pt){
        if(!board.isOOB(pt.x-1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x - 1, pt.y));
            pt.translate(-1,0);
            System.out.println("You move UP one space. .");
        }
    }

    public void moveDown(Point pt){
        if(!board.isOOB(pt.x+1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x + 1, pt.y));
            pt.translate(1,0);
            System.out.println("You move DOWN one space. .");
        }
    }

    public void moveLeft(Point pt){
        if(!board.isOOB(pt.x,pt.y-1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y - 1));
            pt.translate(0,-1);
            System.out.println("You move LEFT one space. .");
        }
    }

    public void moveRight(Point pt){
        if(!board.isOOB(pt.x,pt.y+1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y + 1));
            pt.translate(0,1);
            System.out.println("You move RIGHT one space. .");
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
            case SAVE: //SaveEngine.writeSave(player); uncomment to save
                break;
        }
        board.printlookGrid(A,B, debug);
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
        int i = 0;
        
        board.map[1][1].returnSymbol(debug);

        while(i < 6)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol(debug) == '/')
            {
                enemyloc = new Point(num1, num2);
                enemyholder = new Enemy(enemyloc);
                enemies[i] = new Enemy(enemyloc);
                board.getTile(num1, num2).insertEnemy(enemies[i]);
                listOfEnemyLoc[i]=enemyloc;
                i++;
                System.out.println("DUMBSHIT AT" + enemyloc);
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
        Point itemloc;
        Item itemholder;

        for(int i = 0; i < items.length; i++)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].returnSymbol(debug) == '/')
            {
                if(playerAmmoPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Ammo(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    listOfItemLoc[i] = itemloc;
                    playerAmmoPlace = true;
                }
                else if(invPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Invincibility(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    listOfItemLoc[i] = itemloc;
                    invPlace = true;
                }
                else if(radarPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Radar(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    listOfItemLoc[i] = itemloc;
                    radarPlace = true;
                }
                else
                {
                    i--;
                }
            }
            if(playerAmmoPlace && invPlace && radarPlace)
                break;
        }
    }

    private void generateBriefcase() {
        int r = rand.nextInt(9);
        board.getRoom(rooms[r]).setBriefcase(true);
        System.out.print("Placed at " + rooms[r]);

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
    public static boolean invincibilityOn() {
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
    public void setPos(Point p) {
        if(!board.isOOB(p.x, p.y)) {
            position = p;
        }

    }

    public Player getPlayer(){
        return player;
    }

    /**
     * This method goes through the list of items
     * checking if the item still exists.
     * If so, checks if the position is the same as
     * the {@link Player}s
     * If the position is the same, it uses the {@link Item}
     */
    public void checkPos(Point playerposition)
    {
        for(int i = 0; i < listOfItemLoc.length; i++)
        {
            if(player.getPos() == listOfItemLoc[i])
                if(items[i].exists)
                {
                    useItem(items[i]);
                }
        }
    }

    public void useItem(Item i)
    {
        i.use();
    }

    public void setGameWon(){
        gameWon=true;
    }

    /**
     * This method returns a boolean value of {@code false} representing the game is over.
     * @return false.
     */
    public boolean gameOver(){
       if(player.getNumOfLives() == 0) {
           return true;
       }
       else if(player.getNumOfLives() != 0){
           return false;
       }
       else if (gameWon()) {
           return true;
       }
       else return false;
    }

    public void timeDelay(int a)
    {
        try {
            System.out.println(". . .");
            Thread.sleep(a);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}