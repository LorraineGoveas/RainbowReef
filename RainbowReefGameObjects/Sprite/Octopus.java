package RainbowReefGameObjects.Sprite;

import java.io.IOException;

public class Octopus extends GameObjectSprites {
    public Octopus() throws IOException {
        resourcePath = "src/RainbowReefResources/Visual/Octopus/Bigleg_small_strip24.png";
        this.assignID();
        this.setBufferedImage();
        YFrames = 1;
        XFrames = 24;
        loadImages();
        health = 1;
        score = 60;
        effect = 3;
    }

    public Octopus( double x, double y ) throws IOException {
        this();
        this.x = x;
        this.y = y;
        this.setHitBox();
    }
}

