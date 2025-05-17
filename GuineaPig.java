import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuineaPig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GuineaPig extends SmoothMover
{
    protected static GreenfootImage spriteSheet;
    protected GreenfootImage[][] animations;
    protected int frameHeight = 48;
    protected int frameWidth = 48;
    protected int currentDir = 2;
    protected int currentFrame = 0;
    protected final int animationSpeed = 20;
    protected int animationDelay = animationSpeed;
    
    
    public GuineaPig(Vector movement, GreenfootImage spriteSheet)
    {
        this.spriteSheet = spriteSheet;
        animations = new GreenfootImage[4][3];
        initializeAnimations();
        addForce(movement);
        setImage(animations[currentDir][0]);
    }
    
    public void initializeAnimations()
    {
        for (int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                animations[i][j] = new GreenfootImage(frameWidth,frameHeight);
                animations[i][j].drawImage(spriteSheet, -j*frameWidth,
                                                        -i*frameHeight);
            }
        }
    }
    
    public void animate()
    {
        animationDelay++;
        if(animationDelay > animationSpeed){
            setImage(animations[currentDir][currentFrame]);
            currentFrame++;
            if(currentFrame==3){
                currentFrame = 0;
            }
            animationDelay = 0;
        }
    }
}
