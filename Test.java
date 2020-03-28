class Test{
    public static void main(String[] args) throws InterruptedException {
        Row row = new Row(10);
        Zombie zombie = new NormalZombie(0, row.getTile(9));
        
        row.getTile(0).addPlant(new Peashooter(0, row.getTile(0)));
        

        while(true){
            if (Game.turn == 20){
                row.getTile(1).addPlant(new Peashooter(Game.turn, row.getTile(1)));
            }

            if (Game.turn == 10){
                row.getTile(9).addZombie(zombie);
            }

            row.print();
            System.out.println("\t\tTurn: " + Game.turn + " \tZombie HP: " + zombie.getCurrentHealth() + "\t hasZombie" + row.getTile(0).getPlant().tile.row.hasZombie());
            Thread.sleep(200);
            row.turnPass();
            Game.turn++;
        }


    }
}