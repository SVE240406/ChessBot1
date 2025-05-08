import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class GUI extends JFrame {
    private final boolean[][] backgroundBlack = new boolean[8][8];
    private JButton[][] buttons;       // "Darstellungseigenschaften" der Felder (JButtons)
    private char[][] settings;         // eine Referenz auf das übergebene Array
    private Game spiel;                // eine Referenz auf die Spiele-Instanz für den "Rückruf"
    private MouseListener mListener;

    public GUI(String titel, char[][] gesetzt, Game spiel) {
        super(titel);
        this.spiel = spiel;

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                backgroundBlack[i][j] = i % 2 + j % 2 == 1;

        if (gesetzt != null && gesetzt.length > 0 && gesetzt[0].length > 0) {
            settings = new char[8][8];
            for (int i = 0; i < 8; i++)
                Arrays.fill(settings[i], ' ');
            buttons = new JButton[settings.length][settings[0].length];
            // -> alle Zeilen haben soviele Elemente wie die erste Zeile!
            init();
        } else
            System.err.println("Kein gültiges Array übergeben!");
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(10, 10));
        if (spiel != null)
            mListener = new MyMouseListener();

        JButton actButton = null;
        for (int row = 0; row < 10; row++)
            for (int col = 0; col < 10; col++) {
                actButton = new JButton();
                actButton.setEnabled(false);
                actButton.setFont(new Font("Arial", Font.PLAIN, 20));
                if (mListener != null && row != 0&&row !=9 && col != 0&&col!= 9) {
                    actButton.addMouseListener(mListener);
                    actButton.setBackground(getColor(row-1, col-1));
                    actButton.setFont(new Font("Cabrili", Font.PLAIN, 34));
                    buttons[row-1][col-1] = actButton;
                }else {
                    actButton.setBackground(Color.LIGHT_GRAY);
                    if((col == 0 || col == 9) && !(row == 0 || row == 9))
                        actButton.setText("" + (9-row));
                    else if(!(col == 0 || col == 9) && (row == 0 || row == 9))
                        actButton.setText("" + (char)(col+96));
                }

                add(actButton);
            }

        setBounds(20, 20, (backgroundBlack[0].length+2) * 70, (backgroundBlack.length+2) * 70);
        aktualisiereAnzeige();
        setResizable(false);
        setVisible(true);
    }

    public void aktualisiereAnzeige() {
        JButton actButton = null;
        for (int row = 0; row < settings.length; row++)
            for (int col = 0; col < settings[0].length; col++) {
                actButton = buttons[row][col];
                actButton.setText("" + settings[row][col]);
                actButton.setBackground(getColor(row,col));
            }
    }

    public Color getColor(int row, int col) {
        if(!spiel.possibleMovesSelected[row][col]){
            if (backgroundBlack[row][col])
                return Color.BLACK;
            else
                return Color.WHITE;
        }else {
            if (backgroundBlack[row][col])
                return Color.DARK_GRAY;
            else
                return Color.LIGHT_GRAY;
        }
    }

    private class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (spiel == null) return;

            for (int row = 0; row < settings.length; row++)
                for (int col = 0; col < settings[0].length; col++)
                    if (e.getSource() == buttons[row][col])
                        spiel.mausKlick(row, col, e.getButton());
        }
    }

    public void popup(String titel, String nachricht, boolean fehler) {
        if (fehler)
            JOptionPane.showMessageDialog(this, nachricht, titel, JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, nachricht, titel, JOptionPane.INFORMATION_MESSAGE);
    }

    public void resetArray(char[][] gesetzt) {
        settings = gesetzt;
    }
}

