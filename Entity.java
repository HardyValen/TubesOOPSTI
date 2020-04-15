import java.awt.Image;

public abstract class Entity {
    private Image image;        // Gantiin representation
    private boolean isDead;     
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;

    public abstract void move();

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getDX(){
        return dx;
    }
    
    public int getDY(){
        return dy;
    }

    public void setX(Integer x){
        this.x = x;
    }

    public void setY(Integer y){
        this.y = y;
    }

    public void setDX(Integer dx){
        this.dx = dx;
    }

    public void setDY(Integer dy){
        this.dy = dy;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }
}