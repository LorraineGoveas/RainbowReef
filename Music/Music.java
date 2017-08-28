package Music;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import static java.lang.Thread.sleep;

public class Music implements Runnable
{
    AudioStream musicStream;
    FileInputStream musicSound;

    @Override
    public void run()
    {
        while ( 1 == 1 ) {
            try {
                musicSound = new FileInputStream( "src/RainbowReefResources/Audio/Music.wav" );
                musicStream = new AudioStream( musicSound );
                AudioPlayer.player.start( musicStream );
                sleep( (2 * 60 + 24) * 1000 );
            } catch ( Exception e ) {}
        }
    }
}
