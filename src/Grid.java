/**
 * Created by travis on 11/14/16.
 */
public class Grid {
    private Cell[][] map = new Cell[9][9];

    Grid()
    {
        map[0][9] = new Player();
    }

    private boolean isEmpty()
    {
        return false;
    }
}
