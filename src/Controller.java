import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    // Lyt for input
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        if (e.getKeyChar() == ' ') {
            if (Main.alive) {
                Bird.jump();
            } else {
                Main.restart();
            }
        }
    }

    // Bruger ikke de metoder, men de skal være der

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
