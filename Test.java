class Test{
    public static void main(String[] args) throws InterruptedException {
        Sunflower sunflower = new Sunflower(0, new Tile());
        while(true){
            System.out.println("SP Points: " + Game.spPoints);
            sunflower.turnPass();
            Thread.sleep(100);
            Main.clearConsole();
        }
        // Row row = new Row(15);
        // Zombie zombie = new NormalZombie(0, row.getTile(row.tiles.size() - 1));
        // Peashooter pea = new Peashooter(0, row.getTile(0));
        // row.getTile(0).addPlant(pea);

        // boolean loop = true;
        // while(loop){
        //     if (Game.turn % 20 == 5){
        //         boolean flag = false;
        //         int i = 0;

        //         while (!flag && i < row.tiles.size()){
        //             if (row.getTile(i).plant == null) {
        //                 pea = new Peashooter(Game.turn, row.getTile(i));
        //                 row.getTile(i).addPlant(pea);
        //                 flag = true;
        //             } else {
        //                 i++;
        //             }
        //         }
        //     }

        //     if (Game.turn % 104 == 60){
        //         zombie = new BucketheadZombie(0, row.getTile(row.tiles.size() - 1));
        //         row.getTile(row.tiles.size() - 1).addZombie(zombie);
        //     }

        //     if (Game.turn % 30 == 10){
        //         zombie = new NormalZombie(0, row.getTile(row.tiles.size() - 1));
        //         row.getTile(row.tiles.size() - 1).addZombie(zombie);
        //     }

        //     if (Game.turn % 38 == 25){
        //         zombie = new ConeheadZombie(0, row.getTile(row.tiles.size() - 1));
        //         row.getTile(row.tiles.size() - 1).addZombie(zombie);
        //     }
            
        //     row.print();
        //     System.out.println("\t\tTurn: " + Game.turn);
        //     Thread.sleep(100);
        //     row.turnPass();
        //     Game.turn++;
        //     Main.clearConsole();
        //     if (row.getTile(0).zombies.size() > 0){
        //         if (row.getTile(0).zombies.get(0).getActionCD() <= 1){
        //             loop = false;
        //             System.out.println("You Lose!");
        //         }
        //     }
        // }
    }
}