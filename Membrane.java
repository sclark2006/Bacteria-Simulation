import java.awt.Color;

/**
 * Write a description of class Membrane here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class Membrane extends Organ
{
    public Membrane(Cell cell, Organ parentOrgan, Size size, Shape shape ){
         super(cell, parentOrgan, size,shape);
         createSelfImage();
         updateImage(new Location(0,0));
    }
    
    @Override
    public void createSelfImage() {
        this.cell.getImage().clear();
        this.getImage().setColor(Color.GREEN );
        super.drawImage();
    }
    
     /**
     * Act - do whatever the Membrane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here.
    }    
}
