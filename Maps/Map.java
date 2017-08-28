package Maps;

import RainbowReefGameObjects.RainbowReefBlocks.*;
import RainbowReefGameObjects.RainbowReefGameObject;
import RainbowReefGameObjects.Sprite.Octopus;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;


public class Map {
    protected static final String sep = System.getProperty( "file.separator" );
    protected static int width;
    protected static int height;
    protected static String[] mapPaths = {
            ("src" + sep + "Maps" + sep + "RainbowReefMap.txt"),
            ("src" + sep + "Maps" + sep + "RainbowReefMap2.txt"),
            ("src" + sep + "Maps" + sep + "RainbowReefMap3.txt"),
            ("src" + sep + "Maps" + sep + "RainbowReefMap4.txt")
    };
    protected static int shellX, shellY, starX, starY;
    private static char[][] levelMap;

    public static String getMap( int mapNumber ) {
        return mapPaths[mapNumber];
    }

    public static char[][] parseLevelFile( String resourceLocation ) {
        Path path = FileSystems.getDefault().getPath( resourceLocation );
        try {
            java.util.List<String> levelRows = Files.readAllLines( path );
            height = levelRows.size();
            width = levelRows.get( 0 ).length();

            levelMap = new char[width][height];
            for ( int heightIndex = 0; heightIndex < height; heightIndex++ ) {
                String row = levelRows.get( heightIndex );
                for ( int widthIndex = 0; widthIndex < width; widthIndex++ ) {
                    char currentCharacter = row.charAt( widthIndex );

                    levelMap[widthIndex][heightIndex] = currentCharacter;
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return levelMap;
    }

    public static HashMap createWallMap( int mapNumber ) throws IOException {
        HashMap<Integer, RainbowReefGameObject> gameObkectMap = new HashMap();
        try {
            parseLevelFile( Map.getMap( mapNumber ) );
            for ( int heightIndex = 0; heightIndex < height; heightIndex++ ) {
                for ( int widthIndex = 0; widthIndex < width; widthIndex++ ) {
                    switch ( levelMap[widthIndex][heightIndex] ) {
                        case 'a':
                            Wall wall = new Wall( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( wall.getObjectID(), wall );
                            break;

                        case 'b':
                            BlueBlock blue = new BlueBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( blue.getObjectID(), blue );
                            break;

                        case 'c':
                            RedBlock red = new RedBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( red.getObjectID(), red );
                            break;

                        case 'd':
                            YellowBlock yellow = new YellowBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( yellow.getObjectID(), yellow );
                            break;

                        case 'e':
                            GreenBlock green = new GreenBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( green.getObjectID(), green );
                            break;

                        case 'f':
                            PurpleBlock purple = new PurpleBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( purple.getObjectID(), purple );
                            break;

                        case 'g':
                            TanBlock tan = new TanBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( tan.getObjectID(), tan );
                            break;

                        case 'h':
                            SolidBlock solid = new SolidBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( solid.getObjectID(), solid );
                            break;

                        case 'i':
                            TurquoiseBlock turquoise = new TurquoiseBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( turquoise.getObjectID(), turquoise );
                            break;

                        case 'j':
                            SplitBlock split = new SplitBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( split.getObjectID(), split );
                            break;

                        case 'k':
                            LifeBlock life = new LifeBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( life.getObjectID(), life );
                            break;

                        case 'l':
                            DoubleBlock doubleBlock = new DoubleBlock( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( doubleBlock.getObjectID(), doubleBlock );
                            break;
                        case 'o':
                            Octopus octopus = new Octopus( widthIndex * 20, heightIndex * 20 );
                            gameObkectMap.put( octopus.getObjectID(), octopus );
                            break;
                    }
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        shellX = width / 2 * 20 - 80;
        shellY = height * 20 - 30;
        return gameObkectMap;
    }

    public static int getNumberMaps() {
        return mapPaths.length;
    }

    public static int getShellXStart() {
        return shellX;
    }

    public static int getShellYStart() {
        return shellY;
    }

    public static int getStarXStart() {
        return starX;
    }

    public static int getStarYStart() {
        return starY;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}





