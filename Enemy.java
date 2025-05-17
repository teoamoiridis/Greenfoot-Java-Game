import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends GuineaPig
{
    private static final String[] SHEET_NAMES = {
        "enemySprite1.png",
        "enemySprite2.png",
        "enemySprite3.png",
        "enemySprite4.png",
    };
    
    public Enemy(Vector movement, GreenfootImage spriteSheet){
        super(movement, spriteSheet);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if( ((MyWorld) getWorld()).isGameStarted == false){
            return;
        }
        updateDirection();
        animate();
        move();
        randomTurn();
        checkWorldEdge();
        checkForPlayer();
    }
    
    public void randomTurn(){
        if(Greenfoot.getRandomNumber(100)<10){
            int direction = getMovement().getDirection();
            direction += Greenfoot.getRandomNumber(31) - 15;
            direction = direction % 360;
            getMovement().setDirection(direction);
        }
    }
    
    public void checkWorldEdge(){
        if(getExactX() >= getWorld().getWidth() -10 || getExactX() < 10){
            getMovement().revertHorizontal();
        }
        if(getExactY() >= getWorld().getHeight() -10 || getExactY() < 10){
            getMovement().revertVertical();
        }
    }
    
    public void checkForPlayer(){
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        double dx = player.getExactX() - getExactX();
        double dy = player.getExactY() - getExactY();
        double distance = Math.sqrt(dx * dx + dy * dy); 
        if (distance < 30){
            ((MyWorld) getWorld()).gameOver();
        }
    }
    
    public void updateDirection(){
        int dir = getMovement().getDirection();
        if(dir >= -45 && dir < 45){
            currentDir = 2;
        }else if(dir >= 45 && dir < 135){
            currentDir = 0;
        }else if(dir >=135 && dir < 225){
            currentDir = 1;
        }else{
            currentDir = 3;
        }
    }
    
    public static Enemy randomEnemy(Vector movement){    
        int index = Greenfoot.getRandomNumber(SHEET_NAMES.length);
        spriteSheet = new GreenfootImage(SHEET_NAMES[index]);
        
        return new Enemy(movement, spriteSheet);
    }
}
