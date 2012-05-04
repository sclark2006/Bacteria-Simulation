import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Cell here.
 * 
 * @author Frederick Clark
 * @version May 04, 2012
 * 
 */
public class Cell extends Actor
{

    public Membrane membrane;
    public Cytosome cytosome;
    private List<Organ> organelles;
    
    public Cell() {
        this.organelles = new ArrayList<Organ>();
    }
    
    public List<Organ> getOrganelles() {
        return this.organelles;
    }
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
