import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends Actor
{
    private int width;
    private int height;
    private int fontSize = 18;
    private GreenfootImage image;
    private Map<Integer, Runnable> levelBoards = new HashMap<>();
    
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        image = new GreenfootImage(width, height);
        createImage();
    }
    
    public Board(int width, int height, GreenfootImage logo){
        this.width = width;
        this.height = height;
        image = new GreenfootImage(width, height);
        createImage();
        logo.scale(240, 400);
        image.drawImage(logo, 150, 0);
    }
    
    public Board(int width, int height, int level){
        this.width = width;
        this.height = height;
        image = new GreenfootImage(width, height);
        createImage();
        handleLevel(level);
    }
    
    private void handleLevel(int level){
        levelBoards.put(1, this::fillContent1);
        levelBoards.put(2, this::fillContent2);
        Runnable method = levelBoards.get(level);
        method.run();
    }
    
    private void createImage(){
        image.setColor(new Color(128,128,128, 255));
        image.fillRect(0, 0, width, height);
        image.setColor(new Color(51, 51, 51, 255));
        image.fillRect(10, 10, width-20, height-20);
        setImage(image);
        
        Font font = new Font("Arial", false, false, fontSize);
        image.setFont(font);
        image.setColor(Color.WHITE);
    }
    
    private void fillContent1(){
        image.drawString("Welcome to Hungry Guinea Pig! You play as Roza, a female guinea", 20, 40);
        image.drawString("pig. Roza is very hungry. But be careful! Guinea pigs need a healthy", 20, 70);
        image.drawString("diet. You should feed Roza plenty of veggies:", 20, 100);
        image.setColor(new Color(139,0,0, 255));
        image.drawString("Bell peppers", 20, 130);
        image.setColor(new Color(255,87,34,255));
        image.drawString("Carrots", 20, 160);
        image.setColor(new Color(50,205,50,255));
        image.drawString("Lettuce", 20, 190);
        image.setColor(new Color(34,139,34,255));
        image.drawString("Cucumbers", 20, 220);
        image.setColor(Color.WHITE);
        image.drawString("You can also feed Roza fruits, but dont overdo it! Fruits contain a lot", 20, 250);
        image.drawString("sugar", 20, 280);
        image.setColor(new Color(255,0,0,255));
        image.drawString("Strawberries", 20, 310);
        image.setColor(Color.WHITE);
        image.drawString("Press Enter to continue", 20, 370);
    }
    
    private void fillContent2(){
        image.drawString("Welcome to Level 2", 20, 40);
        image.drawString("Be careful, Roza is over 1 years old! Female guinea pigs that are over", 20, 70);
        image.drawString("1 year old should NEVER breed! Their bones have harden and if they", 20, 100);
        image.drawString("get pregnant they will die! Avoid those nasty male guinea pigs at all",20, 130);
        image.drawString("costs!", 20, 160);
        image.drawString("Press Enter to continue", 20, 370);
    }
    
    public void gameOver(){
        Font font = image.getFont();
        font = font.deriveFont(48);
        image.setFont(font);
        image.drawString("Game Over!", 170, 200);
    }
    
    public void victory(){
        image.drawString("You Won! Congratulations!", 180, 150);
        image.drawString("In loving memory of Roza and Julian!", 20, 370);
    }
}
