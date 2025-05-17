import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GuineaPig
{
    
    public Player(Vector movement){
        super(movement, new GreenfootImage("mainActorSprite.png"));
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if( ((MyWorld) getWorld()).isGameStarted == false){
            return;
        }
        checkKeyPress();
        move();
        animate();
        checkToEatFruit();
    }
    
    public void checkKeyPress()
    {
        String Key = Greenfoot.getKey();
        Vector movement = getMovement();
        
        if(Key != null){
            animationDelay = animationSpeed;
            if(Key.equals("right")){
                movement.setNeutral();
                addForce(new Vector(0,1));
                currentDir = 2;
            }
            if(Key.equals("down")){
                movement.setNeutral();
                addForce(new Vector(90,1));
                currentDir = 0;
            }
            if(Key.equals("left")){
                movement.setNeutral();
                addForce(new Vector(180,1));
                currentDir = 1;
            }
            if(Key.equals("up")){
                movement.setNeutral();
                addForce(new Vector(270,1));
                currentDir = 3;
            }
        }
    }
    
    public void checkToEatFruit()
    {
        Fruit fruit = (Fruit) getOneIntersectingObject(Fruit.class);
        
        if(fruit !=null){
            removeTouching(Fruit.class);
            ((MyWorld) getWorld()).eat();
        }
    }
}
