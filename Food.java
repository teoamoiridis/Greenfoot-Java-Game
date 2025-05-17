import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Food extends Actor
{
    
    protected int timer = 10*50;
    protected int flashDelay = 20;
    protected boolean isTransparent = false;
    
    /**
     * Act - do whatever the Fruit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkTimer();
    }
    
    public void checkTimer(){
        if(timer < 4*50){
            flash();
        }
        if(timer == 0){
            getWorld().removeObject(this);
        }
        timer--;
    }
    
    public void flash(){
        flashDelay--;
        if(flashDelay == 0){
            if(isTransparent == false){
                getImage().setTransparency(128);
                isTransparent = true;
            }else{
                getImage().setTransparency(255);
                isTransparent = false;
            }
            flashDelay = 20;
        }
    }
    
     public static void spawnFood(MyWorld world, Class<? extends Food> foodClass) {
        int x = Greenfoot.getRandomNumber(world.getWidth());
        int y = Greenfoot.getRandomNumber(world.getHeight());
        try{
            Food food = foodClass.getDeclaredConstructor().newInstance();
            world.addObject(food, x, y);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
