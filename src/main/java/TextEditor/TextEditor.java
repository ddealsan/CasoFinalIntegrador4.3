package TextEditor;

import DrawingTool.DrawingTool;

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

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 5, 5)); // GridLayout con 6 filas, 1 columna y 5 de separación horizontal y vertical

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> saveFile());
        buttonPanel.add(saveButton);

        JButton clearButton = new JButton("Borrar");
        clearButton.addActionListener(e -> textArea.setText(""));
        buttonPanel.add(clearButton);

        JButton drawingToolButton = new JButton("Herramienta de Dibujo");
        drawingToolButton.addActionListener(e -> {
            JFrame drawingFrame = new JFrame("Herramienta de Dibujo");
            DrawingTool drawingTool = new DrawingTool();
            drawingFrame.add(drawingTool);
            drawingFrame.setSize(600, 600);
            drawingFrame.setVisible(true);
        });
        buttonPanel.add(drawingToolButton);

        // Añadir un componente de relleno para empujar los botones "Salir" y "Cancelar" hacia la parte inferior
        buttonPanel.add(Box.createVerticalGlue());

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> frame.dispose());
        cancelButton.setBackground(Color.RED); // Cambiar el color del botón a rojo
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