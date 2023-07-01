package ark.bank.management;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	
	Transactions(String pinnumber){
		this.pinnumber = pinnumber ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(200,325,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(160, 420, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(325, 420, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

	    fastcash = new JButton("Fast Cash");
		fastcash.setBounds(160, 455, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(325, 455, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Change PIN");
		pinchange.setBounds(160, 490, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(325, 490, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(325, 525, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		setSize(850,850);
		setLocation(300,0);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == exit) {
			System.exit(0);
		}else if (ae.getSource()== deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource()== withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
			
		}else if (ae.getSource()== fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}else if (ae.getSource()== pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if (ae.getSource()== balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if (ae.getSource()== ministatement) {
			
			new MiniStatement(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Transactions("");
		
	}

}
