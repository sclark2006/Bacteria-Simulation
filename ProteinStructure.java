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
    protected ProteinStructure parentOrgan;
    protected Size size;
    protected Shape shape;
    protected Cell cell;
    protected List<ProteinStructure> children;
    private Random randomizer;
    protected Location location;
    
    public ProteinStructure(Cell cell,ProteinStructure parentOrgan,Size size, Shape shape) {
        this.size = size;
        this.shape = shape;
        if(!shape.equals(Shape.IMAGE))
            this.setImage(new GreenfootImage(size.getWidth(), size.getHeight()));
        this.parentOrgan = parentOrgan;
        this.children = new ArrayList<>();
        this.cell = cell;
        if(parentOrgan != null)
            this.parentOrgan.getChildren().add(this);

        randomizer = WaterEnvironment.getRandomizer();
        //Add the actor to the world
        //if(this.parentOrgan != null)
        //    this.getWorld().addObject(this,parentOrgan.getX(),parentOrgan.getY());
        
    }
   
    public ProteinStructure(ProteinStructure parentOrgan,Size size, Shape shape) {
        this(parentOrgan.getCell(),parentOrgan,size,shape);
    }
    
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
    
    public ProteinStructure getParentOrgan() {
        return this.parentOrgan;
    }
    
    public List<ProteinStructure> getChildren() {
        return this.children;
    }
    
    public Cell getCell() {
        return this.cell;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public Location getRandomLocation(int margin) {
        int x = randomCoord(parentOrgan.getSize().getWidth(), this.getSize().getWidth() + margin);
        int y = randomCoord(parentOrgan.getSize().getHeight(), this.getSize().getHeight() + margin);
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
