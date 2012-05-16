import java.util.HashSet;
import java.util.Set;

/**
 * Write a description of class Cell here.
 * 
 * @author Frederick Clark
 * @version May 04, 2012
 * 
 */
public class Cell extends ProteinStructure
{
    public Envelope envelope;
    public Soma soma;
    private Set<Chromosome> genome;
    
   public Cell(Cell parentCell, Size size, Shape shape) {
        super(parentCell, size, shape);
        this.location = new Location(0,0);
    }
   
    public Cell(Size size, Shape shape) {
        super(null, size, shape);
        this.location = new Location(0,0);
    }
    
    public static Cell defaultInstance() {
        
        Cell cell = Gene.BuildCellSpace.expressStructure(null);
        cell.envelope =  (Envelope) cell.addSubStructure(Gene.BuildMembrane.expressStructure(cell));
        cell.soma = (Cytosome) cell.addSubStructure(Gene.BuildCytosome.expressStructure(cell));
        cell.genome = Cell.initialGenome(cell.soma);
        cell.addSubStructure(Gene.BuildRybosome.expressStructure(cell) );
        cell.addSubStructure(Gene.BuildMotionStructure.expressStructure(cell) );
        
        return cell;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public Soma getSoma() {
        return soma;
    }
        
    
    public Set<Chromosome> getGenome() {
        return this.genome;
    }
 
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
         for(ProteinStructure organ : getSubStructures()) 
         {
             organ.act();
         }
    }
    
    private static Set<Chromosome> initialGenome(Soma parent) {
        //Creates a Set to store the chromosome created
        Set<Chromosome> initGenome = new HashSet<Chromosome>();
        Chromosome chromosome = Gene.BuildChromosome.expressStructure(parent.getCell()); //new Chromosome(parent);
        //fill the chromosome with the needed genes
        chromosome.add(Gene.BuildMotionStarter);
                   //add(Gene.BuildChromosomeClonner).
                   //add(Gene.BuildDuplicationStopper); 
        parent.addSubStructure(chromosome);        
        initGenome.add(chromosome);
        return initGenome;
    }

    @Override
    public void createSelfImage() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cell.class;
    }
}
