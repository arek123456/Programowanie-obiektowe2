package Lab01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Cwiczenie extends JFrame{
    private JPanel JPanel1;
    private JButton okButton;
    private JButton wyjscieButton;
    private JLabel JLabelText1;
    private JLabel JLabelData;
    private JButton klikButton;

    public static void main(String[] args) {
        Cwiczenie cwiczenie = new Cwiczenie();
        cwiczenie.setVisible(true);
    }//koniec main

    public Cwiczenie(){
        super("jk12345");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height = 300;
        this.setSize(width,height);
        //this.pack();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = JOptionPane.showInputDialog("Podaj imie");

                //JOptionPane.showMessageDialog(null, "Witaj "+ text);
                //JOptionPane.showMessageDialog(null, "Witaj "+ text,
                       // "Uwaga", JOptionPane.WARNING_MESSAGE);

                JOptionPane.showMessageDialog(null, "Witaj "+ text,
                        "Uwaga", JOptionPane.YES_NO_OPTION);


            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        klikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabelText1.setText("to jest tekt po zmienie");
                JLabelData.setText(new Date().toString());
            }
        });
    }

}
