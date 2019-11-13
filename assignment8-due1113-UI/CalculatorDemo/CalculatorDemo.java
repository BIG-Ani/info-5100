package Assignment8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Stack;

public class CalculatorDemo extends BaseGuiFrame {
    private JPanel contentPanel;

    private JPanel displayPanel;
    private JTextField displayText;

    private JPanel buttonPanel;
    private JButton[] digitButtons; // 0 - 9
    private JButton[] operatorButtons; // + - * / =

    private JButton pointButton;

    // calculation
    Stack<Integer> numStack = new Stack<>();
    Stack<String> operatorStack = new Stack<>();

    @Override
    public void create() {
        setBounds(500, 300, 250, 200);

        contentPanel = new JPanel();

        // setting the displaying area
        displayPanel = new JPanel();
        displayText = new JTextField();
        displayText.setText("0");
        displayText.setHorizontalAlignment(JTextField.RIGHT);
        displayText.setColumns(18);
        displayPanel.add(displayText);

        // setting the buttons area
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 3, 3));
        pointButton = new JButton("");
        digitButtons = new JButton[10];
        for (int i = 9; i >= 0; i--){
            digitButtons[i] = new JButton(String.valueOf(i));
        }

        String[] operations = {"/", "=", "*", "-", "+"};
        operatorButtons = new JButton[5];
        for (int i = 0; i < operations.length; i++){
            operatorButtons[i] = new JButton(operations[i]);
        }
    }

    @Override
    public void add(Container container) {
        // setting contentPanel, consisting displaying area and buttons area
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);

        addDisplayPanel(contentPanel);
        addButtonPanel(contentPanel);
    }

    private void addDisplayPanel(JPanel contentPanel) {
        contentPanel.add(displayPanel, BorderLayout.NORTH);
    }

    private void addButtonPanel(JPanel contentPanel) {
        int buttonIndex = 9, operatorIndex = 4;
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 4; c++){
                if (c < 3){
                    buttonPanel.add(digitButtons[buttonIndex--]);
                }else{
                    buttonPanel.add(operatorButtons[operatorIndex--]);
                }
            }
        }

        buttonPanel.add(digitButtons[buttonIndex]);
        buttonPanel.add(pointButton);

        while(operatorIndex >= 0){
            buttonPanel.add(operatorButtons[operatorIndex--]);
        }

        contentPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void addListeners() {
        for (int i = 0; i < digitButtons.length; i++){
            int numButton = i;
            digitButtons[i].addActionListener(e -> storeNums(numButton));
        }

        for (int i = 0; i < operatorButtons.length; i++) {
            if (i != 1){
                int numOperator = i;
                operatorButtons[i].addActionListener(e -> storeOperator(numOperator));
            }else{
                operatorButtons[i].addActionListener(e -> calculate());
            }
        }
    }

    private void calculate() {
        int num1 = numStack.pop();
        int num2 = numStack.isEmpty()? 0 : numStack.pop();

        switch (operatorStack.pop()){
            case "+":
                displayText.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                displayText.setText(String.valueOf(num2 - num1));
                break;
            case "*":
                displayText.setText(String.valueOf((num1 * num2)));
                break;
            case "/":
                displayText.setText(String.valueOf(num2 / num1));
                break;
        }
    }

    private void storeOperator(int numOperator) {
        displayText.setText("0");
        numStack.push(0);
        operatorStack.push(operatorButtons[numOperator].getText());
    }

    private void storeNums(int d) {
        int init = 0;
        for (int i = 0; i < digitButtons.length; i++){
            if (d == i){
                init = numStack.isEmpty()? 0 : numStack.pop();
                init = 10 * init + Integer.parseInt(digitButtons[i].getText());
                numStack.push(init);
                displayText.setText(String.valueOf(numStack.peek()));
            }
        }
    }

    // main test
    public static void main(String[] args) {
        new CalculatorDemo();
    }
}
