package RainbowReefGameObjects.Sprite;

import RainbowReefGameObjects.RainbowReefGameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObjectSprites extends RainbowReefGameObject

{
    protected int XStep, YStep, frames, XFrames, YFrames;
    protected int currentFrame = 0;
    private BufferedImage[] imageFrames;

    protected void loadImages() throws IOException {
        this.XStep = image.getWidth() / XFrames;
        this.YStep = image.getHeight() / YFrames;
        this.imageFrames = new BufferedImage[XFrames * YFrames];
        for ( int YIndex = 0; YIndex < YFrames; YIndex++ ) {
            for ( int XIndex = 0; XIndex < XFrames; XIndex++ ) {
                this.imageFrames[YIndex + XIndex] = image.getSubimage( XIndex * XStep, YIndex * YStep, XStep, YStep );
            }
        }
        image = imageFrames[0];
    }

    @Override
    protected void setBufferedImage() throws IOException {
        image = ImageIO.read( new File( resourcePath ) );
    }

    public BufferedImage getFrame( int frame ) {
        return this.imageFrames[frame];
    }

    public int frameCount() {
        return imageFrames.length;
    }

    public int getYstep() {
        return YStep;
    }

    public int getXstep() {
        return XStep;
    }

    @Override
    public void repaint( Graphics graphics ) {
        currentFrame = (currentFrame + 1) % frameCount();
        image = imageFrames[currentFrame];
        Graphics2D graphics2d = ( Graphics2D ) graphics;
        graphics2d.drawImage( image, ( int ) x, ( int ) y, null );
    }

}


