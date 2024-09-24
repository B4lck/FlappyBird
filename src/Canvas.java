import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Tegn baggrund
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Frame.width, Frame.height);

        // Tegn Pipes
        g.setColor(Color.green);
        for (Pipe pipe : Pipe.pipes) {
            g.fillRect((int)pipe.getX(), 0, Pipe.PIPE_WIDTH, pipe.getY());
            g.fillRect((int)pipe.getX(), pipe.getY() + Pipe.PIPE_OPENING_HEIGHT, Pipe.PIPE_WIDTH, Frame.height - (pipe.getY() + Pipe.PIPE_OPENING_HEIGHT));
        }

        // Tegn jorden
        g.setColor(new Color(0, 99, 32)); // Mørkegrøn
        g.fillRect(0, Frame.height - Bird.groundHeight, Frame.width, Bird.groundHeight);

        // Tegn fugl
        g.setColor(Color.yellow);
        g.fillRect(Bird.x, Bird.y, Bird.width, Bird.height);

        // Tegn score
        g.setColor(Color.white);
        int fontSize = 50;
        g.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
        g.drawString(Integer.toString(Main.point), Frame.width / 2 - 15, 50);

        // Tegn Dødskærm
        if (!Main.alive) {
            g.setColor(Color.white);
            g.drawString("You died!", 90, 200);
        }
    }
}
