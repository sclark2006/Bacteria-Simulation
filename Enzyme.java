import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enzime here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public abstract class Enzyme extends Protein
{
    protected long effectiveTime;
 
    public Enzyme(long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
    
    public long getEffectiveTime() {
        return effectiveTime;
    }
}
