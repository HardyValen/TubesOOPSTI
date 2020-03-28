import java.util.List;
import java.util.ArrayList;

public class Tile{
    protected Plant plant;
    protected List<Zombie> zombies = new ArrayList<Zombie>();
    protected List<Projectile> projectiles = new ArrayList<Projectile>();
    protected Row row;

    public Tile(){}

    public Tile(Row row){
        this.row = row;
    }

    public Plant getPlant() {
        return plant;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public List<Zombie> getZombies() {
        return zombies;
    }

    public void addPlant(Plant plant) {
        if (this.plant != null) {
            System.out.println("You cannot plant " + plant.getName() + "Because this tile already have a " + this.plant.getName());
        } else {
            this.plant = plant;
        }
    }

    public void removePlant(){
        this.plant = null;
    }

    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public void addProjectile(Projectile projectile){
        this.projectiles.add(projectile);
    }

    public void removeFirstProjectile(){
        this.removeProjectile(0);
    }

    public void removeProjectile(int i){
        if (i < projectiles.size()) {
            this.projectiles.remove(i);
        }
    }
    
    public void removeFirstZombie(){
        this.zombies.remove(0);
    }

    public void removeZombie(int i){
        if (i < zombies.size()) {
            this.removeZombie(0);
        }
    }

    public void processProjectiles(){
        int i = 0;
        while (zombies.size() > 0 && projectiles.size() > 0) {
            int zombieHP = this.zombies.get(i).getCurrentHealth();
            int projectileDamage = this.projectiles.get(0).getAttackDamage();
            this.zombies.get(i).setCurrentHealth(zombieHP - projectileDamage);
            
            this.removeFirstProjectile();

            if (this.zombieCheckHP(i)) {
                i++;
            }
        }
    }

    public void turnPass(){
        this.processProjectiles();

        if (plant != null) {
            plant.turnPass();
        }
        
        if (projectiles.size() > 0) {
            for (Projectile projectile : projectiles) {
                projectile.turnPass();
            }
        }

        if (zombies.size() > 0){
            for (Zombie zombie : zombies) {
                zombie.turnPass();
            }
        }
    }

    public void actionCheck(){
        if (plant != null) {
            plant.actionCheck();
        }
        
        if (projectiles.size() > 0) {
            for (Projectile projectile : projectiles) {
                projectile.actionCheck();
            }
        }

        if (zombies.size() > 0){
            for (Zombie zombie : zombies) {
                zombie.actionCheck();
            }
        }
    }

    public boolean zombieCheckHP(int i){
        if (i < zombies.size()) {
            if (zombies.get(i).getCurrentHealth() <= 0) {
                zombies.remove(i);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean zombieCheckAction(int i){
        if (i < zombies.size()) {
            if (zombies.get(i).getActionCD() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean projectileCheckAction(int i){
        if (i < projectiles.size()) {
            if (projectiles.get(i).getActionCD() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setZombies(List<Zombie> zombies) {
        this.zombies = zombies;
    }
    
    public void addZombie(Zombie zombie){
        this.zombies.add(zombie);
    }

    public void print(){
        if (plant != null) {
            System.out.print(plant.getRepresentation());
        } else {
            if (zombies.size() > 0) {
                System.out.print(zombies.get(0).getRepresentation());
            } else {
                if (projectiles.size() > 0) {
                    System.out.print(projectiles.get(0).getRepresentation());
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    public void printDetail(){
        if (plant != null) {
            System.out.println("Plant: " + plant.getName() + " " + plant.getRepresentation());
        } else {
            System.out.println("No plant on this tile");
        }

        if (zombies.size() > 0) {
            System.out.print("Zombie(" + zombies.size() + "): ");
            for (Zombie zombie : zombies) {
                System.out.print(zombie.getRepresentation() + "(" + zombie.getCurrentHealth() + ") ");
            }
            System.out.println("");
        } else {
            System.out.println("No zombie on this tile");
        }

        if (projectiles.size() > 0) {
            System.out.print("Projectile(" + projectiles.size() + "): ");
            for (Projectile projectile : projectiles){
                System.out.print(projectile.getRepresentation());
            }
            System.out.println();
        } else {
            System.out.println("No projectile on this tile");
        }
    }

}