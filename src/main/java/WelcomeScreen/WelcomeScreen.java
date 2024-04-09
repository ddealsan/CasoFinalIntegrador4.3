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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(newButton);
        panel.add(editButton);
        panel.add(compareButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeScreen();
    }
}