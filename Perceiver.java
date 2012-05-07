import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Perceiver here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public abstract class Perceiver extends Organ
{
    protected int minLevel;
    protected int maxLevel;
    
    public Perceiver(int width, int height, OrganShape shape, Organ parentOrgan, int minLevel, int maxLevel){
     super(width,height,shape,parentOrgan);
     this.minLevel = minLevel;
     this.maxLevel = maxLevel;
    }
    
    public int getMinLevel() {
        return minLevel;
    }
    
    public int getMaxLevel() {
        return maxLevel;
    }

    public abstract void perceive();
    /**
     * Act - do whatever the Perceiver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        perceive();
    }    
}
