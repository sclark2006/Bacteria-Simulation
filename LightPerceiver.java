import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightPerceiver here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public class LightPerceiver extends Perceiver
{
    public LightPerceiver(Cell cell, Organ parentOrgan, Size size, Shape shape, int minLevel, int maxLevel){
     super(cell,parentOrgan,size,shape, minLevel, maxLevel);
    }
    
    //TODO: Implement the createSelfImage method
    @Override
    public void createSelfImage() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void perceive() {
    }
}
