package com.mvc;

import com.constant.Message;
import com.constant.MyColor;
import com.datamodel.*;
import com.enums.OperationTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        view.addAdditionButtonListener(new AdditionButtonListener());
        view.addSubtractionButtonListener(new SubtractionButtonListener());
        view.addMultiplicateButtonListener(new MultiplicationButtonListener());
        view.addDerivativeButtonListener(new DerivativeButtonListener());
        view.addDivisionButtonListener(new DivisionButtonListener());
        view.addIntegrationButtonListener(new IntegrationButtonListener());
        view.addEraseText1ButtonListener(new EraseText1ButtonListener());
        view.addEraseText2ButtonListener(new EraseText2ButtonListener());
        view.addEraseText3ButtonListener(new EraseText3ButtonListener());
        view.addInfoButtonListener(new InfoButtonListener());
        view.addComboBoxListener(new ComboBoxListener());
    }
    public void operation(OperationTypes opType){
        try{
            String userInputP1="";
            String userInputP2="";
            userInputP1 = view.getPolynomial1Text();
            userInputP2 = view.getPolynomial2Text();
            Polynomial p1 = Operation.stringWithRegex(userInputP1);
            Polynomial p2 = Operation.stringWithRegex(userInputP2);

            if(userInputP1.equals("")){
                view.setPolynomial1Text("Completeaza polinomul pentru a efectua operatia!");
                view.setColorToText(1, Color.red);
                return;
            }

            if(opType != OperationTypes.DERIVATIVE &&
                    opType!= OperationTypes.INTEGRATION &&
                    userInputP2.equals("")){
                view.setPolynomial2Text("Completeaza polinomul pentru a efectua operatia!");
                view.setColorToText(2, Color.red);
                return;
            }

            view.setColorToText(1, Color.black);
            view.setColorToText(2, Color.black);

            switch (opType){
                case ADDITION:
                    p1.additionPolynomial(p2);
                    break;
                case SUBTRACTION:
                    p1.subtractionPolynomial(p2);
                    break;
                case MULTIPLICATION:
                    p1.multiplicationPolynomial(p2);
                    break;
                case DIVISION:
                    p1.divisionPolynomial(p2);
                    break;
                case DERIVATIVE:
                    p1.derivativePolynomial();
                    break;
                case INTEGRATION:
                    p1.integralPolynomial();
                    break;
                default :
                    break;
            }
            view.setPolynomialResultText(p1.toString("p"));
            model.setP1(p1);
            model.setP2(p2);

        } catch(Exception e){
            UIManager UI=new UIManager();
            UI.put("OptionPane.background", MyColor.MY_PINK);
            UI.put("Panel.background", MyColor.MY_PINK);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            showMessageDialogCustom(e.getMessage(),true);
        }
    }
    private void showMessageDialogCustom(String s, boolean asError) {
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", new Color(250,218,221));
        UI.put("Panel.background", new Color(250,218,221));
        if(asError==false) {
            JOptionPane.showMessageDialog(null, s);
        } else{
            JOptionPane.showMessageDialog(null, s, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* clase interne */
    class AdditionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe ADD");
            operation(OperationTypes.ADDITION);
        }
    }
    class SubtractionButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe SUB");
            operation(OperationTypes.SUBTRACTION);

        }
    }
    class MultiplicationButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe MULT");
            operation(OperationTypes.MULTIPLICATION);
        }
    }
    class DivisionButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe DIV");
            operation(OperationTypes.DIVISION);
        }
    }
    class DerivativeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe DER");
            operation(OperationTypes.DERIVATIVE);
        }
    }
    class IntegrationButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("AM APASAT pe INT");
            operation(OperationTypes.INTEGRATION);
        }
    }
    class EraseText1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            view.setPolynomial1Text("");
        }
    }
    class EraseText2ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            view.setPolynomial2Text("");
        }
    }
    class EraseText3ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            view.setPolynomialResultText("");
        }
    }
    class InfoButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            showMessageDialogCustom(Message.INFO,false);
        }
    }
    class ComboBoxListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = (String) view.getComboBox().getSelectedItem();
            Polynomial p = model.getP1();


            if(s.compareTo("Reminder")==0){
                try {
                    view.setPolynomialResultText(p.toString("r"));
                }catch(Exception ex){
                    showMessageDialogCustom(ex.getMessage(),true);
                }
            }
            else if(s.compareTo("Result")==0){
                try {
                    view.setPolynomialResultText(p.toString("p"));
                }catch(Exception ex){
                    showMessageDialogCustom(ex.getMessage(),true);
                }
            }
        }
    }
}