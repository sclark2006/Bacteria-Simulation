
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
    public CellWall(Cell cell, Shape shape ){
         super(cell,shape);
         createSelfImage();
         this.location = new Location(0,0);
         updateImage();
    }
    
    @Override
    public void createSelfImage() {
        this.cell.getImage().clear();
        this.getImage().setColor(Color.GREEN );
        super.drawImage();
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cell.class;
    }
    
}