package Game;



public class Player {

    public enum Color{
        WHITE,BLACK
    }

    private Color color;

    public Player(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }


}
