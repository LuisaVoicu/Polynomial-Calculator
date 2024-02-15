package com.mvc;

import com.constant.MyColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static com.constant.MyColor.*;


public class View  extends JFrame{

    private JTextField polynomial1Text;
    private JTextField polynomial2Text;
    private JTextField polynomialResultText;

    private JButton multiplicate;
    private JButton divide;
    private JButton add;
    private JButton subtract;
    private JButton integrate;
    private JButton derivate;
    private JLabel polynomial1Label;
    private JLabel polynomial2Label;
    private JLabel polynomialResultLabel;

    private JLabel titleLabel;
    private JButton eraseText1;
    private JButton eraseText2;
    private JButton eraseText3;
    private JButton infoButton;
    private JPanel infoMenu;
    private JPanel title;
    private JPanel panelUp ;
    private JPanel panelUp1;
    private JPanel panelUp2;
    private JPanel panelUp3;
    private JPanel panelDown;
    private JPanel mainPanel;
    private JComboBox<String> comboResult;
    public View(){
        initElements();
        setColor();
        setIcon();
        addElementsToPanels();
        setLayoutsForPanels();
        setTextFont();

        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(480,550));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("✨ POLYNOMIAL CALCULATOR ✨");
        this.setVisible(true);
    }

    public void initElements(){
        // initializari
        String s = "✨ POLYNOMIAL CALCULATOR ✨";
        titleLabel = new JLabel(s);
        multiplicate = new JButton("Multiplicate");
        divide = new JButton("Divide");
        add = new JButton("Add");
        subtract = new JButton("Substract");
        integrate = new JButton("Integrate");
        derivate = new JButton("Derivate");
        polynomial1Label = new JLabel("Polynomial   I    ");
        polynomial2Label = new JLabel("Polynomial  II    ");
        polynomialResultLabel = new JLabel("Polynomial  Result");

        String[] choices={"Result","Reminder"};
        comboResult = new JComboBox<String>(choices); //added

        polynomial1Text = new JTextField(30);
        polynomial2Text = new JTextField(30);
        polynomialResultText = new JTextField(30);
        eraseText1 = new JButton("");
        eraseText2 = new JButton("");
        eraseText3 = new JButton("");
        infoButton = new JButton("");

        // panels
        infoMenu = new JPanel();
        mainPanel = new JPanel();
        title = new JPanel();
        panelUp = new JPanel();
        panelUp1 = new JPanel();
        panelUp2 = new JPanel();
        panelUp3 = new JPanel();
        panelDown = new JPanel();
    }

    public void setColor(){

        //culoare paneluri
        mainPanel.setBackground(MY_PINK);
        panelUp1.setBackground(MY_PINK);
        panelUp2.setBackground(MY_PINK);
        panelUp3.setBackground(MY_PINK);
        title.setBackground(MY_PINK);

        // culoare btn operatii
        multiplicate.setBackground(MY_BLUE);
        divide.setBackground(MY_SECOND_PINK);
        add.setBackground(MY_SECOND_PINK);
        subtract.setBackground(MY_BLUE);
        integrate.setBackground(MY_BLUE);
        derivate.setBackground(MY_SECOND_PINK);

        // x-urile
        eraseText1.setBackground(MyColor.MY_PINK);
        eraseText2.setBackground(MyColor.MY_PINK);
        eraseText3.setBackground(MyColor.MY_PINK);
        eraseText1.setBorderPainted(false);
        eraseText2.setBorderPainted(false);
        eraseText3.setBorderPainted(false);

        //info-btn
        infoButton.setBackground(MyColor.MY_PINK);
        infoButton.setBorderPainted(false);

        comboResult.setBackground(MY_SECOND_PINK);


    }

    public void setIcon(){
        //butoanele pentru multimi \src\main\java\com\image
        Icon info = new ImageIcon("src/main/java/com/image/info.png");
        Icon eraseIcon = new ImageIcon("src/main/java/com/image/delbtn.png");
        Icon mIcon = new ImageIcon("src/main/java/com/image/multiply.png");
        Icon dIcon = new ImageIcon("src/main/java/com/image/div.png");
        Icon sIcon = new ImageIcon("src/main/java/com/image/substr.png");
        Icon aIcon = new ImageIcon("src/main/java/com/image/add.png");
        Icon iIcon = new ImageIcon("src/main/java/com/image/int.png");
        Icon ddIcon = new ImageIcon("src/main/java/com/image/der.png");
        infoButton.setIcon(info);
        multiplicate.setIcon(mIcon);
        add.setIcon(aIcon);
        subtract.setIcon(sIcon);
        divide.setIcon(dIcon);
        integrate.setIcon(iIcon);
        derivate.setIcon(ddIcon);
        eraseText1.setIcon(eraseIcon);
        eraseText2.setIcon(eraseIcon);
        eraseText3.setIcon(eraseIcon);

    }

    public void addElementsToPanels(){
        title.add(titleLabel);
        infoMenu.add(infoButton);
        panelDown.add(multiplicate);
        panelDown.add(divide);
        panelDown.add(add);
        panelDown.add(subtract);
        panelDown.add(integrate);
        panelDown.add(derivate);

        panelUp1.add(polynomial1Label);
        panelUp1.add(polynomial1Text);
        panelUp1.add(eraseText1);
        panelUp2.add(polynomial2Label);
        panelUp2.add(polynomial2Text);
        panelUp2.add(eraseText2);
        // panelUp3.add(polynomialResultLabel);
        comboResult.setVisible(true);
        panelUp3.add(comboResult);
        panelUp3.add(polynomialResultText);
        panelUp3.add(eraseText3);

        panelUp.add(panelUp1);
        panelUp.add(panelUp2);
        panelUp.add(panelUp3);


    }

    public void setLayoutsForPanels(){
        infoMenu.setLayout(new BoxLayout(infoMenu,BoxLayout.X_AXIS));
        infoMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelUp1.setLayout(new FlowLayout());
        panelUp2.setLayout(new FlowLayout());
        panelUp3.setLayout(new FlowLayout());
        panelUp.setLayout(new BoxLayout(panelUp,BoxLayout.Y_AXIS));
        panelUp.setAlignmentX(0.1f);
        panelDown.setLayout(new GridLayout(3,3));;
        mainPanel.add(infoMenu);
        mainPanel.add(title);
        mainPanel.add(panelUp);
        mainPanel.add(panelDown);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
    }

    public void setTextFont(){
        String s = "SansSerif";
        titleLabel.setFont(new Font(s, Font.BOLD, 18));
        polynomial1Label.setFont(new Font(s, Font.BOLD, 12));
        polynomial2Label.setFont(new Font(s, Font.BOLD, 12));
        polynomialResultLabel.setFont(new Font(s, Font.BOLD, 12));
        polynomial1Text.setFont(new Font(s, Font.BOLD, 12));
        polynomial2Text.setFont(new Font(s, Font.BOLD, 12));
        polynomialResultText.setFont(new Font(s, Font.BOLD, 12));
        comboResult.setFont(new Font(s, Font.BOLD, 12));
    }

    public String getPolynomial1Text(){
        return polynomial1Text.getText();
    }

    public String getPolynomial2Text(){
        return polynomial2Text.getText();
    }

    public void setPolynomialResultText(String s){
        polynomialResultText.setText(s);
    }

    public void setPolynomial1Text(String s){
        polynomial1Text.setForeground(Color.red);
        polynomial1Text.setText(s);
    }

    public void setPolynomial2Text(String s){
        polynomial2Text.setForeground(Color.red);
        polynomial2Text.setText(s);
    }

    public void setColorToText(int whichOne, Color color){
        switch (whichOne){
            case 1:
                polynomial1Text.setForeground(color);
                break;
            case 2:
                polynomial2Text.setForeground(color);
                break;
            case 3:
                polynomialResultText.setForeground(color);
                break;
        }
    }

    public JComboBox<String> getComboBox(){
        return comboResult;
    }

    /*Listeners*/
    public void addMultiplicateButtonListener(ActionListener listener){
        multiplicate.addActionListener(listener);
    }
    public void addDivisionButtonListener(ActionListener listener){
        divide.addActionListener(listener);
    }
    public void addAdditionButtonListener(ActionListener listener){
        add.addActionListener(listener);
    }
    public void addSubtractionButtonListener(ActionListener listener){
        subtract.addActionListener(listener);
    }
    public void addDerivativeButtonListener(ActionListener listener){
        derivate.addActionListener(listener);
    }
    public void addIntegrationButtonListener(ActionListener listener){
        integrate.addActionListener(listener);
    }
    public void addEraseText1ButtonListener(ActionListener listener){
        eraseText1.addActionListener(listener);
    }
    public void addEraseText2ButtonListener(ActionListener listener){
        eraseText2.addActionListener(listener);
    }
    public void addEraseText3ButtonListener(ActionListener listener){
        eraseText3.addActionListener(listener);
    }
    public void addInfoButtonListener(ActionListener listener){
        infoButton.addActionListener(listener);
    }
    public void addComboBoxListener(ActionListener listener){
        comboResult.addActionListener(listener);
    }

}