/**
 * Write a description of class Location here.
 * 
 * @author Frederick Clark 
 * @version May 5, 2012
 */
public class Location  
{
    // instance variables - replace the example below with your own
    public int X;
    public int Y;
    public int Rotation;

    /**
     * Constructor for objects of class Location
     */
    public Location(int x, int y)
    {
        this(x,y,0);
    }
    
    public Location(int x, int y, int rotation) {
        this.X = x;
        this.Y = y;
        this.Rotation = rotation;
    }
}
