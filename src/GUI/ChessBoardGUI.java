package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ChessBoardGUI extends JFrame {

    private static final int BOARD_SIZE = 8;
    private JPanel chessBoardPanel;
    public static boolean isWhiteTurn;
    private static JButton[][] squares;
    public ChessBoardGUI(){
        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());
        //Setup Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem startGameItem = new JMenuItem("Start Game");
        JMenuItem exitItem = new JMenuItem("Exit");
        startGameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(startGameItem);
        menu.add(exitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);


        chessBoardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squares = new JButton[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0 ; i < BOARD_SIZE;i++){
            for (int j = 0 ; j < BOARD_SIZE;j++){
                squares[i][j] = new JButton();
                if((i + j) % 2 == 0){
                    squares[i][j].setBackground(Color.WHITE);
                }
                else {
                    squares[i][j].setBackground(Color.GRAY);
                }
                squares[i][j].addActionListener(new BoardButtonListener(i,j));
                chessBoardPanel.add(squares[i][j]);
            }
            frame.add(chessBoardPanel,BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
    private void startGame(){
        for(int i = 0; i<BOARD_SIZE;i++){
            for(int j = 0; j<BOARD_SIZE;j++){
                squares[i][j].setIcon(null);
            }
            isWhiteTurn = true; // Start with White's turn

            for(i = 0; i<BOARD_SIZE; i++){
                squares[1][i].setIcon(new ImageIcon(".\\white_pawn.png"));
                squares[6][i].setIcon(new ImageIcon(".\\black_pawn.png"));
            }

            squares[0][0].setIcon(new ImageIcon(".\\white_rook.png"));
            squares[0][7].setIcon(new ImageIcon(".\\white_rook.png"));
            squares[7][0].setIcon(new ImageIcon(".\\black_rook.png"));
            squares[7][7].setIcon(new ImageIcon(".\\black_rook.png"));
            squares[0][1].setIcon(new ImageIcon(".\\white_knight.png"));
            squares[0][6].setIcon(new ImageIcon(".\\white_knight.png"));
            squares[7][1].setIcon(new ImageIcon(".\\black_knight.png"));
            squares[7][6].setIcon(new ImageIcon(".\\black_knight.png"));
            squares[0][2].setIcon(new ImageIcon(".\\white_bishop.png"));
            squares[0][5].setIcon(new ImageIcon(".\\white_bishop.png"));
            squares[7][2].setIcon(new ImageIcon(".\\black_bishop.png"));
            squares[7][5].setIcon(new ImageIcon(".\\black_bishop.png"));
            squares[0][3].setIcon(new ImageIcon(".\\white_queen.png"));
            squares[7][3].setIcon(new ImageIcon(".\\black_queen.png"));
            squares[0][4].setIcon(new ImageIcon(".\\white_king.png"));
            squares[7][4].setIcon(new ImageIcon(".\\black_king.png"));
        }

    }
    private void switchTurn() {
        isWhiteTurn = !isWhiteTurn;
    }
    private class BoardButtonListener implements ActionListener{
        private int m_x,m_y;
        private BoardButtonListener(int x,int y){
            m_x = x;
            m_y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getIcon()!= null){
                switchTurn();
            }
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChessBoardGUI();
            }
        });
    }
}
