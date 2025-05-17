import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MyWorld extends World
{
    protected Player player;
    protected ProgressBar progressBar;
    protected Board gameboard;
    GreenfootSound crunchS = new GreenfootSound("crunch1.mp3");
    protected GreenfootImage tileSet = new GreenfootImage("grass_tileset_16x16.png");
    protected static int tileWidth = 16;
    protected static int tileHeight = 16;
    protected static int mapWidth = 38;
    protected static int mapHeight = 25;
    protected static final int MAP_PIXEL_WIDTH = tileWidth*mapWidth;
    protected static final int MAP_PIXEL_HEIGHT = tileHeight*mapHeight;
    protected int[][] tileMap = new int[mapHeight][mapWidth];
    protected int maxFood = 5;
    protected int currentLevel;
    protected final int MAXLEVEL = 2;
    protected boolean isGameStarted = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int width, int height, int cellSize)
    {    
        super(width, height, cellSize);
    }
    
    public void act(){
        removeBoard();
        if(isGameStarted == false){
            return;
        }
        spawnFood();
        checkWinCondition();
    }
    
    public void spawnFood(){
        List<Food> foods = getObjects(Food.class);
        int currentFood = foods.size();
        if(currentFood<maxFood){
            Food.spawnFood(this,Fruit.class);
        }
    }
    
    public void eat()
    {
        crunchS.play();
        progressBar.increase(10);
    }
    
    public void removeBoard(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.start();
            isGameStarted = true;
            removeObject(gameboard);
        }
    }
    
    public void initializeTileMap(int offset){
        Random rand = new Random();
        for(int i=0; i<mapHeight; i++){
            for(int j=0; j<mapWidth; j++){
                tileMap[i][j] = rand.nextInt(3)+1+offset;
            }
        }     
    }
    
    public void initializeTiles(){
        for(int i=0; i<mapHeight; i++){
            for(int j=0; j<mapWidth; j++){
                int type = tileMap[i][j];
                Tile tile = new Tile(type, tileSet);
                addObject(tile, j*tileWidth, i*tileHeight);
            }
        }
    }
    
    public void checkWinCondition(){
        if(progressBar.isFull()){
            if(currentLevel < MAXLEVEL){
                Greenfoot.setWorld(new GuineaPigWorld2(player));
            }else{
                Board victoryBoard = new Board(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8);
                victoryBoard.victory();
                addObject(victoryBoard,(MAP_PIXEL_WIDTH-8)/2, (MAP_PIXEL_HEIGHT-8)/2);
                Greenfoot.stop();
            }
        }
    }
    
    public void gameOver(){
        Board gameOverBoard = new Board(MAP_PIXEL_WIDTH-8, MAP_PIXEL_HEIGHT-8);
        gameOverBoard.gameOver();
        addObject(gameOverBoard,(MAP_PIXEL_WIDTH-8)/2, (MAP_PIXEL_HEIGHT-8)/2);
        Greenfoot.stop();
    }
}
