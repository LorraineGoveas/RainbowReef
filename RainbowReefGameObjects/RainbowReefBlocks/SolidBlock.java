package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class SolidBlock extends Block {
    public SolidBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block_solid.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 1;
        score = 0;
        effect = 0;
    }

    public SolidBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }

    public void takeDamage( int damage ) {
    }
}
