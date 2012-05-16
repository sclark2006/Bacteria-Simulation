import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightPerceiver here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class LightPerceiver extends Perceiver
{
    public LightPerceiver(Cell cell, Size size, Shape shape, int minLevel, int maxLevel){
     super(cell,size,shape, minLevel, maxLevel);
     createSelfImage();
    }
    
    //TODO: Implement the createSelfImage method
    @Override
    public void createSelfImage() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void perceive() {
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cytosome.class;
    }
}
