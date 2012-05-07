import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Citosoma here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public class Cytosome extends Organ
{
    public static final int TRANSPARENCY = 200;
    
    public Cytosome(Membrane membrane){
        super(membrane.getWidth(),membrane.getHeight() ,membrane.getShape(),membrane);
        createSelfImage();
        updateImage(new Location(0,0));
    }
   
    public void createSelfImage() {
        this.getImage().setColor(Color.WHITE );
        this.getImage().setTransparency(TRANSPARENCY);
        this.fillImage(0,0,width,height);
    }
    
    /**
     * Act - do whatever the Citosoma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
}
