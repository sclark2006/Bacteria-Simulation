/**
 * The Orientation enum helps determine the direction towards where an actor moves
 *
 * @author Frederick Clark
 * @version May 16, 2012
 */
public enum Orientation {
    NORTH(90), SOUTH(270), EAST(0), WEST(180), NORTH_EAST(45), NORTH_WEST(135), SOUTH_WEAST(225), SOUT_EAST(315), ;
    private int rotation;
    
    private Orientation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() {
        return rotation;
    }
    
    public int getUpperBound() {
        return rotation + 22;
        //if(rotation + 22 > 359)
        //    return (rotation + 22) - 360;
        //else
        //    return rotation + 22;
    }
    public int getLowerbound() {
        return rotation - 22;
       // if(rotation - 22 < 0)
        //    return 360 + (rotation - 22);
        //else
        //    return rotation - 22;
    }
    
    public static Orientation getOrientation(int rotation) {
        if (rotation == 360)
            rotation = 0;
         for(Orientation ori : values())
            if(rotation >= ori.getLowerbound() && rotation <= ori.getUpperBound())
                return ori;
        return null;
    }
    
}