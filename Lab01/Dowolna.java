package Lab01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dowolna extends JFrame{
    private JPanel JPanel1;
    private JTextField textField1;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JLabel JLabel1;
    private JLabel JLabel2;
    String tekstA, tekstB;

    public static void main(String[] args) {
        Dowolna dowolna = new Dowolna();
        dowolna.setVisible(true);
    }
    public Dowolna(){
        super("Zamiana String");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekstA = textField1.getText();
                tekstA = tekstA.toUpperCase();
                JLabel1.setText(tekstA);
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekstB = textField1.getText();
                tekstB = tekstB.toLowerCase();
                JLabel2.setText(tekstB);
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
