import java.awt.Color;
/**
 * Write a description of class Citosoma here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class Cytosome extends Organ
{
    public static final int TRANSPARENCY = 200;
    
    public Cytosome(Cell cell,Organ parentOrgan, Size size, Shape shape ) {
        super(cell, parentOrgan,size,shape);
        createSelfImage(); 
        updateImage(parentOrgan.getLocation());
    }
    
    public Cytosome(Membrane membrane){
        this(membrane.getCell(),membrane,membrane.getSize(),membrane.getShape());

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
    }
}
