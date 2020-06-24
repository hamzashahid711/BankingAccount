package bankaccount;
import java.io.*; 

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Files extends Login{

	private String s;
	
	
	
	public Files() {
		super();
		s ="infoholder.txt"; 
		
	}
	public void openfiles() throws Exception {
		try {
			System.out.println(super.loginpass());
			}
			catch(MyException e) {
				System.out.println(e);
			    System.exit(0);

			}
			catch(MyException2 z) {
				System.out.println(z);
			    System.exit(0);

			
			}
		super.login();
		try {
			
			
		      File file = new File(s);
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try {
			
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(s, true)));

		    out.println(super.password);
		    out.println(super.username);
		    encrypt();
		    out.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		   
		}
		 try { 
	            BufferedReader in = new BufferedReader( 
	                        new FileReader(s)); 
	  
	            String mystring; 
	            while ((mystring = in.readLine()) != null) { 
	                System.out.println(mystring); 
	            } 
	        } 
	        catch (IOException e) { 
	            System.out.println("Exception Occurred" + e); 
	            e.printStackTrace();
	        } 
	    }
	
	 public void encrypt() throws Exception 
	    {
		 String strKey = "tsar12345tsar12345"; 
		 
		 String strData = "";
		 try {
				Login z = new Files();

				SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
				Cipher cipher=Cipher.getInstance("Blowfish");
				cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
				byte[] encrypted=cipher.doFinal(super.username.getBytes());
				byte[] encrypte=cipher.doFinal(super.password.getBytes());

				strData=new String(encrypted);
				strData=new String(encrypte);
				PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(s, true)));
				write.println(encrypted);
				write.println(encrypte);
				write.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e);
			}
//stole most of this code to encrypt the username and password I am writing to the file^^^^^^
	    }
	
	
	
}
