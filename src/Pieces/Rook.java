package Pieces;

import Game.Player;
import Game.Type;

public class Rook extends Piece {
    Type type;
    /**
     * Constructor for a Piece.
     *
     * @param x      the x location of the Piece
     * @param y      the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public Rook(int x, int y, Player player) {
        super(x, y, player);
        type = Type.ROOK;
    }

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        return (finalX==m_x || finalY==m_y);
    }

    @Override
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = Math.abs(finalX - startX)+Math.abs(finalY-startY);
        int x_dir = 0, y_dir = 0;
        if(finalX - startX!=0){
           if(finalX>0){
               x_dir = 1;
           }
           else{
               x_dir= -1;
           }
        }
        if(finalY - startY!=0){
            if(finalY>0){
                y_dir = 1;
            }
            else {
                y_dir = -1;
            }
        }
        int [][] path = new int[2][pairs - 1];

        if(pairs - 1 > 0){
            for (int i = 0; i < pairs - 1;i++){
                path[0][i] = startX + x_dir*(i+1);
                path[1][i] = startY + y_dir*(i+1);
            }
        }
        return path;

    }

    @Override
    public Type getType() {
        return null;
    }
}
