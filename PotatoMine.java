public class PotatoMine extends Plant implements Damaging{
    public static int plantRechargeCD = 0;
    protected int attackDamage;
    public PotatoMine(int plantedTurn, Tile tile){
        super(
            10,             // maxHealth
            plantedTurn,    // plantedTurn
            25,            // spCost
            40,             // Turns to be Used Again
            0x1f954,        // representation 🥔
            "Potato Mine",   // Plant name
            28,               // Action Time (Arming Time)
            tile
        );
        attackDamage = 360;
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void turnPass() {
        if (actionCD == 0){
            //Meledak pas ada zombie di tile-nya
            //Bikin method khusus dia untuk meledak?
            //Perlu arming time gak? Atau sekalinya ditanam bisa langsung meledak?
            int i = 0;
            while (tile.zombies.size() > 0 && i < tile.zombies.size())
            int zombieHP = tile.zombies.get(0).getCurrentHealth();
            tile.zombies.get(i).setCurrentHealth(zombieHP - attackDamage);
                if (this.zombieCheckHP(i)) {
                    i++;
                }
            }
            this.tile.removePlant();

    public void setPlantRechargeCD(int plantRechargeCD) {
        Peashooter.plantRechargeCD = plantRechargeCD;
    }

    public void refreshPlantRechargeCD(){
        setPlantRechargeCD(getPlantRechargeTime());
    }

    public void print(){
        super.print();
        System.out.println("A Regular Peashooter");
        System.out.println("Early Game Plant");
        System.out.println("Not effective for clearing Horde of Zombies");
        System.out.println("");
    }
}