package levels;
import main.Game;
import main.GamePanel;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;


public class LevelManager {
    private Game game;
    private GamePanel gamePanel;
    Level [] level;
    private BufferedImage[] levelSprite;
    public LevelManager(Game game){
        this.game = game;
        //levelSprite = LoadSave.GetPlayerAtlas(LoadSave.LEVEL_ATLAS);
        importOutsideSprites();
    }
    public void getLevelManage(){
        BufferedImage tile = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUNNING);
        level = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(RUNNING)];
    }

    private void importOutsideSprites() {
        BufferedImage img=LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite=new BufferedImage[48];
        for (int i=0; i<4; i++){
            for (int j=0; j<12; j++){
                int index = i*12+j;
                levelSprite[i]= img.getSubimage(j*32,i*32,32,32);
            }
        }
    }


    public void update(){

    }
    public void draw (Graphics g){
        int col =0;
        int row =0;
        int x =0;
        int y =0;
        while (col<Game.TILES_IN_WIDTH && row< Game.TILES_IN_HEIGHT){
            g.drawImage(levelSprite[2],0,0,null );
            col++;
            x += Game.
        }
    }
}
