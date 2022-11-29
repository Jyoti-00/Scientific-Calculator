import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
/* This class creates and defines the attributes of the frame, panel and buttons for the calculator. 
 * It takes the integer and operation input from the user and uses variablkes to assign inputted value 
 * to perform calculations. It also uses math class to perform certain scientific calculations
 */


// Creating the Frame and adding listener interface to implement action events 
public class SciFiCalculator extends JFrame implements ActionListener{

	
	
	//Container of the calculator
	JPanel calcpanel;
	

	// Declaring the buttons 
	JButton trisin, tricos, tritan;
	JButton opsqrt,oneoverx,oplog, xsquare,xcube ,factorialbtn;
	JButton piecalcbtn,percentagebtn,bracket1 , bracket2;
	
	JButton numkey3,numkey2,numkey1,numkey4,numkey5,numkey6, numkey7, numkey8, numkey9,numkey0;

	JButton opaddition, opsubtract, opmultiply, opdivide;
	JButton numstateposneg,equalansbtn;
	
	JButton eqnclearbutton, decimalbtn,addtomemorybtn, memoryshowbtn, memoryclrbtn;

	JTextField equationdomain; // Textfield for inputting equation
	JTextField answerdomain; // Textfield for getting calculated result 

	

	
	 char ch;
	
	 String lastOperation = "";
	
	 double standbyV1, standbyV2, output, aggregate;
	 static double memoryvar;
	
	
	 int base = 1, count1 = 0, count2 = 0, count3 = 0;
	
	
	 
	 
	 // This is a parameterized constructor which takes different parameters such as
	// name of the buttons, position and dimension etc and pass them to create the calculator 
	
	 
	public SciFiCalculator()
	{
		calcpanel = new JPanel();
		calcpanel.setLayout(null);
	
		// First row buttons 
		numkey0 = new JButton("0");  // Button name
		numkey0.setBounds(30,685,100,60); //x-axis, y-axis, Width and Height of the buttons 
		numkey0.setFocusable(false);
		numkey0.setFont(new Font("Comic Sans", Font.BOLD, 24)); 
		numkey0.setBorder(BorderFactory.createEtchedBorder());
		
		decimalbtn = new JButton(".");
		decimalbtn.setBounds(140,685,100,60);
		decimalbtn.setFocusable(false); 
		decimalbtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    decimalbtn.setBorder(BorderFactory.createEtchedBorder());
		
		numstateposneg = new JButton("+/-");
		numstateposneg.setBounds(250,685,100,60);
		numstateposneg.setFocusable(false);
		numstateposneg.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numstateposneg.setBorder(BorderFactory.createEtchedBorder());
		
		equalansbtn = new JButton("=");
		equalansbtn.setBounds(360,685,100,60);
		equalansbtn.setFocusable(false);
	    equalansbtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    equalansbtn.setBorder(BorderFactory.createEtchedBorder());
		

		//Second row buttons
		numkey1 = new JButton("1");
		numkey1.setBounds(30,615,100,60);
		numkey1.setFocusable(false);
		numkey1.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey1.setBorder(BorderFactory.createEtchedBorder());
		
		numkey2 = new JButton("2");
		numkey2.setBounds(140,615,100,60);
		numkey2.setFocusable(false);
		numkey2.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey2.setBorder(BorderFactory.createEtchedBorder());
		
		numkey3 = new JButton("3");
		numkey3.setBounds(250,615,100,60);
		numkey3.setFocusable(false);
		numkey3.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey3.setBorder(BorderFactory.createEtchedBorder());
		
		opaddition = new JButton("+");
		opaddition.setBounds(360,615,100,60);
		opaddition.setFocusable(false);
		opaddition.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    opaddition.setBorder(BorderFactory.createEtchedBorder());
		
		//Third row buttons
		numkey4 = new JButton("4");
		numkey4.setBounds(30,545,100,60);
		numkey4.setFocusable(false);
		numkey4.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey4.setBorder(BorderFactory.createEtchedBorder());
		
		numkey5 = new JButton("5");
		numkey5.setBounds(140,545,100,60);
		numkey5.setFocusable(false);
		numkey5.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey5.setBorder(BorderFactory.createEtchedBorder());
		
		numkey6 = new JButton("6");
		numkey6.setBounds(250,545,100,60);
		numkey6.setFocusable(false);
		numkey6.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey6.setBorder(BorderFactory.createEtchedBorder());
		
		opsubtract = new JButton("-");
		opsubtract.setBounds(360,545,100,60);
		opsubtract.setFocusable(false);
		opsubtract.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    opsubtract.setBorder(BorderFactory.createEtchedBorder());
		
		//Fourth Row Buttons
		numkey7 = new JButton("7");
		numkey7.setBounds(30,475,100,60);
		numkey7.setFocusable(false);
		numkey7.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey7.setBorder(BorderFactory.createEtchedBorder());
		
		numkey8 = new JButton("8");
		numkey8.setBounds(140,475,100,60);	
		numkey8.setFocusable(false);
		numkey8.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey8.setBorder(BorderFactory.createEtchedBorder());
		
		numkey9 = new JButton("9");
		numkey9.setBounds(250,475,100,60);
		numkey9.setFocusable(false);
		numkey9.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    numkey9.setBorder(BorderFactory.createEtchedBorder());
		
		opmultiply = new JButton("*");
		opmultiply.setBounds(360,475,100,60);
		opmultiply.setFocusable(false);
		opmultiply.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    opmultiply.setBorder(BorderFactory.createEtchedBorder());
		
		//Fifth Row buttons
		trisin = new JButton("SIN");
		trisin.setBounds(30,405,100,60);
		trisin.setFocusable(false);
		trisin.setFont(new Font("Comic Sans", Font.BOLD, 22));
	    trisin.setBorder(BorderFactory.createEtchedBorder());
		
		tricos = new JButton("COS");
		tricos.setBounds(140,405,100,60);
		tricos.setFocusable(false);
		tricos.setFont(new Font("Comic Sans", Font.BOLD, 22));
	    tricos.setBorder(BorderFactory.createEtchedBorder());
		
		tritan = new JButton("TAN");
		tritan.setBounds(250,405,100,60);
		tritan.setFocusable(false);
		tritan.setFont(new Font("Comic Sans", Font.BOLD, 22));
	    tritan.setBorder(BorderFactory.createEtchedBorder());
		
		opdivide = new JButton("/");
		opdivide.setBounds(360,405,100,60);
		opdivide.setFocusable(false);
		opdivide.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    opdivide.setBorder(BorderFactory.createEtchedBorder());
		
		//Sixth Row Buttons
		xsquare = new JButton("\u33A1"); // Unicode for square
		xsquare.setBounds(30,335,100,60);
		xsquare.setFocusable(false);
		xsquare.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    xsquare.setBorder(BorderFactory.createEtchedBorder());
		
		xcube = new JButton("\u33A5"); //Unicode for cube
		xcube.setBounds(140,335,100,60);	
		xcube.setFocusable(false);
		xcube.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    xcube.setBorder(BorderFactory.createEtchedBorder());
	    
		factorialbtn = new JButton("n!");
		factorialbtn.setBounds(250,335,100,60);
		factorialbtn.setFocusable(false);
		factorialbtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    factorialbtn.setBorder(BorderFactory.createEtchedBorder());
		
		oneoverx = new JButton("1/x");
		oneoverx.setBounds(360,335,100,60);
		oneoverx.setFocusable(false);
		oneoverx.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    oneoverx.setBorder(BorderFactory.createEtchedBorder());
		
		//Seventh Row Buttons
		opsqrt = new JButton("\u221A"); // Unicode for Square root
		opsqrt.setBounds(30,265,100,60);
		opsqrt.setFocusable(false);
		opsqrt.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    opsqrt.setBorder(BorderFactory.createEtchedBorder());
		
		oplog = new JButton("log");
		oplog.setBounds(140,265,100,60);
		oplog.setFocusable(false);
		oplog.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    oplog.setBorder(BorderFactory.createEtchedBorder());
		
		piecalcbtn = new JButton("\u03c0"); //Unicode for PI
		piecalcbtn.setBounds(250,265,100,60);
		piecalcbtn.setFocusable(false);
		piecalcbtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    piecalcbtn.setBorder(BorderFactory.createEtchedBorder());
		
		percentagebtn = new JButton("%");
		percentagebtn.setBounds(360,265,100,60);
		percentagebtn.setFocusable(false);
		percentagebtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    percentagebtn.setBorder(BorderFactory.createEtchedBorder());
		
		//Eighth Row Buttons
		bracket1 = new JButton("(");
		bracket1.setBounds(30,195,100,60);
		bracket1.setFocusable(false);
		bracket1.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    bracket1.setBorder(BorderFactory.createEtchedBorder());
		
		bracket2 = new JButton(")");
		bracket2.setBounds(140,195,100,60);
		bracket2.setFocusable(false);
		bracket2.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    bracket2.setBorder(BorderFactory.createEtchedBorder());
		
		addtomemorybtn = new JButton("Save");
		addtomemorybtn.setBounds(250,195,100,60);
		addtomemorybtn.setFocusable(false);
		addtomemorybtn.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    addtomemorybtn.setBorder(BorderFactory.createEtchedBorder());
		
		eqnclearbutton = new JButton("AC");
		eqnclearbutton.setBounds(360,195,100,60);
		eqnclearbutton.setForeground(Color.RED);
		eqnclearbutton.setFocusable(false);
		eqnclearbutton.setFont(new Font("Comic Sans", Font.BOLD, 24));
	    eqnclearbutton.setBorder(BorderFactory.createEtchedBorder());
	    
	    // Ninth Row Buttons
	    memoryshowbtn = new JButton("Recall");
	    memoryshowbtn.setBounds(30, 145, 210, 40);
	    memoryshowbtn.setFocusable(false);
	    memoryshowbtn.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    memoryshowbtn.setBorder(BorderFactory.createEtchedBorder());
	    
	    memoryclrbtn = new JButton("ClearM");
	    memoryclrbtn.setBounds(250, 145, 210, 40);
	    memoryclrbtn.setForeground(Color.RED);
	    memoryclrbtn.setFocusable(false);
	    memoryclrbtn.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    memoryclrbtn.setBorder(BorderFactory.createEtchedBorder());
	    
	    
	    
		//TextField to Enter Equation		

		equationdomain = new JTextField(20);
		equationdomain.setBounds(30,15,430,60);
		equationdomain.setFont(new Font("Comic Sans", Font.BOLD, 15));
		equationdomain.setHorizontalAlignment(SwingConstants.RIGHT);
		equationdomain.setBackground(Color.white);
		equationdomain.setText("");
		equationdomain.setEditable(false);
		equationdomain.addKeyListener(new KeyAdapter() {
             public void keyTyped(KeyEvent keyevent) {
                     char c = keyevent.getKeyChar();
                     if (c >= '0' && c <= '9') {
                     } else {
                             keyevent.consume();
                     }
             }
     });

		 // Textfield to get answers 
		
		answerdomain = new JTextField(20);
		answerdomain.setBounds(30,80,430,60);
		answerdomain.setFont(new Font("Comic Sans", Font.BOLD, 15));
		answerdomain.setHorizontalAlignment(SwingConstants.RIGHT);
		answerdomain.setBackground(Color.white);
		answerdomain.setText("");
		answerdomain.setEditable(false);

		
		// adding buttons to the panel 
		
		add(calcpanel);
		calcpanel.add(numkey3);
		calcpanel.add(numkey2);
		calcpanel.add(numkey1);
		calcpanel.add(numkey4);
		calcpanel.add(numkey5);
		calcpanel.add(numkey6);
		calcpanel.add(numkey7);
		calcpanel.add(numkey8);
		calcpanel.add(numkey9);
		calcpanel.add(numkey0);
		calcpanel.add(decimalbtn);
		calcpanel.add(opaddition);
		calcpanel.add(numstateposneg);
		calcpanel.add(opsubtract);
		calcpanel.add(equalansbtn);
		calcpanel.add(trisin);
		calcpanel.add(tricos);
		calcpanel.add(tritan);
		calcpanel.add(opdivide);
		calcpanel.add(xsquare);
		calcpanel.add(xcube);
		calcpanel.add(factorialbtn);
		calcpanel.add(opmultiply);
		calcpanel.add(opsqrt);
		calcpanel.add(oplog);
		calcpanel.add(piecalcbtn);
		calcpanel.add(percentagebtn);
		calcpanel.add(bracket1);
		calcpanel.add(bracket2);	
		calcpanel.add(eqnclearbutton);
		calcpanel.add(oneoverx);
		calcpanel.add(addtomemorybtn);
		calcpanel.add(equationdomain);
		calcpanel.add(answerdomain);
		calcpanel.add(memoryshowbtn);
		calcpanel.add(memoryclrbtn);

		
		// adding actionlistener to collect action events 
		numkey3.addActionListener(this);
		numkey2.addActionListener(this);
		numkey1.addActionListener(this);
		numkey4.addActionListener(this);
		numkey5.addActionListener(this);
		numkey6.addActionListener(this);
		numkey7.addActionListener(this);
		numkey8.addActionListener(this);
		numkey9.addActionListener(this);
		numkey0.addActionListener(this);
		opsubtract.addActionListener(this);
		numstateposneg.addActionListener(this);
		opaddition.addActionListener(this);
		equalansbtn.addActionListener(this);	
		trisin.addActionListener(this);
		tricos.addActionListener(this);
		tritan.addActionListener(this);
		opdivide.addActionListener(this);
		xsquare.addActionListener(this);
		xcube.addActionListener(this);
		factorialbtn.addActionListener(this);
		opmultiply.addActionListener(this);
		opsqrt.addActionListener(this);
		oplog.addActionListener(this);
		piecalcbtn.addActionListener(this);
		percentagebtn.addActionListener(this);
		oneoverx.addActionListener(this);
		bracket1.addActionListener(this);
		bracket2.addActionListener(this);
		eqnclearbutton.addActionListener(this);
		addtomemorybtn.addActionListener(this);
		decimalbtn.addActionListener(this);
		memoryshowbtn.addActionListener(this);
		memoryclrbtn.addActionListener(this);
			
	}
	
	
	
	// This is the main method where the frame of the calculator is created and attributes passed
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Calculator = new SciFiCalculator();
		
		Calculator.setTitle("Calculator");
		Calculator.setSize(500, 850);
		Calculator.setLocation(250, 30);
		Calculator.setVisible(true);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
	// this method calculates the factorial of an integer 
	 double factorialfunction(double var) {
         int initial = 0;
         if (var < 0) {
                 initial = 20;
                 return 0;
         }
         
         double a, b = 1;
         for (a = 2; a <= var; a += 1.0)
                 b *= a;
         return b;
         
 }
	
	// This method is invoked when an action occurs 
	 public void actionPerformed(ActionEvent e) {
         String userinput = e.getActionCommand();
         
         
         
         if (userinput.equals("n!"))  // factorial calculation 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                 } 
                 
                 else {
                         aggregate = factorialfunction(Double.parseDouble(equationdomain.getText()));
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         
         // Taking integer inputs 
        if (userinput.equals("0")) 
        	 
         {
                 if (count3 == 0) {
                         equationdomain.setText(equationdomain.getText() + "0");
                         
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "0");
                         count3 = 0;
                 }
         }
         if (userinput.equals("1")) 
         {
                 if (count3 == 0) {
                	 
                         equationdomain.setText(equationdomain.getText() + "1");
                         
                 }
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "1");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("2")) 
         {
                 if (count3 == 0) 
                 {
                         equationdomain.setText(equationdomain.getText() + "2");
                         
                 } 
                 else {
                	 
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "2");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("3")) 
         {
                 if (count3 == 0) {
                	 
                         equationdomain.setText(equationdomain.getText() + "3");
                 } 
                 else {
                	 
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "3");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("4")) 
         {
                 if (count3 == 0) {
                         equationdomain.setText(equationdomain.getText() + "4");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "4");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("5")) 
         {
                 if (count3 == 0) {
                	 
                         equationdomain.setText(equationdomain.getText() + "5");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "5");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("6")) 
         {
                 if (count3 == 0) 
                 {
                         equationdomain.setText(equationdomain.getText() + "6");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "6");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("7")) 
         {
                 if (count3 == 0) 
                 {
                         equationdomain.setText(equationdomain.getText() + "7");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "7");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("8")) 
        	 
         {
                 if (count3 == 0) 
                 {
                         equationdomain.setText(equationdomain.getText() + "8");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "8");
                         count3 = 0;
                 }
         }
         
         if (userinput.equals("9")) 
        	 
         {
                 if (count3 == 0) {
                         equationdomain.setText(equationdomain.getText() + "9");
                 } 
                 else {
                         equationdomain.setText("");
                         equationdomain.setText(equationdomain.getText() + "9");
                         count3 = 0;
                 }
         }
         
       
         // assigning the role of equal sign 
        if (userinput.equals("=")) 
        	 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                 } 
               else {
                         standbyV2 = Double.parseDouble(equationdomain.getText());
                         
                         // Storing the inputs in variables and performing calculation 
                         switch (ch) {
                         case '+':
                                 output = standbyV1 + standbyV2;
                                 break;
                         case '-':
                                 output = standbyV1 - standbyV2;
                                 break;
                         case '/':
                                 output = standbyV1 / standbyV2;
                                 break;
                         case '*':
                                 output = standbyV1 * standbyV2;
                                 break;
                                 
                         }
                         
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + output);
                         count3 = 1;
                         
                 }
         }
        
        // assigning the role of the operators 
        if (userinput.equals("+")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                        standbyV1 = 0;
                        ch = '+';
                } else {
                        standbyV1 = Double.parseDouble(equationdomain.getText());
                        equationdomain.setText("");
                        ch = '+';
                        count2 = 0;
                        count1 = 0;
                }
                equationdomain.requestFocus();
        }
        
        if (userinput.equals("-")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                        standbyV1 = 0;
                        ch = '-';
                } 
                else {
                        count1 = 0;
                        count2 = 0;
                        standbyV1 = Double.parseDouble(equationdomain.getText());
                        equationdomain.setText("");
                        ch = '-';
                }
                equationdomain.requestFocus();
        }
        
        if (userinput.equals("*"))
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                        standbyV1 = 1;
                        ch = '*';
                }
                else {
                        count1 = 0;
                        count2 = 0;
                        standbyV1 = Double.parseDouble(equationdomain.getText());
                        ch = '*';
                        equationdomain.setText("");
                }
                equationdomain.requestFocus();
        }
        
        if (userinput.equals("/")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                        standbyV1 = 1;
                        ch = '/';
                } 
                else {
                        count1 = 0;
                        count2 = 0;
                        standbyV1 = Double.parseDouble(equationdomain.getText());
                        ch = '/';
                        equationdomain.setText("");
                }
                equationdomain.requestFocus();
        }
        
        // Using Math class for arithmetic operations 
        if (userinput.equals("\u33A1")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                } 
                else {
                        aggregate = Math.pow(Double.parseDouble(equationdomain.getText()), 2);
                        equationdomain.setText("");
                        answerdomain.setText(equationdomain.getText() + aggregate);
                }
        }
        
        // Using Math class for numeric function Cube number 
        if (userinput.equals("\u33A5")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                }
                else {
                        aggregate = Math.pow(Double.parseDouble(equationdomain.getText()), 3);
                        equationdomain.setText("");
                        answerdomain.setText(equationdomain.getText() + aggregate);
                }
        }
        
        // Using Math class for numeric function Square Root 
        if (userinput.equals("\u221A")) 
        {
                if (equationdomain.getText().equals("")) {
                        equationdomain.setText("");
                } else {
                        aggregate = Math.sqrt(Double.parseDouble(equationdomain.getText()));
                        equationdomain.setText("");
                        answerdomain.setText(equationdomain.getText() + aggregate);
                }
        }
        
        // Integer Divided by one 
         if (userinput.equals("1/x")) 
         
         {
                 if (equationdomain.getText().equals("")) {
                	 
                         equationdomain.setText("");
                 } 
                 else {
                         aggregate = 1 / Double.parseDouble(equationdomain.getText());
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         // Using input/100 to get percentage 
         if (userinput.equals("%"))
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                         
                 }
                 else {
                	     aggregate = Double.parseDouble(equationdomain.getText()) / 100;
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         
         // Getting the opposite line value of an integer 
         if (userinput.equals("+/-")) 
         {
                 if (count1 == 0) {
                         equationdomain.setText("-" + equationdomain.getText());
                         count1 = 1;
                 } else {
                         equationdomain.setText(equationdomain.getText());
                 }
         }
         
         
         if (userinput.equals(".")) 
         {
                 if (count2 == 0) {
                         equationdomain.setText(equationdomain.getText() + ".");
                         count2 = 1;
                 } else {
                         equationdomain.setText(equationdomain.getText());
                 }
         }
         
         // Clears memory 
         if (userinput.equals("ClearM")) 
         {
                 memoryvar = 0;
                 equationdomain.setText("");
         }
         // Shows memory 
         if (userinput.equals("Recall"))
         {
                 equationdomain.setText("");
                 equationdomain.setText(equationdomain.getText() + memoryvar);
         }
         
         // Saves to the memory 
         if (userinput.equals("Save"))
         {
                 if (base == 1) {
                         memoryvar = Double.parseDouble(answerdomain.getText());
                         base++;
                 } else {
                         memoryvar += Double.parseDouble(answerdomain.getText());
                         equationdomain.setText("" + memoryvar);
                 }
         }
         // Clears Textfields 
         if (userinput.equals("AC")) 
         {
                 equationdomain.setText("");
                 count1 = 0;
                 count2 = 0;
                 count3 = 0;
                 answerdomain.setText("");
         }
         
         // // Using Math class for numeric function Logarithm 
         /* Math.log gives the logarithmic value by taking e as base which is considered ln(x)
          * Thats why math.log10() is used, to use 10 as logarithm base 
          */
         if (userinput.equals("log")) 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                         
                 } 
                 else {
                         aggregate = Math.log10(Double.parseDouble(equationdomain.getText()));
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         
         // Math class to solve trigonometric problems 
         if (userinput.equals("SIN")) 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                 } else {
                         aggregate = Math.sin(Double.parseDouble(equationdomain.getText()));
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         if (userinput.equals("COS")) 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                 } else {
                         aggregate = Math.cos(Double.parseDouble(equationdomain.getText()));
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         if (userinput.equals("TAN")) 
         {
                 if (equationdomain.getText().equals("")) {
                         equationdomain.setText("");
                 } else {
                         aggregate = Math.tan(Double.parseDouble(equationdomain.getText()));
                         equationdomain.setText("");
                         answerdomain.setText(equationdomain.getText() + aggregate);
                 }
         }
         
         //  // Using Math class for numeric function value of pi 
         if (userinput.equals("\u03c0"))  //Unicode for PI
         {
             if (equationdomain.getText().equals("")) {
                     equationdomain.setText("");
             } else {
                     aggregate = Math.PI*(Double.parseDouble(equationdomain.getText()));
                     equationdomain.setText("");
                     answerdomain.setText(equationdomain.getText() + aggregate);
             }
     }
         equationdomain.requestFocus(); // To get the component input focus 
         
   }
	 
	 

}

