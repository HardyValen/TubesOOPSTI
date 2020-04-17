import javax.swing.*;

public class Test01a_SwingOnMain {  
public static void main(String[] args) {  
    JFrame f=new JFrame();//creating instance of JFrame  
            
    JButton b=new JButton("The Button");//creating instance of JButton  
    b.setBounds(220,285,160,30);//x axis, y axis, hitboxWidth, hitboxHeight  
            
    f.add(b);//adding button in JFrame  
            
    f.setSize(600,600);  
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
    }  
}