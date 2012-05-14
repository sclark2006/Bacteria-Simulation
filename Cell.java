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
    public Cytosome soma;
    private Set<Chromosome> genome;

    public Cell(Size size, Shape shape) {
        super(null, size, shape);
    }
    
    public static Cell defaultInstance() {
        Cell cell = new Cell(new Size(150,90), Shape.CIRCLE);
        cell.envelope =  (Envelope) cell.addSubStructure(new Membrane(cell, Shape.CIRCLE));
        cell.soma = (Cytosome) cell.addSubStructure(new Cytosome((Membrane)cell.envelope));
        cell.genome = Cell.initialGenome(cell.soma);
        cell.addSubStructure(new Rybosome(cell.soma));
        return cell;
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
    
    private static Set<Chromosome> initialGenome(ProteinStructure parent) {
        //Creates a Set to store the chromosome created
        Set<Chromosome> initGenome = new HashSet<Chromosome>();
        Chromosome chromosome = new Chromosome(parent);
        //fill the chromosome with the needed genes
        chromosome.add(Gene.BuildDuplicationStarter).
                   add(Gene.BuildChromosomeClonner).
                   add(Gene.BuildDuplicationStopper); 
                    
        chromosome.setParentStructure(parent);
        initGenome.add(chromosome);
        return initGenome;
    }

    @Override
    public void createSelfImage() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
