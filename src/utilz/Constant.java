package utilz;
public class Constant {
    public static class Direction{
        public static final int LEFT =0;
        public static final int UP =1;
        public static final int RIGHT =2;
        public static final int DOWN =3;
    }
    public static class PlayerConstant{
        public static final int RUNNING = 0;
        public static final int IDLE =1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int DOOR_OUT= 6;
        public static final int DOOR_IN= 7;
        public static final int DEAD= 8;
        public static final int ATTACK =9;
        public static int getSpriteAmount (int playerAction){
            switch (playerAction){
                case RUNNING:
                    return 8;
                case IDLE:
                    return 11;
                case JUMP:
                    return 1;
                case FALLING:
                    return 1;
                case GROUND:
                    return 1;
                case HIT:
                    return 2;
                case DOOR_OUT:
                    return 8;
                case DOOR_IN:
                    return 8;
                case DEAD:
                    return 4;
                case ATTACK:
                    return 3;
                default:
                    return 1;

            }
    }}
}
