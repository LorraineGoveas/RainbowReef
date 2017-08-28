package Movement;

import RainbowReefGameObjects.Sprite.Shell;
import RainbowReefGameObjects.Sprite.Star;

import java.awt.event.KeyEvent;

public class ShellMovement {
    public static void controlShell( Shell shell, Star star, KeyboardInput keyboardInput ) {
        if ( shell.getXCoordinate() > 20 && keyboardInput.keyArray[KeyEvent.VK_LEFT] ) {
            shell.left();
        }
        if ( (shell.getXCoordinate() + shell.getWidth()) < 620 && keyboardInput.keyArray[KeyEvent.VK_RIGHT] ) {
            shell.right();
        }
        if ( keyboardInput.keyArray[KeyEvent.VK_ENTER] ) {
            star.setFired();
        }
    }
}
