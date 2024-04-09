package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEditor2 {
    private JFrame frame;
    private JTextArea textArea;
    private File currentFile; // Variable para almacenar el archivo actual

    public TextEditor2() {
        frame = new JFrame("Editor de Texto");
        textArea = new JTextArea();

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try {
                textArea.setText(new String(Files.readAllBytes(Paths.get(currentFile.getPath()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 5, 5)); // GridLayout con 6 filas, 1 columna y 5 de separación horizontal y vertical

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> saveFile());
        buttonPanel.add(saveButton);

        JButton clearButton = new JButton("Borrar");
        clearButton.addActionListener(e -> textArea.setText(""));
        buttonPanel.add(clearButton);

        // Añadir un componente de relleno para empujar los botones "Salir" y "Cancelar" hacia la parte inferior
        buttonPanel.add(Box.createVerticalGlue());

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> frame.dispose());
        cancelButton.setBackground(Color.RED); // Cambiar el color del botón a rojo
        buttonPanel.add(cancelButton);

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> {
            saveFile();
            frame.dispose();
        });
        buttonPanel.add(exitButton);

        frame.setLayout(new BorderLayout());
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void saveFile() {
        if (currentFile != null) {
            try (FileWriter writer = new FileWriter(currentFile)) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(frame, "Archivo guardado con éxito.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error al guardar el archivo.");
                e.printStackTrace();
            }
        }
    }
}