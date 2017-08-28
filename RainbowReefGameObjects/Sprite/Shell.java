package RainbowReefGameObjects.Sprite;

import java.io.IOException;

public class Shell extends GameObjectSprites {
    private int velocity;

    public Shell() throws IOException {
        resourcePath = "src/RainbowReefResources/Visual/Shell/Katch_strip24.png";
        velocity = 3;
        health = 60;
        XFrames = 24;
        YFrames = 1;

        this.setBufferedImage();
        loadImages();
    }

    public Shell( double x, double y ) throws IOException {
        this();
        this.x = x;
        this.y = y;
        this.setHitBox();
    }

    public void left() {
        x -= velocity;
        setHitBox();
    }

    public void right() {
        x += velocity;
        setHitBox();
    }


}

