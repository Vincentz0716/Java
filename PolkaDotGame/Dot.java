import java.awt.*;

abstract class Dot {
    int x, y;
    int r;

    Dot(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    boolean touches(int ox, int oy, int or) {
        double dist = Math.sqrt(Math.pow(this.x - ox, 2) + Math.pow(this.y - oy, 2));
        return dist < (this.r + or);
    }

    abstract void draw();
}

class PlayerDot extends Dot {

    PlayerDot(int x, int y, int r) {
        super(x, y, r);
    }

    void updateFromMouse() {
        this.x = Mouse.x;
        this.y = Mouse.y;

        // keep on screen
        if (x < r) x = r;
        if (y < r) y = r;
        if (x > Game.width - r) x = Game.width - r;
        if (y > Game.height - r) y = Game.height - r;
    }

    @Override
    void draw() {
        Game.canvas.setColor(new Color(60, 170, 255)); // light blue
        Game.canvas.fillOval(x - r, y - r, r * 2, r * 2);

        // small highlight so it looks cute
        Game.canvas.setColor(new Color(230, 250, 255));
        Game.canvas.fillOval(x - r / 2, y - r / 2, r / 2, r / 2);
    }
}

class FoodDot extends Dot {

    FoodDot(int x, int y, int r) {
        super(x, y, r);
    }

    void respawn() {
        this.x = randInt(30, Game.width - 30);
        this.y = randInt(60, Game.height - 30);
    }

    @Override
    void draw() {
        Game.canvas.setColor(new Color(80, 230, 130)); // green
        Game.canvas.fillOval(x - r, y - r, r * 2, r * 2);
        Game.canvas.setColor(Color.BLACK);
        Game.canvas.drawOval(x - r, y - r, r * 2, r * 2);
    }

    private int randInt(int lower, int upper) {
        int range = upper - lower;
        return (int) (Math.random() * range + lower);
    }
}
