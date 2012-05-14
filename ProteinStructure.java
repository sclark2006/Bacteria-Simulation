import greenfoot.GreenfootImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Write a description of class ProteinStructure here.
 * 
 * @author Frederick Clark 
 * @version May 02, 2012
 */
public abstract class ProteinStructure extends Protein
{ 
    private List<ProteinStructure> subStructures;
    
    protected ProteinStructure parentStructure;
    protected Size size;
    protected Shape shape;
    protected Cell cell;    
    private Random randomizer;
    protected Location location;
    
    public ProteinStructure(Cell cell,Size size, Shape shape) {
        this.size = size;
        this.shape = shape;
        if(!shape.equals(Shape.IMAGE))
            this.setImage(new GreenfootImage(size.getWidth(), size.getHeight()));
        this.subStructures = new ArrayList<ProteinStructure>();
        this.cell = cell;
        //if(parentStructure != null)
        //    this.parentStructure.getSubStructures().add(this);

        //Add the actor to the world        
        randomizer = WaterEnvironment.getRandomizer();

        //if(this.parentStructure != null)
        //    this.getWorld().addObject(this,parentStructure.getX(),parentStructure.getY());
        
    }
  
    /*public ProteinStructure(ProteinStructure parentStructure,Size size, Shape shape) {
        this(parentStructure.getCell(),parentStructure,size,shape);
    }*/
    
    protected void drawImage() {
        int width = size.getWidth();
        int height = size.getHeight();
        
        switch(this.shape) {
            case LINE:  this.getImage().drawLine(0, (int)(height/2),width,(int)(height/2));
                        break;
            case CIRCLE: this.getImage().drawOval(0,0,width, height);
                        break;
            case RECTANGLE: this.getImage().drawRect(0,0,width, height);
                            break;
            case TRIANGLE: this.getImage().drawPolygon(new int[]{(int)(width/2),0,width}, new int[]{0, height,height}, 3);
                            break;
        }
    }
    
    protected void fillImage() {
        int width = size.getWidth();
        int height = size.getHeight();
        
        switch(this.shape) {
            case LINE:  this.getImage().drawLine(0, (int)(height/2),width,(int)(height/2));
                        break;
            case CIRCLE: this.getImage().fillOval(0,0,width, height);
                        break;
            case RECTANGLE: this.getImage().fillRect(0,0,width, height);
                            break;
            case TRIANGLE: this.getImage().fillPolygon(new int[]{(int)(width/2),0,width}, new int[]{0, height,height}, 3);
                            break;
        }
    }
    
    protected void fillImage(Location location, Size size) {
        int x = location.getX();
        int y = location.getY();
        int width = size.getWidth();
        int height = size.getHeight();
        
        switch(this.shape) {
            case LINE:  this.getImage().drawLine(x, (int)(height/2),width,(int)(height/2));
                        break;
            case CIRCLE: this.getImage().fillOval(x,y,width, height);
                        break;
            case RECTANGLE: this.getImage().fillRect(x,y,width, height);
                            break;
            case TRIANGLE: this.getImage().fillPolygon(new int[]{(int)(width/2),x,width}, new int[]{y, height,height}, 3);
                            break;
        }
    }
   
    public abstract void createSelfImage();
    public void addedToParent() {}
    public void removedFromParent(){}
   
    public void setParentStructure(ProteinStructure parentStructure) {
        if(parentStructure != null) {
            parentStructure.subStructures.add(this);
            this.addedToParent();
        }
        else if(this.parentStructure != null) {
            this.parentStructure.subStructures.remove(this);
            this.removedFromParent();
            
        }
        this.parentStructure = parentStructure;
    }
    
    public ProteinStructure addSubStructure(ProteinStructure child) {
        if(child != null) {
            child.setParentStructure(this);
        }
        return child;
    }
    
    public ProteinStructure removeSubStructure(ProteinStructure child) {
        if(child != null) {
            child.setParentStructure(null);            
        }
        return child;
    }
    
    public void updateImage(Location selfLoc) 
    {
        this.location = selfLoc;
        getImage().rotate(selfLoc.getRotation());
        GreenfootImage image = new GreenfootImage(cell.getSize().getWidth(), cell.getSize().getHeight());
        image.drawImage(getCell().getImage(),0,0); //Draw the previous cell image
        image.drawImage(this.getImage(), selfLoc.getX(), selfLoc.getY()); //Draw the self image
        getCell().setImage(image); //Updates the cell image
    }
    
    public Size getSize() {
        return this.size;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    public ProteinStructure getParentStructure() {
        return this.parentStructure;
    }
    
    public List<ProteinStructure> getSubStructures() {
        return this.subStructures;
    }
    
    public Cell getCell() {
        return this.cell;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public Location getRandomLocation(int margin) {
        int parentWidth = parentStructure == null ? parentStructure.getSize().getWidth() : cell.getSize().getWidth();
        int parentHeight = parentStructure == null ? parentStructure.getSize().getHeight() : cell.getSize().getHeight();
        
        int x = randomCoord(parentWidth, this.getSize().getWidth() + margin);
        int y = randomCoord(parentHeight, this.getSize().getHeight() + margin);
        int r = (int)randomizer.nextInt(360);
        return new Location(x,y,r);
    }
    
    
    /**
     * Returns a random number relative to the size of the food pile.
     */
    private int randomCoord(int envSize, int refSize)
    {
        int halfSize = (int) (envSize / 2);
        int val = halfSize + (int) (randomizer.nextGaussian() * (halfSize / 2));
        if (val < 0)
            return envSize;
            
        if (val > envSize - refSize)
            return envSize - refSize;
        else
            return val;
    }
    
}
