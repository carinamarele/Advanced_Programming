package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Prin aceasta clasa cream butoanele pentru setarea culorii si a numarului de laturi a figurilor pe care le vom face</p>
 */
public class ConfigPanel extends JPanel implements ActionListener {
    final MainFrame frame;
    JLabel label; // Desenam poligoane regulate
    JSpinner sidesField; // numarul de laturi
    JComboBox colorCombo; // culoarea figurilor
    JComboBox type;
    Color colorObject;// pentru setarea culorii random

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * <p>Prin aceasta metoda, initializam datele( numarul de laturi si culoare lor)</p>
     */
    private void init() {
        JLabel typesFigure=new JLabel("Choose a figure:");
                String[] figures={"polygon","circle"};
        type=new JComboBox(figures);
        type.addActionListener(this);
        add(typesFigure);
        add(type);
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3); //default number of sides

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        JLabel colorLabel=new JLabel("Choose a color:");
        String[] colors = {"BLACK", "Random","Gradient"};
        colorCombo = new JComboBox(colors);
        colorCombo.addActionListener(this);
        add(colorLabel);
        add(colorCombo);
    }
//settere si gettere pentru toate variabilele clasei
    public MainFrame getFrame() {
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public void setColorCombo(JComboBox colorCombo) {
        this.colorCombo = colorCombo;
    }

    public Color getColorObject() {
        return colorObject;
    }

    public void setColorObject(Color colorObject) {
        this.colorObject = colorObject;
    }

    /**
     * <p>Prin aceasta metoda voi spune ce se va intampla cand apasa undeva</p>
     * @param e - reprezinta click-ul pe care il dam cu mouse ul intr-un loc, adica pe ce apasam
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorCombo) {
            if (colorCombo.getSelectedItem() == "BLACK") {
                colorObject = new Color(0,0,0,100);
            }
            else if(colorCombo.getSelectedItem()=="Gradient"){
                colorObject=Color.WHITE;
            }
            else {
                int r, g, b;
                r = (int) (Math.random() * 100 + 1);
                g = (int) (Math.random() *212 + 1);
                b = (int) (Math.random() * 215 + 1);
                colorObject = new Color(r, g, b,100);

            }

        }
    }
}
