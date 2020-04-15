import javax.swing.ImageIcon;

public class ConeheadZombie extends Zombie{
    public ConeheadZombie(int row){
        initialize(row);
    }

    private void initialize(int row){
        ImageIcon imageIcon = ImageFactory.createImage(Image.ZOMBIES_CONEHEAD);
        setImage(imageIcon.getImage());

        int start_x = Constants.BOARD_WIDTH;
        int start_y = Constants.TILE_START + (Constants.TILE_HEIGHT * row) - Constants.ZOMBIES_CONEHEAD_HEIGHT;

        setX(start_x);
        setY(start_y);

        this.dx = -1;
        this.dy = 0;
        this.attackDamage = 4;
        this.maxHealth = 80;
        this.currentHealth = this.maxHealth;
    }
}