import java.util.List;
import java.util.ArrayList;

public class Row {
    protected List<Tile> tiles = new ArrayList<Tile>();

    public Row(int size){
        for(int j = 0; j < size; j++){
            tiles.add(new Tile());
        }
    }

    /**
     * @return the tiles
     */
    public List<Tile> getTiles() {
        return tiles;
    }

    public Tile getTile(int i){
        if (tiles.size() > 0){
            return tiles.get(i);
        } else {
            return null;
        }
    }

    public Tile getFirstTile(){
        return this.getTile(0);
    }

    public Tile getLastTile(){
        return this.getTile(this.tiles.size() - 1);
    }

    public void turnPass(){
        for (Tile tile : tiles) {
            int thisTileIndex = tiles.indexOf(tile);

            if (tile.zombies.size() > 0){
                int thisZombieIndex = 0;
                while (tile.zombies.size() > 0 && thisZombieIndex < tile.zombies.size()) {
                    if (tile.zombieCheckAction(thisZombieIndex) && (tile.zombies.get(thisZombieIndex).getDirection() != 0)){
                        Zombie zombieTemp = tile.zombies.get(thisZombieIndex);
                        tile.zombies.remove(thisZombieIndex);
                        zombieTemp.actionCheck();   // Refresh Cooldown

                        if ((thisTileIndex > 0) && (thisTileIndex < tiles.size() - 1)) {
                            Tile tileNext = tiles.get(thisTileIndex + zombieTemp.getDirection());
                            zombieTemp.setTile(tileNext);
                            tileNext.addZombie(zombieTemp);
                        } else {
                            if ((thisTileIndex == 0) && zombieTemp.getDirection() > 0){
                                Tile tileNext = tiles.get(thisTileIndex + zombieTemp.getDirection());
                                zombieTemp.setTile(tileNext);
                                tileNext.addZombie(zombieTemp);
                            } else if (thisTileIndex == tiles.size() - 1 && zombieTemp.getDirection() < 0) {
                                Tile tileNext = tiles.get(thisTileIndex + zombieTemp.getDirection());
                                zombieTemp.setTile(tileNext);
                                tileNext.addZombie(zombieTemp);
                            }
                        }
                        
                    } else {
                        thisZombieIndex++;
                    }
                }
            }
            tile.processProjectiles();
        }

        for(Tile tile : tiles){
            tile.turnPass();
        }

        for(Tile tile : tiles){
            int thisTileIndex = tiles.indexOf(tile);
            if (tile.projectiles.size() > 0){
                int thisprojectileIndex = 0;
                while (tile.projectiles.size() > 0 && thisprojectileIndex < tile.projectiles.size()) {
                    if (tile.projectileCheckAction(thisprojectileIndex) && (tile.projectiles.get(thisprojectileIndex).getDirection() != 0)){
                        Projectile projectileTemp = tile.projectiles.get(thisprojectileIndex);
                        tile.projectiles.remove(thisprojectileIndex);
                        projectileTemp.actionCheck();
                        
                        if ((thisTileIndex > 0) && (thisTileIndex < tiles.size() - 1)) {
                            Tile tileNext = tiles.get(thisTileIndex + projectileTemp.getDirection());
                            projectileTemp.setTile(tileNext);
                            tileNext.addProjectile(projectileTemp);
                        } else {
                            if ((thisTileIndex == 0) && projectileTemp.getDirection() > 0){
                                Tile tileNext = tiles.get(thisTileIndex + projectileTemp.getDirection());
                                projectileTemp.setTile(tileNext);
                                tileNext.addProjectile(projectileTemp);
                            } else if (thisTileIndex == tiles.size() - 1 && projectileTemp.getDirection() < 0) {
                                Tile tileNext = tiles.get(thisTileIndex + projectileTemp.getDirection());
                                projectileTemp.setTile(tileNext);
                                tileNext.addProjectile(projectileTemp);
                            }
                        }
                        
                    } else {
                        thisprojectileIndex++;
                    }
                }
            }
            tile.processProjectiles();
        }
    }

    public void print(){
        for (Tile tile : tiles) {
            System.out.print("|");
            tile.print();
            if(tiles.indexOf(tile) == tiles.size() - 1){
                System.out.print("|");
            }
        }
        // System.out.println("");
    }
}