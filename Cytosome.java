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
    
    public Cytosome(Cell cell) {
        super(cell);
        createSelfImage(); 
        enzymeQueue = new PriorityQueue<Enzyme>();
    }
    

   
    @Override
    public void createSelfImage() {
        this.getImage().setColor(Color.WHITE );
        this.getImage().setTransparency(TRANSPARENCY);
        this.fillImage();
    }
        
    /**
     * Act - do whatever the Cytosome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override 
    public void act() 
    {
        //updateImage();
        for(Enzyme enzyme : enzymeQueue) {
            if(enzyme.isActive())
                enzyme.act();
            else
                enzymeQueue.remove(enzyme);
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
