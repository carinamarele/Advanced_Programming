package org.example;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p> Prin aceasta clasa imi creez butoanele de salvare,incarcare,resetare si iesire</p>
 */
public class ControlPanel extends JPanel implements ActionListener {
    final MainFrame frame;
    JButton saveBtn;
    JButton loadBtn;
    JButton resetBtn;
    JButton undoBtn;
    JButton exitBtn;
    File filePath = new File("E:\\test.png");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * <p> Imi creez butoanele si le adaug in label-ul creat</p>
     */
    private void init() {
        saveBtn = new JButton("Save");
        //saveBtn.setBounds(100, 100, 100, 100);
        saveBtn.setFocusable(false);
        loadBtn = new JButton("Load");

        loadBtn.setFocusable(false);
        resetBtn = new JButton("Reset");

        resetBtn.setFocusable(false);
        exitBtn = new JButton("Exit");

        exitBtn.setFocusable(false);
        undoBtn = new JButton("Undo");

        undoBtn.setFocusable(false);
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(undoBtn);
        add(exitBtn);
        // le spun ce sa faca daca le apas
        saveBtn.addActionListener(this);
        loadBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        undoBtn.addActionListener(this);
        exitBtn.addActionListener(this);

    }

    /**
     * <p>Prin aceasta metoda salvez imaginea creata ca test.png</p>
     *
     * @param e - reprezinta click-ul dat cu mouse-ul, apasarea de buton
     */
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * <p> Prin aceasta metoda incarc poza salvata</p>
     *
     *
     * @param e - reprezinta click-ul dat cu mouse-ul, apasarea de buton
     */
    private void load(ActionEvent e) {

        try {
            frame.canvas.shapes.clear();
            frame.canvas.image = ImageIO.read(filePath);
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.repaint();
            //frame.canvas.drawShapeList();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * <p>Resetez imaginea,deci voi sterge tot</p>
     *
     *
     * @param e - reprezinta click-ul dat cu mouse-ul, apasarea de buton
     */
    private void reset(ActionEvent e) {
        frame.canvas.shapes.clear();
        frame.canvas.image = new BufferedImage(frame.canvas.W, frame.canvas.H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
        frame.canvas.repaint();

    }

    /**
     * <p> Sterg ultima figura desenata</p>
     * @param e - reprezinta click-ul dat cu mouse-ul
     */
    private void undo(ActionEvent e){
        frame.canvas.deleteLastShape();
        frame.canvas.drawShapeList();
        frame.canvas.repaint();
    }

    /**
     * <p>Ies din aplicatie, cand se apasa butonul exit ne va intreba daca vrem sa iesim si va trebui sa apasam yes</p>
     *
     * @param e - reprezinta click-ul dat cu mouse-ul, apsarea de buton
     */
    private void exit(ActionEvent e) {
        JFrame newFrame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(newFrame, "Confirm if you want to EXIT", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    /**
     * <p>Prin aceasta metoda spunem ce se va intampla cand apasam un buton</p>
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            save(e);
        } else if (e.getSource() == loadBtn) {
            load(e);
        } else if (e.getSource() == resetBtn) {
            reset(e);
        } else if (e.getSource() == exitBtn) {
            exit(e);
        } else if (e.getSource() ==undoBtn){
            undo(e);
        }
    }
}