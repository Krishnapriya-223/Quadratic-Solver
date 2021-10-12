import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.*;

public class Quadratic extends JFrame{

	
	private JPanel contentPane; 
	JFormattedTextField tf1, tf2, tf3;
	TextArea area;
	Button result;
	Label head, lb1, lb2;
		
	
	public Quadratic() {
		setType(Type.POPUP);
		setForeground(Color.LIGHT_GRAY);
		setTitle("WELCOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 10, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		head = new Label("QUADRATIC SOLVER");
		head.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		head.setBounds(50,20,500,25);
		
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(Integer.MIN_VALUE);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		
		tf1 = new JFormattedTextField(formatter);
		tf1.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		tf1.setBounds(75,70,60,25);
		
		lb1 = new Label(" x² + ");
		lb1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lb1.setBounds(135,70,50,25);
		
		tf2 = new JFormattedTextField(formatter);
		tf2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		tf2.setBounds(185,70,60,25);
		
		lb2 = new Label(" x + ");
		lb2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lb2.setBounds(245,70,50,25);
		
		tf3 = new JFormattedTextField(formatter);
		tf3.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
		tf3.setBounds(295,70,60,25);
		
		result = new Button("ANSWER");
		result.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		result.setBounds(165, 120, 100, 25);
		result.addActionListener(new Ans());
		result.setActionCommand("ANSWER");
		
		area = new TextArea();
		area.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		area.setBounds(25, 170, 400, 580);
                area.setEditable(False);
		
		contentPane.add(head);
		contentPane.add(tf1);
		contentPane.add(lb1);
		contentPane.add(tf2);
		contentPane.add(lb2);
		contentPane.add(tf3);
		contentPane.add(result);
		contentPane.add(area);
	}

	public class Ans implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int a = Integer.parseInt(tf1.getText());
			int b = Integer.parseInt(tf2.getText());
			int c = Integer.parseInt(tf3.getText());
			if(e.getActionCommand().equals("ANSWER"))
			{
				double delta = (b*b)-(4*a*c);
				double root = Math.sqrt(delta);
				String disc = String.format("%.0f", delta);
				String sqr = String.format("%.4f", root);
				String text = "The given quadratic equation is,\n\t\t"+a+"x² + "+b+"x + "+c+" = 0"
							+"\nLet us consider,\n\t\ta="+a+", b="+b+", c="+c 
							+ "\n\nFormula to find the roots of quadratic equation is : "
							+ "\n\t\t(-b±√b²-4ac)/2a"+"\n\nLet us find the discriminant,"
							+"\nDiscriminant (Delta) = b²-4ac"
							+"\n\t\t\t= ("+b+")² - 4 x "+a+" x "+c+"\n\t\t\t= "+disc
							+ "\nThe discriminant is equal to "+disc+"\t";
				if(delta>0)
				{
					text += "    (Delta>0)\n\nThe discriminant value (delta) is POSITIVE"
							+"\nTherefore the given quadratic equation has real and\nunequal roots"
							+"\n\nThe two unequal roots of the given equation is,"
							+"\n\t(-b + Delta)/2a and (-b - Delta)/2a"
							
							+"\n\nRoot 1:\n\t(-b + Delta)/2a = (-"+b+" + √"+disc+") / 2x"+a
							+"\n\t\t\t   = (-" +b+ " + "+sqr+") / 2x"+a
							+"\n\t\t\t   = "+String.format("%.2f", (-(double)b+root))+" / "+(2*a)
							+"\n\t\t\t   = "+String.format("%.2f", (-(double)b+root)/(2*a))
							
							+"\n\nRoot 2:\n\t(-b - Delta)/2a = (-"+b+" - √"+disc+") / 2x"+a
							+"\n\t\t\t   = (-" +b+ " - "+sqr+") / 2x"+a
							+"\n\t\t\t   = "+String.format("%.2f", (-(double)b-root))+" / "+(2*a)
							+"\n\t\t\t   = "+String.format("%.2f", (-(double)b-root)/(2*a))
							+"\n\nThe roots of the equation "+a+"x² + "+b+"x + "+c+" = 0 is"
							+"\n\t\t "+String.format("%.2f", ((double)(-b+root))/(2*a))+"  and  "
							+String.format("%.2f", ((double)(-b-root))/(2*a));
					
				}
				else if(delta == 0)
				{
					text += "    (Delta=0)\n\nThe discriminant value (delta) is ZERO"
							+"\nTherefore the given quadratic equation has real and\nequal roots"
							+"\n\nThe two equal roots of the given equation is,"
							+"\n\t-b/2a and -b/2a"
							+"\n\nRoots:\n\t(-b)/2a = (-"+b+") / 2x"+a
							+"\n\t\t  = (-"+b+") / "+(2*a)
							+"\n\t\t  = "+ (-1*b)/(2*a)
							+"\n\nThe roots of the equation "+a+"x² + "+b+"x + "+c+" = 0 is"
							+"\n\t\t "+(-1*b)/(2*a)+"  and  "+(-1*b)/(2*a);
				}
				else
				{
					double g = (-(double)b)/(2*a);
					double h = (Math.sqrt(-delta))/(2*a);
					double del = Math.sqrt(-delta);
					text += "    (Delta<0)\n\nThe discriminant value (delta) is NEGATIVE"
							+ "\nTherefore the given quadaric equation has \nimaginary roots"
							+"\n\nThe two complex roots of the given equation is as \nfollows,"
							
							+"\n\nRoot 1:\n\t(-b + Delta)/2a = (-"+b+" + √"+disc+") / 2x"+a
							+"\n\t\t\t   = (-"+b+" + (√-1)x(√"+disc+") ) / "+2*a
							+"\n\tWe know that √-1 = i,"
							+"\n\t\t\t   = (-"+b+" + "+(String.format("%.2f", del))+"i) / "+2*a
							+"\n\t\t\t   = (-"+b+"/"+2*a+") + ("+(String.format("%.2f", del))+"i/"+2*a+")"
							+"\n\t\t\t   = "+(String.format("%.2f", g))+" + "+(String.format("%.2f", h))+"i"
							
							+"\n\nRoot 2:\n\t(-b + Delta)/2a = (-"+b+" - √"+disc+") / 2x"+a
							+"\n\t\t\t   = (-"+b+" - (√-1)x(√"+disc+") ) / "+2*a
							+"\n\tWe know that √-1 = i,"
							+"\n\t\t\t   = (-"+b+" - "+(String.format("%.2f", del))+"i) / "+2*a
							+"\n\t\t\t   = (-"+b+"/"+2*a+") + ("+(String.format("%.2f", del))+"i/"+2*a+")"
							+"\n\t\t\t   = "+(String.format("%.2f", g))+" + "+(String.format("%.2f", h))+"i"
							
							+"\n\nThe roots of the equation "+a+"x² + "+b+"x + "+c+" = 0 is:"
							+"\n\t "+(String.format("%.2f", g))+" + "+(String.format("%.2f", h))+"i  and  "
							+(String.format("%.2f", g))+" + "+(String.format("%.2f", h))+"i";
				}
				area.setText(text);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quadratic frame = new Quadratic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
