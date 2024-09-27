import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JFrame frame;
    private JTextField display;
    private JButton addButton, minusButton, timesButton, divideButton;
    private JButton equalsButton, dotButton, resetButton, delButton;
    private Font myFont = new Font("Arial", Font.BOLD, 30);


    private double num1 = 0;
    private double result = 0;
    private char operator;

    public GUI() {
        numberButtons = new JButton[10];
        functionButtons = new JButton[8];
        display = new JTextField();
        frame = new JFrame("Calculator");
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        display = new JTextField();
        display.setBounds(50,25,300,50);
        display.setEditable(false);



        for(int i = 0; i< numberButtons.length; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
        }

        resetButton = new JButton("reset");
        delButton = new JButton("delete");
        addButton = new JButton("+");
        minusButton = new JButton("-");
        timesButton = new JButton("*");
        divideButton = new JButton("÷");
        equalsButton = new JButton("=");
        dotButton = new JButton(".");

        functionButtons[0] = resetButton;
        functionButtons[1] = delButton;
        functionButtons[2] = addButton;
        functionButtons[3] = minusButton;
        functionButtons[4] = timesButton;
        functionButtons[5] = divideButton;
        functionButtons[6] = equalsButton;
        functionButtons[7] = dotButton;

        for (int i = 0; i<functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
        }

        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(minusButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(timesButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(display);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(50, 410, 300, 50);
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 10));
        bottomPanel.add(resetButton);
        bottomPanel.add(delButton);
        frame.add(bottomPanel);

        frame.setVisible(true);

     }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                display.setText(display.getText() + i);
                return;
            }
        }
        if(e.getSource() == dotButton){
            num1 = Double.parseDouble(display.getText());
            display.setText(display.getText() + '.');
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if(e.getSource() == minusButton){
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if(e.getSource() == timesButton){
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if(e.getSource() == equalsButton){
            double num2 = Double.parseDouble(display.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1- num2;
                    break;
                case '*':
                    result = num1* num2;
                    break;
                case '/':
                    if(num2 != 0) {
                        result = num1 / num2;
                    }else{
                        display.setText("error");
                    }
                    break;

            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == resetButton){
            result = 0;
            display.setText("");
        }
        if(e.getSource() == delButton){
            if(!display.getText().isEmpty()) {
                display.setText(display.getText().substring(0, display.getText().length() - 1));
            }
        }

    }

    public static void main(String[] args){
    new GUI();
}

}

