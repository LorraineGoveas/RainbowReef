package Testing;

import java.io.IOException;
import RainbowReefWorld.RainbowReefWorldPanel;
import RainbowReefWorld.GameFrame;

/**
 * Created by lorraine on 5/4/17.
 */
public class RainbowReefWorldTest {
    public static void main( String[] args ) throws IOException
    {
        new GameFrame( new RainbowReefWorldPanel() );
    }
}
