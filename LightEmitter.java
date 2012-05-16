
/**
 * Write a description of class LightEmitter here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class LightEmitter extends Emitter
{
    public LightEmitter(Cell cell, Size size, Shape shape, int maxLevel){
         super(cell,size,shape,maxLevel);
         createSelfImage();
    }
    //TODO: Implement this method
    @Override
    public void createSelfImage() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void emit() {
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cytosome.class;
    }
}
