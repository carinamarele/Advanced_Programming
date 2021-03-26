package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //figurile pe care le desenam in image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    //Cream imaginea alba unde vom desena poligoanele
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    // metoda prin care vom desena poligoanele, setand si dimensiunile
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {//cand apas undeva mi se va apela functia drawShape care imi va desena poligoanele
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }

    /**
     * <p> Prin aceasta metoda desenam poligoane</p>
     * @param x - coordonata in imagine
     * @param y -  coordonata in imagine
     */
    private void drawShape(int x, int y) {
        int radius =(int)(Math.random()*10+4);
        int sides = (int) frame.configPanel.getSidesField().getValue();
        Color color =frame.configPanel.getColorObject();
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
//atasam imaginii poligonul desenat,adica le afisam in imagine
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
