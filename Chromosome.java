import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chromosome here.
 * 
 * @author Frederick Clark 
 * @version May 2, 2012
 */
public class Chromosome extends Organ
{
    public Gene first;
    public Gene last;

    public Chromosome(Organ parentOrgan){
        //31,53
        super(30,30,OrganShape.IMAGE,parentOrgan);
        createSelfImage();
        updateImage(this.getRandomLocation(20));
    }
    
    public void createSelfImage() {
        setImage("chromosome1.gif");
    }
    
    /**
     * Act - do whatever the Chromosome wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
