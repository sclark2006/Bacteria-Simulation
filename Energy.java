import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Energy here.
 * 
 * @author Frederick Clark 
 * @version May 5, 2012. Constructor added
 */
public abstract class Energy extends Actor
{
    protected int level = 0;
    public Energy(int initialLevel) {
        this.level = initialLevel;
    }
    
    public int getLevel() {
        return this.level;
    }
}
