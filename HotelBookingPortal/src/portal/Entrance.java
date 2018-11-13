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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToBirla = new JLabel("Welcome to BIRLA ONLINE HOTEL BOOKING PORTAL");
		lblWelcomeToBirla.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBirla.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeToBirla.setForeground(Color.BLUE);
		lblWelcomeToBirla.setBounds(10, 80, 522, 26);
		contentPane.add(lblWelcomeToBirla);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 574, 26);
		contentPane.add(panel);
		
		JTextPane txtpnWelcomeToAn = new JTextPane();
		String str = "";
		txtpnWelcomeToAn.setText("Welcome to modern era hotel booking portal which makes life easy.\n"+ str);
	
		txtpnWelcomeToAn.setBounds(31, 142, 244, 120);
		contentPane.add(txtpnWelcomeToAn);
	}
}
