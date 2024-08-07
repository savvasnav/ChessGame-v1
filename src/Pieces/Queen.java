package Pieces;

import Game.Player;
import Game.Type;

public class Queen extends Piece{
    Type type;
    /**
     * Constructor for a Piece.
     *
     * @param x      the x location of the Piece
     * @param y      the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public Queen(int x, int y, Player player) {
        super(x, y, player);
        type = Type.QUEEN;
    }

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = finalX - m_x;
        int y_diff = finalY - m_y;
        return (x_diff == y_diff)||(finalX==m_x || finalY==m_y);
    }

    @Override
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        return new int[0][];
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }
}
