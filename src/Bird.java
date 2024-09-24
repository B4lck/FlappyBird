public class Bird {
    // Start værdier
    public static final int START_Y = 50;

    // Fugl værdier
    public static int x = 50;
    public static int y = START_Y;
    public static final int width = 50;
    public static final int height = 20;

    // Physics
    public static float yVel = 0;
    public static final int jumpForce = 15;
    public static final int groundHeight = 50;
    public static final float gravity = 1.7f;

    public static void jump() {
        yVel = (float) jumpForce;
    }

    public static void update() {
        // Move player
        yVel -= gravity;
        y -= (int) yVel;

        // Tjek for om spilleren skal dø
        if (collidesWithPipe()) {Main.die();}
        if (y + height >= Frame.height - groundHeight) {Main.die();}
    }

    public static boolean collidesWithPipe() {
        // AABB collision detection
        for (Pipe pipe : Pipe.pipes) {
            // Tjek øverste rør
            if (x < pipe.getX() + Pipe.PIPE_WIDTH && x + width > pipe.getX() && y < pipe.getY()) {
                return true;
            }

            // Tjek nederste rør
            if (x < pipe.getX() + Pipe.PIPE_WIDTH && x + width > pipe.getX() && y > pipe.getY() + Pipe.PIPE_OPENING_HEIGHT) {
                return true;
            }
        }

        return false;
    }
}
