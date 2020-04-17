
public class Projectile extends Entity {
    protected int attackDamage;
    protected int delayDamage;
    protected Tile tile; // Tile Start

    
    public void move(){
        this.x += this.dx;
        this.y += this.dy;
        hitboxX += dx;
        hitboxY += dy;
    }

    public void setTile(Tile tile){}
}