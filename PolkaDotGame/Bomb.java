import java.awt.*;
import javax.swing.*;

class Bomb {
    int x, y;
    int dx, dy;
    int w = 40;
    int h = 50;
    Image image;

    Bomb(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.image = new ImageIcon("bomb.png").getImage();
    }

    void move() {
        // bounce on walls
        x += dx;
        y += dy;

        if (x < 0) {
            x = 0;
            dx *= -1;
        }
        if (x + w > Game.width) {
            x = Game.width - w;
            dx *= -1;
        }
        if (y < 0) {
            y = 0;
            dy *= -1;
        }
        if (y + h > Game.height) {
            y = Game.height - h;
            dy *= -1;
        }

        draw();
    }

    void draw() {
        Game.canvas.drawImage(this.image, this.x, this.y, w, h, null);
    }

    // Collision with a circle (player)
    boolean touches(int cx, int cy, int cr) {
        int bombCenterX = x + w / 2;
        int bombCenterY = y + h / 2;

        double dist = Math.sqrt(Math.pow(bombCenterX - cx, 2) + Math.pow(bombCenterY - cy, 2));
        // treat bomb as circle-ish for simple collision
        int bombRadius = Math.min(w, h) / 2;
        return dist < (bombRadius + cr);
    }
}
