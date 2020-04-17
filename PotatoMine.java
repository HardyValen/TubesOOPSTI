
public class PotatoMine extends Plant{
    protected boolean isExploded = false;
    protected boolean isArmed = false;

    public PotatoMine(){
        hitboxWidth = Constants.PLANTS_POTATO_MINE_UNARMED_WIDTH;
        hitboxHeight = Constants.PLANTS_POTATO_MINE_UNARMED_HEIGHT;
        setImage(ImageFactory.createImage(Image.PLANTS_POTATO_MINE_UNARMED).getImage());
        phaseable = false;

        maxHealth = Constants.PLANTS_POTATO_MINE_HEALTH;
        currentHealth = maxHealth;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1)) + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_POTATO_MINE_UNARMED_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_POTATO_MINE_UNARMED_HEIGHT);
        setDX(0);
        setDY(0);

        actionTime = Constants.PLANTS_POTATO_MINE_ACTIONDELAY;
        actionCurrent = actionTime;
    }

    // public int isPotatoMineReady(){
    //     if (actionCurrent == 0 && !isArmed) {
    //         actionCurrent = 20;
    //         isArmed = true;
    //         phaseable = true;
    //         hitboxWidth = Constants.PLANTS_POTATO_MINE_READY_WIDTH;
    //         hitboxHeight = Constants.PLANTS_POTATO_MINE_READY_HEIGHT;
    //         hitboxX = Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX);
    //         hitboxY = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * tile.posY);
    //         setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_POTATO_MINE_READY_WIDTH / 2));
    //         setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_POTATO_MINE_READY_HEIGHT);
    //         setImage(ImageFactory.createImage(Image.PLANTS_POTATO_MINE_READY).getImage()); 
    //     }
    // }

    public int actionExplode(){
        if (actionCurrent == 0 && isArmed) {
            if (isExploded){
                setIsDead(true);
                return 2;
            } else {
                actionCurrent = actionTime;
                isExploded = true;
                hitboxWidth = Constants.TILE_WIDTH * 3;
                hitboxHeight = Constants.TILE_HEIGHT * 3;
                hitboxX = Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX);
                hitboxY = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY - 1)); 
                setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.ENVIRONMENT_CHERRY_BOMB_EXPLOSION_WIDTH / 2));
                setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.ENVIRONMENT_CHERRY_BOMB_EXPLOSION_HEIGHT);
                setImage(ImageFactory.createImage(Image.ENVIRONMENT_CHERRY_BOMB_EXPLOSION).getImage());
                return 1;
            }
        } else return 0;
    }

    // public int actionExplode(){
    //     if (actionCurrent == 0) {
    //         if (isArmed) {
    //             if (isExploded){
    //                 setIsDead(true);
    //                 return 2;
    //             } else {
    //                 actionCurrent = actionTime;
    //                 isExploded = true;
    //                 setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.ENVIRONMENT_POTATO_MINE_EXPLOSION_WIDTH / 2));
    //                 setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.ENVIRONMENT_POTATO_MINE_EXPLOSION_HEIGHT);
    //                 setImage(ImageFactory.createImage(Image.ENVIRONMENT_POTATO_MINE_EXPLOSION).getImage());
    //                 return 1;
    //             }
    //         } else {
                // actionCurrent = actionTime;
                // isArmed = true;
                // hitboxWidth = Constants.TILE_WIDTH;
                // hitboxHeight = Constants.TILE_HEIGHT;
                // hitboxX = Constants.TILE_X_START + (Constants.TILE_WIDTH * tile.posX);
                // hitboxY = Constants.TILE_Y_START + (Constants.TILE_HEIGHT * tile.posY);
                // setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_POTATO_MINE_READY_WIDTH / 2));
                // setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_POTATO_MINE_READY_HEIGHT);
                // setImage(ImageFactory.createImage(Image.PLANTS_POTATO_MINE_READY).getImage()); 
    //             return 0;
    //         }
    //     } else return 0;
    // }
}