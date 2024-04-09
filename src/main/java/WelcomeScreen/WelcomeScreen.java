package WelcomeScreen;

import TextEditor.TextEditor;
import TextEditor.TextEditor2;
import TextComparator.TextComparator;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    private JFrame frame;

    public WelcomeScreen() {
        frame = new JFrame("Gestión de Publicaciones - Alfonso X El Sabio");

        JButton newButton = new JButton("Crear nuevo texto");
        newButton.addActionListener(e -> new TextEditor());

        JButton editButton = new JButton("Editar texto existente");
        editButton.addActionListener(e -> new TextEditor2());

        JButton compareButton = new JButton("Comparador de textos");
        compareButton.addActionListener(e -> new TextComparator());

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 0, 10)); // Espaciado entre botones
        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
        buttonPanel.add(compareButton);
        buttonPanel.add(exitButton);

        // Reemplaza "ruta/a/tu/imagen.jpg" con la ruta a tu imagen
        ImageIcon imageIcon = new ImageIcon("ruta/a/tu/imagen.jpg");
        JLabel imageLabel = new JLabel(imageIcon);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(imageLabel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setSize(800, 600); // Tamaño de ventana más grande
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}