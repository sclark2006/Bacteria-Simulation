
/**
 * Write a description of class Soma here.
 * 
 * @author Frederick Clark
 * @version May 14, 2012
 */
public abstract class Soma extends ProteinStructure
{
    public Soma(Cell cell){
         super(cell, cell.getSize(), cell.getShape());
    }
    
    @Override
    public void onAddedToParent() {
        this.location = parentStructure.getLocation();
        updateImage();
    }
}
