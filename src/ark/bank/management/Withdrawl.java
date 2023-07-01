package ark.bank.management;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {
	JTextField amount;
	JButton withdrawl,back;
	String pinnumber;
	Withdrawl(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(850,850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,850,850);
		add(image);
		
		JLabel text = new JLabel ("Enter the Amount you want to Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("System",Font.BOLD,22));
		amount.setBounds(170,340,300,25);
		image.add(amount);
		
		withdrawl = new JButton("Withdraw");
		withdrawl.setBounds(340, 490, 130, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		

		back = new JButton("Back");
		back.setBounds(170, 490, 130, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(850,850);
		setLocation(300,0);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == withdrawl ) {
	    	String number = amount.getText();
	    	Date date = new Date();
	    	if (number.equals("")) {
	    		JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
	    		
	    	}else {
	    		try {
	    		Conn conn = new Conn();
	    		String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
	    	   conn.s.executeUpdate(query);
	    	   JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
	    	    setVisible(false);
	    	    new Transactions(pinnumber).setVisible(true);
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
	    	}	
	  } else if (ae.getSource()== back) {
		  setVisible(false);
		  new Transactions(pinnumber).setVisible(true);
	  }
    }
	
	public static void main(String[] args) {
		new Withdrawl("");
		
	}

}
