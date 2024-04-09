package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {
    private JFrame frame;
    private JTextArea textArea;

    public TextEditor() {
        frame = new JFrame("Editor de Texto");
        textArea = new JTextArea();

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> saveFile());

        frame.setLayout(new BorderLayout());
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setSize(1200, 600); // Cambiado para que coincida con el tamaño de la ventana principal
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void saveFile() {
        String fileName = JOptionPane.showInputDialog(frame, "Ingrese el nombre del archivo:");
        if (fileName != null) {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(frame, "Archivo guardado con éxito.");
                frame.dispose(); // Cierra la ventana del editor de texto
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error al guardar el archivo.");
                e.printStackTrace();
            }
        }
    }
}