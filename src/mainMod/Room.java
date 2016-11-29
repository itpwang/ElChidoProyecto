package mainMod;
import java.awt.*;


/**
 * This class is in charge of returning a char
 * representing the location of each room on the grid.
 */
public class Room extends Tile {

    /**
     * This field is set to {@code true} if the briefcase is in the room,
     * {@code false} if it is not.
     */
    private boolean briefcase = false;

    /**
     * This field is the position of a room object.
     */
    private Point roomPos;

    /**
     * This constructor method instantiates a room object with {@link #roomPos}
     * equal to the Point passed as an argument.
	 */
	public Room(Point Pos){
        roomPos=Pos;
    }

    /**
     * This method checks if there is a room at the point
     * @return boolean {@code true}
     */
    public boolean isRoom(){return true;}

    /**
     * This method returns {@code true, false} depending if {@link #briefcase}
     * is in the room
     *
     * @return boolean {@code true} if {@link #briefcase = @code true},
     * and {@code false} if {@link #briefcase = @code false}
     */
    public boolean getBriefcase(){
        return briefcase;
    }
    public boolean isBriefcaseRoom() {
        if(briefcase)
            return true;
        else
            return false;
    }

    /**
     * This method sets {@link #briefcase} to the value of the boolean passed
     *
     * @param value {@code true, false}
     */
    public void setBriefcase(boolean value){
        briefcase=value;
    }
}
