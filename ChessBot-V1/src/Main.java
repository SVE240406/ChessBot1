import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static char[][] board = new char[8][8];
    public static String[] PossibleMoves;
    public static boolean playerIsWhite = true;
    public static boolean whiteOnMove = true;
    public static boolean check = false;

    public Main(char[][] board) {
        if (board.length == this.board.length)
            this.board = board;
    }

    public static void main(String[] args) {
        createBoard();
        playerMoves();
    }

    public static void createBoard() {
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < 8; j++) {
                        switch (j) {
                            case 0, 7:
                                board[i][j] = '♜';
                                break;
                            case 1, 6:
                                board[i][j] = '♞';
                                break;
                            case 2, 5:
                                board[i][j] = '♝';
                                break;
                            case 3:
                                board[i][j] = '♛';
                                break;
                            case 4:
                                board[i][j] = '♚';
                                break;
                        }
                    }
                    break;
                case 7:
                    for (int j = 0; j < 8; j++) {
                        switch (j) {
                            case 0, 7:
                                board[i][j] = '♜';
                                break;
                            case 1, 6:
                                board[i][j] = '♞';
                                break;
                            case 2, 5:
                                board[i][j] = '♝';
                                break;
                            case 3:
                                board[i][j] = '♛';
                                break;
                            case 4:
                                board[i][j] = '♚';
                                break;
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < 8; j++)
                        board[i][j] = '♟';
                    break;
                case 6:
                    for (int j = 0; j < 8; j++)
                        board[i][j] = '♙';
                    break;
                default:
                    for (int j = 0; j < 8; j++)
                        board[i][j] = ' ';
                    break;
            }
        }

        printBoard();
    }

    public static void legalMoves(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(whiteOnMove) {
                    switch (board[i][j]) {
                        case 'R':
                            for (int k = i; true; k++) {
                            }
                        case 'N':
                        case 'B':
                        case 'Q':
                        case 'K':
                        case 'P':
                    }
                }
                else{

                }
            }
        }
    }

    public static void playerMoves() {
        String move = scanner.nextLine();
        if (move.charAt(move.length() - 1) == '#' || move.charAt(move.length() - 1) == '+') {
            check = true;
            if (move.charAt(move.length() - 1) == '#') {
                System.out.println((playerIsWhite) ? "1:0" : "0:1");
                System.exit(0);
            }
            move = move.substring(0, move.length() - 1);
        } else if (move.toUpperCase().charAt(move.length() - 1) == 'O') {
            if (move.toUpperCase().equals("O-O-O")) {
                if (playerIsWhite) {
                    if (board[0][0] == 'R' && board[0][1] == 'c' && board[0][2] == 'c' && board[0][3] == 'c' && board[0][4] == 'K') {
                        board[0][0] = board[0][4] = 'c';
                        board[0][2] = 'K';
                        board[0][3] = 'R';
                        printBoard();
                    }
                } else {
                    if (board[8][0] == 'R' && board[8][1] == 'c' && board[8][2] == 'c' && board[8][3] == 'c' && board[8][4] == 'K') {
                        board[8][0] = board[8][4] = 'c';
                        board[8][2] = 'K';
                        board[8][3] = 'R';
                        printBoard();
                    }
                }
            } else {
                if (playerIsWhite) {
                    if (board[0][4]=='K'&&board[0][5]=='c'&&board[0][6]=='c'&&board[0][7]=='R') {
                        board[0][7] = board[0][4] = 'c';
                        board[0][5] = 'R';
                        board[0][6] = 'K';
                        printBoard();
                    }
                } else {
                    if (board[8][4]=='K'&&board[8][5]=='c'&&board[8][6]=='c'&&board[8][7]=='R') {
                        board[8][7] = board[8][4] = 'c';
                        board[8][5] = 'R';
                        board[8][6] = 'K';
                        printBoard();
                    }
                }
            }
        }
        switch (move.toUpperCase().charAt(0)) {
            case 'R':
                if (move.toUpperCase().charAt(move.length()-3)=='x'){

                }
            case 'N':
            case 'B':
            case 'Q':
            case 'K':
            default:
        }
    }


    public static void addMove (String move) {
        String[] arr = new String[PossibleMoves.length+1];
        for (int i = 0; i < PossibleMoves.length; i++)
            arr[i] = PossibleMoves[i];
        arr[PossibleMoves.length] = move;
        PossibleMoves = arr;
    }

    public static void printBoard() {
        for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < 8; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }
}