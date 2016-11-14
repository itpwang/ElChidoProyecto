/**
 * Created by Ivan on 11/10/2016.
 */
import java.awt.Point;

public class Grid extends Cell {
	static enum Directions {
		UP, DOWN, LEFT, RIGHT;
	}
	public static final int playableField = 9; //static_assert((mapSize - playableField) == 2, "Difference must be 2");
	public static final int mapSize = 11; //Java has no static assert because it's ass
	private Cell[][] map = new Cell[mapSize][mapSize]; //Playable field = 9x9
	
	Map() {
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[i][j] = new Cell(new Point(i, j));
			}
		}
		setBorders();
		map[Math.toPlayableX(0)][Math.toPlayableY(0)].setChar('P');
		System.out.println(Math.toPlayable(0, 0));
		
		Point e = Math.toMap(0, 0);
		System.out.println(e);
		//map[e.x][e.y].setChar('K');
		//map[e.x][e.y].setVisibility(true);
		//moveCell(getCell(e.x, e.y), Directions.UP);
	}
	public Cell getCell(int x, int y) {
		return map[x][y];
	}
	public void swapCell(Cell c, Directions d) {
		if(d == Directions.UP && !getCell((c.getPos().x - 1), c.getPos().y).isBound()) {
			char temp = c.getChar();
			c.setChar(getCell((c.getPos().x - 1), c.getPos().y).getChar());
			getCell((c.getPos().x - 1), c.getPos().y).setChar(temp);
		}
	}
	
	private void setBorders() {
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[0][j] = new Cell('_', true, true);
				map[i][0] = new Cell('|', true, true);
				map[mapSize - 1][j] = new Cell('-', true, true);
				map[j][mapSize - 1] = new Cell('|', true, true);
			}
		}
	}
	 
	public void printMap() {
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				System.out.print(map[i][j].getChar());
			}
			System.out.println();
		}
			
	}
}
}
