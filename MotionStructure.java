
/**
 * Write a description of class MotionStructure here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class MotionStructure extends ProteinStructure
{
     public MotionStructure(Cell cell, Size size, Shape shape){
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
     * Act - do whatever the MotionStructure wants to do. This method is called whenever
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
