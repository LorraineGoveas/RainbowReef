package RainbowReefWorld;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame( JPanel RainbowReefWorldPanel ) {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );
        this.add( RainbowReefWorldPanel );
        setVisible( true );
        this.pack();
    }

}
