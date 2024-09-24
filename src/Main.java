import javax.swing.JFrame;

public class Main {
    // Game state info
    public static boolean alive = true;
    public static int point = 0;

    // Engine info
    public static JFrame window = new Frame();
    public static final int targetFPS = 50;

    public static void main(String[] args) {
        Pipe.init();
        window.paint(window.getGraphics());

        start();
    }

    static void start() {
        // Game loop
        while (true){
            if (alive) {
                Bird.update();
                Pipe.updatePipes();
            }
            window.repaint();
            Pipe.CURRENT_PIPE_SPEED +=0.005f;
            delay(1000 / targetFPS);
        }
    }

    static void restart() {
        // Reset pipes
        Pipe.pipes.clear();
        Pipe.CURRENT_PIPE_SPEED = Pipe.PIPE_START_SPEED;
        Pipe.init();

        // Reset fugl
        Bird.yVel = 0;
        Bird.y = Bird.START_Y;

        // Reset spil parametre
        alive = true;
        point = 0;

    }

    // Delay metode
    static void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    static void die() {
        alive = false;
    }
}