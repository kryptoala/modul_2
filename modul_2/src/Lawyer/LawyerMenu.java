package Lawyer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Klasa odpowiadajaca za wyswietlanie graficznego interfejsu uzytkownika w menu dzielenia sekretu.
 */
public class LawyerMenu extends JFrame {

	final LawyerMenu f_menu = this;
	final LawyerConfig c_config = new LawyerConfig();
	final JButton 
			/**
			 * przycisk do spisywania testamentu
			 */
			b_share = new JButton(),
			/**
			 * przycisk do wysylania
			 */
			b_send = new JButton(),
			/**
			 * przycisk do wyjscia
			 */
			b_exit = new JButton();
	final JPanel p_panel1 = new JPanel(); //panel na przyciski
	final JPanel p_panel2 = new JPanel(); // panel na exit
	final JPanel p_panel3 = new JPanel(); // panel na na label
	final JLabel l_label = new JLabel(); // label na nazwe
	
	public LawyerMenu(){
		
super("Podzial sekretu");
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(LawyerConfig.MenuSize[0], LawyerConfig.MenuSize[1]);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		/* obrazki  na buttonach */
		try {
			Image img = ImageIO.read(getClass().getResource(LawyerConfig.MenuButtons[0]));
				b_share.setIcon(new ImageIcon(img));
			Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.MenuButtons[1]));
				b_send.setIcon(new ImageIcon(img1));
			Image img2 = ImageIO.read(getClass().getResource(LawyerConfig.MenuButtons[2]));
				b_exit.setIcon(new ImageIcon(img2));
		    Image img3 = ImageIO.read(getClass().getResource(LawyerConfig.MenuButtons[3]));
		    	l_label.setIcon(new ImageIcon(img3));
		  } catch (IOException ex) {
			  
		  }
		
		
		b_share.setBorder(new EmptyBorder(0,0,0,0));
		b_send.setBorder(new EmptyBorder(0,0,0,0));
		b_exit.setBorder(new EmptyBorder(0,0,0,0));
		l_label.setBorder(new EmptyBorder(0,0,0,0));
		
		p_panel1.setLayout(new FlowLayout());
		p_panel1.add(b_share);
		p_panel1.add(b_send);
		p_panel2.setLayout(new BorderLayout());
		p_panel2.add(b_exit, BorderLayout.EAST);
		p_panel3.setLayout(new FlowLayout());
		p_panel3.add(l_label);
		
		this.add(p_panel1,BorderLayout.CENTER);
		this.add(p_panel2,BorderLayout.SOUTH);
		this.add(p_panel3, BorderLayout.NORTH);
		
		this.pack();
		p_panel1.setBackground(Color.black);
		p_panel2.setBackground(Color.black);
		p_panel3.setBackground(Color.black);
		
		
		/*		Dzielenie testamentu		*/
		b_share.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LawyerConfig.sharer=true;
				new SecretSharingWindow();
				f_menu.dispose();
                
				
			}
		});
		
		/*	Wysylanie czesci sekretu */		
		
		b_send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LawyerConfig.sender = true;
				new SecretSendingWindow();
				f_menu.dispose();
                
	         
			} 
		}
		);
		
		
		/*		EXIT	*/	
		
		b_exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			
		});
		
	}
	

	/**
	 * G³ówna funkcja programu.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {	
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new LawyerMenu();
			}
		});
		TimeUnit.SECONDS.sleep(1);
	SwingUtilities.invokeLater(new Runnable() {
	public void run(){
			
		}
	
			
	});
	}
	
}
