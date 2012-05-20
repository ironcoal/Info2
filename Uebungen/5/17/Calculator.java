import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;

class Calculator extends Frame implements ActionListener {
    private TextField eingabe;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, 
        b9, bC, b0, bsign, bplus, bminus, bequal;
    
    private int temp_number = 0;
    private String temp_calc = "x";
    private int result = 0;
    boolean is_number = false;

    public Calculator() {
        super();
        setTitle("Rechner");
        setBackground(Color.LIGHT_GRAY);
        Font font1 = new Font("SansSerif", Font.PLAIN, 20);
        
        Panel rechner = new Panel(new BorderLayout(0, 10));
        Panel tasten = new Panel(new GridLayout(0, 3, 3, 5));
        
        eingabe = new TextField();
        eingabe.setPreferredSize(new Dimension(200, 50));
        eingabe.setFont(font1);
        eingabe.setEditable(false);
        eingabe.setText("");

        tasten.add(b1 = new Button("1"));
        tasten.add(b2 = new Button("2"));
        tasten.add(b3 = new Button("3"));
        tasten.add(b4 = new Button("4"));
        tasten.add(b5 = new Button("5"));
        tasten.add(b6 = new Button("6"));
        tasten.add(b7 = new Button("7"));
        tasten.add(b8 = new Button("8"));
        tasten.add(b9 = new Button("9"));
        tasten.add(bC = new Button("C"));
        tasten.add(b0 = new Button("0"));
        tasten.add(bsign = new Button("+/-"));
        tasten.add(bplus = new Button("+"));
        tasten.add(bminus = new Button("-"));
        tasten.add(bequal = new Button("="));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bC.addActionListener(this);
        b0.addActionListener(this);
        bsign.addActionListener(this);
        bplus.addActionListener(this);
        bminus.addActionListener(this);
        bequal.addActionListener(this);

        rechner.add(eingabe, BorderLayout.NORTH);
        rechner.add(tasten, BorderLayout.CENTER);

        add(rechner);

        addWindowListener(new Closer());
    }
    
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        switch (s) {
            case "+/-":
                if (is_number) {
                    temp_number *= -1;
                    show(temp_number);
                } else {
                    if (eingabe.getText().equals("-"))
                        show("");
                    else 
                        show("-");                      
                }
                break;
            case "C": 
                temp_number = 0;
                temp_calc = "x";
                result = 0;
                show("");
                break;
            case "=":
                calc();
                temp_number = 0;
                is_number = false;
                temp_calc = "x";
                show(result);
                break;
            case "+": case "-":
                calc();
                temp_calc = s;
                is_number = false;
                temp_number = 0;
                show(result);
                break;
            default:
                int i = Integer.parseInt(s);
                temp_number *= 10;
                temp_number += i;
                if (temp_calc.equals("x"))
                    result = 0;
                if (eingabe.getText().equals("-"))
                    temp_number *= -1;
                is_number = true;
                show(temp_number);          
            }
            System.out.println("result: " + result + " temp_number: " + temp_number + " temp_calc: " 
                + temp_calc + " is_number: " + is_number);
    }               
    private void calc() {
        if (temp_calc.equals("+"))
            result += temp_number;
        else if (temp_calc.equals("-"))
            result -= temp_number;
        else 
            result = temp_number;       
    }               

    private void show(int number) {
        eingabe.setText(Integer.toString(number));
    }

    private void show(String s) {
        eingabe.setText(s);
    }

    protected static final class Closer extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}