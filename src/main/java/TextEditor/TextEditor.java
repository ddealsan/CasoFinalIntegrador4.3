package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.FileWriter;

public class TextEditor {
    private JTextArea textArea;
    private JFrame frame;
    private JList<String> fileList;
    private DefaultListModel<String> listModel;

    public TextEditor() {
        frame = new JFrame("Interactive Text Editor");
        textArea = new JTextArea();
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToFile();
            }
        });

        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileList.addListSelectionListener(e -> loadFile(fileList.getSelectedValue()));

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.add(new JScrollPane(fileList), BorderLayout.EAST);
        frame.setSize(700, 500);
        frame.setVisible(true);

        loadFileList();
    }

    private void saveTextToFile() {
        try (FileWriter writer = new FileWriter("document.txt")) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadFileList();
    }

    private void loadFileList() {
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(name -> name.endsWith(".txt"))
                    .forEach(listModel::addElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            textArea.read(reader, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }


}