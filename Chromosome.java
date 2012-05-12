
/**
 * Write a description of class Chromosome here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public final class Chromosome extends ProteinStructure
{
    public Gene first;
    public Gene last;

    public Chromosome(Cell cell, ProteinStructure parentOrgan,Size size, Shape shape ){
         super( cell,parentOrgan,size,shape);
         createSelfImage();
         updateImage(this.getRandomLocation(20));
    }
    public Chromosome(Cytosome cytosome){
        this(cytosome.getCell(),cytosome,new Size(30,30),Shape.IMAGE);
    }

    @Override
    public void createSelfImage() {
        setImage("chromosome1.gif");
    }
    
    /**
     * Act - do whatever the Chromosome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here.
    }

    public Chromosome insertBegining(Gene newGene) {
        if(this.first == null) {            
            first = newGene;
            last = newGene;            
            newGene.chromosome = this;
            newGene.previous = null;
            newGene.next = null;
        }else 
          first.insertBefore(newGene);
          
        return this;
    }
    
    public Chromosome insertEnd(Gene newGene) {
        if(this.last == null)
            insertBegining(newGene);
        else
            last.insertAfter(newGene);
        return this;
    }
    
    public Chromosome add(Gene newGene) {
        return insertEnd(newGene);
    }
    
    public Chromosome remove(Gene gene) {
        if(gene.previous == null)
            first = gene.next;
        else
            gene.previous.next = gene.next;
        
        if (gene.next == null)
            last = gene.previous;
        else
            gene.next.previous = gene.previous;
        
        gene.chromosome = null;
        gene.previous = null;
        gene.next = null;
        System.gc();
        
        return this;
    }
    
    public void mutate() {
    }
}
