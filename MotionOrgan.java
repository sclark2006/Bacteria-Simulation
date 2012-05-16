
/**
 * Write a description of class MotionOrgan here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class MotionOrgan extends ProteinStructure
{
     public MotionOrgan(Cell cell, Size size, Shape shape){
         super(cell,size,shape);
        createSelfImage(); 
    }

    @Override
    public void onAddedToParent() {
        this.location = parentStructure.getLocation();
        updateImage();
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

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Envelope.class;
    }
}
