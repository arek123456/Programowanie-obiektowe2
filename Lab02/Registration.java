package Lab02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Registration extends JDialog{
    private JPanel registerPanel;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAdrress;
    private JPasswordField pfPassword;
    private JPasswordField pfPasswordConfirm;
    private JButton btnRegister;
    private JButton btnCancel;

    public Registration(JFrame parent){
        super(parent);
        setTitle("Create the new account");
        setVisible(true);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    private void registerUser(){
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String address = tfAdrress.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfPasswordConfirm.getPassword());

        if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter all fields","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,"Confirm Password does not match","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = addUserToDatabase(name,email,phone,address,password);
        if(user != null) {
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Failed to register new user","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    public User user;
    private User addUserToDatabase(String name, String email, String phone, String address, String password){
        User user = null;
        //sprawdzenie połączenia do bazy
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name,email,phone,address,password) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,password);
            //insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.address = address;
                user.password = password;
            }
            //close connection
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        Registration myform = new Registration(null);
        User user = myform.user;
        if(user!=null){
            System.out.println("Succesfull registration of: "+user.name);
        }
        else{
            System.out.println("Registration failed");
        }
    }
}
