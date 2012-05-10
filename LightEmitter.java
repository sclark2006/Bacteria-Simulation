
/**
 * Write a description of class LightEmitter here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public final class LightEmitter extends Emitter
{
    public LightEmitter(Cell cell, Organ parentOrgan, Size size, Shape shape, int maxLevel){
         super(cell,parentOrgan,size,shape,maxLevel);
         createSelfImage();
         updateImage(this.getRandomLocation(20));
    }
    //TODO: Implement this method
    @Override
    public void createSelfImage() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void emit() {
    } 
}
