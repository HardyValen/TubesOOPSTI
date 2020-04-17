
public class CherryBomb extends Plant{
    protected boolean isExploded = false;

    public CherryBomb(){
        hitboxWidth = Constants.PLANTS_CHERRY_BOMB_WIDTH;
        hitboxHeight = Constants.PLANTS_CHERRY_BOMB_HEIGHT;
        setImage(ImageFactory.createImage(Image.PLANTS_CHERRY_BOMB).getImage());
        phaseable = true;
    }

    public void setTile(Tile tile){
        this.tile = tile;
        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.PLANTS_CHERRY_BOMB_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY + 1)) - Constants.PLANTS_CHERRY_BOMB_HEIGHT);
        setDX(0);
        setDY(0);

        actionTime = Constants.PLANTS_CHERRY_BOMB_ACTIONTIME;
        actionCurrent = actionTime;
    }

    public int actionExplode(){
        if (actionCurrent == 0) {
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
}