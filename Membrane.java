
import java.awt.Color;

/**
 * Write a description of class Membrane here.
 *
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class Membrane extends Envelope {

    public Membrane(Cell cell) {
        super(cell);
        createSelfImage();
    }

    @Override
    public void createSelfImage() {
        this.cell.getImage().clear();
        this.getImage().setColor(Color.GREEN);
        super.drawImage();
    }

    @Override
    public void onAddedToParent() {
        this.location = parentStructure.getLocation();        
        updateImage();
    }

    /**
     * Act - do whatever the Membrane wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
        // Add your action code here.
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {

        return CellWall.class;
    }
}
