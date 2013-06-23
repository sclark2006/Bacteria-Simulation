
import java.lang.reflect.Constructor;

/**
 * The class Gene represents a simple Gene in the entire Genoma. A Gene can express as a Protein, so 
 * we can build Organs or Enzymes.
 * 
 * @author Frederick Clark
 * @version May 8, 2012
 */
public final class Gene extends ExtensibleEnum<Gene> {
    public static final Gene 
            
    BuildMotionOrgan = newGene(MotionOrgan.class, new Size(10,30), Shape.LINE), 
    BuildDigestiveOrgan =newGene(DigestiveOrgan.class, new Size(30,30), Shape.CIRCLE),
    BuildMembrane = newGene(Membrane.class, null, Shape.CIRCLE),
    BuildCytosome = newGene(Cytosome.class,null,Shape.CIRCLE),
    BuildRybosome = newGene(Rybosome.class,new Size(6,6), Shape.TRIANGLE),
    BuildLightPerceiver = newGene(LightPerceiver.class, new Size(16,10),Shape.CIRCLE),
    BuildLightEmitter = newGene(LightEmitter.class, new Size(16,10), Shape.CIRCLE),
    
    BuildOrganBuilderStopper = newGene(OrganBuilderStopper.class, 10),
    BuildMembraneDestroyer = newGene(MembraneDestroyer.class,0),
    BuildMembraneDivider = newGene(MembraneDivider.class,0),
    BuildCytosomeDivider = newGene(CytosomeDivider.class,0),
    BuildDuplicationStarter = newGene(DuplicationStarter.class,5),
    BuildDuplicationStopper = newGene(DuplicationStopper.class,5),
    BuildMotionStarter = newGene(MotionStarter.class,5),
    //BuildMotionStopper = newEnzymeGene(MotionStopper.class,5),
    BuildChromosomeClonner = newGene(ChromosomeCloner.class,0);
    
    private Class<? extends Protein> proteinToBuild;
    private Object[] properties;
    
   
    private boolean active;

    public Chromosome chromosome;
    public Gene next;    
    public Gene previous;
    
    
    public Gene(String name, int ordinal)
    {
        super(name,ordinal);
    }

    public boolean isActive() {
        return active;
    }

    public Class<? extends Protein> getProteinToBuild() {
        return proteinToBuild;
    }

    public Object[] getProperties() {
        return properties;
    }
        
    public void activate() {
        active = true;
    }
    
    public void deactivate() {
        active = false;
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
    
    public Gene add(Gene newGene) {
        return this.insertAfter(newGene);
    }
    
    @SuppressWarnings("unchecked")
	public <T extends Organ> T expressOrgan(Cell cell, Organ parentOrgan) {
        try {
            Constructor<?> ctor;
            T organ = null;
            //Is an Organ?
            if(proteinToBuild.isAssignableFrom(Organ.class)) {
                ctor = proteinToBuild.getConstructors()[0];
                Object[] values = new Object[this.properties.length + 2];
                values[0] = parentOrgan;
                values[1] = cell;
                for(int i=2; i < values.length; i++)
                    values[i] = this.properties[i-2];
                organ = (T)ctor.newInstance(this.properties);   
            }
            
            return organ;
        }
        //catch(NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        catch(Exception e) {
            return null;
            //throw new IllegalArgumentException("The class "+enumType.getSimpleName() + " doesn't inherits " + ExtensibleEnum.class.getSimpleName());
        } 
    }
    
    @SuppressWarnings("unchecked")
	public <T extends Enzyme> T expressEnzyme() {
        try {
            Constructor<?> ctor;
            T enzyme = null;
            //Is an Enzyme?
            if(proteinToBuild.isAssignableFrom(Enzyme.class)) {
                ctor = proteinToBuild.getConstructors()[0];
                enzyme = (T)ctor.newInstance(this.properties);
            }
            
            return enzyme;
        }
        //catch(NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        catch(Exception e) {
            return null;
            //throw new IllegalArgumentException("The class "+enumType.getSimpleName() + " doesn't inherits " + ExtensibleEnum.class.getSimpleName());
        } 
    }
    
    public static Gene newGene(Class<? extends Protein> proteinToBuild, Object... properties) {
        Gene gene = ExtensibleEnum.newInstance(Gene.class,"Build"+proteinToBuild.getSimpleName());
        gene.proteinToBuild = proteinToBuild;
        gene.properties = properties;
        return gene;
    }
    
}