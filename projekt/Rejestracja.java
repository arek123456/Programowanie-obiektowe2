package Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rejestracja extends JDialog {
    private JPanel JPanel2;
    private JTextField imieTF;
    private JTextField nazwiskoTF;
    private JTextField emailTF;
    private JTextField loginTF;
    private JButton zarejestrujBtn;
    private JButton zamknijBtn;
    private JButton wsteczBtn;
    private JPasswordField hasloPF;
    private JPasswordField potwierdzhasloPF;

    public Rejestracja(JFrame parent) {
        super(parent);
        setTitle("Formularz rejestracji");
        setContentPane(JPanel2);
        int width = 450, height = 385;
        setMinimumSize(new Dimension(width, height));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        wsteczBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Logowanie logowanie = new Logowanie(null);
                logowanie.setVisible(true);
            }
        });

        zarejestrujBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rejestracjaUzytkownika();
            }
        });

        zamknijBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void rejestracjaUzytkownika() {
        String imie = imieTF.getText();
        String nazwisko = nazwiskoTF.getText();
        String email = emailTF.getText();
        Pattern pattern1 = Pattern.compile("[a-zA-Z]+");
        Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
        Pattern pattern3 = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher1 = pattern1.matcher(imie);
        Matcher matcher2 = pattern2.matcher(nazwisko);
        Matcher matcher3 = pattern3.matcher(email);
        if (!matcher1.matches() || !matcher2.matches() || !matcher3.matches()) {
            JOptionPane.showMessageDialog(this,
                    "Proszę podać prawidłowe dane!",
                    "Spróbuj ponownie",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            String login = loginTF.getText();
            String haslo = String.valueOf(hasloPF.getPassword());
            String potwierdzhaslo = String.valueOf(potwierdzhasloPF.getPassword());
            if (imie.isEmpty() || nazwisko.isEmpty() || email.isEmpty() || login.isEmpty() || haslo.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Wypełnij wszystkie pola!",
                        "Spróbuj ponownie",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!haslo.equals(potwierdzhaslo)) {
                JOptionPane.showMessageDialog(this,
                        "Podane hasła nie są takie same!",
                        "Spróbuj ponownie",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            uzytkownik = dodawanieUzytkownikaDoBazy(imie, nazwisko, email, login, haslo);
            if (uzytkownik != null) {
                dispose();
                Logowanie logowanie = new Logowanie(null);
                logowanie.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Błąd w rejestracji użytkownika!",
                        "Spróbuj ponownie",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Uzytkownik uzytkownik;

    private Uzytkownik dodawanieUzytkownikaDoBazy(String imie,String nazwisko,String email,String login,String haslo) {
        Uzytkownik uzytkownik = null;

        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO uzytkownicy (imie,nazwisko,email,login,haslo) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,imie);
            preparedStatement.setString(2,nazwisko);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,login);
            preparedStatement.setString(5,haslo);
            int dodanieUzytkownika = preparedStatement.executeUpdate();
            if (dodanieUzytkownika > 0) {
                uzytkownik = new Uzytkownik();
                uzytkownik.imie = imie;
                uzytkownik.nazwisko  = nazwisko;
                uzytkownik.email = email;
                uzytkownik.login = login;
                uzytkownik.haslo = haslo;
            }
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return uzytkownik;
    }
}