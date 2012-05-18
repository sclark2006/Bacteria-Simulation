
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
        this.getImage().setColor(Color.GREEN);
        super.drawImage();
    }

    /**
     * Act - do whatever the Membrane wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
        //updateImage();
        // Add your action code here.
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {

        return CellWall.class;
    }
}
