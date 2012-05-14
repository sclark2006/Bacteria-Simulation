import java.awt.Color;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Write a description of class Cytosome here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class Cytosome extends ProteinStructure
{
    public static final int TRANSPARENCY = 200;
    private Queue<Enzyme> enzymeQueue;
    
    public Cytosome(Cell cell,Size size, Shape shape ) {
        super(cell, size,shape);
        createSelfImage(); 
        updateImage(parentStructure.getLocation());
        enzymeQueue = new PriorityQueue<Enzyme>();
    }
    
    public Cytosome(Membrane membrane){
        this(membrane.getCell(),membrane.getSize(),membrane.getShape());

    }
   
    @Override
    public void createSelfImage() {
        this.getImage().setColor(Color.WHITE );
        this.getImage().setTransparency(TRANSPARENCY);
        this.fillImage(this.location, this.size);
    }
    
    /**
     * Act - do whatever the Cytosome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override 
    public void act() 
    {
        // Add your action code here.
        for(Enzyme enzyme : enzymeQueue) {
            enzyme.act();
        }
    }

    public Queue<Enzyme> getEnzymeQueue() {
        return enzymeQueue;
    }
    
    
}
