package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class PurpleBlock extends Block {
    public PurpleBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block1.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 15;
        effect = 0;
    }

    public PurpleBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }
}
