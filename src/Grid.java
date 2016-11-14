/**
 * Created by travis on 11/14/16.
 */
public class Grid {
    public Cell[][] map = new Cell[9][9];

    Grid()
    {
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map.length; j++)
                map[i][j] = new Tile();

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

    private boolean isEmpty()
    {
        return false;
    }

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
