package ark.bank.management;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
	long random;
	JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, others, married, unmarried;
	JDateChooser dateChooser;
	
	SignupOne(){     //constructor
		setLayout(null);
		
		Random ran = new Random(); //to generate random no. to app. form
	    random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		JLabel formno =new JLabel("Application Form No. " + random );
		formno.setFont(new Font ("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personalDetails =new JLabel("Page 1 : Personal Details");
		personalDetails.setFont(new Font ("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		JLabel name =new JLabel("Name :");
		name.setFont(new Font ("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField ();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel fname =new JLabel("Fathers Name :");
		fname.setFont(new Font ("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField ();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel dob =new JLabel("Date Of Bith :");
		dob.setFont(new Font ("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		add(dateChooser);
		
					
		JLabel gender =new JLabel("Gender :");
		gender.setFont(new Font ("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 120, 30);
		male.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(male);
		female = new JRadioButton("Female");
	    female.setBounds(450, 290, 120, 30);
	    female.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup(); // to select only one option from male or female
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		JLabel email =new JLabel("Email :");
		email.setFont(new Font ("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField ();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel marital =new JLabel("Marital Status :");
		marital.setFont(new Font ("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 120, 30);
		married.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(married);
		unmarried = new JRadioButton("Unmarried");
	    unmarried.setBounds(450, 390, 120, 30);
	    unmarried.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(unmarried);
		others = new JRadioButton("Other");
	    others.setBounds(600, 390, 120, 30);
	    others.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(others);
		
		ButtonGroup maritalgroup = new ButtonGroup(); // to select only one option from male or female
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(others);
		
		JLabel address =new JLabel("Address :");
		address.setFont(new Font ("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextField = new JTextField ();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city =new JLabel("City :");
		city.setFont(new Font ("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityTextField = new JTextField ();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		JLabel state =new JLabel("State :");
		state.setFont(new Font ("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		stateTextField = new JTextField ();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		JLabel pincode =new JLabel("pincode :");
		pincode.setFont(new Font ("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pincodeTextField = new JTextField ();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setFont(new Font("Raleway", Font.BOLD, 16));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		setSize(850,800);
		setLocation(350,10);// loc from where frame opens(co-ordinates of upper left corner)
		setVisible(true);
		setLayout(null);
		
	}

	public void actionPerformed(ActionEvent ae) {
		String formno ="", random; // double quote is used to convert number in to string format by concating them 
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		}
		
		String email = emailTextField.getText();
		String marital = null;
		if  (married.isSelected()) {
			marital = "Married";
		} else if (unmarried.isSelected()) {
			marital = "Unmarried";
		} else if (others.isSelected()) {
			marital = "Other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pincode = pincodeTextField.getText();
		
		
		try {
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name  Required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
			    c.s.executeUpdate(query);
			    
			    setVisible(false);
			    new SignupTwo(formno).setVisible(true); // object of signupTwo form to open it after clicking next button on signupOne  
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {   //main method
		new SignupOne();    // object of main method
	}
}
