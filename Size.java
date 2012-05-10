/**
 * The class Size
 * 
 * @author Frederick Clark
 * @version May 8, 2012
 */
public class Size 
 {
    // instance variables 
    private int width;
    private int height;

    /**
     * Constructor for objects of class Size
     */
        
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Size other = (Size) obj;
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.width;
        hash = 79 * hash + this.height;
        return hash;
    }
    
    
}
