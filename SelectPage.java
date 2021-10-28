import java.awt.BorderLayout;                  
import java.awt.EventQueue;                            
import java.awt.Font;                     
import java.awt.Label;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class SelectPage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectPage frame = new SelectPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Label head, cnct;
	JButton next = new JButton();
	JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
	public SelectPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		setTitle("Quadratic solver with procedures");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		head = new Label("QUADRATIC SOLVER");
		head.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		head.setBounds(35,45,500,30);
		
		cnct = new Label("Select the format of the quadratic equation to solve:");
		cnct.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		cnct.setBounds(18,125,420,20);
		
		ButtonGroup bg = new ButtonGroup();
		
		r1 = new JRadioButton("ax²+bx+c=0");
		r1.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r1.setBounds(75,170,250,20);
		bg.add(r1);
		
		r2 = new JRadioButton("ax²-bx+c=0");
		r2.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r2.setBounds(75,210,250,20);
		bg.add(r2);
		
		r3 = new JRadioButton("ax²+bx-c=0");
		r3.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r3.setBounds(75,250,250,20);
		bg.add(r3);
		
		r4 = new JRadioButton("-ax²+bx+c=0");
		r4.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r4.setBounds(75,290,250,20);
		bg.add(r4);
		
		r5 = new JRadioButton("ax²-bx-c=0");
		r5.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r5.setBounds(75,330,250,20);
		bg.add(r5);
		
		r6 = new JRadioButton("-ax²-bx+c=0");
		r6.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r6.setBounds(75,370,250,20);
		bg.add(r6);
		
		r7 = new JRadioButton("-ax²+bx-c=0");
		r7.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r7.setBounds(75,410,250,20);
		bg.add(r7);
		
		r8 = new JRadioButton("-ax²-bx-c=0");
		r8.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		r8.setBounds(75,450,250,20);
		bg.add(r8);
				
		next = new JButton("Next");
		contentPane.add(next);
		next.setBounds(170,500,100,25);
		next.addActionListener(new Click());
		next.setActionCommand("NEXT");
		
		contentPane.add(head);
		contentPane.add(cnct);
		contentPane.add(r1);
		contentPane.add(r2);
		contentPane.add(r3);
		contentPane.add(r4);
		contentPane.add(r5);
		contentPane.add(r6);
		contentPane.add(r7);
		contentPane.add(r8);
	}
	
	public class Click implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str = e.getActionCommand();
			if(str.equals("NEXT"))
			{
				try
				{
					if(r1.isSelected()==true)
					{
						Quadratic frame = new Quadratic();
						frame.setVisible(true);
						dispose();					
					}
					else if(r2.isSelected()==true)
					{
						Quadratic1 frame = new Quadratic1();
						frame.setVisible(true);
						dispose();					
					}
					else if(r3.isSelected()==true)
					{
						Quadratic2 frame = new Quadratic2();
						frame.setVisible(true);
						dispose();					
					}
					else if(r4.isSelected()==true)
					{
						Quadratic3 frame = new Quadratic3();
						frame.setVisible(true);
						dispose();					
					}
					else if(r5.isSelected()==true)
					{
						Quadratic4 frame = new Quadratic4();
						frame.setVisible(true);
						dispose();					
					}
					else if(r6.isSelected()==true)
					{
						Quadratic5 frame = new Quadratic5();
						frame.setVisible(true);
						dispose();					
					}
					else if(r7.isSelected()==true)
					{
						Quadratic6 frame = new Quadratic6();
						frame.setVisible(true);
						dispose();					
					}
					else if(r8.isSelected()==true)
					{
						Quadratic7 frame = new Quadratic7();
						frame.setVisible(true);
						dispose();					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Select any one format from the above");
					}
				}
				catch(Exception error)
				{
					JOptionPane.showMessageDialog(null, "Some error occured");
				}
			}
		}
	}

}
