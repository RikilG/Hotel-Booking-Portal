package portal;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dbManagers.CustomerDbManager;
import definitions.Customer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPasswordField;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.*;
import javax.swing.SwingConstants;

public class RegisterUI {

	private static final int CENTRE = 0;
	JFrame frame;
	private JTextField tfName;
	private JTextField tfUsername;
	private JTextField tfEmailId;
	private JTextField tfVerifyAns;
	private JTextField txtMobile;
	private JTextArea taAddress;
	private final Action action = new SwingAction();
	private JPasswordField setpasswordField;
	private JPasswordField confirmpasswordField;

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
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 600, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().setBackground(new Color(255, 200, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblRegister = new JLabel(" One   Step   to   Create   your  Account    :");
		lblRegister.setBounds(12, 30, 411, 45);
		lblRegister.setIcon(null);
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(lblRegister);
		
		JLabel lblName = new JLabel("Name                       :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBackground(Color.LIGHT_GRAY);
		lblName.setBounds(40, 129, 136, 14);
		frame.getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setBackground(new Color(250, 250, 210));
		tfName.setBounds(186, 127, 280, 23);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username                :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(40, 201, 136, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblSetPassword = new JLabel("Set Password           :");
		lblSetPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetPassword.setBounds(40, 237, 136, 14);
		frame.getContentPane().add(lblSetPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password    :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(40, 272, 136, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEmailId = new JLabel("Email Id                    :");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setBounds(40, 313, 136, 14);
		frame.getContentPane().add(lblEmailId);
		
		tfUsername = new JTextField();
		tfUsername.setBackground(new Color(250, 250, 210));
		tfUsername.setBounds(186, 199, 280, 23);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfEmailId = new JTextField();
		tfEmailId.setBackground(new Color(250, 250, 210));
		tfEmailId.setBounds(186, 311, 280, 23);
		frame.getContentPane().add(tfEmailId);
		tfEmailId.setColumns(10);
		
		JLabel lblResedentialAdress = new JLabel("Residential  Address :\r\n ");
		lblResedentialAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResedentialAdress.setBounds(40, 406, 136, 50);
		frame.getContentPane().add(lblResedentialAdress);
		
		taAddress = new JTextArea();
		taAddress.setBackground(new Color(250, 250, 210));
		taAddress.setBounds(186, 403, 280, 53);
		frame.getContentPane().add(taAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth            :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(40, 165, 136, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		setpasswordField = new JPasswordField();
		setpasswordField.setBackground(new Color(250, 250, 210));
		setpasswordField.setBounds(186, 236, 280, 20);
		frame.getContentPane().add(setpasswordField);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBackground(new Color(250, 250, 210));
		confirmpasswordField.setBounds(186, 271, 280, 20);
		frame.getContentPane().add(confirmpasswordField);
		
		JLabel lblEnterYourPersonal = new JLabel("Enter your Personal Details Here.  (NOTE : These details are only for verification purpose only)");
		lblEnterYourPersonal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterYourPersonal.setBounds(12, 88, 541, 14);
		frame.getContentPane().add(lblEnterYourPersonal);
		
		JLabel lblIAmNot = new JLabel("I am not a Robot :");
		lblIAmNot.setBounds(65, 467, 111, 31);
		frame.getContentPane().add(lblIAmNot);
		
		tfVerifyAns = new JTextField();
		tfVerifyAns.setBackground(new Color(250, 250, 210));
		tfVerifyAns.setBounds(255, 467, 86, 23);
		frame.getContentPane().add(tfVerifyAns);
		tfVerifyAns.setColumns(10);
		
		JCheckBox chckbxAgreeTnC = new JCheckBox("I agree to the Terms and conditions of using this software.");
		chckbxAgreeTnC.setForeground(new Color(102, 0, 0));
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
		
		JList list_1 = new JList();
		list_1.setBounds(422, 187, 1, 1);
		frame.getContentPane().add(list_1);
		
		JLabel lblText = new JLabel("");
		lblText.setBounds(186, 467, 59, 23);
		frame.getContentPane().add(lblText);
		
		generateRandom(lblText);
		
		JCheckBox chckbxVerify = new JCheckBox("Verify");
		chckbxVerify.setBounds(186, 491, 83, 23);
		frame.getContentPane().add(chckbxVerify);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateRandom(lblText);
				chckbxVerify.setSelected(false);
				
			}
		});
		
		JLabel lblverify = new JLabel("");
		lblverify.setHorizontalAlignment(SwingConstants.CENTER);
		lblverify.setBounds(255, 496, 319, 14);
		frame.getContentPane().add(lblverify);
		chckbxAgreeTnC.setEnabled(false);
		chckbxVerify.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					if(!lblText.getText().equals(tfVerifyAns.getText())) {
						lblverify.setText("make sure you enter text correctly.\nplease try again");
						lblverify.setForeground(Color.red);
					}
					else {
						lblverify.setText("matching sequence");
						lblverify.setForeground(Color.GREEN);
					}
				}
				if(lblverify.getText()=="matching sequence") {
					chckbxAgreeTnC.setEnabled(true);
				}
				else {
					chckbxAgreeTnC.setEnabled(false);
				}
			}           
	      });
		
		chckbxAgreeTnC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					btnConfirmOnClick();
				}
			}           
	      });
		
		Image refresh = new ImageIcon(this.getClass().getResource("/hotelsDB/refresh.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		btnNewButton.setIcon(new ImageIcon(refresh));
		
		btnNewButton.setBounds(351, 467, 34, 23);
		frame.getContentPane().add(btnNewButton);
		
		JCalendar j=new JCalendar();
//		lblDateOfBirth.add(j);
//		Date d=new Date();
//		j.setDate(11);
//		d.setMonth(11);
//		d.setYear(1999);
//		Date d1=new Date();
//		d1.setDate(11);
//		d1.setMonth(11);
//		d1.setYear(1909);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(250, 250, 210));
		dateChooser.setDateFormatString("d MMM yyyy");
		dateChooser.setForeground(Color.BLACK);
		dateChooser.setToolTipText("");
		dateChooser.setBounds(186, 161, 280, 20);
		frame.getContentPane().add(dateChooser);
//		//dateChooser.setSelectableDateRange(d,d1);
//		//dateChooser.setMaxSelectableDate(d);
//		//dateChooser.setMinSelectableDate(d1);
		
		Calendar cal=Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR)-17,cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		Date d1=cal.getTime();
		try {
			dateChooser.setMaxSelectableDate(d1);
		}
		catch(Exception e) {
			
		}
		
		Calendar cal1=Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR)-90,cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		Date d2=cal.getTime();
		try {
			dateChooser.setMinSelectableDate(d2);
		}
		catch(Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}
		
		JLabel lblMobileNumber = new JLabel("Mobile Number         :");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNumber.setBounds(40, 352, 136, 23);
		frame.getContentPane().add(lblMobileNumber);
		
		txtMobile = new JTextField();
		txtMobile.setBackground(new Color(250, 250, 210));
		txtMobile.setBounds(186, 355, 280, 20);
		frame.getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
//		JLabel lblValidate = new JLabel("validate");
//		lblValidate.setHorizontalAlignment(SwingConstants.CENTER);
//		lblValidate.setBounds(12, 259, 562, 14);
//		frame.getContentPane().add(lblValidate);
//		
//		String password = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
//		Pattern pattern3 = Pattern.compile(password);
//		Matcher mtch3 = pattern3.matcher(setpasswordField.getText());
//		lblValidate.setEnabled(false);
//		if(!mtch3.matches()) {
//			lblValidate.setEnabled(true);
//			lblValidate.setText("password created must contain atleast one uppercase letter,one lowercase letter,one special character and a number and also length of minimum 6 letters");
//			lblValidate.setForeground(Color.RED);
//		}
		
		JButton btnConfirm = new JButton("Confirm ");
		btnConfirm.setEnabled(false);
		chckbxAgreeTnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAgreeTnC.isSelected()) {
				btnConfirm.setEnabled(true);
				}
				else {
					btnConfirm.setEnabled(false);
				}
			}
		});
		chckbxAgreeTnC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					btnConfirmOnClick();
				}
			}           
	      });
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "^[a-zA-Z ]{1,20}$";
				Pattern pattern1 = Pattern.compile(name);
				Matcher mtch1 = pattern1.matcher(tfName.getText());
				if(!mtch1.matches()) {
					JOptionPane.showMessageDialog(null,"name should consist of only alphabets");
				}
				String emailPattern = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}\\.[a-zA-Z\\-\\.]{2,30}$";
				//String emailPattern = "\\b[a-zA-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{20}\\b";
				Pattern pattern = Pattern.compile(emailPattern);
				Matcher mtch4 = pattern.matcher(tfEmailId.getText());
				if(!mtch4.matches()) {
					JOptionPane.showMessageDialog(null,"Email format is not correct.\n Email format example: abc@domain.com");
				}
				String mobilePattern = "^[0-9]{1}[0-9]{9}$";
				 pattern = Pattern.compile(mobilePattern);
				 Matcher mtch5 = pattern.matcher(txtMobile.getText());
				if(!mtch5.matches()) {
					JOptionPane.showMessageDialog(null,"Invalid Mobile Number");
				}
				String userName = "^[a-zA-Z0-9!@#%&-_]{1,20}$";
				Pattern pattern2 = Pattern.compile(userName);
				Matcher mtch2 = pattern2.matcher(tfUsername.getText());
				if(!mtch2.matches()) {
					JOptionPane.showMessageDialog(null,"not valid username");
				}
				String password = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				Pattern pattern3 = Pattern.compile(password);
				Matcher mtch3 = pattern3.matcher(String.valueOf(setpasswordField.getPassword()));
				if(!mtch3.matches()) {
					JOptionPane.showMessageDialog(null,"password created must contain atleast one uppercase letter,one lowercase letter,one special character and a number and also length of minimum 6 letters");
				}
				String one = String.valueOf(setpasswordField.getPassword());
				String two = String.valueOf(confirmpasswordField.getPassword());
				if(!one.equals(two)) {
					JOptionPane.showMessageDialog(null,"passwords do not match.\n please enter same passwords");
				}
				if(mtch1.matches() && mtch4.matches() && mtch5.matches() && mtch2.matches() && mtch3.matches() && one.equals(two)) {
					CustomerDbManager cdb = new CustomerDbManager();
					if(cdb.usernameAvailable(tfUsername.getText().toLowerCase().trim())) {
						JOptionPane.showMessageDialog(null, "Registered Successfully.\n Login to Continue");
						CustomerDbManager dbio = new CustomerDbManager();
						String dob = DateFormat.getDateInstance().format(dateChooser.getDate());
						Customer c = new Customer("0", tfUsername.getText().toLowerCase().trim(), String.valueOf(setpasswordField.getPassword()), tfName.getText(), dob, taAddress.getText(), tfEmailId.getText(), txtMobile.getText()); //edit this.
						dbio.writeDB(c);
						frame.dispose();
						LoginUI window = new LoginUI();
						window.frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Username already taken. Please choose another.");
						tfUsername.setText("");
					}
				}
			}
			
		});
		
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirm.setBounds(245, 551, 101, 29);
		frame.getContentPane().add(btnConfirm);
			
		
	}
	
	
	void btnConfirmOnClick() {
		// check strings and write to database.
		System.out.println("working");
	}
	
	void reValidateFrame() {
		frame.revalidate();
	}
	
	void generateRandom(JLabel l) {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String length = "567";
		Random rand = new Random();
		
		StringBuffer str = new StringBuffer();
		l.setText("");
		int num =4+rand.nextInt(length.length());
		str.delete(0,num);
		for(int i=0;i<num;i++) {
			str.append(characters.charAt(rand.nextInt(characters.length())));
		}
		String randText = str.toString();
		l.setText(randText);
		
		reValidateFrame();
	}
	
	public class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Confirm Registration");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
