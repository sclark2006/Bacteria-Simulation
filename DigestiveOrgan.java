
/**
 * Write a description of class DigestiveOrgan here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class DigestiveOrgan extends Organ
{
     public DigestiveOrgan(Cell cell, Organ parentOrgan, Size size, Shape shape){
         super(cell,parentOrgan,size,shape);
         createSelfImage();
         updateImage(this.getRandomLocation(20));
    }
    
     //TODO: implement this method
    @Override
    public void createSelfImage() {
        throw new UnsupportedOperationException();
    }
    /**
     * Act - do whatever the DigestiveOrgan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here.
    }    
}
