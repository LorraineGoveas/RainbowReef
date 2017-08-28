package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class DoubleBlock extends Block {
    public DoubleBlock() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block_double.png";
        this.assignID();
        this.setBufferedImage();
        this.setHitBox();
        health = 2;
        score = 5;
        effect = 0;
    }

    public DoubleBlock( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }

    public void takeDamage( int damage ) {
        health -= 1;
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Block1.png";
        try {
            this.setBufferedImage();
        } catch ( Exception e ) {
        }
    }

}
