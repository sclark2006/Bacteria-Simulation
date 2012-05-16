
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frederick.clark
 */
public final class CellWall extends Envelope
{
    public CellWall(Cell cell){
         super(cell);
         createSelfImage();
    }
    
    @Override
    public void createSelfImage() {
        this.getImage().setColor(Color.GREEN );
        super.drawImage();
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cell.class;
    }
    
}