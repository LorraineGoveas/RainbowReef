package RainbowReefGameObjects.RainbowReefBackgrounds;

import RainbowReefGameObjects.RainbowReefGameObject;

import java.io.IOException;

public class Background extends RainbowReefGameObject {
    public Background() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Background" + sep + "Background1.png";
        this.setBufferedImage();
        this.x = 0;
        this.y = 0;
    }
}
