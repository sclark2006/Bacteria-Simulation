import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Emitter here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public abstract class Emitter extends ProteinStructure
{
    protected int maxLevel;
    
    public Emitter(Cell cell, Size size, Shape shape, int maxLevel){
        super(cell, size,shape);
        this.maxLevel = maxLevel;
    }

    @Override
    public void onAddedToParent() {
        this.location = this.randomLocation(20);
         updateImage();
    }
        
    public int getMaxLevel() {
        return maxLevel;
    }
    
    
    public abstract void emit();
    /**
     * Act - do whatever the Emitter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        emit();
    }    
}
