import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuineaPigWorld2 extends MyWorld
{
    private static final int TILEMAP_OFFSET = 4;

    /**
     * Constructor for objects of class World2.
     * 
     */
    public GuineaPigWorld2(Player player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(mapWidth*tileWidth-8, mapHeight*tileHeight-8, 1);
        isGameStarted = false;
        currentLevel = 2;
        initializeTileMap(TILEMAP_OFFSET);
        initializeTiles();
        addObject(player, 300, 200);
        progressBar = new ProgressBar(100, 10, 100);
        addObject(progressBar, 60, 10);
        gameboard = new Board(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8,currentLevel);
        addObject(Enemy.randomEnemy(new Vector(0,1.5)), 200, 50);
        addObject(Enemy.randomEnemy(new Vector(0,1.5)), 100, 150);
        addObject(Enemy.randomEnemy(new Vector(180,1.5)), 450, 350);
        addObject(Enemy.randomEnemy(new Vector(0,1.5)), 450, 50);
        addObject(Enemy.randomEnemy(new Vector(180,1.5)), 550, 300);
        addObject(gameboard,(MAP_PIXEL_WIDTH-8)/2, (MAP_PIXEL_HEIGHT-8)/2);
    }
}
