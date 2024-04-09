package WelcomeScreen;

import TextEditor.TextEditor;
import TextEditor.TextEditor2;
import TextComparator.TextComparator;
import EmailValidator.EmailValidator;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class WelcomeScreen {
    private JFrame frame;

    public WelcomeScreen() {
        frame = new JFrame("Gestión de Publicaciones - Alfonso X El Sabio");

        JButton newButton = new JButton("Crear nuevo texto".toUpperCase());
        newButton.setPreferredSize(new Dimension(60, 25));
        newButton.addActionListener(e -> new TextEditor());
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(Color.BLUE);
        newButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        newButton.setFocusPainted(false);
        newButton.setBorder(new LineBorder(new Color(0, 0, 128), 3));

        JButton editButton = new JButton("Editar texto existente".toUpperCase());
        editButton.setPreferredSize(new Dimension(60, 25));
        editButton.addActionListener(e -> new TextEditor2());
        editButton.setForeground(Color.WHITE);
        editButton.setBackground(Color.BLUE);
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        editButton.setBorder(new LineBorder(new Color(0, 0, 128), 3));

        JButton compareButton = new JButton("Comparador de textos".toUpperCase());
        compareButton.setPreferredSize(new Dimension(60, 25));
        compareButton.addActionListener(e -> new TextComparator());
        compareButton.setForeground(Color.WHITE);
        compareButton.setBackground(Color.BLUE);
        compareButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        compareButton.setBorder(new LineBorder(new Color(0, 0, 128), 3));

        JButton emailValidatorButton = new JButton("Validador de Email".toUpperCase());
        emailValidatorButton.setPreferredSize(new Dimension(60, 25));
        emailValidatorButton.addActionListener(e -> new EmailValidator());
        emailValidatorButton.setForeground(Color.WHITE);
        emailValidatorButton.setBackground(Color.BLUE);
        emailValidatorButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        emailValidatorButton.setBorder(new LineBorder(new Color(0, 0, 128), 3));

        JButton exitButton = new JButton("Salir".toUpperCase());
        exitButton.setPreferredSize(new Dimension(60, 25));
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.BLUE);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        exitButton.setBorder(new LineBorder(new Color(0, 0, 128), 3));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // Cambiar a 5 filas para acomodar el nuevo botón
        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
        buttonPanel.add(compareButton);
        buttonPanel.add(emailValidatorButton); // Agregar el nuevo botón
        buttonPanel.add(exitButton);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/FotoLogo.png"));
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>Bienvenido al sistema de publicaciones de texto de la Universidad Alfonso X El Sabio</div></html>");
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        leftPanel.add(welcomeLabel, BorderLayout.SOUTH);
        leftPanel.setBackground(Color.WHITE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, buttonPanel);
        splitPane.setDividerSize(20);
        splitPane.setDividerLocation(600);
        splitPane.setEnabled(false);
        splitPane.setForeground(new Color(0, 0, 128));

        frame.add(splitPane);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}