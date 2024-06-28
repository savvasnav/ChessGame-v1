package Pieces;

import Game.*;

public abstract class Piece {

    public int m_x,m_y;
    public Player m_player;
    /** Constructor for a Piece.
     * @param x the x location of the Piece
     * @param y the y location of the Piece
     * @param player the Player object associated with the Piece
     **/
    public Piece (int x, int y, Player player){
        m_x = x;
        m_y = y;
        m_player = player;
       // myGame.player.gameBoard.boardArray[x][y];
    }

    /**
     * A function that determines if the path is valid on Piece type.
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return a boolean indicating whether the path is valid
     */

    public abstract boolean isValidPath(int finalX, int finalY);

    /**
     * A function that draws a path from one point to the other based on Piece type and stores the coordinates
     * @param startX the initial X location
     * @param startY the initial Y location
     * @param finalX the final X location
     * @param finalY the final Y location
     * @return an array of coordinates of the given Path
     */
    public abstract int[][] drawPath(int startX, int startY , int finalX, int finalY);

    /**
     * A function that returns the type of Piece
     * @return an integer indicating the Piece type
     */
    public abstract Type getType();

}
