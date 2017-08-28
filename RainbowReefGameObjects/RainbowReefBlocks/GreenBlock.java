package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class GreenBlock extends Block {
    public GreenBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block4.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 10;
        effect = 0;
    }

    public GreenBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }
}