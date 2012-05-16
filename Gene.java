
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
    
    BuildCellSpace = newGene(Cell.class,new Size(150,90), Shape.CIRCLE),
    BuildMotionStructure = newGene(MotionStructure.class, new Size(10,30), Shape.LINE), 
    BuildDigestiveOrgan =newGene(DigestiveOrgan.class, new Size(30,30), Shape.CIRCLE),
    BuildMembrane = newGene(Membrane.class, Shape.CIRCLE),
    BuildCytosome = newGene(Cytosome.class, Shape.CIRCLE),
    BuildRybosome = newGene(Rybosome.class,new Size(6,6), Shape.CIRCLE),
    BuildLightPerceiver = newGene(LightPerceiver.class, new Size(16,10),Shape.CIRCLE),
    BuildLightEmitter = newGene(LightEmitter.class, new Size(16,10), Shape.CIRCLE),
    BuildCellWhall = newGene(CellWall.class, null, Shape.CIRCLE),
            
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
    
    
    protected Gene(String name, int ordinal)
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
    
    public <T extends ProteinStructure> T expressStructure(Cell cell) {
        try {
            Constructor ctor;
            T structure = null;
            //Is an ProteinStructure?
            if(ProteinStructure.class.isAssignableFrom(proteinToBuild)) {
                ctor = proteinToBuild.getConstructors()[0];
                Object[] values = new Object[this.properties.length + 1];
                values[0] = cell;
                for(int i=1; i < values.length; i++)
                    values[i] = this.properties[i-1];
                //System.out.println(Arrays.toString(values));
                structure = (T)ctor.newInstance(values); 
                //System.out.println("Created the instance of "+structure);
            }
            else
                System.out.println(ProteinStructure.class +"  is not assignable from "+proteinToBuild);
            
            return structure;
        }
        //catch(NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        catch(IllegalArgumentException iae) {
            throw iae;
        }
        catch(Exception e) {
            System.out.println("An exception happend when trying to initialize the structure. " +e.toString());
            return null;
            //throw new IllegalArgumentException("The class "+enumType.getSimpleName() + " doesn't inherits " + ExtensibleEnum.class.getSimpleName());
        } 
    }
    
    public <T extends Enzyme> T expressEnzyme() {
        try {
            Constructor ctor;
            T enzyme = null;
            //Is an Enzyme?
            if(Enzyme.class.isAssignableFrom(proteinToBuild)) {
                ctor = proteinToBuild.getConstructors()[0];
                enzyme = (T)ctor.newInstance(this.properties);
            }else
                System.out.println(Enzyme.class +"  is not assignable from "+proteinToBuild);
            
                
            
            return enzyme;
        }
        //catch(NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        catch(IllegalArgumentException iae) {
            throw iae;
        }
        catch(Exception e) {
            System.out.println("An exception happend when trying to initialize the Enzyme. " +e.toString());
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