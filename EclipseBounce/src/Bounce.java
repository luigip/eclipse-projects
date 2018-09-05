import javax.swing.*;


public class Bounce extends JFrame {
  
    public Bounce() {
        super ("Tennis");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BouncePanel());
        setVisible(true);
    }

    public static void main(String[] args){
        new Bounce();
    }
}
