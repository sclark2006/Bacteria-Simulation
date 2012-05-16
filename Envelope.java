
/**
 * Write a description of class Envelope here.
 * 
 * @author Frederick Clark
 * @version May 14, 2012
 */
public abstract class Envelope extends ProteinStructure
{
    public Envelope(Cell cell){
         super(cell, cell.getSize(), cell.getShape());
    }
}
