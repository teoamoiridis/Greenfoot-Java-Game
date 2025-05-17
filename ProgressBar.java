import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgressBar extends Actor
{
    private int maxValue;
    private int currentValue;
    private int width;
    private int height;
    private boolean isFull = false;
    private GreenfootImage image;
    
    public ProgressBar(int width, int height, int maxValue)
    {
        this.width = width;
        this.height = height;
        this.maxValue = maxValue;
        this.currentValue = 0;
        this.image = makeImage();
    }
    
    public GreenfootImage makeImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
        return(image);
    }
    
    public void updateImage()
    {
        image.setColor(Color.GREEN);
        image.fillRect(0, 0, currentValue, height);
    }
    
    public void increase(int amount)
    {
        currentValue += amount;
        if (currentValue > maxValue){
            currentValue = maxValue;
        }
        updateImage();
    }
    
    public boolean isFull(){
        if(currentValue == maxValue){
            currentValue = 0;
            isFull = true;
            return isFull;
        }
        return isFull;
    }
    
    /**
     * Act - do whatever the ProgressBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
