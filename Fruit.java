import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit extends Food
{
    public Fruit(){
        int number = Greenfoot.getRandomNumber(5) + 1;
        setImage("Fruit" + number + ".png");
    }
}
