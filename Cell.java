import greenfoot.Actor;
import greenfoot.World;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a description of class Cell here.
 * 
 * @author Frederick Clark
 * @version May 04, 2012
 * 
 */
public class Cell extends Actor
{
    //public static final int WIDTH = 150;
    //public static final int HEIGHT = 90;
    
    public static final Size SIZE = new Size(150,90);
    public Membrane membrane;
    public Cytosome cytosome;
    private List<Organ> organelles;
    private Set<Chromosome> genome;
    private Size size;
    private Location location;
    
    public Cell(Location location) {
        super();
        this.size = SIZE;
        this.location = location;
        this.membrane = new Membrane(this,null,size,Shape.CIRCLE);
        this.membrane.updateImage(location);
        this.cytosome = new Cytosome(this.membrane);
        this.genome = initialGenome();
        this.organelles = new ArrayList<Organ>();
        this.organelles.add(new Rybosome(this.cytosome));
    }
    
    public Cell(Membrane membrane, Cytosome cytosome, Set<Chromosome> genome) {
        super();
        this.membrane = membrane;
        this.cytosome = cytosome;
        this.organelles = new ArrayList<Organ>();
        this.genome = genome;
    }
    
    @Override
    protected void addedToWorld(World world) {
        //System.out.println("Added Cell to the world " + world.toString());
        //int xpos = getX() + (int)(width / 2);
        //int ypos = getY() + (int)(height / 2);
        //this.getWorld().addObject(this.organelles.get(0), xpos, ypos);
    }
    
    public List<Organ> getOrganelles() {
        return this.organelles;
    }
    
    public Set<Chromosome> getGenome() {
        return this.genome;
    }
 
    public Size getSize() {
        return size;
    }
 
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
         for(Organ organ : organelles) 
         {
             organ.act();
         }
    }
    
    private Set<Chromosome> initialGenome() {
        //Creates a Set to store the chromosome created
        Set<Chromosome> initGenome = new HashSet<Chromosome>();
        Chromosome chromosome = new Chromosome(this.cytosome);
        //fill the chromosome with the needed genes
        chromosome.add(Gene.BuildOrganBuilderStopper).
                   add(Gene.BuildRybosome).
                   add(Gene.BuildMotionOrgan).
                   add(Gene.BuildLightPerceiver); 
                    
        
        initGenome.add(chromosome);
        return initGenome;
    }
}
