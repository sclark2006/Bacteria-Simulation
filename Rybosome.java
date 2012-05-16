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
         genome = getCell().getGenome().iterator();
    }
    
       
    @Override
    public void createSelfImage() {
        this.getImage().setColor(java.awt.Color.CYAN );
        super.fillImage();
    }
    
   @Override
    public void onAddedToParent() {
        this.location = this.randomLocation(20);
         updateImage();
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
        if(currentGene != null) {
            if (currentGene != null && currentGene.isActive()) {  
                //Create a protein from the current Gene             
                if(currentGene.getProteinToBuild().isAssignableFrom(ProteinStructure.class)) {
                    ProteinStructure structure = currentGene.expressStructure(this.getCell());
                    ProteinStructure parent = this.getCell().getSubStructureByType(structure.getParentType());
                    parent.addSubStructure(structure);
                }else if(currentGene.getProteinToBuild().isAssignableFrom(Enzyme.class)) {
                    ((Cytosome)this.parentStructure).getEnzymeQueue().add(currentGene.expressEnzyme());
                }
                //parentStructure

            }
        //Updates the current gene
        
        currentGene = currentGene.next;
        }
    }

    @Override
    public Class<? extends ProteinStructure> getParentType() {
        return Cytosome.class;
    }

}
