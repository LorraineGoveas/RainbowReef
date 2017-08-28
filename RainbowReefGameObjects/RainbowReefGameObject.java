package RainbowReefGameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract public class RainbowReefGameObject {
    protected static final String sep = System.getProperty( "file.separator" );
    protected static int numberOfObjects = 0;
    protected int health = 1;
    protected int score = 0;
    protected double x;
    protected double y;
    protected int objectID;
    protected Rectangle hitBox;
    protected int currentDegrees;
    protected String resourcePath;
    protected BufferedImage image;

    protected int effect;

    public static int getNumberofObjects() {
        return numberOfObjects;
    }

    public int getEffect() {
        return this.effect;
    }

    public void changeCurrentDegrees( int degreeChange ) {
        currentDegrees += degreeChange;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage( int damage ) {
        health -= damage;
    }

    protected void setBufferedImage() throws IOException {
        image = ImageIO.read( new File( resourcePath ) );
    }

    protected void assignID() {
        this.objectID = numberOfObjects;
        numberOfObjects++;
    }

    public int getObjectID() {
        return this.objectID;
    }

    public void setHitBox() {
        hitBox = new Rectangle( ( int ) this.x, ( int ) this.y, image.getWidth(), image.getHeight() );
    }

    public double getXCoordinate() {
        return this.x;
    }

    public void setXCoordinate( double x ) {
        this.x = x;
    }

    public double getYCoordinate() {
        return this.y;
    }

    public void setYCoordinate( double y ) {
        this.y = y;
    }

    public int getWidth() {
        return this.image.getWidth();
    }

    public int getHeight() {
        return this.image.getHeight();
    }

    public int getCurrentDegrees() {
        return this.currentDegrees;
    }

    public void setCurrentDegrees( int degrees ) {
        currentDegrees = degrees;
    }

    public double getCurrentRadians() {
        return Math.toRadians( currentDegrees );
    }

    public Rectangle getHitBox() {
        return this.hitBox;
    }

    public int getScore() {
        return this.score;
    }

    public boolean collisionOccurred( RainbowReefGameObject otherObject ) {
        return hitBox.intersects( otherObject.getHitBox() );
    }

    public void repaint( Graphics graphics ) {
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        graphics2d.drawImage( image, ( int ) x, ( int ) y, null );
    }
}