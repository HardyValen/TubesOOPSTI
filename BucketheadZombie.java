import javax.swing.ImageIcon;

public class BucketheadZombie extends Zombie{
    public BucketheadZombie(int row){
        initialize(row);
    }

    private void initialize(int row){
        ImageIcon imageIcon = ImageFactory.createImage(Image.ZOMBIES_BUCKETHEAD);
        setImage(imageIcon.getImage());

        int start_x = Constants.BOARD_WIDTH;
        int start_y = Constants.TILE_START + (Constants.TILE_HEIGHT * row) - Constants.ZOMBIES_BUCKETHEAD_HEIGHT;

        setX(start_x);
        setY(start_y);

        this.dx = -1;
        this.dy = 0;
        this.attackDamage = 4;
        this.maxHealth = 120;
        this.currentHealth = this.maxHealth;
    }
}