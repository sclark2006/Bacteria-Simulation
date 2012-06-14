
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
    private static final int SPEED = 2;
    private int deltaX = 0;
    private int deltaY = 0;
    
    public MotionStructure(Cell cell, Orientation orientation) {
        super(cell, null, Shape.IMAGE);
        //this.cellImage = cell.getImage();
        this.orientation = orientation;
        createSelfImage();
    }

    private void moveCell() {
        //int rotation = Orientation.getOrientation(this.orientation.getRotation()).getRotation();
        //cell.setRotation(rotation);
        deltaX = adjustSpeed(deltaX);
        deltaY = adjustSpeed(deltaY);
        int newRot = (int) (180 * Math.atan2(deltaX, deltaY) / Math.PI);
        //Just make rotations lower than 30 degrees
        if( Math.abs(newRot - cell.getRotation()) <= 30)
            cell.setRotation(newRot);
        //If the cell is located at the limits of the world, turn 60 degrees
        if(cell.isAtWorldLimits())
            cell.turn(60);
       
        cell.move(SPEED);
    }
     private int adjustSpeed(int speed)
    {
        speed = speed + WaterEnvironment.getRandomizer().nextInt(2 * SPEED - 1) - SPEED + 1;
        return capSpeed(speed);
    }

    /**
     * The speed returned is in the range [-SPEED .. SPEED].
     */
    private int capSpeed(int speed)
    {
        if (speed < -SPEED)
            return -SPEED;
        else if (speed > SPEED)
            return SPEED;
        else
            return speed;
    }
    
    
    @Override
    public void createSelfImage() {
        setImage("helice.gif");
        this.size = new Size(this.getImage().getWidth(), this.getImage().getHeight());
        //cell.size.increase(this.size.getWidth(), 0);     
    }

    @Override
    public void updateImage() {
    }
    
    /**
     * Act - do whatever the MotionStructure wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
        super.act();
        //cell.setImage(cellImage);
        //updateImage();
        //Limits the chances of moving to a 50% of the actions (to decrease the speed)
        if( WaterEnvironment.getRandomizer().nextInt(100) < 50)
            moveCell();
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Envelope.class;
    }

    public Orientation getOrientation() {
        return orientation;
    }
    
    @Override
    public void setRotation(int rotation) {
        super.setRotation(orientation.getRotation() + rotation);
    }
    
    
}
