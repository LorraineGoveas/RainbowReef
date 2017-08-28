package RainbowReefGameObjects.Sprite;

import java.io.IOException;

public class Star extends GameObjectSprites {
    protected int velocity;
    protected double safeX;
    protected double safeY;
    protected int XDirection = 1;
    protected int YDirection = 1;
    protected boolean fired;

    public Star() throws IOException {
        resourcePath = "src/RainbowReefResources/Visual/Star/Pop_strip45.png";
        currentDegrees = 270;
        health = 110;
        velocity = 3;
        XFrames = 45;
        YFrames = 1;
        this.setBufferedImage();
        loadImages();
    }

    public Star( double x, double y ) throws IOException {
        this();
        this.x = x;
        this.y = y;
        this.setHitBox();
        this.setSafeZone();
    }

    public void moveVertically() {
        y = y + YDirection * velocity * Math.sin( getCurrentRadians() );
        setHitBox();
    }

    public void moveHorizontally() {
        x = x + XDirection * velocity * Math.cos( getCurrentRadians() );
        setHitBox();
    }

    public void setSafeZone() {
        this.safeX = this.getXCoordinate();
        this.safeY = this.getYCoordinate();
    }

    public void placeAtSafeZone() {
        this.x = safeX;
        this.y = safeY;
        this.setHitBox();
    }

    public void setXDirection( int direction ) {
        XDirection = direction;
    }

    public void setFired() {
        fired = true;
    }

    public boolean isFired() {
        return fired;
    }

    public void changeXDirection() {
        this.XDirection *= -1;
    }

    public void changeYDirection() {
        this.YDirection *= -1;
    }

}
