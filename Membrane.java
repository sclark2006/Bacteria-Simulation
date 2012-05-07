import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Membrane here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public class Membrane extends Organ
{
    public Membrane(int width, int height, OrganShape shape, Cell cell){
         super(width,height,shape,null, cell);
         this.cell = cell;
         createSelfImage();
         updateImage(new Location(0,0));
    }
    
    public void createSelfImage() {
        this.cell.getImage().clear();
        this.getImage().setColor(Color.GREEN );
        super.drawImage();
    }
    
     /**
     * Act - do whatever the Membrane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
