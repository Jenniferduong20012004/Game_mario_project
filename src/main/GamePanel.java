package main;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import javax.swing.*;
import java.awt.*;
import static main.Game.*;
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private Game game;

    public GamePanel(Game game) {
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);
        this.game = game;
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void updateGame(){
}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
