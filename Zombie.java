import javax.swing.ImageIcon;

public abstract class Zombie extends Entity {
    protected int attackDamage;
    protected int maxHealth;
    protected int currentHealth;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void damageByAmount(int a) {
        currentHealth -= a;   
    }

    public void move(){
        this.x += this.dx;
        this.y += this.dy;
    }
}