package Engine;

public class Player implements Moves{
    boolean life;
    String name;
    int x;
    int y;

    public Player(boolean life, String name, int x, int y) {
        this.life = life;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public void up() {
        x =+ 1;
    }

    @Override
    public void down() {
        x =- 1;
    }

    @Override
    public void left() {
        y =- 1;
    }

    @Override
    public void right() {
        y =+ 1;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
