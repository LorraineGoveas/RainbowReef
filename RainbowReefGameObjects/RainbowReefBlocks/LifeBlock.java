package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class LifeBlock extends Block {
    public LifeBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block_life.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 5;
        effect = 1;

    }

    public LifeBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }

}