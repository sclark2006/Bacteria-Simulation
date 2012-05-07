import greenfoot.GreenfootImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Write a description of class Organ here.
 * 
 * @author Frederick Clark 
 * @version May 02, 2012
 */
public abstract class Organ extends Protein
{
    protected Organ parentOrgan;
    protected int height;
    protected int width;
    protected OrganShape shape;
    protected Cell cell;
    protected List<Organ> children;
    private Random randomizer;
    private Location location;
    
    public Organ(int width, int height, OrganShape shape, Organ parentOrgan, Cell cell) {
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.setImage(new GreenfootImage(width, height));
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
   
    public Organ(int width, int height, OrganShape shape, Organ parentOrgan) {
        this(width,height,shape,parentOrgan, parentOrgan.getCell());
    }
    
    protected void drawImage() {
        
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
    
    protected void fillImage(int x, int y, int width, int height) {
        
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
        getImage().rotate(selfLoc.Rotation);
        GreenfootImage image = new GreenfootImage(cell.getWidth(), cell.getHeight());
        image.drawImage(getCell().getImage(),0,0); //Draw the previous cell image
        image.drawImage(this.getImage(), selfLoc.X, selfLoc.Y); //Draw the self image
        getCell().setImage(image); //Updates the cell image
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public OrganShape getShape() {
        return this.shape;
    }
    
    public Organ getParentOrgan() {
        return this.parentOrgan;
    }
    
    public List<Organ> getChildren() {
        return this.children;
    }
    
    public Cell getCell() {
        return this.cell;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public Location getRandomLocation(int margin) {
        int x = randomCoord(parentOrgan.getWidth(), this.width + margin);
        int y = randomCoord(parentOrgan.getHeight(), this.height + margin);
        int t = (int)randomizer.nextInt(359);
        return new Location(x,y,t);
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
