package ark.bank.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 
public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField ;
	JPasswordField pinTextField;
	Login (){
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(120, 10, 100, 100);
	    add(label);
	    
	    JLabel text = new JLabel("Welcome to ark Bank's ATM");
	    text.setFont(new Font("Osward", Font.BOLD, 30));
	    text.setBounds(250, 40, 450, 40);
	    add(text);
		
	    JLabel cardno = new JLabel("Card No.  :");
	    cardno.setFont(new Font("Raleway", Font.BOLD, 25));
	    cardno.setBounds(170, 150, 450, 40);
	    add(cardno);
	    
	    cardTextField = new JTextField();
	    cardTextField.setBounds(330, 150, 250, 40);
	    cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
	    add(cardTextField);
	    
	    JLabel pin = new JLabel("Pin No.    :");
	    pin.setFont(new Font("Raleway", Font.BOLD, 25));
	    pin.setBounds(170, 200, 450, 40);
	    add(pin);
	    
	    pinTextField = new JPasswordField();
	    pinTextField.setBounds(330, 200, 250, 40);
	    pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
	    add(pinTextField);
	    
	    login = new JButton("SIGN IN");
	    login.setBounds(260, 300, 100, 30);
	    login.addActionListener(this);
	    add(login);
	    
	    clear = new JButton("CLEAR");
	    clear.setBounds(420, 300, 100, 30);
	    clear.addActionListener(this);
	    add(clear);
	    
	    signup = new JButton("SIGN UP");
	    signup.setBounds(260, 350, 260, 30);
	    signup.addActionListener(this);
	    add(signup);
	    
		setTitle("ARK BANKS ATM");
		setSize(800,480);
		setLayout(null);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		
	}   else if(ae.getSource() == login) {
		
		Conn conn = new Conn();
		String cardnumber = cardTextField.getText();
		String pinnumber = pinTextField.getText();
		String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'"; 
		try {
			ResultSet rs = conn.s.executeQuery(query);
			if (rs.next()) {
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				
			}
		} catch (Exception e){
			System.out.println(e);
		}
		
	}   else if(ae.getSource() == signup) {
		setVisible(false);
		new SignupOne().setVisible(true);
		
	}	
		
	}
	public static void main(String[] args) {
	      new Login();	
	}

}
