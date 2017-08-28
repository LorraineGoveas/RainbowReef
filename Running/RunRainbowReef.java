package Running;

import RainbowReefWorld.GameFrame;
import RainbowReefWorld.RainbowReefWorldPanel;

import java.io.IOException;

public class RunRainbowReef {
    public static void main( String[] args ) throws IOException {
        new GameFrame( new RainbowReefWorldPanel() );
    }
}
