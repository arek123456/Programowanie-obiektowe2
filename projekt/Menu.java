package Projekt;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu extends JDialog {
    private JPanel JPanel3;
    private JTextField markaTF;
    private JTextField modelTF;
    private JTextField przebiegTF;
    private JTextField kolorTF;
    private JButton zamknijBtn;
    private JButton usunBtn;
    private JButton dodajBtn;
    private JButton wyswietlBtn;
    private JTable pojazdyT;
    private JButton wyczyscBtn;
    private JButton edytujBtn;

    public Menu(JFrame parent) {
        super(parent);
        setTitle("Menu pojazdów");
        setContentPane(JPanel3);
        int width = 675, height = 485;
        setMinimumSize(new Dimension(width, height));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        polaczenieZBaza();
        tworzenieTabeli();

        zamknijBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        dodajBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marka = markaTF.getText();
                String model = modelTF.getText();
                String przebieg = przebiegTF.getText();
                String kolor = kolorTF.getText();
                Pattern pattern1 = Pattern.compile("[a-zA-Z]+");
                Pattern pattern2 = Pattern.compile("[a-zA-Z0-9]+");
                Pattern pattern3 = Pattern.compile("[0-9]+");
                Pattern pattern4 = Pattern.compile("[a-zA-Z]+");
                Matcher matcher1 = pattern1.matcher(marka);
                Matcher matcher2 = pattern2.matcher(model);
                Matcher matcher3 = pattern3.matcher(przebieg);
                Matcher matcher4 = pattern4.matcher(kolor);
                if (!matcher1.matches() || !matcher2.matches() || !matcher3.matches() || !matcher4.matches()) {
                    JOptionPane.showMessageDialog(null,
                            "Podaj prawidłowe dane!",
                            "Spróbuj ponownie",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String[] dane = {
                            markaTF.getText(),
                            modelTF.getText(),
                            przebiegTF.getText(),
                            kolorTF.getText()};
                    DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                    tabela.addRow(dane);
                    dodaniePojazdu();
                    JOptionPane.showMessageDialog(null, "Dodano poprawnie dane");
                    markaTF.setText("");
                    modelTF.setText("");
                    przebiegTF.setText("");
                    kolorTF.setText("");
                }
            }
        });

        usunBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                if (pojazdyT.getSelectedRowCount() == 1) {
                    String tblmarka = tabela.getValueAt(pojazdyT.getSelectedRow(),0).toString();
                    String tblmodel = tabela.getValueAt(pojazdyT.getSelectedRow(),1).toString();
                    String tblprzebieg = tabela.getValueAt(pojazdyT.getSelectedRow(),2).toString();
                    String tblkolor = tabela.getValueAt(pojazdyT.getSelectedRow(),3).toString();
                    pojazd = usuwaniePojazduzBazy(tblmarka,tblmodel,tblprzebieg,tblkolor);
                    tabela.removeRow(pojazdyT.getSelectedRow());
                }
                else {
                    if (pojazdyT.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Brak danych do usunięcia!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Zaznacz tylko jeden wiersz do usunięcia!");
                    }
                }
                markaTF.setText("");
                modelTF.setText("");
                przebiegTF.setText("");
                kolorTF.setText("");
            }
        });

        wyswietlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                while (tabela.getRowCount() != 0) {
                    tabela.removeRow(0);
                }
                pojazd = wyswietlaniePojazduzBazy();
            }
        });

        wyczyscBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markaTF.setText("");
                modelTF.setText("");
                przebiegTF.setText("");
                kolorTF.setText("");
                DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                while (tabela.getRowCount() != 0) {
                    tabela.removeRow(0);
                }
            }
        });

        edytujBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                String marka = markaTF.getText();
                String model = modelTF.getText();
                String przebieg = przebiegTF.getText();
                String kolor = kolorTF.getText();
                Pattern pattern1 = Pattern.compile("[a-zA-Z]+");
                Pattern pattern2 = Pattern.compile("[a-zA-Z0-9]+");
                Pattern pattern3 = Pattern.compile("[0-9]+");
                Pattern pattern4 = Pattern.compile("[a-zA-Z]+");
                Matcher matcher1 = pattern1.matcher(marka);
                Matcher matcher2 = pattern2.matcher(model);
                Matcher matcher3 = pattern3.matcher(przebieg);
                Matcher matcher4 = pattern4.matcher(kolor);
                if (!matcher1.matches() || !matcher2.matches() || !matcher3.matches() || !matcher4.matches()) {
                    JOptionPane.showMessageDialog(null,
                            "Podaj prawidłowe dane!",
                            "Spróbuj ponownie",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if (pojazdyT.getSelectedRowCount() == 1) {
                    String tblmarka = tabela.getValueAt(pojazdyT.getSelectedRow(),0).toString();
                    String tblmodel = tabela.getValueAt(pojazdyT.getSelectedRow(),1).toString();
                    String tblprzebieg = tabela.getValueAt(pojazdyT.getSelectedRow(),2).toString();
                    String tblkolor = tabela.getValueAt(pojazdyT.getSelectedRow(),3).toString();
                    marka = markaTF.getText();
                    model = modelTF.getText();
                    przebieg = przebiegTF.getText();
                    kolor = kolorTF.getText();
                    tabela.setValueAt(marka, pojazdyT.getSelectedRow(),0);
                    tabela.setValueAt(model, pojazdyT.getSelectedRow(),1);
                    tabela.setValueAt(przebieg, pojazdyT.getSelectedRow(),2);
                    tabela.setValueAt(kolor, pojazdyT.getSelectedRow(),3);
                    pojazd = edytowaniePojazduzBazy(marka,model,przebieg,kolor,tblmarka,tblmodel,tblprzebieg,tblkolor);
                    markaTF.setText("");
                    modelTF.setText("");
                    przebiegTF.setText("");
                    kolorTF.setText("");
                }
                else {
                    if (pojazdyT.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null,"Brak danych do edycji!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Wybierz jeden wiersz do edycji!");
                    }
                }
            }
        });
    }

    private void tworzenieTabeli() {
        Object[][] dane = {};
        pojazdyT.setModel(new DefaultTableModel(dane, new String[]{"Marka", "Model", "Przebieg", "Kolor"}));
        TableColumnModel kolumny = pojazdyT.getColumnModel();
        DefaultTableCellRenderer centerRendered = new DefaultTableCellRenderer();
        centerRendered.setHorizontalAlignment(JLabel.CENTER);
        kolumny.getColumn(0).setCellRenderer(centerRendered);
        kolumny.getColumn(1).setCellRenderer(centerRendered);
        kolumny.getColumn(2).setCellRenderer(centerRendered);
        kolumny.getColumn(3).setCellRenderer(centerRendered);
    }

    private void dodaniePojazdu() {
        String marka = markaTF.getText();
        String model = modelTF.getText();
        String przebieg = przebiegTF.getText();
        String kolor = kolorTF.getText();
        pojazd = dodawaniePojazduDoBazy(marka, model, przebieg, kolor);
        if (pojazd == null) {
            JOptionPane.showMessageDialog(this,
                    "Błąd w dodaniu pojazdu!",
                    "Spróbuj ponownie",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public Pojazd pojazd;

    private Pojazd dodawaniePojazduDoBazy(String marka, String model, String przebieg, String kolor) {
        Pojazd pojazd = null;

        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO pojazdy (marka,model,przebieg,kolor) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, marka);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, przebieg);
            preparedStatement.setString(4, kolor);

            int dodaniePojazdu = preparedStatement.executeUpdate();
            if (dodaniePojazdu > 0) {
                pojazd = new Pojazd();
                pojazd.marka = marka;
                pojazd.model = model;
                pojazd.przebieg = przebieg;
                pojazd.kolor = kolor;
            }
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pojazd;
    }

    private Pojazd wyswietlaniePojazduzBazy() {
        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT marka,model,przebieg,kolor FROM pojazdy");

            while (resultSet.next()) {
                String marka = resultSet.getString("marka");
                String model = resultSet.getString("model");
                String przebieg = resultSet.getString("przebieg");
                String kolor = resultSet.getString("kolor");
                String[] dane = {
                        marka,
                        model,
                        przebieg,
                        kolor};
                DefaultTableModel tabela = (DefaultTableModel) pojazdyT.getModel();
                tabela.addRow(dane);
            }
            JOptionPane.showMessageDialog(null, "Wyświetlono wszystkie dane z bazy");
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pojazd;
    }

    private Pojazd usuwaniePojazduzBazy(String marka,String model,String przebieg,String kolor) {
        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "DELETE FROM pojazdy WHERE marka=? AND model=? AND przebieg=? AND kolor=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,marka);
            preparedStatement.setString(2,model);
            preparedStatement.setString(3,przebieg);
            preparedStatement.setString(4,kolor);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rekord został usunięty");
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pojazd;
    }

    private Pojazd edytowaniePojazduzBazy(String marka,String model,String przebieg,String kolor, String marka2,String model2,String przebieg2,String kolor2) {
        final String DB_URL = "jdbc:mysql://localhost/BazaPojazd?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            String sql = "UPDATE pojazdy SET marka=?,model=?,przebieg=?,kolor=? WHERE marka=? AND model=? AND przebieg=? AND kolor=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,marka);
            preparedStatement.setString(2,model);
            preparedStatement.setString(3,przebieg);
            preparedStatement.setString(4,kolor);
            preparedStatement.setString(5,marka2);
            preparedStatement.setString(6,model2);
            preparedStatement.setString(7,przebieg2);
            preparedStatement.setString(8,kolor2);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rekord został zmodyfikowany");
            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pojazd;
    }

    private boolean polaczenieZBaza() {
        boolean dodanePojazdy = false;

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
            String sql = "CREATE TABLE IF NOT EXISTS pojazdy (" +
                    "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "marka VARCHAR(200) NOT NULL," +
                    "model VARCHAR(200) NOT NULL," +
                    "przebieg varchar(200) NOT NULL," +
                    "kolor VARCHAR(200) NOT NULL)";
            statement.executeUpdate(sql);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM pojazdy");
            if (resultSet.next()) {
                int numerPojazdu = resultSet.getInt(1);
                if (numerPojazdu > 0) {
                    dodanePojazdy = true;
                }
            }
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dodanePojazdy;
    }
}