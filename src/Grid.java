/*
 * This class represents the Grid object, utilized by the GameEngine
 * to create and print the map the game will be played on.
 */
public class Grid {
	/*
	 * An object array of type {@link Cell} is created. The multidimensional
	 * array allows for a 9 by 9 grid to be created.
	 */
    public Cell[][] map = new Cell[9][9];

    /*
     * Constructor which is called to instantiate the map.
     */
    public Grid()
    {
       /*
        * This for loop allows each place in the multidimensional array to be instantiated as a Tile object.
        */
    	for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map.length; j++)
                map[i][j] = new Tile();
    	/*
    	 * Certain predisclosed tiles are set up as the Rooms in which the briefcase could potentially be
    	 * located in.
    	 */
        map[1][1] = new Room();
        map[4][1] = new Room();
        map[7][1] = new Room();


        map[1][4] = new Room();
        map[4][4] = new Room();
        map[7][4] = new Room();

        map[1][7] = new Room();
        map[4][7] = new Room();
        map[7][7] = new Room();
    }

    /*
     * This method returns a boolean value to determine if the tile the player wishes to be moved onto
     * is empty. If true, the player may move onto it.
     */
    public boolean isEmpty()
    {
        return false;
    }

    /*
     * This method is a void method which prints the map. Uses a for loop to run through the multi-dimensional
     * array and prints out the subsequent tiles.
     */
    public void printGrid()
    {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                System.out.print(map[i][j].returnSymbol());
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
