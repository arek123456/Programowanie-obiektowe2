package Lab02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog{
    private JPanel loginPanel;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnOk;
    private JButton btnCancel;
    public Login(JFrame parent){

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                user = getAutenticateUser(email,password);
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login(null);
        User user = Login.user;
    }
}
