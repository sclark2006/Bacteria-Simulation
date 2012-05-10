
/**
 * Write a description of class Perceiver here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public abstract class Perceiver extends Organ
{
    protected int minLevel;
    protected int maxLevel;
    
    public Perceiver(Cell cell, Organ parentOrgan, Size size, Shape shape, int minLevel, int maxLevel){
     super(cell,parentOrgan,size,shape);
     this.minLevel = minLevel;
     this.maxLevel = maxLevel;
    }
    
    public int getMinLevel() {
        return minLevel;
    }
    
    public int getMaxLevel() {
        return maxLevel;
    }

    public abstract void perceive();
    /**
     * Act - do whatever the Perceiver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        perceive();
    }    
}
