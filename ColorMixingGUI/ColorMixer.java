import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorMixer extends JFrame{
    private JLabel red;
    private JLabel yellow;
    private JLabel blue;
    private JLabel result;
    private JButton calc;
    private ImageIcon res;
    private JCheckBox redSelected;
    private JCheckBox yellowSelected;
    private JCheckBox blueSelected;
    private JPanel colorsPanel;
    private JPanel selectionPanel;
    private JPanel resultPanel;

    public ColorMixer(){
        //call the JFrame constructor
        super("Color Mixing");

        //specify action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create border manager for the content pane
        setLayout(new BorderLayout());

        //build the panels
        buildColorsPanel();
        buildSelectionPanel();
        buildResultPanel();

        //add panels to content pane
        add(colorsPanel, BorderLayout.NORTH);
        add(selectionPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        //pack and display window
        pack();
        setVisible(true);
    }

    private void buildColorsPanel(){
        //create panel
        colorsPanel = new JPanel();

        //create the labels
        red = new JLabel();
        blue = new JLabel();
        yellow = new JLabel();
        
        //create image icons
        ImageIcon r = new ImageIcon("red.jpg");
        ImageIcon b = new ImageIcon("blue.jpg");
        ImageIcon y = new ImageIcon("yellow.jpg");

        //set them to labels
        red.setIcon(r);
        blue.setIcon(b);
        yellow.setIcon(y);

        //add labels to panel
        
        colorsPanel.add(red);
        colorsPanel.add(blue);
        colorsPanel.add(yellow);
    }

    private void buildSelectionPanel(){
        //create panel
        selectionPanel = new JPanel();
        calc = new JButton("Mix");
        //create checkboxes
        redSelected = new JCheckBox();
        blueSelected = new JCheckBox();
        yellowSelected = new JCheckBox();
        calc.addActionListener(new MixingListener());

        selectionPanel.add(redSelected);
        selectionPanel.add(blueSelected);
        selectionPanel.add(yellowSelected);
        selectionPanel.add(calc);
    }

    public void buildResultPanel(){
        //create panel
        resultPanel = new JPanel();

        //create label
        result = new JLabel();

        //create image icon
        //add label to result panel
        resultPanel.add(result);
    }

    private class MixingListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(redSelected.isSelected() && yellowSelected.isSelected()&&!(blueSelected.isSelected())){
                res = new ImageIcon("orange.jpg");
                blueSelected.setEnabled(false);
            }
            else if(redSelected.isSelected() && blueSelected.isSelected()&&!(yellowSelected.isSelected())){
                res = new ImageIcon("purple.jpg");
                yellowSelected.setEnabled(false);
            }
            else if(yellowSelected.isSelected() && blueSelected.isSelected()&&!(redSelected.isSelected())){
                res = new ImageIcon("green.jpg");
                redSelected.setEnabled(false);
            }

            //set icon to label
            result.setIcon(res);
            redSelected.setSelected(false);
            redSelected.setEnabled(true);
            blueSelected.setSelected(false);
            blueSelected.setEnabled(true);
            yellowSelected.setSelected(false);
            yellowSelected.setEnabled(true);
        }
    }

    public static void main(String[] args){
        new ColorMixer();
    }
}
