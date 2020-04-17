import javax.swing.ImageIcon;

public class ImageFactory {
    public static ImageIcon createImage(Image image){
        ImageIcon imageIcon = null;

        switch (image) {
            case BUTTON_PLAY_GAME:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.BUTTON_PLAY_GAME_URL));
                break;
            case BUTTON_PAUSE:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.BUTTON_PAUSE_URL));
                break;
            case BUTTON_SHOVEL:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.BUTTON_SHOVEL_URL));
                break;
            case ENVIRONMENT_CHERRY_BOMB_EXPLOSION:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_CHERRY_BOMB_EXPLOSION_URL));
                break;
            case ENVIRONMENT_GAMEOVER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_GAMEOVER_URL));
                break;
            case ENVIRONMENT_GAME_SCREEN:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_GAME_SCREEN_URL));
                break;
            case ENVIRONMENT_PEA_PROJECTILE:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_PEA_PROJECTILE_URL));
                break;
            case ENVIRONMENT_POTATO_MINE_EXPLOSION:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_POTATO_MINE_EXPLOSION_URL));
                break;
            case ENVIRONMENT_SUN_ICON:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_SUN_ICON_URL));
                break;
            case ENVIRONMENT_SUN_LAWN:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ENVIRONMENT_SUN_LAWN_URL));
                break;
            case PLANTS_CHERRY_BOMB:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_CHERRY_BOMB_URL));
                break;
            case PLANTS_PEASHOOTER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_PEASHOOTER_URL));
                break;
            case PLANTS_POTATO_MINE_READY:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_POTATO_MINE_READY_URL));
                break;
            case PLANTS_POTATO_MINE_UNARMED:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_POTATO_MINE_UNARMED_URL));
                break;
            case PLANTS_REPEATER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_REPEATER_URL));
                break;
            case PLANTS_SPIKEWEED:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_SPIKEWEED_URL));
                break;
            case PLANTS_SUNFLOWER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_SUNFLOWER_URL));
                break;
            case PLANTS_THREEPEATER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_THREEPEATER_URL));
                break;
            case PLANTS_WALLNUT:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.PLANTS_WALLNUT_URL));
                break;

            case SEEDPACKETS_CHERRY_BOMB:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_CHERRY_BOMB_URL));
                break;
            case SEEDPACKETS_PEASHOOTER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_PEASHOOTER_URL));
                break;
            case SEEDPACKETS_POTATO_MINE:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_POTATO_MINE_URL));
                break;
            case SEEDPACKETS_REPEATER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_REPEATER_URL));
                break;
            case SEEDPACKETS_SPIKEWEED:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_SPIKEWEED_URL));
                break;
            case SEEDPACKETS_SUNFLOWER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_SUNFLOWER_URL));
                break;
            case SEEDPACKETS_THREEPEATER:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_THREEPEATER_URL));
                break;
            case SEEDPACKETS_WALLNUT:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.SEEDPACKETS_WALLNUT_URL));
                break;

            case ZOMBIES_NORMAL:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ZOMBIES_NORMAL_URL));
                break;
            case ZOMBIES_CONEHEAD:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ZOMBIES_CONEHEAD_URL));
                break;
            case ZOMBIES_BUCKETHEAD:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ZOMBIES_BUCKETHEAD_URL));
                break;
            case ZOMBIES_BRICKHEAD:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ZOMBIES_BRICKHEAD_URL));
                break;
            case ZOMBIES_GARGANTUAR:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.ZOMBIES_GARGANTUAR_URL));
                break;
            case LOGO:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.LOGO_URL));
                break;
            case MAIN_SCREEN:
                imageIcon = new ImageIcon(ImageFactory.class.getResource(Constants.MAIN_SCREEN_URL));
                break;
            default:
                return null;
        }

        return imageIcon;
    }
}