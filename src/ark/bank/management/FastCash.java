package ark.bank.management;
import java.util.Date;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener {
	
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	String pinnumber;
	
	FastCash (String pinnumber){
		this.pinnumber = pinnumber ;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 850, 850);
		add(image);
		
		JLabel text = new JLabel("Select Withdrawl Amount");
		text.setBounds(200,325,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(160, 420, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Rs 500");
		withdrawl.setBounds(325, 420, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

	    fastcash = new JButton("RS 1000");
		fastcash.setBounds(160, 455, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Rs 2000");
		ministatement.setBounds(325, 455, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(160, 490, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Rs 10000");
		balanceenquiry.setBounds(325, 490, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Back");
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
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else {
			String amount = ((JButton) ae.getSource()).getText().substring(3);  //eg. 500
		    Conn c = new Conn();
		    try {
		         ResultSet  rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
		    	int balance = 0;
		    	while(rs.next()) {
		    		if (rs.getString("type").equals("Deposit")) {
		    			balance += Integer.parseInt(rs.getString("amount"));
		    		}else {
		    			balance -= Integer.parseInt(rs.getString("amount"));
		    		}
		    	}
		    	if (ae.getSource() != exit && balance < Integer.parseInt(amount) ) {
		    		JOptionPane.showMessageDialog(null, "Insufficient Balance");
		    		return;
		    		
		    	}
		    	
		    	Date date = new Date();
		    	String query = "insert into bank values('"+pinnumber+"','"+date+"', 'withdrawl','"+amount+"')";
		    	c.s.executeUpdate(query);
		    	JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
		    	
		    	setVisible(false);
		    	new Transactions(pinnumber).setVisible(true);
		    }catch (Exception e) {
		    	System.out.println(e);
		    }
		}
			
	}
	
	
	public static void main(String[] args) {
		new FastCash("");
		
	}

}
