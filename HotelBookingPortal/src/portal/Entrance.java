package portal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrance frame = new Entrance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entrance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setBounds(10, 54, 574, 26);
		contentPane.add(panel);
		
		JLabel lblWelcomeToBirla = new JLabel("Welcome to BIRLA ONLINE HOTEL BOOKING PORTAL");
		panel.add(lblWelcomeToBirla);
		lblWelcomeToBirla.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBirla.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeToBirla.setForeground(Color.BLUE);
		
		JTextPane txtpnWelcomeToAn = new JTextPane();
		txtpnWelcomeToAn.setBackground(new Color(255, 239, 213));
		txtpnWelcomeToAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		String str = "*Find Best Hotels of your choice that we provide";
		String str1 = "*Hotel Booking is completely free";
		String str2 = "*Terms and Conditions apply";
		txtpnWelcomeToAn.setEditable(false);
		
		JButton btnBookAHotel = new JButton("Book a Hotel");
		btnBookAHotel.setBackground(new Color(244, 164, 96));
		btnBookAHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginUI window = new LoginUI();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBookAHotel.setBounds(200, 299, 158, 23);
		contentPane.add(btnBookAHotel);
		txtpnWelcomeToAn.setText("*Welcome to modern era Online hotel booking portal which makes life easy\n"+ str+"\n"+str1+"\n"+str2);
	
		txtpnWelcomeToAn.setBounds(63, 114, 442, 91);
		contentPane.add(txtpnWelcomeToAn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Entrance.class.getResource("/hotelsDB/4.jpg")));
		lblNewLabel.setBounds(10, 91, 564, 459);
		contentPane.add(lblNewLabel);
	}
}
