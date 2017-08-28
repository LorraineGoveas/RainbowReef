package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class YellowBlock extends Block {
    public YellowBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block2.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 35;
        effect = 0;
    }

    public YellowBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }
}
