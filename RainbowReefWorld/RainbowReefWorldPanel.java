package RainbowReefWorld;

import GameClock.Clock;
import Maps.Map;
import Movement.KeyboardInput;
import Movement.ShellMovement;
import Movement.StarMovement;
import Music.Music;
import RainbowReefGameObjects.RainbowReefBackgrounds.Background;
import RainbowReefGameObjects.RainbowReefGameObject;
import RainbowReefGameObjects.Sprite.Shell;
import RainbowReefGameObjects.Sprite.Star;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public final class RainbowReefWorldPanel extends JPanel implements Observer {
    private static int mapNumber = 0;
    private static HashMap<Integer, RainbowReefGameObject> gameObjectMap;
    private int height;
    private int width;
    private int playerScore = 0;
    private int playerLives = 3;
    private Dimension dimension;
    private BufferedImage livesImage;
    private BufferedImage congratulations;
    private RainbowReefGameObject background;
    private ArrayList<Star> starArray;
    private Shell shell;
    private KeyboardInput keyboardInput = new KeyboardInput();
    private Clock gameClock = new Clock();
    private Music music = new Music();
    private boolean playerWin = false;

    public RainbowReefWorldPanel() throws IOException {
        initialize( mapNumber );
        keyboardInput.addObserver( this );
        this.addKeyListener( keyboardInput );

        gameClock.addObserver( this );
        new Thread( this.gameClock ).start();
        new Thread( this.music ).start();
    }

    private void initialize( int mapNumber ) throws IOException {
        gameObjectMap = Map.createWallMap( mapNumber );
        width = Map.getWidth() * 20;
        height = Map.getHeight() * 20;
        livesImage = ImageIO.read( new File( "src/RainbowReefResources/Visual/Star/Pop_strip45.png" ) );
        livesImage = livesImage.getSubimage( 0, 0, livesImage.getWidth() / 45, livesImage.getHeight() );
        congratulations = ImageIO.read( new File( "src/RainbowReefResources/Visual/Blocks/Congratulation.png" ) );

        this.dimension = new Dimension( width, height );
        this.setPreferredSize( dimension );
        this.setSize( dimension );
        this.setFocusable( true );
        this.requestFocusInWindow();

        starArray = new ArrayList<Star>();
        shell = new Shell( Map.getShellXStart(), Map.getShellYStart() );
        starArray.add( new Star( shell.getXCoordinate(), shell.getYCoordinate() ) );
        background = new Background();
    }

    public void update( Observable observable, Object object ) {
        ShellMovement.controlShell( shell, starArray.get( 0 ), keyboardInput );
        StarMovement.controlStar( shell, starArray, gameObjectMap );
        playerScore += StarMovement.getScoreAdded();
        switch ( StarMovement.getEffect() ) {
            case 1:
                playerLives++;
                break;
            case 2:
                try {
                    Star blockStar = new Star( starArray.get( 0 ).getXCoordinate(), starArray.get( 0 ).getYCoordinate() );
                    starArray.add( blockStar );
                    blockStar.setFired();
                } catch ( Exception e ) {
                }
                break;
            case 3:
                mapNumber++;
                if ( mapNumber == Map.getNumberMaps() ) {
                    playerWin = true;
                    break;
                }
                try {
                    initialize( mapNumber );
                } catch ( Exception e ) {
                }
                break;
        }

        for ( int index = 0; index < starArray.size(); index++ ) {
            if ( starArray.get( index ).getYCoordinate() > height ) {
                starArray.remove( index );
                if ( starArray.isEmpty() ) {
                    playerLives--;
                    try {
                        FileInputStream lossSound = new FileInputStream( "src/RainbowReefResources/Audio/Sound_lost.wav" );
                        AudioStream lossStream = new AudioStream( lossSound );
                        AudioPlayer.player.start( lossStream );
                        starArray.add( new Star( shell.getXCoordinate(), shell.getYCoordinate() ) );
                    } catch ( Exception e ) {
                    }
                }
            }
            this.repaint();
        }
    }

    public void paintComponent( Graphics graphics ) {
        super.paintComponent( graphics );
        background.repaint( graphics );

        for ( int i = 0; i < RainbowReefGameObject.getNumberofObjects(); i++ ) {
            if ( gameObjectMap.containsKey( i ) ) gameObjectMap.get( i ).repaint( graphics );
        }
        graphics.setFont( new Font( "Sans Serif", Font.BOLD, 12 ) );
        graphics.setColor( Color.CYAN );
        graphics.drawString( "Lives:", width / 4, 15 );
        for ( int index = 1; index <= playerLives; index++ ) {
            Image currentLivesImage = livesImage.getScaledInstance( 17, 17, 0 );
            graphics.drawImage( currentLivesImage, (width / 4 + 30 + index * 20), 0, null );
        }
        shell.repaint( graphics );
        for ( int index = 0; index < starArray.size(); index++ ) {
            starArray.get( index ).repaint( graphics );
        }
        drawScore( graphics );
        if ( playerLives == 0 ) {
            gameOver( graphics );
        }
        if ( playerWin ) gameWin( graphics );
    }

    private void drawScore( Graphics graphics ) {
        graphics.setColor( Color.CYAN );
        graphics.setFont( new Font( "Sans Serif", Font.BOLD, 12 ) );
        graphics.drawString( "Score:" + playerScore, 20, 15 );
    }

    private void gameOver( Graphics graphics ) {
        graphics.setFont( new Font( "Copperplate Gothic Light", Font.BOLD, 40 ) );

        graphics.setColor( Color.BLACK );
        graphics.fillRect( 0, 0, width, height );

        graphics.setColor( Color.CYAN );
        graphics.drawString( "Game Over", (width / 2) - 150, height / 2 );


        gameClock.deleteObservers();
        this.removeKeyListener( keyboardInput );
    }

    private void gameWin( Graphics graphics ) {
        graphics.drawImage( congratulations, 0, 0, null );
        gameClock.deleteObservers();
        this.removeKeyListener( keyboardInput );
    }


}
