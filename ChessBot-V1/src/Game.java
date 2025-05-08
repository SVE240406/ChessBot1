import java.util.Arrays;

/**
 * Die Spiele-Klasse in der alle Funktionen des Spiels "Tic Tac Toe" realisiert sind.
 *
 * @author Nikolai Sverdlov
 * @version V1
 */
public class Game {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public boolean[][] possibleMovesSelected = {{false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false}};
    private int selectedIndex = 0;
    private boolean weissIstAnDerReihe;
    private boolean spielIstZuEnde;
    String blackPieces = "♚♛♜♝♞♟";
    String whitePieces = "♔♕♖♗♘♙";

    private final GUI oberflaeche = new GUI("Chess", board, this);

    public Game() {
        board = new char[8][8];
        neuesSpiel();
    }

    private void neuesSpiel() {
        createBoard();
        possibleMovesSelected = new boolean[8][8];
        for (int i = 0; i < 8; i++)
            Arrays.fill(possibleMovesSelected[i], false);
        oberflaeche.resetArray(board);
        weissIstAnDerReihe = true;
        spielIstZuEnde = false;
        oberflaeche.aktualisiereAnzeige();
    }

    public void mausKlick(int zeile, int spalte, int maustaste) {
        if(board[zeile][spalte] == ' ' && !possibleMovesSelected[zeile][spalte]) {
            for (boolean[] booleans : possibleMovesSelected) Arrays.fill(booleans, false);
        }else if(possibleMovesSelected[zeile][spalte]) {
            char selectedPiece = board[selectedIndex/10][selectedIndex%10];
            board[selectedIndex/10][selectedIndex%10] = ' ';
            for (boolean[] booleans : possibleMovesSelected) Arrays.fill(booleans, false);
            selectedIndex = 0;
            board[zeile][spalte] = selectedPiece;
            weissIstAnDerReihe = !weissIstAnDerReihe;
        }else{
            for (boolean[] booleans : possibleMovesSelected) Arrays.fill(booleans, false);
            if(weissIstAnDerReihe) {
                switch (board[zeile][spalte]) {
                    case '♔':
                        for (int i = 0; i < 3; i++)
                            for (int j = 0; j < 3; j++)
                                if (board[zeile + i][spalte + j] == ' ')
                                    possibleMovesSelected[zeile + 1][spalte] = true;

                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♕':
                        for (int i = 1; zeile + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile + i][spalte]))
                                break;
                            possibleMovesSelected[zeile + i][spalte] = true;
                            if(blackPieces.contains(""+board[zeile + i][spalte]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile - i][spalte]))
                                break;
                            possibleMovesSelected[zeile - i][spalte] = true;
                            if (blackPieces.contains(""+board[zeile - i][spalte]))
                                break;
                        }
                        for (int i = 1; spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile][spalte + i]))
                                break;
                            possibleMovesSelected[zeile][spalte + i] = true;
                            if (blackPieces.contains(""+board[zeile][spalte + i]))
                                break;
                        }
                        for (int i = 1; spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile][spalte - i]))
                                break;
                            possibleMovesSelected[zeile][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile + i][spalte+i] = true;
                            if(blackPieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile - i][spalte+i] = true;
                            if (blackPieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile+i][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile-i][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♖':
                        for (int i = 1; zeile + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile + i][spalte]))
                                break;
                            possibleMovesSelected[zeile + i][spalte] = true;
                            if(blackPieces.contains(""+board[zeile + i][spalte]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile - i][spalte]))
                                break;
                            possibleMovesSelected[zeile - i][spalte] = true;
                            if (blackPieces.contains(""+board[zeile - i][spalte]))
                                break;
                        }
                        for (int i = 1; spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile][spalte + i]))
                                break;
                            possibleMovesSelected[zeile][spalte + i] = true;
                            if (blackPieces.contains(""+board[zeile][spalte + i]))
                                break;
                        }
                        for (int i = 1; spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile][spalte - i]))
                                break;
                            possibleMovesSelected[zeile][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♗':
                        for (int i = 1; zeile + i <= 7 && spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile + i][spalte+i] = true;
                            if(blackPieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte + i <= 7; i++) {
                            if (whitePieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile - i][spalte+i] = true;
                            if (blackPieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile+i][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte - i >= 0; i++) {
                            if (whitePieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile-i][spalte - i] = true;
                            if (blackPieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♘':

                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♙':
                        if (board[zeile - 1][spalte] == ' ')
                            possibleMovesSelected[zeile - 1][spalte] = true;
                        if (spalte - 1 >= 0 && board[zeile - 1][spalte - 1] != ' ')
                            possibleMovesSelected[zeile - 1][spalte - 1] = true;
                        if (spalte + 1 < 8 && board[zeile - 1][spalte + 1] != ' ')
                            possibleMovesSelected[zeile - 1][spalte + 1] = true;
                        if (zeile == 6 && board[zeile - 2][spalte] == ' ')
                            possibleMovesSelected[zeile - 2][spalte] = true;
                        selectedIndex = zeile * 10 + spalte;
                        break;
                }
            }else{
                switch (board[zeile][spalte]) {
                    case '♚':
                        for (int i = 0; i < 3; i++)
                            for (int j = 0; j < 3; j++)
                                if (board[zeile + i][spalte + j] == ' ')
                                    possibleMovesSelected[zeile + 1][spalte] = true;
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♛':
                        for (int i = 1; zeile + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile + i][spalte]))
                                break;
                            possibleMovesSelected[zeile + i][spalte] = true;
                            if(whitePieces.contains(""+board[zeile + i][spalte]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile - i][spalte]))
                                break;
                            possibleMovesSelected[zeile - i][spalte] = true;
                            if (whitePieces.contains(""+board[zeile - i][spalte]))
                                break;
                        }
                        for (int i = 1; spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile][spalte + i]))
                                break;
                            possibleMovesSelected[zeile][spalte + i] = true;
                            if (whitePieces.contains(""+board[zeile][spalte + i]))
                                break;
                        }
                        for (int i = 1; spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile][spalte - i]))
                                break;
                            possibleMovesSelected[zeile][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile + i][spalte+i] = true;
                            if(whitePieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile - i][spalte+i] = true;
                            if (whitePieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile+i][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile-i][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♜':
                        for (int i = 1; zeile + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile + i][spalte]))
                                break;
                            possibleMovesSelected[zeile + i][spalte] = true;
                            if(whitePieces.contains(""+board[zeile + i][spalte]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile - i][spalte]))
                                break;
                            possibleMovesSelected[zeile - i][spalte] = true;
                            if (whitePieces.contains(""+board[zeile - i][spalte]))
                                break;
                        }
                        for (int i = 1; spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile][spalte + i]))
                                break;
                            possibleMovesSelected[zeile][spalte + i] = true;
                            if (whitePieces.contains(""+board[zeile][spalte + i]))
                                break;
                        }
                        for (int i = 1; spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile][spalte - i]))
                                break;
                            possibleMovesSelected[zeile][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♝':
                        for (int i = 1; zeile + i <= 7 && spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile + i][spalte+i] = true;
                            if(whitePieces.contains(""+board[zeile + i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte + i <= 7; i++) {
                            if (blackPieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                            possibleMovesSelected[zeile - i][spalte+i] = true;
                            if (whitePieces.contains(""+board[zeile - i][spalte+i]))
                                break;
                        }
                        for (int i = 1; zeile + i <= 7 && spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile+i][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile+i][spalte - i]))
                                break;
                        }
                        for (int i = 1; zeile - i >= 0 && spalte - i >= 0; i++) {
                            if (blackPieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                            possibleMovesSelected[zeile-i][spalte - i] = true;
                            if (whitePieces.contains(""+board[zeile-i][spalte - i]))
                                break;
                        }
                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♞':

                        selectedIndex = zeile * 10 + spalte;
                        break;
                    case '♟':
                        if (board[zeile + 1][spalte] == ' ')
                            possibleMovesSelected[zeile + 1][spalte] = true;
                        if (spalte + 1 < 8 && board[zeile + 1][spalte + 1] != ' ')
                            possibleMovesSelected[zeile + 1][spalte + 1] = true;
                        if (spalte - 1 >= 0 && board[zeile + 1][spalte - 1] != ' ')
                            possibleMovesSelected[zeile + 1][spalte - 1] = true;
                        if (zeile == 1 && board[zeile + 2][spalte] == ' ')
                            possibleMovesSelected[zeile + 2][spalte] = true;
                        selectedIndex = zeile * 10 + spalte;
                        break;
                }
            }
        }
        oberflaeche.aktualisiereAnzeige();
    }

    private void createBoard() {
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
                                board[i][j] = '♖';
                                break;
                            case 1, 6:
                                board[i][j] = '♘';
                                break;
                            case 2, 5:
                                board[i][j] = '♗';
                                break;
                            case 3:
                                board[i][j] = '♕';
                                break;
                            case 4:
                                board[i][j] = '♔';
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
    }

    public static void main(String[] args){new Game();}
}