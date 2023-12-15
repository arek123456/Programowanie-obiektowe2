package Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Logowanie extends JDialog {
    private JTextField loginTF;
    private JPasswordField hasloPF;
    private JButton zalogujBtn;
    private JButton zamknijBtn;
    private javax.swing.JPanel JPanel1;
    private JButton brakkontaBtn;

    public Logowanie(JFrame parent) {
        super(parent);
        setTitle("Formularz logowania");
        setContentPane(JPanel1);
        int width = 450, height = 385;
        setMinimumSize(new Dimension(width,height));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        polaczenieZBaza();

        zalogujBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginTF.getText();
                String haslo = String.valueOf(hasloPF.getPassword());
                uzytkownik =  sprawdzenieUzytkownika(login,haslo);
                if (uzytkownik != null) {
                    dispose();
                    Menu menu = new Menu(null);
                    menu.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(Logowanie.this,
                            "Login lub hasło są nieprawidłowe!",
                            "Spróbuj ponownie",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        brakkontaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Rejestracja rejestracja = new Rejestracja(null);
                rejestracja.setVisible(true);
            }
        });

        zamknijBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public Uzytkownik uzytkownik;
    private Uzytkownik sprawdzenieUzytkownika(String login, String haslo) {
        Uzytkownik uzytkownik = null;

        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM uzytkownicy WHERE login=? AND haslo=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,haslo);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                uzytkownik = new Uzytkownik();
                uzytkownik.imie = resultSet.getString("imie");
                uzytkownik.nazwisko = resultSet.getString("nazwisko");
                uzytkownik.email = resultSet.getString("email");
                uzytkownik.login = resultSet.getString("login");
                uzytkownik.haslo = resultSet.getString("haslo");
            }
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return uzytkownik;
    }

    private boolean polaczenieZBaza() {
        boolean zarejestrowaniUzytkownicy = false;

        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS BazaPojazd");
            statement.close();
            connection.close();
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS uzytkownicy (" +
                    "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "imie VARCHAR(200) NOT NULL," +
                    "nazwisko VARCHAR(200) NOT NULL," +
                    "email varchar(200) NOT NULL," +
                    "login VARCHAR(200) NOT NULL," +
                    "haslo VARCHAR(200) NOT NULL)";
            statement.executeUpdate(sql);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM uzytkownicy");
            if (resultSet.next()) {
                int numerUzytkownikow = resultSet.getInt(1);
                if (numerUzytkownikow > 0) {
                    zarejestrowaniUzytkownicy = true;
                }
            }
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return zarejestrowaniUzytkownicy;
    }
}