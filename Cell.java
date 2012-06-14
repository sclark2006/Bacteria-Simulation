import greenfoot.World;
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
    private Set<MotionStructure> motionStructures;
     
   public Cell(Cell parentCell, Size size, Shape shape) {
        super(parentCell, size, shape);
        this.location = new Location(0,0);
        motionStructures =  new HashSet<MotionStructure>();
    }
   
    public Cell(Size size, Shape shape) {
        this(null, size, shape);        
    }
    
    public static Cell defaultInstance() {
        
        Cell cell = Gene.BuildCellSpace.expressStructure(null);
        cell.envelope =  (Envelope) cell.addSubStructure(Gene.BuildMembrane.expressStructure(cell));
        cell.soma = (Cytosome) cell.addSubStructure(Gene.BuildCytosome.expressStructure(cell));
        cell.genome = Cell.initialGenome(cell.soma);
        cell.addSubStructure(Gene.BuildRybosome.expressStructure(cell) );
        cell.motionStructures.add((MotionStructure)cell.addSubStructure(Gene.BuildMotionStructureAtWest.expressStructure(cell)));
        
        return cell;
    }
    
    @Override
    public void addedToWorld(World world) {
        for(MotionStructure motor: motionStructures) {
            world.addObject(motor, this.getX(), this.getY());
            updateMotor(motor);
        }
    }
    
    private void updateMotor(MotionStructure motor) {        
        motor.setRotation(this.getRotation());
        motor.setLocation(this.getX(), this.getY());
        motor.move((getImage().getWidth() + motor.getImage().getWidth()) / 2);
    }
    
       @Override
    public void setRotation(int rotation) {
        super.setRotation(rotation);
        for(MotionStructure motor: motionStructures) {
            updateMotor(motor);
        }
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        for(MotionStructure motor: motionStructures) {
            updateMotor(motor);
        }
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
    
    public boolean isAtWorldLimits() {
        return getX() > getWorld().getWidth() - this.getSize().getWidth() || 
               getX()== 0 || 
               getY() > getWorld().getHeight() - this.getSize().getHeight()||
               getY() == 0;
    }
}
