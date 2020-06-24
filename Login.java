package bankaccount;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.Scanner;


import javax.swing.*;    
 
class MyException extends Exception {
	String umessage;
	public MyException() {
		
	}
	public String tousername() {
		umessage = "invalid number of characters";
		return "CustomException[ 1.8" + umessage + "]";
	   }
	
	 

	  
	}
class MyException2 extends Exception {
	String pmessage;
	public MyException2() {
		
	}
	
	public String topassword() {
		
		pmessage = "you do not meet the requirments for the password field";
		return "CustomException[ 1.9" + pmessage + "]";
	   }
	   

	 

	  
	}
public class Login{
	
	
	String password; // made these instance variables with no modifiers so they can be accessed by the class and classes of this package only 

	String username;
	private int count,count1, count2, count3,count4; 
	public Login() {
		
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
	}
	
	public String loginpass() throws MyException, MyException2{
		boolean access = false;
		String message = "You have created a username & password!";
		
		
		Scanner scan = new Scanner(System.in);
		
		
		while(access == false) {
		System.out.println("Enter in a Username between 10 and 5 characters");
		String user = scan.nextLine();
		if(user.length() > 10 || user.length() < 5) {
			throw new MyException();
		}
		else {
			access = true;
			username = user;
		}
		
		}
		access = false;
		
		while(access == false) {
		System.out.println("Enter in a Password completing the fields of"+"\r"+"7 characters" + "\r"+ "1 number" + "\r" + "1 upper case"+ "\r" + "1 lowercase");

		String pass = scan.nextLine();
		validpass(pass);
		if(count > 3) {
			
			access = true;
			password = pass;
		}
		else {

			throw new MyException2();
		}
		}
		return message;
		
	}
	private int validpass(String password) {
		if(password.length() >= 7) {
			count1 ++;
			
		}
		for(int i = 0; i < password.length(); i++ ) {
			char c = password.charAt(i);
			if(Character.isDigit(c)) {
				count2 ++;
			}
			if(count2 > 1) {
				break;
			}
			
			
		}
		for(int j =0; j< password.length(); j++ ) {
			char z = password.charAt(j);
			if(Character.isUpperCase(z)) {
				count3 ++;
			
			
		}
			if(count3 > 1) {
				break;
			}
		}
		for(int k =0; k< password.length(); k++ ) {
			char t = password.charAt(k);
			if(Character.isLowerCase(t)) {
				count4 ++;
			}
			if(count4 > 1) {
				break;
			}
			
		}
		count = count1+count2+count3+count4;
		
		return count;
		
		
	}
	
	public void login() {
		boolean access = false;
		int tries = 0 ;
		while(access == false && tries < 3) {
		System.out.println("Enter your username :" );
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		if(answer.equals(username)) {
			System.out.println("Enter your password :" );
			String s = scan.nextLine();
			if(s.equals(password)) {
				access = true;
			}
			else {
				System.out.println("Incorrect username or password" );
				tries ++;
				
			}
		}
		else {
			System.out.println("Incorrect username or password" );
			tries ++;
			
		}
		}
		if(tries >= 3 ) {
			System.out.println("Acess Denied" );
		    System.exit(0);

		}
		 JFrame Loginframe = new JFrame("Login iBanking");
		 JLabel user = new JLabel("UserName: ");
		 JTextField uss =  new JTextField(30);
		 
		 
		 user.setLabelFor(uss);
		 
		 
		 JLabel password = new JLabel("Password: ");
		 JPasswordField Passwordd = new JPasswordField(30);
	     password.setLabelFor(Passwordd);
	     
	     
	     JButton displaypass = new JButton("Display Password");
	     JButton login = new JButton("Login ");
	     
	     
	     displaypass.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent a) {
	    		 String password = new String(Passwordd.getPassword());
	    		 JOptionPane.showMessageDialog(Loginframe,"Password is " + password);
	    		 }
	     });
	    	 login.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent a) {
		    		 JOptionPane.showMessageDialog(Loginframe,"You have succefully logged in");
		    		 SecondFrame();
		    		 }

				private void SecondFrame() {
					JFrame f = new JFrame("Logged in");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(300,300);
					f.setVisible(true);
							
						
				}
	    	 
	});


	     
	        JPanel panel = new JPanel();
	        
	        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	       
	 
	        panel.add(user);
	        panel.add(uss);
	        panel.add(password);
	        panel.add(Passwordd);
	        
	        panel.add(displaypass);
	        panel.add(login);
	        
	        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	       
	 
	        Loginframe.setSize(300, 120);
	        Loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Loginframe.getContentPane().add(panel);
	        Loginframe.setVisible(true);
	    }
	
	
}
	
		
	
	
	

