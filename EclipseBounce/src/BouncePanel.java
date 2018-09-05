import java.awt.*;
import javax.swing.*;
import java.util.*;


public class BouncePanel extends JPanel implements Runnable {
    Image ball, court;
    float current = 0F;
    Thread runner;
    int xPosition = 10;
    int xMove = 1;
    int yPosition = -1;
    int ballHeight = 185;
    int ballWidth = 190;
    int height;

    public BouncePanel(){
        super();
        Toolkit kit = Toolkit.getDefaultToolkit();
        ball = kit.getImage(getClass().getResource("tennis.gif"));
        court = kit.getImage(getClass().getResource("court.jpg"));
        runner = new Thread(this);
        runner.start();
    }

    @Override
    public void paintComponent(Graphics comp){
        Graphics2D comp2D = (Graphics2D) comp;
        height = getSize().height - ballHeight;
        if (yPosition == -1) yPosition = height - 20;
        if ((court != null) && (ball != null)){
            comp2D.drawImage(court, 0, 0, this);
            comp2D.drawImage(ball, (int) xPosition, (int)yPosition, this);
        }
    }

    @Override
    public void run(){
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread){
            current += (float) 0.1;
            if (current > 3)
                current = (float) 0;
            xPosition += xMove;
            if (xPosition > (getSize().width - ballWidth))
                xMove *= -1;
            if (xPosition < 1)
                xMove  *= -1;
            double bounce = Math.sin(current) * height;
            yPosition = (int) (height - bounce);
            repaint();
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){}
        }
    }

}
