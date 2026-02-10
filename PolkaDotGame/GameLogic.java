import java.awt.*;

public class GameLogic {

    // Background image from Lesson 7
    private BackGround bk;

    // Player dot (controlled by mouse)
    private PlayerDot player;

    // Collectible dots
    private FoodDot[] foods;

    // Enemy bombs (image from Lesson 7)
    private Bomb[] bombs;

    // HUD
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;

    // Small cooldown so you don't lose all lives instantly
    private int hitCooldownFrames = 0;

    public GameLogic() {
        bk = new BackGround();

        player = new PlayerDot(Game.width / 2, Game.height / 2, 18);

        foods = new FoodDot[6];
        for (int i = 0; i < foods.length; i++) {
            foods[i] = new FoodDot(randInt(30, 560), randInt(60, 360), 10);
        }

        bombs = new Bomb[3];
        for (int i = 0; i < bombs.length; i++) {
            int x = randInt(50, 520);
            int y = randInt(0, 200);
            int dx = randInt(-3, 4);
            if (dx == 0) dx = 2;
            int dy = randInt(2, 5);
            bombs[i] = new Bomb(x, y, dx, dy);
        }
    }

    public void gameLoop() {
        // Draw background first
        bk.draw();

        if (gameOver) {
            drawHUD();
            drawGameOver();
            if (Keys.pressed[Keys.ENTER]) {
                resetGame();
            }
            return;
        }

        // Update
        player.updateFromMouse();
        if (hitCooldownFrames > 0) hitCooldownFrames--;

        for (FoodDot f : foods) {
            // if player touches food -> score + respawn
            if (player.touches(f.x, f.y, f.r)) {
                score += 1;
                f.respawn();
            }
            f.draw();
        }

        for (Bomb b : bombs) {
            b.move(); // draws inside move()

            // collide with player
            if (hitCooldownFrames == 0 && b.touches(player.x, player.y, player.r)) {
                lives -= 1;
                hitCooldownFrames = 25; // ~0.75 sec at 30ms/frame

                // send player back to center so it feels fair
                player.x = Game.width / 2;
                player.y = Game.height / 2;

                if (lives <= 0) {
                    gameOver = true;
                }
            }
        }

        // Draw player last so it's on top
        player.draw();

        // Draw HUD
        drawHUD();
    }

    private void drawHUD() {
        Game.canvas.setFont(new Font("Arial", Font.BOLD, 18));
        Game.canvas.setColor(Color.WHITE);
        Game.canvas.drawString("Score: " + score, 15, 25);
        Game.canvas.drawString("Lives: " + lives, 15, 48);
    }

    private void drawGameOver() {
        Game.canvas.setFont(new Font("Arial", Font.BOLD, 42));
        Game.canvas.setColor(Color.WHITE);
        Game.canvas.drawString("GAME OVER", 160, 200);

        Game.canvas.setFont(new Font("Arial", Font.PLAIN, 18));
        Game.canvas.drawString("Press ENTER to play again", 190, 235);
    }

    private void resetGame() {
        score = 0;
        lives = 3;
        gameOver = false;
        hitCooldownFrames = 0;

        player.x = Game.width / 2;
        player.y = Game.height / 2;

        for (FoodDot f : foods) {
            f.respawn();
        }

        for (Bomb b : bombs) {
            b.x = randInt(50, Game.width - 80);
            b.y = randInt(0, 200);
        }
    }

    private int randInt(int lower, int upper) {
        int range = upper - lower;
        return (int) (Math.random() * range + lower);
    }
}
