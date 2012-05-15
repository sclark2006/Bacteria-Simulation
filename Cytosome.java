import java.awt.Color;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Write a description of class Cytosome here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class Cytosome extends Soma
{
    public static final int TRANSPARENCY = 200;
    private Queue<Enzyme> enzymeQueue;
    
    public Cytosome(Cell cell,Shape shape ) {
        super(cell, shape);
        createSelfImage(); 
        updateImage(cell.getLocation());
        enzymeQueue = new PriorityQueue<Enzyme>();
    }
    
    public Cytosome(Membrane membrane){
        this(membrane.getCell(),membrane.getShape());
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
        Enzyme enzyme = enzymeQueue.peek();
        if(enzyme != null) {
            if(enzyme.isActive())
                enzyme.act();
            else
                enzymeQueue.poll();
        }
    }

    public Queue<Enzyme> getEnzymeQueue() {
        return enzymeQueue;
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Membrane.class;
    }
    
    
}
