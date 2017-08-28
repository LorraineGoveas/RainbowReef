package RainbowReefGameObjects.RainbowReefBlocks;

import java.io.IOException;

public class Wall extends RainbowReefGameObjects.RainbowReefBlocks.Block {
    public Wall() throws IOException {
        resourcePath = "src" + sep + "RainbowReefResources" + sep + "Visual" + sep + "Blocks" + sep + "Wall.png";
        this.assignID();
        this.setBufferedImage();
        score = 0;
        effect = 0;
    }

    public Wall( int xCoordinate, int yCoordinate ) throws IOException {
        this();
        this.setXCoordinate( xCoordinate );
        this.setYCoordinate( yCoordinate );
        this.setHitBox();
    }

    public void takeDamage( int damage ) {
    }
}
