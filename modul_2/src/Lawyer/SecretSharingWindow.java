package Lawyer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Klasa odpowiadajaca za modul sluzacy do dzielenia sekretu na czesci.
 *
 */
public class SecretSharingWindow extends JFrame {

/**
 * Wskaznik na wyswietlana ranmke.
 */
final SecretSharingWindow f_secretSharingWindow = this;
	
	
	private JPanel 
		p_panel1 = new JPanel(), // panel do labeli
		p_panel2 = new JPanel(), // ogolny panel do przyciskow
		p_panel3 = new JPanel(), // panel do przyciskow
		p_panel4 = new JPanel(); // panel do TextFielda
	
	private JLabel 
		l_label = new JLabel(), // label gorny
		l_label1 = new JLabel(), // napis pierwszy
		l_label2 = new JLabel(), // wpisz calk. liczbe spadkobiercow
		l_label3 = new JLabel(); // wpisz liczbe potrzeb. spadkobier.
		
	private JButton
		b_share = new JButton(),
		b_back = new JButton(),
		b_exit = new JButton();
	
	private JTextArea
		t_textArea = new JTextArea(), // cos 
		t_textArea1 = new JTextArea();
	
	 protected BigInteger prime;	// liczba pierwsza
	 
	 protected BigInteger[] coefficients; // wspolczynniki
	 
	 protected BigInteger message; // liczba, która otrzymalismy
	 
	 protected BigInteger[] BImessage; // zakodowany testament w BI
	
	
public SecretSharingWindow(){
		
		super("Dzielenie sekretu");
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(LawyerConfig.SecretSharingWindowSize[0], LawyerConfig.SecretSharingWindowSize[1]);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		try {
			Image img = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[0]));
				b_share.setIcon(new ImageIcon(img));
			Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[1]));
				b_back.setIcon(new ImageIcon(img1));
			Image img2 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[2]));
				b_exit.setIcon(new ImageIcon(img2));
		    Image img3 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[3]));
		    	l_label.setIcon(new ImageIcon(img3));
		    Image img4 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[4]));
		    	l_label1.setIcon(new ImageIcon(img4));
		    Image img5 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[5]));
			    l_label2.setIcon(new ImageIcon(img5));
			Image img6 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSharingButtons[6]));
			    l_label3.setIcon(new ImageIcon(img6));  	    	
		  } catch (IOException ex) {
			  
		  }
		
		
		b_share.setBorder(new EmptyBorder(0,0,0,0));
		b_back.setBorder(new EmptyBorder(0,0,0,0));
		b_exit.setBorder(new EmptyBorder(0,0,0,0));
		l_label.setBorder(new EmptyBorder(0,0,0,0));
		l_label1.setBorder(new EmptyBorder(0,0,0,0));
		l_label2.setBorder(new EmptyBorder(0,0,0,0));
		l_label3.setBorder(new EmptyBorder(0,0,0,0));
		
		p_panel1.setLayout(new GridLayout(2,1));
		p_panel1.add(l_label);
		p_panel1.add(l_label1);
		
		p_panel2.setLayout(new BorderLayout());
		p_panel2.add(p_panel3, BorderLayout.EAST);
		
		p_panel3.setLayout(new BorderLayout());
		p_panel3.add(b_share,BorderLayout.NORTH);
		p_panel3.add(b_back,BorderLayout.CENTER);
		p_panel3.add(b_exit,BorderLayout.SOUTH);
		
		JPanel temp_panel1 = new JPanel();
		JPanel temp_panel2 = new JPanel();
		JPanel temp_panel3 = new JPanel();
		JPanel temp_panel3a = new JPanel();
		JPanel temp_panel4 = new JPanel();
		JPanel temp_panel4a = new JPanel(); 
		JLabel temp_label1 = new JLabel("xxx");
		JLabel temp_label2 = new JLabel("xxx");
		temp_label1.setForeground(Color.black);
		temp_label2.setForeground(Color.black); 
		t_textArea.setPreferredSize(new Dimension(25,20));
		t_textArea1.setPreferredSize(new Dimension(25,20));
		temp_panel1.setLayout(new BorderLayout()); 
		temp_panel2.setLayout(new BorderLayout()); 
		temp_panel3.setLayout(new BorderLayout()); 
		temp_panel3a.setLayout(new BorderLayout());
		temp_panel4.setLayout(new BorderLayout());
		temp_panel4a.setLayout(new BorderLayout());
		temp_panel1.setBackground(Color.black); 
		temp_panel2.setBackground(Color.black);
		temp_panel3.setBackground(Color.black); 
		temp_panel3a.setBackground(Color.black); 
		temp_panel4.setBackground(Color.black); 
		temp_panel4a.setBackground(Color.black);
		temp_panel1.add(temp_panel3, BorderLayout.NORTH); 
		temp_panel3.add(temp_label1, BorderLayout.WEST); 
		temp_panel3.add(temp_panel3a, BorderLayout.CENTER); 
		temp_panel3a.add(t_textArea, BorderLayout.WEST); 
		temp_panel2.add(temp_panel4, BorderLayout.NORTH); 
		temp_panel4.add(temp_label2, BorderLayout.WEST); 
		temp_panel4.add(temp_panel4a, BorderLayout.CENTER);
		temp_panel4a.add(t_textArea1, BorderLayout.WEST); 
		p_panel4.setLayout(new GridLayout(4,1));
		p_panel4.add(l_label2); p_panel4.add(temp_panel1); 
		p_panel4.add(l_label3); p_panel4.add(temp_panel2);
		
		this.add(p_panel1,BorderLayout.NORTH);
		this.add(p_panel4, BorderLayout.CENTER);
		this.add(p_panel2, BorderLayout.PAGE_END);
		
		p_panel1.setBackground(Color.black);
		p_panel2.setBackground(Color.black);
		p_panel3.setBackground(Color.black);
		p_panel4.setBackground(Color.black);
		
		
		/*	share button */
		b_share.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Share();
				
				if(LawyerConfig.shared)
				{
					LawyerConfig.success = true;
				}
				
				new LawyerNotificationWindow();
				
				f_secretSharingWindow.dispose();
	
			}
			
		});
		
		
		/*	back button */
		b_back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LawyerConfig.sharer = false;
				new LawyerMenu();
				f_secretSharingWindow.dispose();
			}
			
		});
		
		
		
		/*	exit button  */
		b_exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			
		});
	}

	
	
	  void generatePolynom(int power) {
	        /* Generate Polynom modulo prime */
		  	prime = BigInteger.probablePrime(512 , new Random());
		  	//prime = new BigInteger("877");
		  	System.out.println("**prime******** = " + prime + " power = " + power);
		  	coefficients = new BigInteger[power]; //macierz wspolczynnikow
	        coefficients[0] = message;
	        Random rnd = new Random();
	        for (int i = 1; i < power; i++) {
	        	//coefficients[i] = BigInteger.valueOf((int)(Math.random()*2000));
	        	coefficients[i] = BigInteger.probablePrime(prime.bitLength(), rnd);
	            coefficients[i] = coefficients[i].mod(prime);
	            System.out.println("wspolczynnik[" + i + "] = " + coefficients[i]);
	        }
	    }
	  
	  BigInteger getPolynomValue(BigInteger arg) {
	        BigInteger value = BigInteger.valueOf(0);
	        value = value.add(message);
	        for (int i = 1; i < coefficients.length; i++) {
	            BigInteger k = arg.pow(i).mod(prime);
	           // System.out.println("k1 = "+ k);
	            k = k.multiply(coefficients[i]);
	         //   System.out.println("k2 = "+ k);
	            k = k.mod(prime);
	        //    System.out.println("k3 = "+ k);
	            value = (value.add(k)).mod(prime);
	           // System.out.println("value = "+ value);
	        }
	        
	        value = value.mod(prime);
	        //System.out.println("arg = "+ arg + " finalvalue = "  + value );
	        return value;
	    }
	
	  /**
	  * Metoda odpowiadajaca za dzielenie sekretu na czesci.
	  */
	  public void Share()
		{
			LawyerConfig.NumberOfSharers = new Integer (t_textArea.getText());
			LawyerConfig.NumberOfSharersNeeded = new Integer (t_textArea1.getText());
			
			
		if (LawyerConfig.NumberOfSharersNeeded <= LawyerConfig.NumberOfSharers)
		{
			read_file(LawyerConfig.TestamentFilepath);
			
			// generowanie tylu tablic stringow ilu sharerow z podzielonym testamentem

			for(int i = 0; i < LawyerConfig.NumberOfSharers; i++)
			{
				LawyerConfig.SharersList.add(i, new String[BImessage.length]);
			}
			
		
			
			BigInteger[] shares = new BigInteger[LawyerConfig.NumberOfSharers];
		
			// tablica z intami od 1 do n
			BigInteger[] number = new BigInteger[LawyerConfig.NumberOfSharers];
			
			// uzupelnianie tablicy intow wyznaczajacych osoby; od 1 do n, gdzie n to liczba potrzebnych
			for (int i = 0; i < number.length; i++)
			{
				//number[i] = BigInteger.valueOf(i+1);
			//	number[i] = BigInteger.valueOf((int)((i+1)*2));
				number[i] = BigInteger.valueOf((int)(Math.random()*2000000000));
				System.out.print(" number["+i+"] = " +number[i]);
			}
			System.out.println();
			/*
			
			for (int i = 0; i< coefficients.length; i ++)
			{
				System.out.print(" " + coefficients[i]);
			}
			*/
			


			
			generatePolynom(LawyerConfig.NumberOfSharersNeeded);
			for(int i = 0; i < BImessage.length; i++)
			{
				message = BImessage[i];
				System.out.println("message = " + message);
		     for (int j = 0; j < shares.length; j++) {
		            shares[j] = getPolynomValue(number[j]);
		      }
		     for (int l = 0; l < LawyerConfig.NumberOfSharers ; l++)
		     {
		     LawyerConfig.SharersList.get(l)[i] = shares[l].toString(16);
		  //   System.out.println("LawyerConfig.SharersList.get(" + l + ")[" + i + "] = " +  LawyerConfig.SharersList.get(l)[i] );
		     }
		     
		     // 	wypisywanie otrzymanych wartosci
	        for (int k = 0; k< shares.length; k++)
			{
			//System.out.println("shares[" + (k+1) + "] = "+ shares[k]);
			}
		     
			}

			

			for (int i = 0; i< LawyerConfig.NumberOfSharers; i++){
			write_file(LawyerConfig.SharersFilepath[0]+i+LawyerConfig.SharersFilepath[1], LawyerConfig.SharersList.get(i), number[i].toString());
			}
			LawyerConfig.shared = true;
			System.out.println("Prime = " + prime);
		}
		else
		{
			LawyerConfig.shared = false;
		}
	}
	
	  
	  void write_file(String filepath, String[] Array, String current_sharer){
		  
		  DataOutputStream outWriter = null;
	
		  try{
		outWriter = new DataOutputStream(new FileOutputStream(new File(filepath)));	  
		outWriter.write((new String()).getBytes());
		 outWriter.writeBytes(LawyerConfig.NumberOfSharersNeeded + "number" +  current_sharer + "current" + prime.toString(16) + "prime");
		 
		  for (int i = 0; i < Array.length; i++) {
			  outWriter.writeBytes(Array[i]+ " "); 
		  	}
		 
		  outWriter.flush();  
		 outWriter.close(); 
		  }
		  catch(IOException Argument){}
		}
	 void read_file(String filepath){
		
		 try 
			{
			     String s_line = "";
			     
				 FileReader fr_file = new FileReader(filepath);
			     BufferedReader brBuffer = new BufferedReader(fr_file);
			     
			     try 
			     {
			         while((s_line = brBuffer.readLine()) != null)
			         {
			        		        	 
			            String[] s_break = s_line.split(" ");
			            
			            
			        	 BImessage = new BigInteger[s_break.length];
			        	 
			        	 
			        	 int s = 0;
			        	 BigInteger b;
			        	 try {
			        		 for (int i = 0; i< s_break.length; i++)
			        		 	{
						        		 b = new BigInteger(s_break[s],16);
						        		 BImessage[i] = b;
						        		 s++;
						        	 
			        		 	}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			          
			         }
			     
			     } catch (IOException Argument) 
			     {

			     }
			} catch (FileNotFoundException Argument) 
			{
				
			
		}
	 }
}
