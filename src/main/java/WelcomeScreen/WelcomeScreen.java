package WelcomeScreen;

import TextEditor.TextEditor;
import TextEditor.TextEditor2;
import TextComparator.TextComparator;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class WelcomeScreen {
    private JFrame frame;

    public WelcomeScreen() {
        frame = new JFrame("Gestión de Publicaciones - Alfonso X El Sabio");

        JButton newButton = new JButton("Crear nuevo texto");
        newButton.setPreferredSize(new Dimension(80, 40));
        newButton.addActionListener(e -> new TextEditor());
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(Color.BLUE);
        newButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        newButton.setFocusPainted(false);
        newButton.setBorder(new LineBorder(new Color(0, 0, 128), 2));

        JButton editButton = new JButton("Editar texto existente");
        editButton.setPreferredSize(new Dimension(80, 40));
        editButton.addActionListener(e -> new TextEditor2());
        editButton.setForeground(Color.WHITE);
        editButton.setBackground(Color.BLUE);
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        editButton.setBorder(new LineBorder(new Color(0, 0, 128), 2));

        JButton compareButton = new JButton("Comparador de textos");
        compareButton.setPreferredSize(new Dimension(80, 40));
        compareButton.addActionListener(e -> new TextComparator());
        compareButton.setForeground(Color.WHITE);
        compareButton.setBackground(Color.BLUE);
        compareButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        compareButton.setBorder(new LineBorder(new Color(0, 0, 128), 2));

        JButton exitButton = new JButton("Salir");
        exitButton.setPreferredSize(new Dimension(80, 40));
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.BLUE);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        exitButton.setBorder(new LineBorder(new Color(0, 0, 128), 2));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
        buttonPanel.add(compareButton);
        buttonPanel.add(exitButton);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/FotoLogo.png"));
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>Bienvenido al sistema de publicaciones de texto de la Universidad Alfonso X El Sabio</div></html>");
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        leftPanel.add(welcomeLabel, BorderLayout.SOUTH);
        leftPanel.setBackground(Color.WHITE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, buttonPanel);
        splitPane.setDividerSize(15);
        splitPane.setDividerLocation(600);
        splitPane.setEnabled(false);
        splitPane.setForeground(Color.BLUE);

        frame.add(splitPane);
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}