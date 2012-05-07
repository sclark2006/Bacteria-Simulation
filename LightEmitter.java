import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightEmitter here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public class LightEmitter extends Emitter
{
    public LightEmitter(int width, int height, OrganShape shape, Organ parentOrgan, int maxLevel){
     super(width,height,shape,parentOrgan, maxLevel);
    }
    public void createSelfImage() {}
    public void emit() {
    } 
}
