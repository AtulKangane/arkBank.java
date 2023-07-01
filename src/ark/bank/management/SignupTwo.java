package ark.bank.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class SignupTwo extends JFrame implements ActionListener {
	
	JTextField pan,aadhar;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion, category, occupation, education, income;
	String formno;
	
	
	SignupTwo(String formno){     //constructor
		this.formno = formno;
		setLayout(null);
		setTitle("New Account Application Form Page 2 " );
		
		
		JLabel additionalDetails =new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font ("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel rel =new JLabel("Religion :");
		rel.setFont(new Font ("Raleway", Font.BOLD, 20));
		rel.setBounds(100, 140, 100, 30);
		add(rel);
		
		String ValReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religion = new JComboBox(ValReligion);
		religion.setBounds(300, 140, 400, 30);
		add(religion);
		
		
		JLabel cat =new JLabel("Category :");
		cat.setFont(new Font ("Raleway", Font.BOLD, 20));
		cat.setBounds(100, 190, 200, 30);
		add(cat);
		
		String valcategory[] = {"General","OBC","SC","Other"};
		category = new JComboBox(valcategory);
		category.setBounds(300, 190, 400, 30);
		add(category);
		
		JLabel inc =new JLabel("Income :");
		inc.setFont(new Font ("Raleway", Font.BOLD, 20));
		inc.setBounds(100, 240, 200, 30);
		add(inc);
		
		String incomecategory[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","Up to 10,00,000"};
		income = new JComboBox(incomecategory);
		income.setBounds(300, 240, 400, 30);
		add(income);
		
					
		JLabel edu =new JLabel("Educational");
		edu.setFont(new Font ("Raleway", Font.BOLD, 20));
		edu.setBounds(100, 290, 200, 30);
		add(edu);
			
		JLabel qual =new JLabel("Qualification :");
		qual.setFont(new Font ("Raleway", Font.BOLD, 20));
		qual.setBounds(100, 320, 200, 30);
		add(qual);
		
		String educationValues[] = {"Non-Graduate","Graduation","Post-Graduation","Doctrate","Others"};
		education = new JComboBox(educationValues);
		education.setBounds(300, 305, 400, 30);
		add(education);
		
		
		
		JLabel ocp =new JLabel("Occupation :");
		ocp.setFont(new Font ("Raleway", Font.BOLD, 20));
		ocp.setBounds(100, 390, 200, 30);
		add(ocp);
		
		String occValues[] = {"Salaried","Self Employed","Business","Student","Retired","Others"};
		occupation = new JComboBox(occValues);
		occupation.setBounds(300, 390, 400, 30);
		add(occupation);
		
		
		
		JLabel pno =new JLabel("PAN No :");
		pno.setFont(new Font ("Raleway", Font.BOLD, 20));
		pno.setBounds(100, 440, 200, 30);
		add(pno);
		
		pan = new JTextField ();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
	    pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel adh =new JLabel("AADHAR No :");
		adh.setFont(new Font ("Raleway", Font.BOLD, 20));
		adh.setBounds(100, 490, 200, 30);
		add(adh);
		
		aadhar = new JTextField ();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel snrc =new JLabel("Senior Citizen :");
		snrc.setFont(new Font ("Raleway", Font.BOLD, 20));
		snrc.setBounds(100, 540, 200, 30);
		add(snrc);
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 120, 30);
		syes.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(syes);
		sno = new JRadioButton("NO");
	    sno.setBounds(450, 540, 120, 30);
	    sno.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(sno);
				
		ButtonGroup snrcgroup = new ButtonGroup(); // to select only one option from male or female
		snrcgroup.add(syes);
		snrcgroup.add(sno);
		
		
		JLabel eac =new JLabel("Existing Account :");
		eac.setFont(new Font ("Raleway", Font.BOLD, 20));
		eac.setBounds(100, 590, 200, 30);
		add(eac);
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 120, 30);
		eyes.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(eyes);
		eno = new JRadioButton("NO");
	    eno.setBounds(450, 590, 120, 30);
	    eno.setFont(new Font ("Raleway", Font.PLAIN, 18));
		add(eno);
				
		ButtonGroup eacgroup = new ButtonGroup(); // to select only one option from male or female
		eacgroup.add(eyes);
		eacgroup.add(eno);
		
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
		
		String sreligion = (String)religion.getSelectedItem();
		String scategory = (String)category.getSelectedItem();
		String sincome = (String)income.getSelectedItem();
		String seducation= (String)education.getSelectedItem();
		String soccupation = (String)occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (eno.isSelected()) {
			seniorcitizen = "No";
		}
		
		String existingaccount = null;
		if  (eyes.isSelected()) {
			existingaccount = "Married";
		} else if (eno.isSelected()) {
			existingaccount = "Unmarried";
		}
		
		String span = pan.getText();
		String saadhar = aadhar.getText();
				
		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {   //main method
		new SignupTwo("");    // object of main method
	}
}