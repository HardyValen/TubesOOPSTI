class Test{
    public static void main(String[] args) throws InterruptedException {
        Row row = new Row(10);
        Zombie zombie = new NormalZombie(0, row.getTile(9));
        
        row.getTile(0).addPlant(new Peashooter(0, row.getTile(0)));
        row.getTile(9).addZombie(zombie);

        while(true){
            if (Game.turn == 10){
                row.getTile(1).addPlant(new Peashooter(Game.turn, row.getTile(1)));
            }

            row.print();
            System.out.println("\t\tTurn: " + Game.turn + " \tZombie HP: " + zombie.getCurrentHealth());
            Thread.sleep(200);
            row.turnPass();
            Game.turn++;
        }
    }
}