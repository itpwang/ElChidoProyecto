/**
 * Created by travis on 11/18/16.
 */

import java.awt.Point;

public class Math {

        //Map coord to playable field coord

    /**
     * This method takes a grid coordinate
     * and returns an entities position
     * @param x
     * @param y
     * @return
     */
        static public Point toPlayable(int x, int y) {
            return new Point((8 - x), (y));
        }
    /**
     * This method takes a grid coordinate
     * and returns an entities position
     * @param x
     * @return
     */
        static public int toPlayableX(int x) {
            return (8 - x);
        }
    /**
     * This method takes a grid coordinate
     * and returns an entities position
     * @param y
     * @return
     */
        static public int toPlayableY(int y) {
            return (y);
        }

        //Playable field coord to map coord
        static public Point toMap(int x, int y) {
            return new Point((8 - x), (y));
        }

        static public Point toMap(Point p) {
            return toMap(p.x, p.y);
        }

    /**
     * This method translates a cartesian coordinate to
     * the grid coordinate
     * @param x
     * @return
     */
    static public int toMapX(int x) {
            return (8 - x);
        }
    /**
     * This method translates a cartesian coordinate to
     * the grid coordinate
     * @param y
     * @return
     */
        static public int toMapY(int y) {
            return (y);
        }

    }
