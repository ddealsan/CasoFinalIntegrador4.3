package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {
    private JTextArea textArea;
    private JFrame frame;

    public TextEditor() {
        frame = new JFrame("Interactive Text Editor");
        textArea = new JTextArea();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToFile();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void saveTextToFile() {
        try (FileWriter writer = new FileWriter("document.txt")) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
