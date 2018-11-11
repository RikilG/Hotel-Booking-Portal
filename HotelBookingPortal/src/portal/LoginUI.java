package portal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dbManagers.*;
import definitions.Customer;
import definitions.EnvironmentVariables;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginUI {
	
	private CustomerDbManager dbio = new CustomerDbManager(EnvironmentVariables.USER_DB_NAME);

	JFrame frame;
	private JTextField tfUsername;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // this is to test this class only.
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

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Online Hotel Booking Portal");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(12, 13, 858, 68);
		frame.getContentPane().add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 94, 858, 416);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblUsername.setBounds(238, 63, 161, 43);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(238, 119, 161, 43);
		panel.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(411, 70, 336, 35);
		panel.add(tfUsername);
		tfUsername.setColumns(20);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLoginOnClick();
			}
		});
		btnLogIn.setBounds(617, 174, 130, 43);
		panel.add(btnLogIn);
		
		JLabel lblReg = new JLabel("Do not have an account? ");
		lblReg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReg.setBounds(238, 288, 266, 35);
		panel.add(lblReg);
		
		JButton btnRegisterHere = new JButton("Register Here");
		btnRegisterHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegisterUI window = new RegisterUI();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		btnRegisterHere.setBounds(508, 288, 130, 35);
		panel.add(btnRegisterHere);
		
		JLabel ivLogin = new JLabel("");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		ivLogin.setIcon(new ImageIcon(imgLogin));
		ivLogin.setHorizontalAlignment(SwingConstants.CENTER);
		ivLogin.setBounds(74, 63, 152, 136);
		panel.add(ivLogin);
		
		tfPassword = new JPasswordField();
		tfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLoginOnClick();
			}
		});
		tfPassword.setBounds(411, 126, 336, 35);
		panel.add(tfPassword);
	}
	
	private void btnLoginOnClick() {
		if(dbio.checkDB(new Customer(tfUsername.getText().toLowerCase(),String.valueOf(tfPassword.getPassword()))) == 1) {
			CustomerDbManager dbio = new CustomerDbManager(EnvironmentVariables.USER_DB_NAME);
			portal.Main.signInStatus = 1;
			portal.Main.logInCustomer = dbio.getCustomerFromDB(new Customer(tfUsername.getText().toLowerCase(),String.valueOf(tfPassword.getPassword())));
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ProfileUI window = new ProfileUI("chennai",1);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			frame.dispose();
			//JOptionPane.showMessageDialog(null, "Login Successful.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
			tfUsername.setText("");
			tfPassword.setText("");
		}
	}
}
