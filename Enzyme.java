
/**
 * Write a description of class Enzyme here.
 * 
 * @author Frederick Clark
 * @version May 2, 2012
 */
public abstract class Enzyme extends Protein
{
    protected long effectiveTime;
    private long startTime;
 
    public Enzyme(long effectiveTime) {
        this.effectiveTime = effectiveTime;
        startTime = System.currentTimeMillis();
    }
    
    public long getEffectiveTime() {
        return effectiveTime;
    }
    
    public boolean isActive() {
        long activeTime = (System.currentTimeMillis() - startTime) / 1000;
        if(activeTime <= effectiveTime)
            return true;
        else
            return false;
    }
}
