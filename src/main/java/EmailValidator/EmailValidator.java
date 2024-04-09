package EmailValidator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailValidator {
    private JFrame frame;
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private Properties contacts;

    public EmailValidator() {
        frame = new JFrame("Gestor de Contactos");
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Email", "Número"}, 0);
        contactTable = new JTable(tableModel);
        contacts = new Properties();

        loadContacts();

        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(e -> addContact());

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deleteContact());

        JButton changeButton = new JButton("Cambiar");
        changeButton.addActionListener(e -> changeContact());

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> {
            saveContacts();
            frame.dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(changeButton);
        buttonPanel.add(exitButton);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(contactTable), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void loadContacts() {
        try {
            FileInputStream in = new FileInputStream("contacts.properties");
            contacts.load(in);
            in.close();
            for (String key : contacts.stringPropertyNames()) {
                String[] values = contacts.getProperty(key).split(",");
                tableModel.addRow(new Object[]{values[0], values[1], values[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveContacts() {
        try {
            FileOutputStream out = new FileOutputStream("contacts.properties");
            contacts.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addContact() {
        String name = JOptionPane.showInputDialog(frame, "Introduce el nombre:");
        String email = JOptionPane.showInputDialog(frame, "Introduce el email:");
        String number = JOptionPane.showInputDialog(frame, "Introduce el número:");
        tableModel.addRow(new Object[]{name, email, number});
        contacts.setProperty(email, name + "," + email + "," + number);
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            contacts.remove(tableModel.getValueAt(selectedRow, 1));
            tableModel.removeRow(selectedRow);
        }
    }

    private void changeContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            String name = JOptionPane.showInputDialog(frame, "Introduce el nuevo nombre:", tableModel.getValueAt(selectedRow, 0));
            String email = JOptionPane.showInputDialog(frame, "Introduce el nuevo email:", tableModel.getValueAt(selectedRow, 1));
            String number = JOptionPane.showInputDialog(frame, "Introduce el nuevo número:", tableModel.getValueAt(selectedRow, 2));
            contacts.remove(tableModel.getValueAt(selectedRow, 1));
            tableModel.setValueAt(name, selectedRow, 0);
            tableModel.setValueAt(email, selectedRow, 1);
            tableModel.setValueAt(number, selectedRow, 2);
            contacts.setProperty(email, name + "," + email + "," + number);
        }
    }
}