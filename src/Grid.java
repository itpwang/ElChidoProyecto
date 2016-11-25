import java.awt.Point;

/*
 * This class represents the Grid object, utilized by the GameEngine
 * to create and print the map the game will be played on.
 */
public class Grid {
    /*
	 * An object array of type {@link Cell} is created. The multidimensional
	 * array allows for a 9 by 9 grid to be created.
	 */
    public Tile[][] map = new Tile[9][9];

    /*
     * Constructor which is called to instantiate the map.
     */
    public Grid() {
       /*
        * This for loop allows each place in the multidimensional array to be instantiated as a Tile object.
        */
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                map[i][j] = new Tile();
    	/*
    	 * Certain predisclosed tiles are set up as the Rooms in which the briefcase could potentially be
    	 * located in.
    	 */
    	for(int i = 1; i <= 7; i += 3)
        {
            map[1][i] = new Room(new Point(1,i));
            map[4][i] = new Room(new Point(4,i));
            map[7][i] = new Room(new Point(7, i));
            System.out.print("Dumbshit");
        }

    }

    /*
     * This method returns a boolean value to determine if the tile the player wishes to be moved onto
     * is empty. If true, the player may move onto it.
     */
    public boolean isEmpty() {
        return false;
    } //needs work

    /*
     * This method is a void method which prints the map. Uses a for loop to run through the multi-dimensional
     * array and prints out the subsequent tiles.
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
     * @param {@link Point}
     * @param {@link Point}
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
     * @param row
     * @param col
     * @return  {@link Tile}
     */
    public Tile getTile(int row, int col) {
        return map[row][col];
    }

    public Tile getTile(Point pt){
        return map[pt.x][pt.y];
    }

    public Room getRoom(Point p) { return (Room)map[p.x][p.y]; }

    public boolean isOOB(int x, int y) {
        return (x < 0 || x >= map.length || y < 0 || y >= map.length);
    }

    public void swapTile(Tile A, Tile B){
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
     * This method checks to see if the player move is valid
     * The arguments passed are the {@link Player}'s position
     * and the {@link GameEngine.Direction}
     *
     * @param position
     * @param movePos
     * @return
     */
    public boolean validMove(Point position, GameEngine.Direction movePos){

        Point checkpos = new Point(position);

        switch(movePos){
            case UP:
                checkpos.translate(-1,0);
                if(isOOB(checkpos.x,checkpos.y))
                {
                    System.out.println("That's a wall.  ");
                    return false;
                }
                else if(getTile(checkpos.x,checkpos.y).hasItem()) {return true;}
                else if(getTile(checkpos.x,checkpos.y).isEmpty()) {return true;}
                else return false;
            case DOWN:
                checkpos.translate(1,0);
                if(isOOB(checkpos.x,checkpos.y))
                {
                    System.out.println("That's a wall.  ");
                    return false;
                }
                else if(getTile(checkpos.x,checkpos.y).hasItem())
                {
                    System.out.println("That's a wall.  ");
                    return true;
                }
                else if(getTile(checkpos.x,checkpos.y).isEmpty()) {return true;}
                else return false;
            case LEFT:
                checkpos.translate(0,-1);
                if(isOOB(checkpos.x,checkpos.y))
                {
                    System.out.println("That's a wall.  ");
                    return false;
                }
                else if(getTile(checkpos.x,checkpos.y).hasItem()) {return true;}
                else if(getTile(checkpos.x,checkpos.y).isEmpty()) {return true;}
                else return false;
            case RIGHT:
                checkpos.translate(0,1);
                if(isOOB(checkpos.x,checkpos.y))
                {
                    System.out.println("That's a wall.  ");
                    return false;
                }
                else if(getTile(checkpos.x,checkpos.y).hasItem()) {return true;}
                else if(getTile(checkpos.x,checkpos.y).isEmpty()) {return true;}
                else return false;
            default: return false;
        }

    }
}

