import javax.swing.ImageIcon;

public class Gargantuar extends Zombie{
    public Gargantuar(int row){
        initialize(row);
    }

    private void initialize(int row){
        ImageIcon imageIcon = ImageFactory.createImage(Image.ZOMBIES_GARGANTUAR);
        setImage(imageIcon.getImage());

        int start_x = Constants.BOARD_WIDTH;
        int start_y = Constants.TILE_START + (Constants.TILE_HEIGHT * row) - Constants.ZOMBIES_GARGANTUAR_HEIGHT;

        setX(start_x);
        setY(start_y);

        this.dx = -1;
        this.dy = 0;
        this.attackDamage = 200;
        this.maxHealth = 200;
        this.currentHealth = this.maxHealth;
    }
}