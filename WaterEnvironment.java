import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class WaterEnvironment here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012. Creation of the class
 */
public class WaterEnvironment extends World
{
    private static Random randomizer = new Random();
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    /**
     * Constructor for objects of class WaterEnvironment.
     * 
     */
    public WaterEnvironment()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        setBackground("water3.jpg");
        //setPaintOrder(Cell.class);
        addObject(new Cell(new Location(WIDTH /2, HEIGHT /2)), WIDTH /2, HEIGHT /2);
    }
    
    public static Random getRandomizer()
    {
        return randomizer;
    }

}
