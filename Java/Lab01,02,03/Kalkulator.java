package Lab01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame{
    private JPanel JPanel1;
    private JTextField textFieldB;
    private JTextField textFieldA;
    private JButton sumaButton;
    private JButton roznicaButton;
    private JButton iloczynButton;
    private JButton ilorazButton;
    private JButton wyczyscPolaButton;
    private JButton wyjscieButton;
    private JLabel JLabelScore;

    double valueA, valueB, score;

    public static void main(String[] args) {
       Kalkulator kalkulator = new Kalkulator();
       kalkulator.setVisible(true);
    }

    public Kalkulator() {

        super("Moje pierwsze GUI");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textFieldA.getText());
                valueB = Double.parseDouble(textFieldB.getText());
                score = valueA + valueB;
                JLabelScore.setText("Wynik "+valueA+ " + "+valueB
                        + " = " +score);
            }
        });
        roznicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textFieldA.getText());
                valueB = Double.parseDouble(textFieldB.getText());
                score = valueA - valueB;
                JLabelScore.setText("Wynik "+valueA+ " - "+valueB
                        + " = " +score);
            }
        });
        iloczynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textFieldA.getText());
                valueB = Double.parseDouble(textFieldB.getText());
                score = valueA * valueB;
                JLabelScore.setText("Wynik "+valueA+ " * "+valueB
                        + " = " +score);
            }
        });
        ilorazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(textFieldA.getText());
                valueB = Double.parseDouble(textFieldB.getText());
                if(valueB != 0){
                score = valueA / valueB;
                JLabelScore.setText("Wynik "+valueA+ " / "+valueB
                        + " = " +score);
                }
                else JLabelScore.setText("Nie można dzielic przez zero");
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        wyczyscPolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelScore.setText("Wynik działania ...");
                textFieldA.setText("");
                textFieldB.setText("");
            }
        });
    }
}
