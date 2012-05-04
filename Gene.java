/**
 * The class Gene represents a simple Gene in the entire Genoma. A Gene can express as a Protein, so 
 * we can build Organs or Enzymes.
 * 
 * @author Frederick Clark
 * @version May 3, 2012
 */
public enum Gene  
{   
   //Organ Builders
    BUILD_MOTION_ORGAN(MotionOrgan.class), 
    BUILD_DIGESTIVE_ORGAN(DigestiveOrgan.class),
    BUILD_MEMBRANE(Membrane.class),
    BUILD_CYTOSOME(Cytosome.class),
    BUILD_LIGHT_PERCEIVER_ORGAN(LightPerceiver.class),
    BUILD_LIGHT_EMITTER_ORGAN(LightEmitter.class),
    //Enzyme Builders
    BUILD_MEMBRANE_DESTROYER(MembraneDestroyer.class),
    BUILD_MEMBRANE_DIVIDER(MembraneDivider.class),
    BUILD_CYTOSOME_DIVIDER(CytosomeDivider.class),
    BUILD_DUPLICATION_STARTER(DuplicationStarter.class),
    BUILD_DUPLICATION_STOPPER(DuplicationStopper.class),
    BUILD_MOTION_STARTER(MotionStarter.class),
    BUILD_CHROMOSOME_CLONER(ChromosomeCloner.class);
    
    private Class<? extends Protein> proteinClass;
    public Chromosome chromosome;
    public Gene next;    
    public Gene previous;
    private boolean active;
    
    private Gene(Class<? extends Protein> proteinClass) {
        this.proteinClass = proteinClass;
    }
    
    
    public Gene insertBefore(Gene newGene) {
        if(newGene != null)
        {
            newGene.chromosome = this.chromosome;
            newGene.previous = this.previous;
            newGene.next = this;
            if(this.previous == null)
                chromosome.first = newGene;
            else
                this.previous.next = newGene;
           this.previous = newGene;
        }
        return this;
    }
    
    public Gene insertAfter(Gene newGene) {
        if(newGene != null)
        {
            newGene.chromosome = this.chromosome;
            newGene.previous = this;
            newGene.next = this.next;
            if(this.next == null)
                chromosome.last = newGene;
            else
                this.next.previous = newGene;
           this.next = newGene;
        }
        return this;        
    }
    
    public Protein express() {
        try {
            return (Protein) proteinClass.newInstance();
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void activate() {
        active = true;
    }
    
    public void deactivate() {
        active = false;
    }
}
