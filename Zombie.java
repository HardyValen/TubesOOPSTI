public class Zombie extends Entity {
    protected int attackDamage;
    protected int maxHealth;
    protected int currentHealth;

    public Zombie(int attackDamage, int maxHealth){
        this.attackDamage = attackDamage;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        // Mungkin ditaro di konstanta
        dx = -1;
        dy = 0;
    }

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