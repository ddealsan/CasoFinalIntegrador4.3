package TextComparator;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextComparator {
    private JFrame frame;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea comparisonResultArea;
    private File file1;
    private File file2;

    public TextComparator() {
        frame = new JFrame("Comparador de Textos");
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        comparisonResultArea = new JTextArea();

        JButton selectFile1Button = new JButton("Seleccionar primer archivo");
        selectFile1Button.addActionListener(e -> selectFile(textArea1, 1));

        JButton selectFile2Button = new JButton("Seleccionar segundo archivo");
        selectFile2Button.addActionListener(e -> selectFile(textArea2, 2));

        JButton compareButton = new JButton("Comparar");
        compareButton.addActionListener(e -> compareFiles());

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.add(selectFile1Button);
        buttonPanel.add(selectFile2Button);
        buttonPanel.add(compareButton);

        frame.setLayout(new GridLayout(1, 3));
        frame.add(new JScrollPane(textArea1));
        frame.add(new JScrollPane(textArea2));
        frame.add(new JScrollPane(comparisonResultArea));
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void selectFile(JTextArea textArea, int fileNumber) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./src/main/resources/txts"));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (fileNumber == 1) {
                file1 = fileChooser.getSelectedFile();
            } else {
                file2 = fileChooser.getSelectedFile();
            }
            try {
                textArea.setText(new String(Files.readAllBytes(Paths.get(fileChooser.getSelectedFile().getPath()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void compareFiles() {
        if (file1 != null && file2 != null) {
            try {
                String text1 = new String(Files.readAllBytes(Paths.get(file1.getPath())));
                String text2 = new String(Files.readAllBytes(Paths.get(file2.getPath())));
                comparisonResultArea.setText(text1.equals(text2) ? "Los archivos son iguales" : "Los archivos son diferentes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}