package portal;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterUI {

	JFrame frame;
	private JTextField tfName;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfConfirmPassword;
	private JTextField tfEmailId;
	private JTextField tfDobDate;
	private JTextField tfDobMonth;
	private JTextField tfDobYear;
	private JTextField tfVerifyQ;
	private JTextField tfVerifyAns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public RegisterUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setBackground(new Color(255, 200, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblRegister = new JLabel(" One   Step   to   Create   your  Account    :");
		lblRegister.setBounds(12, 30, 411, 45);
		lblRegister.setIcon(null);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(lblRegister);
		
		JLabel lblName = new JLabel("Name                       :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBackground(Color.LIGHT_GRAY);
		lblName.setBounds(40, 129, 136, 14);
		frame.getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(186, 127, 280, 23);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username                :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(40, 217, 136, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblSetPassword = new JLabel("Set Password           :");
		lblSetPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetPassword.setBounds(40, 253, 136, 14);
		frame.getContentPane().add(lblSetPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password    :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(40, 289, 136, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEmailId = new JLabel("Email Id                    :");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setBounds(40, 336, 136, 14);
		frame.getContentPane().add(lblEmailId);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(186, 215, 280, 23);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(186, 251, 280, 23);
		frame.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
		
		tfConfirmPassword = new JTextField();
		tfConfirmPassword.setBounds(186, 288, 280, 23);
		frame.getContentPane().add(tfConfirmPassword);
		tfConfirmPassword.setColumns(10);
		
		tfEmailId = new JTextField();
		tfEmailId.setBounds(186, 333, 280, 23);
		frame.getContentPane().add(tfEmailId);
		tfEmailId.setColumns(10);
		
		JLabel lblResedentialAdress = new JLabel("Resedential  Adress  :");
		lblResedentialAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResedentialAdress.setBounds(40, 397, 136, 14);
		frame.getContentPane().add(lblResedentialAdress);
		
		JTextArea taAddress = new JTextArea();
		taAddress.setBounds(186, 381, 280, 53);
		frame.getContentPane().add(taAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth            :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(40, 165, 136, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		tfDobDate = new JTextField();
		tfDobDate.setToolTipText("DD");
		tfDobDate.setBounds(184, 163, 35, 20);
		frame.getContentPane().add(tfDobDate);
		tfDobDate.setColumns(10);
		
		tfDobMonth = new JTextField();
		tfDobMonth.setToolTipText("MM");
		tfDobMonth.setBounds(245, 163, 35, 20);
		frame.getContentPane().add(tfDobMonth);
		tfDobMonth.setColumns(10);
		
		tfDobYear = new JTextField();
		tfDobYear.setToolTipText("YY");
		tfDobYear.setBounds(306, 163, 46, 20);
		frame.getContentPane().add(tfDobYear);
		tfDobYear.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(186, 188, 39, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(245, 188, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(316, 188, 35, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblEnterYourPersonal = new JLabel("Enter your Personal Details Here.  (NOTE : These details are only for verification purpose only)");
		lblEnterYourPersonal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterYourPersonal.setBounds(12, 88, 541, 14);
		frame.getContentPane().add(lblEnterYourPersonal);
		
		JButton btnConfirm = new JButton("Confirm ");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmOnClick();
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirm.setBounds(245, 551, 101, 29);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblIAmNot = new JLabel("I am not a Robot :");
		lblIAmNot.setBounds(65, 467, 111, 31);
		frame.getContentPane().add(lblIAmNot);
		
		JCheckBox chckbxVerify = new JCheckBox("Verify");
		chckbxVerify.setBounds(184, 471, 97, 23);
		frame.getContentPane().add(chckbxVerify);
		
		tfVerifyQ = new JTextField();
		tfVerifyQ.setBounds(313, 445, 86, 23);
		frame.getContentPane().add(tfVerifyQ);
		tfVerifyQ.setColumns(10);
		
		tfVerifyAns = new JTextField();
		tfVerifyAns.setBounds(313, 478, 86, 23);
		frame.getContentPane().add(tfVerifyAns);
		tfVerifyAns.setColumns(10);
		
		JLabel label = new JLabel(" /");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(224, 165, 17, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" /");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(285, 165, 17, 16);
		frame.getContentPane().add(label_1);
		
		JCheckBox chckbxAgreeTnC = new JCheckBox("I agree to the Terms and conditions of using this software.");
		chckbxAgreeTnC.setBounds(106, 517, 373, 25);
		frame.getContentPane().add(chckbxAgreeTnC);
		
		JButton btnGoBack = new JButton("Click Here to go back to login page");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
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
		btnGoBack.setBounds(5, 5, 275, 27);
		Image imgBack = new ImageIcon(this.getClass().getResource("/back.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		btnGoBack.setIcon(new ImageIcon(imgBack));
		frame.getContentPane().add(btnGoBack);
	}
	
	void btnConfirmOnClick() {
		// check strings and write to database.
	}

}
