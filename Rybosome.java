/**
 * Write a description of class Rybosome here.
 * 
 * @author Frederick Clark 
 * @version May 5, 2012. Creation of the class
 */
public final class Rybosome extends ProteinStructure
{
    private java.util.Iterator<Chromosome> genome;
    private Chromosome currentChromosome;
    private Gene currentGene;
    
    public Rybosome(Cell cell, Size size, Shape shape){
         super(cell,size,shape);
         createSelfImage();
         updateImage(this.getRandomLocation(20));
    }
    
    public Rybosome(Cytosome cytosome) {
        this(cytosome.getCell(),new Size(6,6),Shape.CIRCLE );
        genome = getCell().getGenome().iterator();
    }
    
    @Override
    public void createSelfImage() {
        this.getImage().setColor(java.awt.Color.CYAN );
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
            Protein protein = null;
            if(currentGene.getProteinToBuild().isAssignableFrom(ProteinStructure.class)) {
                protein = currentGene.expressOrgan(this.getCell(), parentStructure);
            }else if(currentGene.getProteinToBuild().isAssignableFrom(Enzyme.class)) {
                protein = currentGene.expressEnzyme();
                if(parentStructure.getClass().equals(Cytosome.class))
                    ((Cytosome)parentStructure).getEnzymeQueue().add((Enzyme)protein);
            }
            //parentStructure
            
        }
        //Updates the current gene
        currentGene = currentGene.next;
    }    
}
