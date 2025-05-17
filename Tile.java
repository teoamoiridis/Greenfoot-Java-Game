import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    
    private int tileHeight = 16;
    private int tileWidth = 16;
    private int row;
    private int col;
    
    public Tile(int type, GreenfootImage tileSet){
        switch(type){
            case 1:
                row=0; col=0; break;
            case 2:
                row=1; col=0; break;
            case 3:
                row=2; col=0; break;
            case 4:
                row=0; col=8; break;
            case 5:
                row=6; col=0; break;
            case 6:
                row=7; col=0; break;
            case 7:
                row=8; col=0; break;
        }
        GreenfootImage tileImage = new GreenfootImage(tileWidth, tileHeight);
        tileImage.drawImage(tileSet,-col*tileWidth, 
                                    -row*tileHeight);
        setImage(tileImage);
    }
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
