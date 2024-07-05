package Pieces;

import GUI.ChessBoardGUI;
import Game.Player;
import Game.Type;

public class Pawn extends Piece{
    Type type;
    /**
     * Constructor for a Piece.
     *
     * @param x      the x location of the Piece
     * @param y      the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public Pawn(int x, int y, Player player) {
        super(x, y, player);
        type = Type.PAWN;
    }

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = finalX - m_x;
        int y_diff = finalY - m_y;
        if(x_diff == 0){
            if(ChessBoardGUI.isWhiteTurn){
                if(y_diff==1||(y_diff == 2 && m_y == 1)){
                    return true;
                }
            }
            else {
                if(y_diff == -1 || (y_diff == -2 && m_y == 6)){
                    return true;
                }
            }
        }
        if(Math.abs(x_diff)==1){
            if(ChessBoardGUI.isWhiteTurn && y_diff==1){
                return true;
            }
            else if(!(ChessBoardGUI.isWhiteTurn) && y_diff ==-1){
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = Math.abs(finalY-startY);
        int[][] path = new int[2][pairs];
        if(pairs > 0 ){
            for(int i=0;i<pairs;i++){
                path[0][i] = startX;
                path[1][i] = startY + ((ChessBoardGUI.isWhiteTurn)?1:-1)*(i+1);
            }
        }

        return path;
    }

    @Override
    public Type getType() {
        return Type.PAWN;
    }
}
