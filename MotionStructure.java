
import greenfoot.GreenfootImage;
import java.awt.Color;


/**
 * Write a description of class MotionStructure here.
 *
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class MotionStructure extends AnimatedStructure {

    private GreenfootImage cellImage;
    private Orientation orientation;
    
    public MotionStructure(Cell cell, Orientation orientation) {
        super(cell, null, Shape.IMAGE);
        this.cellImage = cell.getImage();
        this.orientation = orientation;
        createSelfImage();
    }

    private void moveCell() {
        int rotation = Orientation.getOrientation(this.orientation.getRotation() + 180).getRotation();
        cell.setRotation(rotation);
        cell.move(1);
    }
    

    @Override
    public void createSelfImage() {
        setImage("helice.gif");
        this.size = new Size(this.getImage().getWidth(), this.getImage().getHeight());
        cell.size.increase(this.size.getWidth(), 0);
        

    }

    //@TODO: Find a way to get a periferic location for this organ
    @Override
    public void onAddedToParent() {
        this.location = new Location(parentStructure.getSize().getWidth()-this.size.getWidth(), parentStructure.getSize().getHeight()/3);
         updateImage();        
    }
    /**
     * Act - do whatever the MotionStructure wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
        super.act();
        cell.setImage(cellImage);
        updateImage();
        moveCell();
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Envelope.class;
    }
}
