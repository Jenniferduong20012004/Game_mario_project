package main;
import entities.Player;
import levels.LevelManager;

import java.awt.*;
public class Game implements Runnable {
    private GameWindow gameWindow;
    private Thread gameThread;
    private GamePanel gamePanel;
    private final int FPS_SET  = 120;
    private final int UP_SET =200;
    private Player player;
    private LevelManager levelManger;
    public final static int TILES_DEFAULT_SIZE =32;//32 x 32 tile
    public final static float SCALE =1.0f;
    public final static int TILES_IN_WIDTH =26;//maxScreenColum
    public final static int TILES_IN_HEIGHT =14;//maxScreenrow
    public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE*SCALE);//32
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;//832
    public final static int GAME_HEIGHT=TILES_SIZE * TILES_IN_HEIGHT;//448
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public Game(){
        InitClass();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void InitClass() {
        player = new Player(200,200);
        levelManger = new LevelManager(this);
    }

    public void update(){
        player.update();
        levelManger.update();
    }
    public void render (Graphics g){
        player.render(g);
        levelManger.draw(g);
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0/ FPS_SET; //nanosecond
        double timePerUpdate= 1000000000.0/ UP_SET;
        long previousTime = System.nanoTime ();
        int frames =0;
        int updates =0;
        long lastCheck = System.currentTimeMillis();
        double deltaU =0;
        double deltaF =0;
        while (true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime -previousTime)/timePerUpdate;
            deltaF += (currentTime -previousTime)/timePerFrame;
            previousTime = currentTime;
            if (deltaU>=1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >=1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis()-lastCheck>=1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS "+frames+" UPS " + updates);
                frames =0;
                updates =0;
            }

        }
   }
    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
