package Lab01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konwerter extends JFrame{
    private JPanel JPanel1;
    private JTextField textField1;
    private JButton konwertujButton;
    private JLabel JLabelWynik;
    private JButton wyjscieButton;
    double liczba,wynik;

    public static void main(String[] args) {
        Konwerter konwerter = new Konwerter();
        konwerter.setVisible(true);
    }
    public Konwerter(){
        super("Konwerter stopni Celsjusza na Fahreinheita");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        konwertujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczba = Double.parseDouble(textField1.getText());
                wynik = 2*liczba+32;
                JLabelWynik.setText("Po konwersji: "+wynik+" Fahreinheit");
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
