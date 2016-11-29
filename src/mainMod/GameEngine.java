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
    private Grid board ;

    /**
     * This field represent a Player object that presents that player in the the game.
     */
    private Player player;

    /**
     * This field represents an array of Enemy objects
     */
    private Enemy[] enemies = new Enemy[6];


    /**
     * This field stores {@link Item}s in
     * {@link ArrayList} of {@link Item}
     */
    private ArrayList<Item> items = new ArrayList<Item>();


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
    private static int invCounter = 5;

    /**
     * This field stores the mmo of the
     * {@link Player}
     */
    private static int playerAmmo = 1;

    private static boolean radar;

    /**
     * This field
     */
    private static boolean gameWon =  false;

    private Point roomplace = new Point();
    /**
     * This boolean field represents whether or not the user is trying to save the game or not.
     */
    private boolean savingGame;

    /**
     * This method returns a boolean value representing if a user is saving the game
     * @return savingGame
     */
    public boolean isSavingGame() {
        return savingGame;
    }

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
     * calls the {@link GameEngine#generatePlayer()} method,
     * the {@link GameEngine#generateEnemies()} method,
     * and the {@link GameEngine#generateItems()} method.
     * Finally it sets the value of {@link GameEngine#debug}
     * to false;
     *
     */
    public GameEngine(){

        this.player = new Player(new Point(8, 0));
        board = new Grid();
        generateBriefcase();
        generatePlayer();
        generateEnemies();
        generateItems();
        debug = false;
    }


    public GameEngine(GameState loadedGameState){
        player = loadedGameState.getSavedPlayer();
        board = loadedGameState.getSavedBoard();
        enemies = loadedGameState.getSavedEnemies();
        isInvincible = loadedGameState.getSavedIsInvincible();
        invCounter = loadedGameState.getSavedInvCounter();
        playerAmmo = loadedGameState.getSavedPlayerAmmo();
        radar = loadedGameState.getSavedRadar();
        debug = loadedGameState.getSavedDebug();


    }

    /**
     * This method toggles the value of the boolean
     * field {@link GameEngine#debug} to the value passed
     * as a parameter, (either True or False).
     *
     * @param state
     */
    public static void changeDebug(boolean state){
        debug = state;
    }

    /**
     * This abstract method will allow the
     * {@link Entity} to take a turn
     */
    public void taketurn(){

        if(gameOver()) return;

        if(isInvincible)
        {
            System.out.println("Your still invincible!");
            System.out.println("InvCounter: " + invCounter);
            timeDelay(1);
            invCounter--;
        }

        playerTurn();

        if(gameOver()) return;

        if(isSavingGame())
            return;

        board.printGrid(debug);
        allEnemiesTurn();
        timeDelay(2);
        board.printGrid(debug);
        System.out.println("LIVES: " + player.getNumOfLives() + " AMMO: " + playerAmmo);
        timeDelay(2);

        if(invCounter <= 0)
        {
            System.out.println("Invincibility wore off!");
            timeDelay(1);
            isInvincible = false;
            invCounter = 5;
        }

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
                if (!board.isOOB(p.x - i, p.y)) {
                	if(board.map[p.x - i][p.y].isRoom()) {
                		System.out.println("you hit the room");
                        timeDelay(1);
                		break;
                	}
                	else if(board.map[p.x - i][p.y].hasEnemy()) {
                        board.map[p.x - i][p.y].killEnemy();
                        break;
                	}
                }
            }
            else if (dir == Direction.DOWN) {
                if (!board.isOOB(p.x + i, p.y)) {
                	if(board.map[p.x + i][p.y].isRoom()) {
                		System.out.println("you hit the room");
                        timeDelay(1);
                		break;
                	}
                	else if(board.map[p.x + i][p.y].hasEnemy()) {
                        board.map[p.x + i][p.y].killEnemy();
                        break;
                	}
                }
            }
            else if (dir == Direction.RIGHT) {
                if (!board.isOOB(p.x, p.y + i)) {
                	if(board.map[p.x][p.y + i].isRoom()) {
                		System.out.println("you hit the room");
                        timeDelay(1);
                		break;
                	}
                	else if(board.map[p.x][p.y + i].hasEnemy()) {
                        board.map[p.x][p.y + i].killEnemy();
                        break;
                	}
                }
            }
            else if (dir == Direction.LEFT) {
                if (!board.isOOB(p.x, p.y - i)) {
                	if(board.map[p.x][p.y - i].isRoom()) {
                		System.out.println("you hit the room");
                        timeDelay(1);
                		break;
                	}
                	else if(board.map[p.x][p.y - i].hasEnemy()) {
                        board.map[p.x][p.y - i].killEnemy();
                        break;
                	}
                }
            }
        }
        playerAmmo--;
    }

    /**
     *
     * @return
     */
    boolean gameWon(){
        return gameWon;
    }

    /**
     * This method represents the turn of the main {@link Player} of the game.
     */
    public void playerTurn() {
        Direction direction;
        Point pPos = player.getPos();
        char itemtype;

        int lives = player.getNumOfLives();

        look(UI.lookPrompt());
        if (savingGame)
            return;

        int entry = UI.moveOrShootPrompt();

        if(entry == 1)
        {
            while(board.validMove(pPos, direction=UI.movePrompt())&&board.canMove(pPos)){
                timeDelay(1);
                switch (direction) {
                    case UP:
                        player.moveUp();
                        moveUp(pPos);
                        if(board.getTile(player.getPos()).hasItem()) {
                            pPos=player.getPos();
                            checkPos(pPos);
                            board.getTile(pPos).setItemNull();
                        }
                        break;
                    case DOWN:

                        Point p = new Point((int) player.getPos().getX()+1,
                                (int) player.getPos().getY());

                        if (board.getTile(p).isRoom())
                            {
                                Room r = (Room) board.getTile(p);
                                if(r.hasBriefcase())
                                {
                                    System.out.println("This room has the briefcase, You Win!!");
                                    gameWon = true;
                                    return;
                                }
                                else {
                                    System.out.println("This room does not have the briefcase! Try again. . .");
                                    return;
                                }

                            }

                        player.moveDown();
                        moveDown(pPos);

                        if(board.getTile(player.getPos()).hasItem()) {
                            pPos=player.getPos();
                            checkPos(pPos);
                            board.getTile(pPos).setItemNull();
                        }
                        break;
                    case LEFT:
                        player.moveLeft();
                        moveLeft(pPos);
                        if(board.getTile(player.getPos()).hasItem()) {
                            pPos=player.getPos();
                            checkPos(pPos);
                            board.getTile(pPos).setItemNull();
                        }
                        break;
                    case RIGHT:
                        player.moveRight();
                        moveRight(pPos);
                        if(board.getTile(player.getPos()).hasItem()) {
                            pPos=player.getPos();
                            checkPos(pPos);
                            board.getTile(pPos).setItemNull();
                        }
                        break;
                }

                itemtype = typeOfItem(board.getTile(pPos).getItem());

                switch(itemtype){
                    case 'a':
                        items.remove(0);
                        break;
                    case 'i':
                        items.remove(1);
                        break;
                    case 'r':
                        items.remove(2);
                        break;
                }
                break;
            }
        }
        else if(entry == 2){
            direction=UI.shootPrompt();
            if(!playerAmmoEmpty())
            {
                shoot(direction);
            }
            else
                System.out.println("You have no ammo!");
            timeDelay(1);

        }
    }

    /**
     * This method takes the {@link Enemy}'s
     * turn.
     *
     * @param ePos
     */
    public void enemyTurn(Point ePos){
        enemyAttack(ePos);
        enemyMove(ePos);
    }

    /**
     * This method takes an {@link Point}
     * for the {@link Enemy} position and
     * checks to see if there is a {@link Player}
     * adjacent to attack. If so,
     * it kills the {@link Player}
     *
     * @param ePos
     */
    public void enemyAttack(Point ePos) {
        //Attack
        if(!board.isOOB(ePos.x - 1, ePos.y)) {
            if(board.getTile(ePos.x - 1, ePos.y).hasPlayer()) {

                System.out.println("The Enemy attacks! ");
                timeDelay(1);

                if(!isInvincible)
                {
                    player.decLives();
                    System.out.println("You ded");
                    timeDelay(1);
                    respawnPlayer();
                }
                else
                    System.out.println("Your invincible!");
                timeDelay(1);

                return;
            }
        }
        if(!board.isOOB(ePos.x + 1, ePos.y)) {
            if (board.getTile(ePos.x + 1, ePos.y).hasPlayer()) {

                System.out.println("The Enemy attacks! ");
                timeDelay(1);

                if(!isInvincible)
                {
                    player.decLives();
                    timeDelay(1);
                    System.out.println("You ded");
                    respawnPlayer();
                }
                else
                    System.out.println("Your invincible!");
                timeDelay(1);

               return;
            }
        }
        if(!board.isOOB(ePos.x, ePos.y + 1)) {
            if(board.getTile(ePos.x, ePos.y + 1).hasPlayer()) {

                System.out.println("The Enemy attacks! ");
                timeDelay(1);

                if(!isInvincible)
                {
                    player.decLives();
                    System.out.println("You ded");
                    timeDelay(1);
                    respawnPlayer();
                }
                else
                    System.out.println("Your invincible!");
                timeDelay(1);

                return;
            }
        }
        if(!board.isOOB(ePos.x, ePos.y - 1)) {
            if(board.getTile(ePos.x, ePos.y - 1).hasPlayer()) {

                System.out.println("The Enemy attacks! ");
                timeDelay(1);

                if(!isInvincible)
                {
                    player.decLives();
                    System.out.println("You ded");
                    timeDelay(1);
                    respawnPlayer();
                }
                else
                    System.out.println("Your invincible!");
                timeDelay(1);

                return;
            }
        }

    }

    /**
     * This method makes the {@link Enemy}
     * move in a random {@link Direction}
     *
     * @param ePos
     */
    public void enemyMove(Point ePos) {
        Direction movement;

        //Move
        while(board.validMove(ePos,movement = rollMove())&&board.canMove(ePos)) {
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
     * Respawns player back to starting location. [8, 0]
     * Resets ammo.
     */
    public void respawnPlayer() {
    	board.swapTile(board.getTile(player.getPos()), board.getTile(new Point(8,0)));
        player.setPlayerPos(new Point(8,0));
        resetAmmo();
    }

    /**
     * This method lookw through {@link #board} for {@link Enemy}
     * and calls{@link #enemyTurn(Point)}
     */
    public void allEnemiesTurn(){
//        for(int i = 0; i>listOfEnemyLoc.length;i++){
//            enemyTurn(listOfEnemyLoc[i]);
//        }
        System.out.println("All the enemies take their turn!");

        for(int i= 0; i<board.getRowLen();i++){
            for(int j=0;j<board.getColLen();j++){
                if(board.getTile(i,j).hasEnemy()){
                    enemyTurn(new Point(i,j));
                }
            }
        }

    }

    /**
     * This method swaps the tile at {@link Entity}'s pt with the tile going up
     * provided it is valid.
     * @param pt
     */
    public void moveUp(Point pt){
        if(!board.isOOB(pt.x-1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x - 1, pt.y));
            pt.translate(-1,0);
        }
    }

    /**
     * This method swaps the tile at {@link Entity}'s pt with the tile going down
     * provided it is valid.
     * @param pt
     */
    public void moveDown(Point pt){
        if(!board.isOOB(pt.x+1,pt.y)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x + 1, pt.y));
            pt.translate(1,0);
        }
    }

    /**
     * This method swaps the tile at {@link Entity}'s pt with the tile going left
     * provided it is valid.
     * @param pt
     */
    public void moveLeft(Point pt){
        if(!board.isOOB(pt.x,pt.y-1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y - 1));
            pt.translate(0,-1);
        }
    }

    /**
     * This method swaps the tile at {@link Entity}'s pt with the tile going right
     * provided it is valid.
     * @param pt
     */
    public void moveRight(Point pt){
        if(!board.isOOB(pt.x,pt.y+1)) {
            board.swapTile(board.getTile(pt.x, pt.y), board.getTile(pt.x, pt.y + 1));
            pt.translate(0,1);
        }
    }

    /**
     * This method rolls a random number from 0 - 3
     * and returns an enum {@link Direction}
     *
     * @return
     */
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

    /**
     * This method takes a {@link Direction}
     * and translates two points in that
     * {@link Direction}
     * @param direction
     */
    public void look(Direction direction){
        boolean check1 = false;
        boolean check2 = false;

        Point A  = player.getPos();
        Point B = player.getPos();

        switch(direction){
            case UP:
                A.translate(-1,0);
                B.translate(-2,0);
                break;
            case DOWN:
                A.translate(1, 0);
                B.translate(2, 0);
                break;
            case LEFT:
                A.translate(0, -1);
                B.translate(0, -2);
                break;
            case RIGHT:
                A.translate(0,1);
                B.translate(0,2);
                break;
            case SAVE:
                saveGame();
                return;
        }

        if(!board.isOOB((int)A.getX(),(int)A.getY()))
        {
            check1 = checkLook(A);

            if(!board.isOOB((int)B.getX(),(int)B.getY()))
            {
                check2 = checkLook(B);
            }
            else
            {
                System.out.println("That's a wall. . ");
                timeDelay(1);
            }
        }
        else
        {
            System.out.println("That's a wall. . ");
            timeDelay(1);
        }

        if(check1 == true || check2 == true)
        {
            System.out.println("There is a Ninja ahead!. .");
            timeDelay(1);
        }
        else
            System.out.println("There is nothing ahead");

        timeDelay(1);
        board.printlookGrid(A,B, debug);
    }

    private void saveGame(Objects ...o) {
        ArrayList<Object> gameObjects = new ArrayList<Object>();

        gameObjects.add(player);
        gameObjects.add(board);
        gameObjects.add(enemies);
        gameObjects.add(isInvincible);
        gameObjects.add(invCounter);
        gameObjects.add(playerAmmo);
        gameObjects.add(radar);
        gameObjects.add(debug);
        //gameObjects.add(radarCounter);
        //gameObjects.add(debug);
        System.out.print("Saving game");
        timeDelay(1);
        timeDelay(1);
        timeDelay(1);
        GameState gameState = new GameState(gameObjects);
        SaveEngine.writeSave(gameState);
        savingGame = true;
    }

    private boolean checkLook(Point a)
    {
            if(board.getTile(a).hasEnemy())
                return true;
            else
                return false;
    }

    /**
     * This method spawns the player object at the default starting point of the grid (bottom left corner).
     */
    public void generatePlayer()
    {
        //board.getTile(8,0).insertPlayer(this.player);
        //DEBUG BELOW
        board.getTile(position).insertPlayer(this.player);
        this.player.setPlayerPos(position);
    }

    /**
     * This method is in charge of randomly generating enemies on an empty space of the map denoted by the "/" symbol. If the space
     */

    private boolean checkSpawn(int n, int m) {
       if(n==6 && (m==0 || m ==1 ))
           return false;
       else if(n==7 && (m==0 || m==1 || m==2))
            return false;
       else if(n==8 && (m==1 || m ==2 || m==3))
           return false;
        else if(n==5 && n==0)
            return false;

        return true;

    }

    /**
     * This method is in charge of randomly generating enemies on an empty space of the map denoted by the "/" symbol. If the space
     */
    public void generateEnemies(){
        int num1, num2;
        Point enemyloc;
        int i = 0;


        board.map[1][1].returnSymbol(debug);

        while(i < 6)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);


            if(board.map[num1][num2].isEmpty() && checkSpawn(num1, num2))
            {
                enemyloc = new Point(num1, num2);
                enemies[i] = new Enemy(enemyloc);
                board.getTile(num1, num2).insertEnemy(enemies[i]);
                i++;
            }

            else if(!checkSpawn(num1,num2)){
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
        int i = 0;
        while(i != 3)
        {
            num1 = rand.nextInt(8);
            num2 = rand.nextInt(8);

            if(board.map[num1][num2].isEmpty())
            {
                if(playerAmmoPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Ammo(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    items.add(itemholder);
                    playerAmmoPlace = true;
                    i++;
                }
                else if(invPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Invincibility(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    items.add(itemholder);
                    invPlace = true;
                    i++;
                }
                else if(radarPlace == false)
                {
                    itemloc = new Point(num1,num2);
                    itemholder = new Radar(itemloc);
                    board.getTile(num1,num2).insertItem(itemholder);
                    items.add(itemholder);
                    radarPlace = true;
                    i++;
                }
            }
        }
    }

    //DEBUG
    //Point asdf;
    private void generateBriefcase() {
        boolean briefcaseset = false;

        while(!briefcaseset)
        {
            int r = rand.nextInt(9);
            int s = rand.nextInt(9);

            //asdf = new Point(r - 1, s);

            if(board.getTile(r,s).isRoom())
            {
                board.getTile(r,s).setBriefcase();
                System.out.println("\nBriefcase placed at \n" + r + " " + s);
                briefcaseset = true;
            }
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
    public static void invincibilityOn() {
        isInvincible = true;
    }

    /**
     * This method increments the {@link GameEngine#playerAmmo}
     * by 1
     */
    public static void resetAmmo() {
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
        changeDebug(true);
        radar = true;
    }

    /**
     * This method returns the {@link Player}
     * @return
     */
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
    public void checkPos(Point playerposition) {
        if(board.getTile(playerposition).hasItem()) {
            useItem(board.getTile(playerposition).getItem());
        }
    }

    /**
     * This method uses the {@link Item}
     *
     * @param i
     */
    public void useItem(Item i)
    {
        i.use();
    }

    /**
     * This method sets the {@link GameEngine#gameWon}
     * equal to True;
     */
    public void setGameWon(){
        gameWon=true;
    }

    /**
     * This method returns a boolean value of {@code false}
     * representing the game is over.
     * @return false.
     */
    public boolean gameOver(){
       if(player.getNumOfLives() == 0) {
           return true;
       }
       else if (gameWon()) {
           return true;
       }
       else return false;
    }

    /**
     * This method pauses the program for the amount
     * of milliseconds passed into the function.
     * @param a
     */
    public void timeDelay(int a) {
        try {
            Thread.sleep(a*1000);
            System.out.println(". . .");
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This method returns a char identifying what type of {@link Item} item is.
     * Returns {@code a} for {@link Ammo}, {@code i} for {@link Invincibility},
     * {@code r} for {@link Radar}
     * @param item
     * @return char
     */
    public char typeOfItem(Item item){
        if(item instanceof Ammo){
            return 'a';
        }
        else if(item instanceof Invincibility){
            return 'i';
        }
        else if(item instanceof Radar){
            return 'r';
        }
        else return 'x';
    }
}
