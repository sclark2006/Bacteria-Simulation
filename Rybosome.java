/**
 * Write a description of class Rybosome here.
 * 
 * @author Frederick Clark 
 * @version May 5, 2012. Creation of the class
 */
public final class Rybosome extends Organ
{
    public static final int WIDTH = 6;
    public static final int HEIGHT = 6;
    private java.util.Iterator<Chromosome> genome;
    private Chromosome currentChromosome;
    private Gene currentGene;
    
    public Rybosome(Cytosome cytosome) {
        super(WIDTH,HEIGHT,OrganShape.TRIANGLE,cytosome);
        genome = getCell().getGenome().iterator();
        createSelfImage();
        updateImage(this.getRandomLocation(20));
    }
    
    @Override
    public void createSelfImage() {
        this.getImage().setColor(java.awt.Color.ORANGE );
        super.fillImage();
    }
    
    /**
     * Act - do whatever the Rybosome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here
        //Updates teh current chromosome
        if(currentChromosome == null)
        {
            currentChromosome = genome.next();
            currentGene = currentChromosome.first;
        }
        
        if(currentGene.isActive()) {
            //Create a protein from the current Gene
            Protein protein = currentGene.express();
            //Is an Organ?
            if(protein.getClass().isAssignableFrom(Organ.class)) {
                
            } else
            //Is an Enzyme?
            if(protein.getClass().isAssignableFrom(Enzyme.class)) {
                
            }
        }
        //Updates the current gene
        currentGene = currentGene.next;
    }    
}
