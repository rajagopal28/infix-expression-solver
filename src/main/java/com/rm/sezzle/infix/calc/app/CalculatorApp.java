package com.rm.sezzle.infix.calc.app;


import com.rm.sezzle.infix.calc.app.constant.CalculatorAppConstants;
import com.rm.sezzle.infix.calc.app.operand.Operand;
import com.rm.sezzle.infix.calc.app.solver.InfixExpressionSolver;

import javax.swing.*;
import java.awt.*;

public class CalculatorApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!");

        Dimension preferredSize = new Dimension(CalculatorAppConstants.UI_PREFERRED_ITEM_WIDTH, CalculatorAppConstants.UI_PREFERRED_ITEM_HEIGHT);
        Font defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, CalculatorAppConstants.UI_TEXT_FONT_SIZE);

        //Creating the Frame
        JFrame frame = new JFrame(CalculatorAppConstants.UI_LABEL_APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(CalculatorAppConstants.UI_PREFERRED_WINDOW_WIDTH, CalculatorAppConstants.UI_PREFERRED_WINDOW_HEIGHT);


        //Creating the panel at bottom and adding components
        JLabel inputLabel = new JLabel(CalculatorAppConstants.UI_LABEL_INPUT, SwingConstants.LEFT);
        inputLabel.setFont(defaultFont);
        inputLabel.setPreferredSize(preferredSize);

        JTextField inputText = new JTextField(CalculatorAppConstants.UI_TEXT_FIELD_LENGTH); // accepts upto 10 characters
        inputText.setPreferredSize(preferredSize);

        JButton solveButton = new JButton(CalculatorAppConstants.UI_BUTTON_SOLVE);
        solveButton.setPreferredSize(preferredSize);

        JLabel resultLabel = new JLabel(CalculatorAppConstants.UI_LABEL_RESULT, SwingConstants.CENTER);
        resultLabel.setFont(defaultFont);
        resultLabel.setPreferredSize(preferredSize);

        solveButton.addActionListener((s) -> {
            InfixExpressionSolver solver = new InfixExpressionSolver();
            try {
                Operand result = solver.solve(inputText.getText());
                resultLabel.setBackground(Color.GREEN);
                resultLabel.setText(CalculatorAppConstants.UI_LABEL_RESULT + result.getValue());
            } catch (Exception ex) {
                resultLabel.setBackground(Color.ORANGE);
                resultLabel.setText(CalculatorAppConstants.UI_LABEL_RESULT_ERROR + ex.getMessage());
            }
        });

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, inputLabel);
        frame.getContentPane().add(BorderLayout.WEST, inputText);
        frame.getContentPane().add(BorderLayout.EAST, solveButton);
        frame.getContentPane().add(BorderLayout.SOUTH, resultLabel);
        frame.setVisible(true);
    }
}
