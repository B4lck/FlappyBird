import java.util.*;

public class Pipe {
    // Pipe information
    public static final int PIPE_START_SPEED = 5;
    public static final int PIPE_WIDTH = 50;
    public static final int PIPE_OPENING_HEIGHT = 100;
    public static final int PIPE_DISTANCE = 225;
    static float CURRENT_PIPE_SPEED = PIPE_START_SPEED;

    // Liste over pipes
    static List<Pipe> pipes = new ArrayList<Pipe>();

    // Instans information
    private float x;
    private int y;

    public static void init() {
        for (int i = 0; i < 2; i++) {
            new Pipe(i * PIPE_DISTANCE);
        }
    }

    public Pipe(int x) {
        this.x = Frame.width + x; // Skærm bredden
        y = (int)(Math.random() * 250 + 100);
        Pipe.pipes.add(this);
    }

    public static void updatePipes() {
        Pipe removedPipe = null;
        for (Pipe pipe : Pipe.pipes) {
            pipe.move();
            if (pipe.x + Pipe.PIPE_WIDTH < 0) {
                removedPipe = pipe;
            }
        }
        if (removedPipe != null) {
            Main.point++;
            Pipe.pipes.remove(removedPipe);
            new Pipe(0);
        }
    }

    private void move() {
        x -= CURRENT_PIPE_SPEED;
    }

    public float getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
