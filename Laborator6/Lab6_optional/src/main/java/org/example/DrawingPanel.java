package org.example;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    List<Shape> shapes =new ArrayList<>();
    final static int W = 1400, H = 800;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //figurile pe care le desenam in image
    GradientPaint paint;
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
        shapes.clear();
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {//cand apas undeva mi se va apela functia drawShape care imi va desena poligoanele
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
//metoda care imi afiseaza lista cu figuri si in functie de tip alege ce sa puna
    public void drawShapeList(){
        this.createOffscreenImage();
        frame.repaint();
        String tip= (String) frame.configPanel.type.getSelectedItem();
        for( Shape shape : this.shapes){
            graphics.setColor(shape.getColor());
            if(tip=="polygon")
            graphics.fill(new RegularPolygon(shape.getX(),shape.getY(),shape.getRadius(),shape.getSides()));
            else if(tip=="circle")
                graphics.fill(new NodeShape(shape.getX(),shape.getY(),shape.getRadius()));
            else {graphics.fill( new RegularPolygon(shape.getX(),shape.getY(),shape.getRadius(),1));}
            frame.repaint();
        }

    }
    //sterge din lista de figuri desenate pana acum ultima figgura
    public void deleteLastShape(){
        int lastIndex= shapes.size()-1;
        shapes.remove(lastIndex);
        drawShapeList();
        frame.canvas.repaint();
    }

    /**
     * <p> Prin aceasta metoda desenam poligoane</p>
     * @param x - coordonata in imagine
     * @param y -  coordonata in imagine
     */
    private void drawShape(int x, int y) {
        int radius;
        if(frame.configPanel.size.isSelected()==false)
        { radius= frame.configPanel.sliderSize.getValue();}
        else{
         radius=(int)(Math.random()*100+10);}
        int sides = (int) frame.configPanel.getSidesField().getValue();
        Color color =frame.configPanel.getColorObject();
        paint=new GradientPaint(0,0,Color.BLUE,420,0,Color.RED);
        if(color==Color.WHITE){graphics.setPaint(paint);}
        else{
            graphics.setColor(color);}
        String tip=(String) frame.configPanel.type.getSelectedItem();
         shapes.add(new Shape(x,y,radius,sides,tip,color));
         drawShapeList();

    }
    //atasam imaginii poligonul desenat,adica le afisam in imagine
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}