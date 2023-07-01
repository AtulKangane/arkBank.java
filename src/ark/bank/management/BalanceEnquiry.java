package ark.bank.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
	
	JButton back;
	
	String pinnumber;
	
	
	BalanceEnquiry(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,850,850);
		add(image);
		
		
		back = new JButton("Back");
		back.setBounds(330, 525, 140, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
	    try {
	        ResultSet  rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
	    	
	    	while(rs.next()) {
	    		if (rs.getString("type").equals("Deposit")) {
	    			balance += Integer.parseInt(rs.getString("amount"));
	    		}else {
	    			balance -= Integer.parseInt(rs.getString("amount"));
	    		}
	    	}
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
		
	    JLabel text = new JLabel("Your current Balance is Rs: " + balance);
	    text.setForeground(Color.white);
	    text.setFont(new Font("Raleway",Font.BOLD,16));
	    text.setBounds(165,300,400,30);
	    image.add(text);
	    
		setSize(850,850);
		setLocation(300,0);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
