package DrawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawingTool extends JPanel {
    private Image image;
    private Graphics2D graphics2D;
    private JLabel mousePositionLabel; // Etiqueta para mostrar la posición del ratón

    public DrawingTool() {
        setDoubleBuffered(false);
        mousePositionLabel = new JLabel(); // Inicializar la etiqueta
        add(mousePositionLabel); // Agregar la etiqueta al panel

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                graphics2D.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
                // Actualizar la etiqueta con la posición actual del ratón
                mousePositionLabel.setText("Posición del ratón: (" + e.getX() + ", " + e.getY() + ")");
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }
}