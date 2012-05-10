/**
 * Write a description of class Location here.
 * 
 * @author Frederick Clark 
 * @version May 5, 2012
 */
public class Location  
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int rotation;

    /**
     * Constructor for objects of class Location
     */
    public Location(int x, int y)
    {
        this(x,y,0);
    }
    
    public Location(int x, int y, int rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }    
}
