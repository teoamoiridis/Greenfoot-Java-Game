import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuineaPigWorld1 extends MyWorld
{
    private static final int TILEMAP_OFFSET = 0;
    private GreenfootSound backgroundMusic;
    private boolean isLogoShown = false;
    private boolean isMusicPlaying = false;

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public GuineaPigWorld1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8, 1);
        currentLevel = 1;
        initializeTileMap(TILEMAP_OFFSET);
        initializeTiles();
        backgroundMusic = new GreenfootSound("Journey to the Elven Sanctuary.mp3");
        player = new Player(new Vector(0,1));
        progressBar = new ProgressBar(100, 10, 100);
        gameboard = new Board(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8,currentLevel);
        addObject(player, 300, 200);
        addObject(progressBar, 60, 10);
        addObject(gameboard,(MAP_PIXEL_WIDTH-8)/2, (MAP_PIXEL_HEIGHT-8)/2);
        Board logo = new Board(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8, new GreenfootImage("logobig.jpg"));
        addObject(logo, (MAP_PIXEL_WIDTH-8)/2, (MAP_PIXEL_HEIGHT-8)/2);
    }
    
    public void act(){
        if(isMusicPlaying == false){
            backgroundMusic.playLoop();
            isMusicPlaying = true;
        }
        if(isLogoShown == false){
            Greenfoot.delay(300);
            Board logo = getObjects(Board.class).get(1);
            if(logo!=null){
                removeObject(logo);
            }
            isLogoShown = true;
        }
        super.act();
    }
}
