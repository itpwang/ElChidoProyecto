/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment Final
 *
 * This is a text-based game where the player has to find a briefcase
 * located in 1 of 9 rooms. Complications include enemies that could kill you.
 * Powerups can also be obtained.
 *
 * Team Destructors
 *   Ivan Wang
 *   Travis Linkey
 *   Sean McCullough
 *   Zach Oeh
 *   Michael Ortega
 *   Andy Rosas
 */
package mainMod;
import java.awt.Point;
import java.io.Serializable;

/**
 * This class represents the Grid object, utilized by the GameEngine
 * to create and print the map the game will be played on.
 */
public class Grid implements Serializable {
    /**
	 * An object array of type {@link Tile} is created. The multidimensional
	 * array allows for a 9 by 9 grid to be created.
	 */
    public Tile[][] map = new Tile[9][9];

    /**
     * Constructor which is called to instantiate the map.
     */
    public Grid() {
        /**
        * This for loop allows each place in the multidimensional array to be instantiated as a Tile object.
        */
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                map[i][j] = new Tile();
    	/**
    	 * Certain pre-disclosed tiles are set up as the Rooms in which the briefcase could potentially be
    	 * located in.
    	 */
    	for(int i = 1; i <= 7; i += 3)
        {
            map[1][i] = new Room(new Point(1,i));
            map[1][i].setIsRoom(true);
            map[4][i] = new Room(new Point(4,i));
            map[4][i].setIsRoom(true);
            map[7][i] = new Room(new Point(7, i));
            map[7][i].setIsRoom(true);
        }

    }


    /**
     * This method is a void method which prints the map. Uses a for loop to run through the multi-dimensional
     * array and prints out the subsequent tiles.
     *
     * @param debug {@link GameEngine#debug}
     */
    public void printGrid(boolean debug) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j].returnSymbol(debug));
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    /**
     * This method takes in two {@link Point}s and prints them in debug mode(visible {@link Tile}
     * Functions as 2 tiles ahead of player in direction looked.
     *
     * @param a {@link Point}
     * @param b {@link Point}
     * @param debug {@link GameEngine#debug}
     */
    public void printlookGrid(Point a, Point b, boolean debug){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                if((i==a.getX()&&j==a.getY())||(i==b.getX()&&j==b.getY())) {
                    System.out.print(map[i][j].returnSymbol(true));
                    System.out.print(' ');
                }
                else {
                    System.out.print(map[i][j].returnSymbol(debug));
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    /**
     * This method returns the cell at the position row,column on the map
     *
     * @param row x-coord
     * @param col y-coord
     * @return Tile {@link Tile}
     */
    public Tile getTile(int row, int col) {
        return map[row][col];
    }

    /**
     * This method returns the {@link Tile} at the {@link Point} on the map
     *
     * @param pt Point on grid
     * @return Tile {@link Tile}
     */
    public Tile getTile(Point pt){
        return map[pt.x][pt.y];
    }

    /**
     * This function returns true if the coordinates entered are out of bounds,
     * false if not
     *
     * @param x x-coord
     * @param y y-coord
     * @return boolean {@code true, false}
     */
    public boolean isOOB(int x, int y) {
        return (x < 0 || x >= map.length || y < 0 || y >= map.length);
    }

    /**
     * This method checks if the {@link Player}/{@link Enemy} at position
     * can move by checking all directions of movement. Returns {@code true}
     * if can move, {@code false} if can NOT move.
     *
     * @param position Point position
     * @return boolean {@code true/false}
     */
    public boolean canMove(Point position){
        if(validMove(position, GameEngine.Direction.UP)||validMove(position, GameEngine.Direction.DOWN)||
                validMove(position,GameEngine.Direction.LEFT)||validMove(position, GameEngine.Direction.RIGHT)){
            return true;
        }
        else return false;
    }

    /**
     * This method returns length of row in map
     *
     * @return int row length of map
     */
    public int getRowLen(){return map.length;}
    /**
     * This method returns length of column in map
     *
     * @return int column length of map
     */
    public int getColLen(){return map[0].length;}

    /**
     * Swaps two tiles. Items stay in original tile.
     * @param A {@link Tile}
     * @param B {@link Tile}
     */
    public void swapTile(Tile A, Tile B){
        if(B.hasItem()) {
            itemBegoneSwap(A, B);
            return;
        }
        if(A.hasItem() && A.hasEnemy()) {
            dropThatItemBoy(A, B);
            return;
        }
        if(A.hasItem() && B.hasItem()) {
            return; //Don't move at all
        }
        Tile temp = new Tile();
        temp.insertPlayer(A.getPlayer());
        temp.insertEnemy(A.getEnemy());
        temp.insertItem(A.getItem());

        A.insertEnemy(B.getEnemy());
        A.insertItem(B.getItem());
        A.insertPlayer(B.getPlayer());

        B.insertEnemy(temp.getEnemy());
        B.insertItem(temp.getItem());
        B.insertPlayer(temp.getPlayer());
    }

    /**
     * Moves enemy into a tile with an item, creating a tile with both an enemy and an item inside
     * @param A
     * @param B
     */
    public void itemBegoneSwap(Tile A, Tile B) {
        B.insertEnemy(A.getEnemy());
        B.insertPlayer(A.getPlayer());
        A.insertEnemy(null);
        A.insertItem(null);
        A.insertPlayer(null);
    }

    /**
     * Drops item on original tile.
     * @param A
     * @param B
     */
    public void dropThatItemBoy(Tile A, Tile B) {
        B.insertEnemy(A.getEnemy());
        A.insertEnemy(null);
    }
    /**
     * This method checks to see if the player move is valid
     * The arguments passed are the {@link Player}'s position
     * and the {@link GameEngine.Direction}. Also implements
     * {@link #canMove(Point)} to check if the {@link Entity} at
     * position can move.
     *
     * @param position Entity position
     * @param movePos The position an entity will move to
     * @return {@code true/false}
     */
    public boolean validMove(Point position, GameEngine.Direction movePos) {

        Point checkPos = new Point(position);

        switch (movePos) {
            case UP:
                checkPos.translate(-1, 0);
                if (isOOB(checkPos.x, checkPos.y)) {
                    return false;
                }
                else if (getTile(checkPos.x, checkPos.y).hasItem()) {
                    return true;
                }
                else if (getTile(checkPos.x, checkPos.y).isEmpty()) {
                    return true;
                }
                else return false;
            case DOWN:
                checkPos.translate(1, 0);
                if (isOOB(checkPos.x, checkPos.y)) {
                    return false;
                }
                else if (getTile(checkPos.x, checkPos.y).hasItem()) {
                    return true;
                }
                else if (getTile(checkPos.x, checkPos.y).isEmpty()) {
                    return true;
                }
                else if (getTile(checkPos.x, checkPos.y).isRoom()) {
                    return true;
                }
                else return false;
            case LEFT:
                checkPos.translate(0, -1);
                if (isOOB(checkPos.x, checkPos.y)) {
                    return false;
                }
                else if (getTile(checkPos.x, checkPos.y).hasItem()) {
                    return true;
                }
                else if (getTile(checkPos.x, checkPos.y).isEmpty()) {
                    return true;
                }
                else return false;
            case RIGHT:
                checkPos.translate(0, 1);
                if (isOOB(checkPos.x, checkPos.y)) {
                    return false;
                }
                else if (getTile(checkPos.x, checkPos.y).hasItem()) {
                    return true;
                }
                else if (getTile(checkPos.x, checkPos.y).isEmpty()) {
                    return true;
                }
                else return false;
            default:
                return false;
        }

    }
}

