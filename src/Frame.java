import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static int width = 400;
    public static int height = 550;
    public JPanel canvas;

    public Frame() {
        super("Flappy Bird");

        // Setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(new Controller());

        // Placer vinduet i midten af skærmen, og giv det en width & height.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width / 2 - Frame.width / 2,screenSize.height / 2 - Frame.height / 2,Frame.width,Frame.height);

        // Canvas
        canvas = new Canvas();
        canvas.setLayout(null);
        canvas.setBackground(Color.CYAN);
        add(canvas);
    }
}