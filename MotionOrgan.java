
/**
 * Write a description of class MotionOrgan here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class MotionOrgan extends Organ
{
     public MotionOrgan(Cell cell, Organ parentOrgan, Size size, Shape shape){
         super(cell,parentOrgan,size,shape);
        createSelfImage(); 
        updateImage(parentOrgan.getLocation());
    }
     
    @Override
    public void createSelfImage() {}
    /**
     * Act - do whatever the MotionOrgan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here.
    }    
}
