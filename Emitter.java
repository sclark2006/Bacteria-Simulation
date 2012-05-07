import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Emitter here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public abstract class Emitter extends Organ
{
    public int maxLevel;
    public Emitter(int width, int height, OrganShape shape, Organ parentOrgan, int maxLevel){
     super(width,height,shape,parentOrgan);
     this.maxLevel = maxLevel;
    }
    
    public abstract void emit();
    /**
     * Act - do whatever the Emitter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        emit();
    }    
}
