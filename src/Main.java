import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Main implements WindowListener, ActionListener {
    Frame window = new Frame("Ador Calculator");
    Panel frame = new Panel();
    Panel screenPanel = new Panel();
    Panel buttonPanel = new Panel();
    Panel resultPanel = new Panel();
    Label screen = new Label("0");
    Button buttons[] = new Button[15];
    Button equalButton = new Button("=");
    Button clearButton = new Button("AC");
    TextField tf = new TextField();

    boolean previousNumber = true;
    String currentSymbol = "";

    DecimalFormat df = new DecimalFormat("#.####");

    Panel northPadding = new Panel();
    Panel southPadding = new Panel();
    Panel eastPadding = new Panel();
    Panel westPadding = new Panel();


    boolean doClear = false;

    Main() {
        buttonPanel.setLayout(new GridLayout(3,5, 10,10));
        for(int i=0; i<10; i++) {
            buttons[i] = new Button(Integer.toString(i));
            buttons[i].setActionCommand(Integer.toString(i));
            buttonPanel.add(buttons[i]);
        }
        buttons[10] = new Button("+");
        buttons[10].setActionCommand("plus");
        buttonPanel.add(buttons[10]);
        buttons[11] = new Button("-");
        buttons[11].setActionCommand("minus");
        buttonPanel.add(buttons[11]);
        buttons[12] = new Button("×");
        buttons[12].setActionCommand("multiply");
        buttonPanel.add(buttons[12]);
        buttons[13] = new Button("÷");
        buttons[13].setActionCommand("division");
        buttonPanel.add(buttons[13]);
        buttons[14] = new Button("%");
        buttons[14].setActionCommand("modulus");
        buttonPanel.add(buttons[14]);
        for(Button button: buttons) {
            button.setBackground(new Color(130,130,130));
            button.setForeground(Color.white);
            button.setFont(new Font("Arial", Font.BOLD, 30));
            button.addActionListener(this);
        }

        buttons[10].setBackground(new Color(90,90,90));
        buttons[11].setBackground(new Color(90,90,90));
        buttons[12].setBackground(new Color(90,90,90));
        buttons[13].setBackground(new Color(90,90,90));
        buttons[14].setBackground(new Color(90,90,90));


        equalButton.setBackground(new Color(90,90,90));
        equalButton.setForeground(Color.white);
        equalButton.setFont(new Font("Arial", Font.BOLD, 30));
        equalButton.setActionCommand("equal");
        equalButton.addActionListener(this);

        clearButton.setBackground(Color.orange);
        clearButton.setForeground(Color.black);
        clearButton.setFont(new Font("Arial", Font.BOLD, 30));
        clearButton.setActionCommand("clear");
        clearButton.addActionListener(this);

        screenPanel.setLayout(new GridLayout(1,1,10,10));
        screenPanel.setPreferredSize(new Dimension(0, 100));
        screen.setBackground(new Color(240,240,240));
        screen.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        screenPanel.add(screen);


        resultPanel.setLayout(new GridLayout(1,2,10,10));
        resultPanel.setPreferredSize(new Dimension(0, 80));
        resultPanel.add(equalButton);
        resultPanel.add(clearButton);

        frame.setLayout(new BorderLayout(10,10));
        frame.add(screenPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        window.setBackground(new Color(190,190,190));
        window.setLayout(new BorderLayout(10,10));
        window.add(northPadding, BorderLayout.NORTH);
        window.add(southPadding, BorderLayout.SOUTH);
        window.add(eastPadding, BorderLayout.EAST);
        window.add(westPadding, BorderLayout.WEST);
        window.add(frame, BorderLayout.CENTER);

        window.setSize(500,500);
        window.addWindowListener(this);
        window.setVisible(true);
    }



    public void doCalculation(String oldText) {
        try {
            String numbers[] = oldText.split("[+\\-×÷%]");
            double result = Double.parseDouble(numbers[0]);

            if(currentSymbol.equals("+")) {
                result += Double.parseDouble(numbers[1]);
            }
            else if(currentSymbol.equals("-")) {
                result -= Double.parseDouble(numbers[1]);
            }
            else if(currentSymbol.equals("×")) {
                result *= Double.parseDouble(numbers[1]);
            }
            else if(currentSymbol.equals("÷") && Double.parseDouble(numbers[1])!=0) {
                result /= Double.parseDouble(numbers[1]);
            }
            else if(currentSymbol.equals("%")) {
                result %= Double.parseDouble(numbers[1]);
            }

            if(currentSymbol.equals("÷") && Double.parseDouble(numbers[1])==0) {
                screen.setText("Math ERROR");
            }
            else {
                screen.setText(df.format(result));
                buttons[1].get
            }

            currentSymbol = "";
        }
        catch (Exception e) {
            doClear = false;
        }
    }

    String setSymbol(String oldText, String symbol) {
        if(!currentSymbol.equals("")) {
            doCalculation(oldText);
            oldText = screen.getText();
        }
        if (previousNumber) {
            previousNumber = false;
            currentSymbol = symbol;
            return oldText+symbol;
        }
        else {
            int oldTextLength = oldText.length();
            String newText = oldText.substring(0, oldTextLength-1);
            currentSymbol = symbol;
            return newText+symbol;
        }
    };


    public void actionPerformed ( ActionEvent e ){
        String oldText = screen.getText();

        String newText = screen.getText();
        if(oldText.equals("0") || oldText.equals("Math ERROR") || doClear) {
            doClear = false;
            newText = "";
        }


        if(e.getActionCommand().equals("equal")) {
            doCalculation(oldText);
            doClear = true;
        }
        else if(e.getActionCommand().equals("clear")) {
            screen.setText("0");
            previousNumber = true;
        }
        if(e.getActionCommand().equals("0")) {
            screen.setText(newText+"0");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("1")) {
            screen.setText(newText+"1");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("2")) {
            screen.setText(newText+"2");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("3")) {
            screen.setText(newText+"3");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("4")) {
            screen.setText(newText+"4");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("5")) {
            screen.setText(newText+"5");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("6")) {
            screen.setText(newText+"6");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("7")) {
            screen.setText(newText+"7");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("8")) {
            screen.setText(newText+"8");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("9")) {
            screen.setText(newText+"9");
            previousNumber = true;
        }
        else if(e.getActionCommand().equals("plus")) {
            screen.setText(setSymbol(oldText,"+"));
        }
        else if(e.getActionCommand().equals("minus")) {
            screen.setText(setSymbol(oldText,"-"));
        }
        else if(e.getActionCommand().equals("multiply")) {
            screen.setText(setSymbol(oldText,"×"));
        }
        else if(e.getActionCommand().equals("division")) {
            screen.setText(setSymbol(oldText,"÷"));
        }
        else if(e.getActionCommand().equals("modulus")) {
            screen.setText(setSymbol(oldText,"%"));
        }
    }


    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new Main();
    }
}