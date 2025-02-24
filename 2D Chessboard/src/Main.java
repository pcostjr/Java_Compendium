class Chessboard {
    String[][] board;

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
        board[7][1] = " N ";  // Knight
        board[7][2] = " B ";  // Bishop
        board[7][3] = " Q ";  // Queen
        board[7][4] = " K ";  // King
        board[7][5] = " B ";  // Bishop
        board[7][6] = " N ";  // Knight
        board[7][7] = " R ";  // Rook
        // repeat setup for pawns
        for (int col = 0; col < 8; col++) {
            board[6][col] = " P ";
        }
        
        board[0][0] = " r ";  // Rook
        board[0][1] = " n ";  // Knight
        board[0][2] = " b ";  // Bishop
        board[0][3] = " q ";  // Queen
        board[0][4] = " k ";  // King
        board[0][5] = " b ";  // Bishop
        board[0][6] = " n ";  // Knight
        board[0][7] = " r ";  // Rook

        // Set up black pawns
        for (int col = 0; col < 8; col++) {
            board[1][col] = " p ";
        }

    }

    public void display() {
        for (int row = 0; row < 8; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Chessboard cb = new Chessboard();
        cb.populate();
        cb.display();

    }
}