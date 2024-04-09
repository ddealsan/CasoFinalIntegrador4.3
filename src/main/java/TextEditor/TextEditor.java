package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {
    private JFrame frame;
    private JTextArea textArea;
    private String fileName; // Variable para almacenar el nombre del archivo

    public TextEditor() {
        frame = new JFrame("Editor de Texto");
        textArea = new JTextArea();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> saveFile());
        buttonPanel.add(saveButton);

        JButton clearButton = new JButton("Borrar");
        clearButton.addActionListener(e -> textArea.setText(""));
        buttonPanel.add(clearButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(cancelButton);

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "¿Quieres salir sin guardar?", "Salir", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                frame.dispose();
            } else {
                saveFile();
                frame.dispose();
            }
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
        if (fileName == null) {
            fileName = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo:");
        }
        if (fileName != null) {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(frame, "Archivo guardado con éxito.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error al guardar el archivo.");
                e.printStackTrace();
            }
        }
    }
}