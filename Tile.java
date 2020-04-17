import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tile extends JButton{
    protected int posX;
    protected int posY;
    protected Plant plant;
    protected float alpha = 0.5f;
    protected Row row;

    public Tile(Row row){
        super();
        setBorderPainted(false);
        // setFocusPainted(false);
        // setContentAreaFilled(false);
        setEnabled(false);
        addMouseListener(new ML());
        this.row = row;

    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void checkPlant(){
        if (plant == null){
            setBackground(new Color(159, 206, 139)); // Green
        } else {
            setBackground(new Color(235, 87, 87)); // Red
        }
    }

    public boolean hasPlant(){
        return plant == null;
    }

    public void paintComponent(java.awt.Graphics g) {
        if (isEnabled()){
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            super.paintComponent(g2);
        }
    }

    public class ML extends MouseAdapter{
        public void mouseExited(MouseEvent e) {
            if (isEnabled()){
                new Thread(new Runnable(){
                    public void run(){
                        for (float i = 1f; i >= .5f; i -= .03f) {
                            setAlpha(i);
                            try {
                              Thread.sleep(10);
                            } catch (Exception e) {}
                        }
                    }
                }).start();
            }
        }

        public void mouseEntered(MouseEvent e) {
            if (isEnabled()){
                new Thread(new Runnable() {
                    public void run() {
                        for (float i = .5f; i <= 1f; i += .03f){
                            setAlpha(i);
                        } try {
                            Thread.sleep(10);
                        } catch (Exception e) {}
                    }
                }).start();
            }
        }

        public void mousePressed(MouseEvent e){
            if (isEnabled()){
                setAlpha(.5f);
            }
        }
    }
}