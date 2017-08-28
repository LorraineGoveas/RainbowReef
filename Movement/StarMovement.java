package Movement;

import RainbowReefGameObjects.RainbowReefGameObject;
import RainbowReefGameObjects.Sprite.Shell;
import RainbowReefGameObjects.Sprite.Star;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StarMovement {
    private static final double DEGREEMODIFIER = 35;
    private static int score = 0;
    private static HashMap<Integer, RainbowReefGameObject> gameObjectMap;
    private static ArrayList<Star> starList;
    private static Shell katch;
    private static int objectEffect;
    private static FileInputStream katchSound, blockSound;
    private static AudioStream katchStream, blockStream;

    private static void initializeSounds() throws IOException
    {
        katchSound = new FileInputStream( "src/RainbowReefResources/Audio/Sound_katch.wav" );
        katchStream = new AudioStream( katchSound );
        blockSound = new FileInputStream( "src/RainbowReefResources/Audio/Sound_block.wav" );
        blockStream = new AudioStream( blockSound );
    }

    public static void controlStar( Shell shell, ArrayList<Star> starArray, HashMap<Integer, RainbowReefGameObject> gameMap ) {
        try { initializeSounds();
        } catch(IOException exception) {}
        gameObjectMap = gameMap;
        starList = starArray;
        katch = shell;
        score = 0;
        objectEffect = 0;

        for ( int index = 0; index < starList.size(); index++ ) {
            if ( !starList.get( index ).isFired() ) {
                starList.get( index ).setXCoordinate( shell.getXCoordinate() + katch.getWidth() / 2 - starList.get( index ).getWidth() / 2 );
                starList.get( index ).setYCoordinate( shell.getYCoordinate() - starList.get( index ).getHeight() );
                return;
            }

            if ( (starList.get( index ).getYCoordinate() + starList.get( index ).getHeight() - 2) > shell.getYCoordinate() ) {
                starList.get( index ).moveVertically();
                starList.get( index ).moveHorizontally();
                if ( starList.get( index ).collisionOccurred( shell ) ) {
                    if ( starList.get( index ).getXCoordinate() < shell.getXCoordinate() ) {
                        starList.get( index ).setXDirection( -1 );
                    } else starList.get( index ).setXDirection( 1 );
                }
                return;
            }

            starList.get( index ).moveVertically();
            if ( !verticalCollisionCheck( starList.get( index ) ) ) starList.get( index ).setSafeZone();

            starList.get( index ).moveHorizontally();
            if ( !horizontalCollisionCheck( starList.get( index ) ) ) starList.get( index ).setSafeZone();
        }
    }

    private static void changeAngle( Star pop ) {
        double relativeLocation;
        relativeLocation = ((pop.getXCoordinate() + pop.getWidth() / 2) - (katch.getXCoordinate() + katch.getWidth() / 2)) / katch.getWidth();
        pop.setCurrentDegrees( ( int ) (270 + DEGREEMODIFIER * relativeLocation) );
        pop.setXDirection( 1 );
    }

    private static boolean verticalCollisionCheck( Star pop ) {
        if ( pop.collisionOccurred( katch ) ) {
            changeAngle( pop );
            pop.changeYDirection();
            AudioPlayer.player.start( katchStream );
            return true;
        }
        if ( objectMapCollisionCheck( pop ) ) {
            pop.changeYDirection();
            pop.placeAtSafeZone();
            return true;
        }
        return false;
    }

    private static boolean horizontalCollisionCheck( Star pop ) {
        if ( objectMapCollisionCheck( pop ) ) {
            pop.placeAtSafeZone();
            pop.changeXDirection();
            return true;
        }
        return false;
    }

    private static boolean objectMapCollisionCheck( Star pop ) {
        for ( int index = 0; index < RainbowReefGameObject.getNumberofObjects(); index++ ) {
            if ( gameObjectMap.containsKey( index ) && pop.collisionOccurred( gameObjectMap.get( index ) ) ) {
                gameObjectMap.get( index ).takeDamage( 1 );
                AudioPlayer.player.start( blockStream );
                if ( gameObjectMap.containsKey( index ) && gameObjectMap.get( index ).isDead() ) {
                    score = gameObjectMap.get( index ).getScore();
                    objectEffect = gameObjectMap.get( index ).getEffect();
                    gameObjectMap.remove( index );
                }
                return true;
            }
        }
        return false;
    }

    public static int getEffect() {
        return objectEffect;
    }

    public static int getScoreAdded() {
        return score;
    }
}
