package Pieces;

import GUI.ChessBoardGUI;
import Game.Player;
import Game.Type;

public class King extends Piece {
    Type type;
    /**
     * Constructor for a Piece.
     *
     * @param x      the x location of the Piece
     * @param y      the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public King(int x, int y, Player player) {
        super(x, y, player);
        type = Type.KING;
    }

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff =Math.abs(finalX - m_x);
        int y_diff = Math.abs(finalY - m_y);
        return (x_diff + y_diff == 1) || (x_diff + y_diff == 2);
    }

    @Override
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {

        return new int[0][];
    }

    @Override
    public Type getType() {
        return Type.KING;
    }
}
