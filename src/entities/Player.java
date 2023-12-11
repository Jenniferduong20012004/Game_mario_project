package entities;
import utilz.Constant;
import utilz.LoadSave;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import static utilz.Constant.PlayerConstant.*;

public class Player extends Entity{

    private int aniTick, aniIndex, aniSpeed = 35;
    private BufferedImage[] attack, dead, door_in, door_out, fall, ground, hit, idle, jump, run;

    private int playerAction = RUNNING;

    private boolean left, up, down, right;
    private boolean moving = false, attacking = false;
    private float PlayerSpeed = 2.0f;
    public Player(float x, float y){
        super (x,y);
        loadAnimation();
    }
    public void update(){
        updatePos();
        updateAnimationTick();
        setAnimation();
    }
    private void updatePos(){
        moving = false;
    if (left && !right){
        x -= PlayerSpeed;
        moving = true;
    }
    else if (right && !left){
        x+= PlayerSpeed;
        moving = true;
    }
    if (up&& !down){
        y-= PlayerSpeed;
        moving = true;
    }
    else if (!up && down){
        y+= PlayerSpeed;
        moving = true;
    }
    }
    private void loadAnimation() {
            BufferedImage ru = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_RUNNING);
            run = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(RUNNING)];
            for (int i = 0; i < run.length; i++)
                run[i] = ru.getSubimage(i * 78, 0, 78, 58);
            BufferedImage id = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_IDLE);
            idle = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(IDLE)];
            for (int i = 0; i < idle.length; i++)
                idle[i] = id.getSubimage(i * 78, 0, 78, 58);
            BufferedImage ju = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_JUMP);
            jump = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(JUMP)];
            for (int i = 0; i < jump.length; i++)
                jump[i] = ju.getSubimage(i * 78, 0, 78, 58);
            BufferedImage fa= LoadSave.GetSpriteAtlas(LoadSave.PLAYER_FALLING);
            fall = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(FALLING)];
            for (int i = 0; i < fall.length; i++)
                fall[i] = fa.getSubimage(i * 78, 0, 78, 58);
            BufferedImage gr =LoadSave.GetSpriteAtlas(LoadSave.PLAYER_GROUND);;
            ground = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(GROUND)];
            for (int i =0; i<ground.length; i++)
                ground[i] = gr.getSubimage(58*i, 0, 58, 78);
            BufferedImage hi = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_HIT);
            hit = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(HIT)];
            for (int i = 0; i < hit.length; i++)
                hit[i] = hi.getSubimage(i * 78, 0, 78, 58);
            BufferedImage dout = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_OUT);
            door_out = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(DOOR_OUT)];
            for (int i = 0; i < door_out.length; i++)
                door_out[i] = dout.getSubimage(i * 78, 0, 78, 58);
            BufferedImage din = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DOOR_IN);
            door_in = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(DOOR_IN)];
            for (int i = 0; i < door_in.length; i++)
                door_in[i] = din.getSubimage(i * 78, 0, 78, 58);
            BufferedImage de = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_DEAD);
            dead = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(DEAD)];
            for (int i = 0; i < dead.length; i++)
                dead[i] = de.getSubimage(i * 78, 0, 78, 58);
            BufferedImage att =LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATTACK);
            attack = new BufferedImage[Constant.PlayerConstant.getSpriteAmount(ATTACK)];
            for (int i = 0; i < attack.length; i++)
                attack[i] = att.getSubimage(i * 78, 0, 78, 58);

    }
    private void setAnimation() {
        int startAni = playerAction;
        if (moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
        if (attacking)
            playerAction = ATTACK;
        if (startAni != playerAction)
            resetAniTick();
    }

    private void resetAniTick() {
        aniTick =0;
        aniIndex =0;
    }

    private void updateAnimationTick(){
        aniTick++;
        if(aniTick>= aniSpeed){
            aniTick =0;
            aniIndex++;
            if (aniIndex >= Constant.PlayerConstant.getSpriteAmount(playerAction)){
                aniIndex =0;
                attacking = false;
            }
        }
    }

    public void render(Graphics g) {
        switch (playerAction) {
            case RUNNING:
                g.drawImage(run[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case IDLE:
                g.drawImage(idle[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case JUMP:
                g.drawImage(jump[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case FALLING:
                g.drawImage(fall[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case GROUND:
                g.drawImage(ground[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case HIT:
                g.drawImage(hit[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case DOOR_OUT:
                g.drawImage(door_out[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case DOOR_IN:
                g.drawImage(idle[DOOR_IN], (int) x, (int) y, 234, 174, null);
                break;
            case DEAD:
                g.drawImage(dead[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
            case ATTACK:
                g.drawImage(attack[aniIndex], (int) x, (int) y, 234, 174, null);
                break;
        }
    }
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
        moving = true;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
        moving = true;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }
    public void setAttack (boolean attacking){
        this.attacking= attacking;
    }
}

