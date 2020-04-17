
public class Constants {
    // Title and JFrame Composition
    public static final String TITLE = "Plants vs Zombies: Bootleg Edition";
    public static final int BOARD_WIDTH = 1024;
    public static final int BOARD_HEIGHT = 576;
    public static final int TILE_HEIGHT = 81;
    public static final int TILE_WIDTH = 67;
    public static final int TILE_X_START = 297;
    public static final int TILE_Y_START = 127;
    

    // Game Assets
    public static final String BUTTON_PLAY_GAME_URL = "assets/Buttons/ButtonPlayGame.png";
    public static final String BUTTON_PAUSE_URL = "assets/Buttons/ButtonPause.png";
    public static final String BUTTON_SHOVEL_URL = "assets/Buttons/ButtonShovel.png";

    public static final String ENVIRONMENT_CHERRY_BOMB_EXPLOSION_URL = "assets/Environment/CherryBombExplosion.png";
    public static final String ENVIRONMENT_GAMEOVER_URL = "assets/Environment/GameOverOverlay.png";
    public static final String ENVIRONMENT_GAME_SCREEN_URL = "assets/Environment/GameScreen.png";
    public static final String ENVIRONMENT_PEA_PROJECTILE_URL = "assets/Environment/PeaProjectile.png";
    public static final String ENVIRONMENT_POTATO_MINE_EXPLOSION_URL = "assets/Environment/PotatoMineExplosion.png";
    public static final String ENVIRONMENT_SUN_ICON_URL = "assets/Environment/SunIcon.png";
    public static final String ENVIRONMENT_SUN_LAWN_URL = "assets/Environment/SunLawn.png";
    
    public static final String PLANTS_CHERRY_BOMB_URL = "assets/Plants/CherryBomb.png";
    public static final String PLANTS_PEASHOOTER_URL = "assets/Plants/Peashooter.png";
    public static final String PLANTS_POTATO_MINE_READY_URL = "assets/Plants/PotatoMine.png";
    public static final String PLANTS_POTATO_MINE_UNARMED_URL = "assets/Plants/PotatoMineUnarmed.png";
    public static final String PLANTS_REPEATER_URL = "assets/Plants/Repeater.png";
    public static final String PLANTS_SPIKEWEED_URL = "assets/Plants/Spikeweed.png";
    public static final String PLANTS_SUNFLOWER_URL = "assets/Plants/Sunflower.png";
    public static final String PLANTS_THREEPEATER_URL = "assets/Plants/Threepeater.png";
    public static final String PLANTS_WALLNUT_URL = "assets/Plants/Wallnut.png";

    public static final String SEEDPACKETS_CHERRY_BOMB_URL = "assets/SeedPackets/CherryBombSeedPacket.png";
    public static final String SEEDPACKETS_PEASHOOTER_URL = "assets/SeedPackets/PeashooterSeedPacket.png";
    public static final String SEEDPACKETS_POTATO_MINE_URL = "assets/SeedPackets/PotatoMineSeedPacket.png";
    public static final String SEEDPACKETS_REPEATER_URL = "assets/SeedPackets/RepeaterSeedPacket.png";
    public static final String SEEDPACKETS_SPIKEWEED_URL = "assets/SeedPackets/SpikeweedSeedPacket.png";
    public static final String SEEDPACKETS_SUNFLOWER_URL = "assets/SeedPackets/SunflowerSeedPacket.png";
    public static final String SEEDPACKETS_THREEPEATER_URL = "assets/SeedPackets/ThreepeaterSeedPacket.png";
    public static final String SEEDPACKETS_WALLNUT_URL = "assets/SeedPackets/WallnutSeedPacket.png";

    public static final String ZOMBIES_NORMAL_URL = "assets/Zombies/NormalZombie.png";
    public static final String ZOMBIES_CONEHEAD_URL = "assets/Zombies/ConeheadZombie.png";
    public static final String ZOMBIES_BUCKETHEAD_URL = "assets/Zombies/BucketheadZombie.png";
    public static final String ZOMBIES_BRICKHEAD_URL = "assets/Zombies/BrickheadZombie.png";
    public static final String ZOMBIES_GARGANTUAR_URL = "assets/Zombies/Gargantuar.png";

    public static final String LOGO_URL = "assets/MainScreen/LogoGame.png";
    public static final String MAIN_SCREEN_URL = "assets/MainScreen/MainScreen.png";

    // Game Speed
    public static final int GAME_SPEED = 33; // In milliseconds. 1000 /  33 ~= 30 fps, 50 ~= 20fps, 100 ~= 10fps
    public static final int GAME_TURN_MOD = 1000 / GAME_SPEED;

    // Zombie Dimension
    public static final int ZOMBIES_NORMAL_ATK_DELAY = 5;
    public static final int ZOMBIES_NORMAL_GARGANTUAR_ATK_DELAY = 33;

    public static final int ZOMBIES_NORMAL_WIDTH = 70;
    public static final int ZOMBIES_CONEHEAD_WIDTH = 70;
    public static final int ZOMBIES_BUCKETHEAD_WIDTH = 80;
    public static final int ZOMBIES_BRICKHEAD_WIDTH = 80;
    public static final int ZOMBIES_GARGANTUAR_WIDTH = 263;

    public static final int ZOMBIES_NORMAL_HEIGHT = 110;
    public static final int ZOMBIES_CONEHEAD_HEIGHT = 139;
    public static final int ZOMBIES_BUCKETHEAD_HEIGHT = 130;
    public static final int ZOMBIES_BRICKHEAD_HEIGHT = 127;
    public static final int ZOMBIES_GARGANTUAR_HEIGHT = 247;

    public static final int ZOMBIES_NORMAL_HEALTH = 40;
    public static final int ZOMBIES_CONEHEAD_HEALTH = 80;
    public static final int ZOMBIES_BUCKETHEAD_HEALTH = 120;
    public static final int ZOMBIES_BRICKHEAD_HEALTH = 160;
    public static final int ZOMBIES_GARGANTUAR_HEALTH = 240;

    public static final int ZOMBIES_MOVESPEED_NORMAL_X = -1;
    public static final int ZOMBIES_MOVESPEED_FAST_X = -2;
    
    // Seed Packet Dimension
    public static final int SEEDPACKET_X_START = 50;
    public static final int SEEDPACKET_Y_START = 77;
    public static final int SEEDPACKET_HEIGHT = 50;
    public static final int SEEDPACKET_WIDTH = 100;

    // Seed Packet Cooldown
    public static final int SEEDPACKET_PEASHOOTER_COOLDOWN = 5 * GAME_SPEED;
    public static final int SEEDPACKET_REPEATER_COOLDOWN = 6 * GAME_SPEED;
    public static final int SEEDPACKET_THREEPEATER_COOLDOWN = 0 * GAME_SPEED;
    public static final int SEEDPACKET_SUNFLOWER_COOLDOWN = 4 * GAME_SPEED;
    public static final int SEEDPACKET_SPIKEWEED_COOLDOWN = 0 * GAME_SPEED;
    public static final int SEEDPACKET_WALLNUT_COOLDOWN = 15 * GAME_SPEED;
    public static final int SEEDPACKET_CHERRY_BOMB_COOLDOWN = 20 * GAME_SPEED;
    public static final int SEEDPACKET_POTATO_MINE_COOLDOWN = 18 * GAME_SPEED;

    // Sun Dimension
    public static final int ENVIRONMENT_SUN_ICON_X_START = 50;
    public static final int ENVIRONMENT_SUN_ICON_Y_START = 30;
    public static final int ENVIRONMENT_SUN_ICON_HEIGHT = 37;
    public static final int ENVIRONMENT_SUN_ICON_WIDTH = 36;

    public static final int ENVIRONMENT_SUN_LAWN_HEIGHT = 70;
    public static final int ENVIRONMENT_SUN_LAWN_WIDTH = 70;

    public static final int SUN_VALUE = 50;
    public static final int DEPTH_SUN = 2;

    public static final int STARTING_SUN = 1000;

    // Plant Dimension
    public static final int PLANTS_PEASHOOTER_HEIGHT = 62;
    public static final int PLANTS_REPEATER_HEIGHT = 62;
    public static final int PLANTS_POTATO_MINE_UNARMED_HEIGHT = 31;
    public static final int PLANTS_POTATO_MINE_READY_HEIGHT = 54;
    public static final int PLANTS_SUNFLOWER_HEIGHT = 66;
    public static final int PLANTS_WALLNUT_HEIGHT = 74;
    public static final int PLANTS_THREEPEATER_HEIGHT = 70;
    public static final int PLANTS_SPIKEWEED_HEIGHT = 31;
    public static final int PLANTS_CHERRY_BOMB_HEIGHT = 63;

    public static final int PLANTS_PEASHOOTER_WIDTH = 60;
    public static final int PLANTS_REPEATER_WIDTH = 60;
    public static final int PLANTS_POTATO_MINE_UNARMED_WIDTH = 18;
    public static final int PLANTS_POTATO_MINE_READY_WIDTH = 60;
    public static final int PLANTS_SUNFLOWER_WIDTH = 60;
    public static final int PLANTS_WALLNUT_WIDTH = 60;
    public static final int PLANTS_THREEPEATER_WIDTH = 85;
    public static final int PLANTS_SPIKEWEED_WIDTH = 60;
    public static final int PLANTS_CHERRY_BOMB_WIDTH = 60;

    public static final int PLANTS_PEASHOOTER_HEALTH = 40;
    public static final int PLANTS_THREEPEATER_HEALTH = 40;
    public static final int PLANTS_CHERRY_BOMB_HEALTH = 40;
    public static final int PLANTS_REPEATER_HEALTH = 40;
    public static final int PLANTS_SUNFLOWER_HEALTH = 40;
    public static final int PLANTS_WALLNUT_HEALTH = 2000;
    public static final int PLANTS_SPIKEWEED_HEALTH = 2000;
    public static final int PLANTS_POTATO_MINE_HEALTH = 40;

    // Plant Costs
    public static final int PLANTS_PEASHOOTER_COST = 100;
    public static final int PLANTS_THREEPEATER_COST = 250;
    public static final int PLANTS_CHERRY_BOMB_COST = 150;
    public static final int PLANTS_REPEATER_COST = 200;
    public static final int PLANTS_SUNFLOWER_COST = 50;
    public static final int PLANTS_WALLNUT_COST = 50;
    public static final int PLANTS_SPIKEWEED_COST = 100;
    public static final int PLANTS_POTATO_MINE_COST = 25;

    // Plant Action
    public static final int PLANTS_PEASHOOTER_ACTIONTIME = 33;
    public static final int PLANTS_THREEPEATER_ACTIONTIME = 33;
    public static final int PLANTS_CHERRY_BOMB_ACTIONTIME = 2 * GAME_SPEED;
    public static final int PLANTS_REPEATER_ACTIONTIME = 33;
    public static final int PLANTS_REPEATER_ACTIONDELAY = 5;
    public static final int PLANTS_SUNFLOWER_ACTIONTIME = 2 * GAME_SPEED;
    public static final int PLANTS_WALLNUT_ACTIONTIME = 2 * GAME_SPEED;
    public static final int PLANTS_SPIKEWEED_ACTIONTIME = 2 * GAME_SPEED;
    public static final int PLANTS_POTATO_MINE_ACTIONTIME = 2 * GAME_SPEED;

    // Projectile Dimension
    public static final int ENVIRONMENT_CHERRY_BOMB_EXPLOSION_HEIGHT = 313;
    public static final int ENVIRONMENT_POTATO_MINE_EXPLOSION_HEIGHT = 128;
    public static final int ENVIRONMENT_PEA_PROJECTILE_HEIGHT = 22;

    public static final int ENVIRONMENT_CHERRY_BOMB_EXPLOSION_WIDTH = 194;
    public static final int ENVIRONMENT_POTATO_MINE_EXPLOSION_WIDTH = 194;
    public static final int ENVIRONMENT_PEA_PROJECTILE_WIDTH = 24;

    private Constants(){}
}