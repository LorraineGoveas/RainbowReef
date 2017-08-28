package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class TurquoiseBlock extends Block {
    public TurquoiseBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block5.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 30;
        effect = 0;
    }

    public TurquoiseBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }
}
