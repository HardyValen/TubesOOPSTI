import java.awt.Image;

public abstract class Entity implements Coordinate{
    private Image image;        // Gantiin representation
    private boolean isDead;     
    protected int x;
    protected int y;
    protected int hitboxX;
    protected int hitboxY;
    protected int dx;
    protected int dy;
    protected int hitboxWidth;
    protected int hitboxHeight;
    protected boolean phaseable = false;

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

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setDX(int dx){
        this.dx = dx;
    }

    public void setDY(int dy){
        this.dy = dy;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }
}