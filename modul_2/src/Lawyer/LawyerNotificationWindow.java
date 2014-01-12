package Lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Klasa odpowiadajaca za okna powiadomien wyswietlane w module do podzialu sekretu.
 *
 */
public class LawyerNotificationWindow extends JFrame {
	
	final LawyerNotificationWindow f_lawyerNotificationWindow = this;
	
	private JPanel 
	p_panel = new JPanel(),
	p_panel1 = new JPanel();
	
	private JLabel l_label = new JLabel();
	
	private JButton b_exit = new JButton();

	
	public LawyerNotificationWindow(){
		
		super("Powiadomienie");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(LawyerConfig.NotificationSize[0],LawyerConfig.NotificationSize[1]);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		try {
			Image img = ImageIO.read(getClass().getResource("mini_powrot.png"));
				b_exit.setIcon(new ImageIcon(img));
		} catch (IOException ex) {}
		
		
		if(!LawyerConfig.success)
		{
			if(LawyerConfig.sharer)
			{
			try {
				Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SharerNotifications[0]));
				l_label.setIcon(new ImageIcon(img1));
				} catch (IOException ex) {}
			}
			
			if(LawyerConfig.sender)
			{
				try {
					Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SenderNotifications[0]));
					l_label.setIcon(new ImageIcon(img1));
					} catch (IOException ex) {}
				
			}		
		}
		
		if(LawyerConfig.success)
		{
			if(LawyerConfig.sharer)
			{
			try {
				Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SharerNotifications[1]));
				l_label.setIcon(new ImageIcon(img1));
				} catch (IOException ex) {}
			}
			
			if(LawyerConfig.sender)
			{
				try {
					Image img1 = ImageIO.read(getClass().getResource(LawyerConfig.SenderNotifications[1]));
					l_label.setIcon(new ImageIcon(img1));
					} catch (IOException ex) {}
				
			}
		}
		
		b_exit.setBorder(new EmptyBorder(0,0,0,0));
		l_label.setBorder(new EmptyBorder(0,0,0,0));
		
		p_panel.setLayout(new BorderLayout());
		p_panel.add(l_label, BorderLayout.CENTER);
		
		p_panel1.setLayout(new BorderLayout());
		p_panel1.add(b_exit, BorderLayout.EAST);
		
		this.add(p_panel, BorderLayout.CENTER);
		this.add(p_panel1, BorderLayout.SOUTH);
		
		p_panel.setBackground(Color.black);
		p_panel1.setBackground(Color.black);
		
		b_exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(LawyerConfig.success)
				{					
					LawyerConfig.sharer = false;
					LawyerConfig.sender = false;
					LawyerConfig.success = false;
					
					LawyerMenu lawyerMenu = new LawyerMenu();
					lawyerMenu.setLocationRelativeTo(null);
					lawyerMenu.setResizable(false);
					lawyerMenu.setVisible(true);
					f_lawyerNotificationWindow.dispose();
				}
				else
				{
					
					if(LawyerConfig.sharer)
					{
						new SecretSharingWindow();
						f_lawyerNotificationWindow.dispose();
					}
					
					if(LawyerConfig.sender)
					{
						new SecretSendingWindow();
						f_lawyerNotificationWindow.dispose();
					}
					
				}
				
			}
			
		});
	}
}
