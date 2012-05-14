
/**
 * Write a description of class Soma here.
 * 
 * @author Frederick Clark
 * @version May 14, 2012
 */
public abstract class Soma extends ProteinStructure
{
    public Soma(Cell cell, Shape shape ){
         super(cell, cell.getSize(), shape);
    }
}
