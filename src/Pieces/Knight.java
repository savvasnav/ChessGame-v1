package Pieces;

import Game.Player;
import Game.Type;

public class Knight extends Piece{
    Type type;
    /**
     * Constructor for a Piece.
     *
     * @param x      the x location of the Piece
     * @param y      the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public Knight(int x, int y, Player player) {
        super(x, y, player);
        type = Type.KNIGHT;
    }

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - m_x);
        int y_diff = Math.abs(finalY - m_y);
        return (x_diff == 2 && y_diff == 1) || (x_diff == 1 && y_diff == 2);
    }

    @Override
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {

        // Knights jump directly to the destination, so there are no intermediate squares
        return new int[2][0];  // Returning an empty path


    }

    @Override
    public Type getType() {
        return Type.KNIGHT;
    }
}
