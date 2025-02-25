class Chessboard {
    private String[][] board;

    public Chessboard() {
        board = new String[8][8];
    }

    // populates the chessboard with all pieces
    public void populate() {
        // Initialize with empty spaces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = "   ";
            }
        }

        board[7][0] = " R ";  // Rook
        board[7][1] = " K ";  // Knight
        board[7][2] = " B ";  // Bishop
        board[7][3] = " Q ";  // Queen
        board[7][4] = " C ";  // King
        board[7][5] = " B ";  // Bishop
        board[7][6] = " K ";  // Knight
        board[7][7] = " R ";  // Rook
        // repeat setup for pawns
        for (int col = 0; col < 8; col++) {
            board[6][col] = " P ";
        }
        
        board[0][0] = " r ";  // Rook
        board[0][1] = " k ";  // Knight
        board[0][2] = " b ";  // Bishop
        board[0][3] = " q ";  // Queen
        board[0][4] = " c ";  // King
        board[0][5] = " b ";  // Bishop
        board[0][6] = " k ";  // Knight
        board[0][7] = " r ";  // Rook

        // Set up black pawns
        for (int col = 0; col < 8; col++) {
            board[1][col] = " p ";
        }

    }

    public void display() {
        for (int row = 0; row < board[0].length; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    public void movePiece(int row, int col, int move_row, int move_col) {
        int new_row = row + move_row;
        int new_col = col + move_col;
        if(0 <= new_row && new_row <= 7 && 0 <= new_col && new_col <= 7) {
            switch(board[row][col]) {
                case " p ":
                    if(move_col == 0 && 0 < move_row && move_row < (row + 2)) {
                        board[row][col] = "   ";
                        board[new_row][new_col] = " p ";
                    }
                    else
                        System.out.println("Error. Invalid Move");
                    break;
                default:
                    System.out.println("Error. Invalid Move");
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Chessboard cb = new Chessboard();
        cb.populate();
        cb.display();
        cb.movePiece(1,1,2,0);
        cb.display();
    }
}