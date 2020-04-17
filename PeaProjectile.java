
public class PeaProjectile extends Projectile {
    public PeaProjectile(Tile tile){
        hitboxWidth = Constants.ENVIRONMENT_PEA_PROJECTILE_WIDTH;
        hitboxHeight = Constants.ENVIRONMENT_PEA_PROJECTILE_HEIGHT;
        setImage(ImageFactory.createImage(Image.ENVIRONMENT_PEA_PROJECTILE).getImage());
        attackDamage = Constants.PROJECTILE_PEA_DAMAGE;
        delayDamage = 0;

        setX(Constants.TILE_X_START + (Constants.TILE_WIDTH * (tile.posX + 1))  + (Constants.TILE_WIDTH / 2) - (Constants.ENVIRONMENT_PEA_PROJECTILE_WIDTH / 2));
        setY(Constants.TILE_Y_START + (Constants.TILE_HEIGHT * (tile.posY)) + (Constants.TILE_HEIGHT / 2) - (Constants.ENVIRONMENT_PEA_PROJECTILE_HEIGHT / 2));
        setDX(10);
        setDY(0);
    }
}