package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class BlueBlock extends Block {
    public BlueBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block6.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 5;
        effect = 0;
    }

    public BlueBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }
}
