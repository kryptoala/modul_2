package Lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Klasa odpowiadajaca za modul wysylania czesci sekretu.
 *
 */
public class SecretSendingWindow extends JFrame{

	/**
	 * Wskaznik na wyswietlana ramke.
	 */
	final public SecretSendingWindow f_secretSendingWindow = this;
	
	private JPanel 
	p_panel1 = new JPanel(), // panel do labeli
	p_panel2 = new JPanel(), // ogolny panel do przyciskow
	p_panel3 = new JPanel(), // panel do przyciskow
	p_panel4 = new JPanel(); // panel do TextFielda
	
	private JLabel 
	l_label = new JLabel(), // label gorny
	l_label1 = new JLabel(); // napis 
	
	private JButton
	b_send = new JButton(),
	b_back = new JButton(),
	b_exit = new JButton();
	
	private JTextArea
	t_textArea = new JTextArea(1,1);//wpisywanie emaili
	
	boolean sending = false; // czy sie wysyla
	
	static SendMailSSL sendMailSSL = new SendMailSSL();
	
	private JFrame f;

	
	final Thread animationThread = new Thread(new Runnable() {

		  public void run() {

				
		        URL url = getClass().getResource("wysylanie.gif");
				Icon icon = new ImageIcon(url);
		        JLabel label = new JLabel(icon);

		        f = new JFrame("Czekaj...");
		        f.getContentPane().add(label);
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.pack();
		        f.setLocationRelativeTo(null);
		        f.setVisible(true);

		  }
		});
	
	final Thread sendingThread = new Thread(new Runnable() {

		  public void run() {
			  String temp;
			  	for (int i = 0; i < LawyerConfig.NumberOfSharers; i++)
				{
					temp = "Czesc_nr_" + i +".txt"; 
					System.out.println("Mail " + (i+1) + ": " + LawyerConfig.MailingList.elementAt(i));
					sendMailSSL.sendEmail(LawyerConfig.MailingList.elementAt(i), "Masz (1) nowy spadek!",  "Witaj! Ktos z Twoich bliskich uczynil Cie jednym ze spadkobiercow swojego majatku. Aby odczytac testament, potrzebna jest okreslona liczba czesci sekretu. W zalaczniku znajduje sie Twoja czesc. Zachowaj ja w bezpiecznym miejscu az do momentu podzialu majatku i ujawnij dopiero na prosbe pelnomocnika osoby, ktora spisala testament!", "Twoja_czesc.txt", temp);
				}
				
				LawyerConfig.sent = true;
				
				if(LawyerConfig.sent)
				{
					f.setVisible(false);
					f.dispose();
					animationThread.interrupt();
				}
				
				repaintThread.start();
			
				f_secretSendingWindow.dispose();

		  }
		});
	
	final Thread repaintThread = new Thread(new Runnable() {
		 @SuppressWarnings("deprecation")
		public void run() {
			 	LawyerNotificationWindow lawyer = new LawyerNotificationWindow();
				lawyer.setVisible(false);
				lawyer.setVisible(true);
			 
	}});
	
	
	public SecretSendingWindow(){
		
		super("Rozsylanie czesci sekretu");
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(LawyerConfig.SecretSendingWindowSize[0], LawyerConfig.SecretSendingWindowSize[1]);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		try {
			if(LawyerConfig.last){
				
				Image img = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[4]));
				b_send.setIcon(new ImageIcon(img));
				
				Image img3 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[5]));
			    l_label1.setIcon(new ImageIcon(img3)); 
			}
			else{
				
				Image img = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[0]));
				b_send.setIcon(new ImageIcon(img));
				
				Image img3 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[3]));
			    l_label1.setIcon(new ImageIcon(img3)); 
			}
			
			
			Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[1]));
				b_exit.setIcon(new ImageIcon(img1));
		    Image img2 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[2]));
		    	l_label.setIcon(new ImageIcon(img2));
		    Image img4 = ImageIO.read(getClass().getResource(LawyerConfig.SecretSendingButtons[6]));
				b_back.setIcon(new ImageIcon(img4));
		     	
		  } catch (IOException ex) {
			  
		  }
		
		
		b_send.setBorder(new EmptyBorder(0,0,0,0));
		b_back.setBorder(new EmptyBorder(0,0,0,0));
		b_exit.setBorder(new EmptyBorder(0,0,0,0));
		l_label.setBorder(new EmptyBorder(0,0,0,0));
		l_label1.setBorder(new EmptyBorder(0,0,0,0));
		
		p_panel1.setLayout(new GridLayout(2,1));
		p_panel1.add(l_label);
		p_panel1.add(l_label1);
	

		p_panel2.setLayout(new BorderLayout());
		p_panel2.add(p_panel3, BorderLayout.EAST);
		
		p_panel3.setLayout(new BorderLayout());
		p_panel3.add(b_send,BorderLayout.NORTH);
		p_panel3.add(b_back,BorderLayout.CENTER);
		p_panel3.add(b_exit,BorderLayout.SOUTH);
		
        JPanel temp_panel1 = new JPanel();
        JPanel temp_panel2 = new JPanel();
        JLabel temp_label1 = new JLabel("xxx");
        JLabel temp_label2 = new JLabel("xxx");

        temp_label1.setForeground(Color.black);
        temp_label2.setForeground(Color.black);

        t_textArea.setPreferredSize(new Dimension(25,20));

        temp_panel1.setLayout(new BorderLayout());
        temp_panel1.setBackground(Color.black);
        temp_panel2.setLayout(new BorderLayout());
        temp_panel2.setBackground(Color.black);

        temp_panel1.add(temp_panel2, BorderLayout.NORTH);

        temp_panel2.add(temp_label1, BorderLayout.WEST);
        temp_panel2.add(t_textArea, BorderLayout.CENTER);
        temp_panel2.add(temp_label2, BorderLayout.EAST);


        p_panel4.setLayout(new GridLayout());
        p_panel4.add(temp_panel1);
        t_textArea.setLineWrap(true);

        this.add(p_panel1,BorderLayout.NORTH);
        this.add(p_panel4, BorderLayout.CENTER);
        this.add(p_panel2, BorderLayout.PAGE_END);

        p_panel1.setBackground(Color.black);
        p_panel2.setBackground(Color.black);
        p_panel3.setBackground(Color.black);
        p_panel4.setBackground(Color.black); 
		
		/*	end button */
		b_send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(LawyerConfig.last || LawyerConfig.NumberOfSharers == 1 )
				{
					LawyerConfig.MailingList.add(LawyerConfig.CurrentMail, t_textArea.getText());
					f_secretSendingWindow.setVisible(false);
					animationThread.start();
					sendingThread.start();
					LawyerConfig.success = true;
					/*
					if(LawyerConfig.sent)
						{
							LawyerConfig.success = true;
						}
						
					new LawyerNotificationWindow();
					
					f_secretSendingWindow.dispose();
					*/
					
				}
				else
				{
					LawyerConfig.MailingList.add(LawyerConfig.CurrentMail, t_textArea.getText());
					LawyerConfig.CurrentMail++;
					System.out.println("Current mail: " + LawyerConfig.CurrentMail);
					System.out.println("Number of sharers: " + LawyerConfig.NumberOfSharers);
					if(LawyerConfig.CurrentMail == (LawyerConfig.NumberOfSharers-1) )
					{
						LawyerConfig.last = true;
					}
					new SecretSendingWindow();
					f_secretSendingWindow.dispose();
					
				}
			}
			
		});
		
		
		/*	back button */
		b_back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LawyerConfig.sender = false;
				LawyerConfig.CurrentMail = 0;
				new LawyerMenu();
				f_secretSendingWindow.dispose();
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
	
	/**
	 * Metoda odpowiadajaca za wysylanie wiadomosci zawierajacych czesci testamentu do spadkobiercow.
	 */
	public void Send()
	{
		sending = true;
		String temp;
		for (int i = 0; i < LawyerConfig.NumberOfSharers; i++)
		{
			temp = "Czesc_nr_" + i +".txt"; 
			System.out.println("Mail " + (i+1) + ": " + LawyerConfig.MailingList.elementAt(i));
			sendMailSSL.sendEmail(LawyerConfig.MailingList.elementAt(i), "Masz (1) nowy spadek!",  "Witaj! Ktos z Twoich bliskich uczynil Cie jednym ze spadkobiercow swojego majatku. Aby odczytac testament, potrzebna jest okreslona liczba czesci sekretu. W zalaczniku znajduje sie Twoja czesc. Zachowaj ja w bezpiecznym miejscu az do momentu podzialu majatku i ujawnij dopiero na prosbe pelnomocnika osoby, ktora spisala testament!", "Twoja_czesc.txt", temp);
		}
		
		LawyerConfig.sent = true;
		sending = false;
	}
}
