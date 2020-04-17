import java.util.Random;

public class ZombieFactory {
    public static Zombie createZombie(ZombieKey zKey){
        Random rand = new Random();
        Zombie z = null;
        int start_x = Constants.BOARD_WIDTH;
        int start_y = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (rand.nextInt(5) + 1));
        int dy = 0;

        switch (zKey) {
            case ZOMBIES_NORMAL:
                z = new Zombie(4, Constants.ZOMBIES_NORMAL_HEALTH);
                z.hitboxWidth = Constants.ZOMBIES_NORMAL_WIDTH;
                z.hitboxHeight = Constants.TILE_HEIGHT;
                z.hitboxX = start_x;
                z.hitboxY = start_y - Constants.TILE_HEIGHT;
                z.setImage(ImageFactory.createImage(Image.ZOMBIES_NORMAL).getImage());
                z.setX(start_x);
                z.setY(start_y - Constants.ZOMBIES_NORMAL_HEIGHT);
                z.setDX(Constants.ZOMBIES_MOVESPEED_NORMAL_X);
                z.setDY(dy);
                break;
            case ZOMBIES_CONEHEAD:
                z = new Zombie(4, Constants.ZOMBIES_CONEHEAD_HEALTH);
                z.hitboxWidth = Constants.ZOMBIES_CONEHEAD_WIDTH;
                z.hitboxHeight = Constants.TILE_HEIGHT;
                z.hitboxX = start_x;
                z.hitboxY = start_y - Constants.TILE_HEIGHT;
                z.setImage(ImageFactory.createImage(Image.ZOMBIES_CONEHEAD).getImage());
                z.setX(start_x);
                z.setY(start_y - Constants.ZOMBIES_CONEHEAD_HEIGHT);
                z.setDX(Constants.ZOMBIES_MOVESPEED_NORMAL_X);
                z.setDY(dy);
                break;
            case ZOMBIES_BUCKETHEAD:
                z = new Zombie(4, Constants.ZOMBIES_BUCKETHEAD_HEALTH);
                z.hitboxWidth = Constants.ZOMBIES_BUCKETHEAD_WIDTH;
                z.hitboxHeight = Constants.TILE_HEIGHT;
                z.hitboxX = start_x;
                z.hitboxY = start_y - Constants.TILE_HEIGHT;
                z.setImage(ImageFactory.createImage(Image.ZOMBIES_BUCKETHEAD).getImage());
                z.setX(start_x);
                z.setY(start_y - Constants.ZOMBIES_BUCKETHEAD_HEIGHT);
                z.setDX(Constants.ZOMBIES_MOVESPEED_NORMAL_X);
                z.setDY(dy);
                break;
            case ZOMBIES_BRICKHEAD:
                z = new Zombie(4, Constants.ZOMBIES_BRICKHEAD_HEALTH);
                z.hitboxWidth = Constants.ZOMBIES_BRICKHEAD_WIDTH;
                z.hitboxHeight = Constants.TILE_HEIGHT;
                z.hitboxX = start_x;
                z.hitboxY = start_y - Constants.TILE_HEIGHT;
                z.setImage(ImageFactory.createImage(Image.ZOMBIES_BRICKHEAD).getImage());
                z.setX(start_x);
                z.setY(start_y - Constants.ZOMBIES_BRICKHEAD_HEIGHT);
                z.setDX(Constants.ZOMBIES_MOVESPEED_NORMAL_X);
                z.setDY(dy);
                break;
            case ZOMBIES_GARGANTUAR:
                z = new Zombie(2000, Constants.ZOMBIES_GARGANTUAR_HEALTH);
                z.hitboxWidth = Constants.ZOMBIES_BRICKHEAD_WIDTH;
                z.hitboxHeight = Constants.TILE_HEIGHT;
                z.hitboxX = start_x;
                z.hitboxY = start_y - Constants.TILE_HEIGHT;
                z.setImage(ImageFactory.createImage(Image.ZOMBIES_GARGANTUAR).getImage());
                z.setX(start_x);
                z.setY(start_y - Constants.ZOMBIES_GARGANTUAR_HEIGHT);
                z.setDX(Constants.ZOMBIES_MOVESPEED_NORMAL_X);
                z.setDY(dy);
                break;
            default:
                return null;
        }

        return z;
    }
}