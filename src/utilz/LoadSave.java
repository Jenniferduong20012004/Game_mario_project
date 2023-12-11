package utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static utilz.Constant.PlayerConstant.*;
import static utilz.Constant.PlayerConstant.ATTACK;

public class LoadSave {
    public static final String PLAYER_RUNNING = "player/Run (78x58).png";
    public static final String PLAYER_IDLE = "player/Idle (78x58).png";
    public static final String PLAYER_JUMP = "player/Jump (78x58).png";
    public static final String PLAYER_FALLING = "player/Fall (78x58).png";
    public static final String PLAYER_GROUND = "player/Ground (78x58).png";
    public static final String PLAYER_HIT = "player/Hit (78x58).png";
    public static final String PLAYER_DOOR_OUT = "player/Door Out (78x58).png";
    public static final String PLAYER_DOOR_IN = "player/Door In (78x58).png";
    public static final String PLAYER_DEAD = "player/Dead (78x58).png";
    public static final String PLAYER_ATTACK = "player/Attack (78x58).png";
    public static final String LEVEL_ATLAS = "outside/backgroundLevel1.png";
    public static final String LEVEL_ONE_DATE = "outside/outside_sprites.png";
    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(LoadSave.class.getResourceAsStream("/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
    public static int [][] GetLevelData(){
        int [][] lvlData = new int [Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATE);
        for (int j =0; j< img.getHeight();j++){
            for (int i =0; i< img.getWidth(); i++){
                Color color = new Color (img.getRGB(i,j));
                int value = color.getRed();
                if (value >=48)
                    value =0;
                lvlData[i][j]= value;
            }
        }
        return lvlData;
    }

    }

