package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import definitions.UserRequirements;

import javax.swing.JTextField;
import javax.swing.JButton;


public class DestinationsUI implements ActionListener {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JDateChooser dateChooser_1;
	private String city="";
	private UserRequirements ur;
	JLabel lblNewLabel_4 = new JLabel();
	private JDateChooser dateChooser ;
	private JLabel ivProfile;
	int room=-1,person=-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DestinationsUI window = new DestinationsUI();
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
	public DestinationsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblNewLabel = new JLabel("Welcome to Hotel Booking Portal");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(227, 11, 445, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectDestinationCity = new JLabel("Select destination city from below");
		lblSelectDestinationCity.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblSelectDestinationCity.setBounds(58, 76, 249, 28);
		frame.getContentPane().add(lblSelectDestinationCity);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Sahmedabad.png")));
		lblNewLabel_1.setBounds(58, 115, 92, 83);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(34, 115, 21, 23);
		frame.getContentPane().add(radioButton);
		radioButton.setActionCommand("Ahmedabad");
		radioButton.addActionListener(this);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Shyderabad.png")));
		label.setBounds(407, 115, 83, 83);
		frame.getContentPane().add(label);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(380, 115, 21, 23);
		frame.getContentPane().add(radioButton_1);
		radioButton_1.setActionCommand("Hyderabad");
		radioButton_1.addActionListener(this);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Schennai.png")));
		label_1.setBounds(752, 115, 83, 83);
		frame.getContentPane().add(label_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(726, 115, 21, 23);
		frame.getContentPane().add(radioButton_2);
		radioButton_2.setActionCommand("Chennai");
		radioButton_2.addActionListener(this);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Smumbai.png")));
		label_2.setBounds(58, 225, 92, 92);
		frame.getContentPane().add(label_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setBounds(34, 233, 21, 23);
		frame.getContentPane().add(radioButton_3);
		radioButton_3.setActionCommand("Mumbai");
		radioButton_3.addActionListener(this);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Sncr.png")));
		label_3.setBounds(407, 225, 74, 92);
		frame.getContentPane().add(label_3);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBackground(Color.WHITE);
		radioButton_4.setBounds(381, 225, 21, 23);
		frame.getContentPane().add(radioButton_4);
		radioButton_4.setActionCommand("Delhi");
		radioButton_4.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DestinationsUI.class.getResource("/hotelsDB/Sbanglore.png")));
		lblNewLabel_2.setBounds(752, 225, 83, 92);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBackground(Color.WHITE);
		radioButton_5.setBounds(726, 225, 21, 23);
		frame.getContentPane().add(radioButton_5);
		radioButton_5.setActionCommand("Bengaluru");
		radioButton_5.addActionListener(this);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		bg.add(radioButton);
		bg.add(radioButton_3);
		bg.add(radioButton_4);
		bg.add(radioButton_5);
		
		JLabel lblCheckInDate = new JLabel("Check in date:");
		lblCheckInDate.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblCheckInDate.setBounds(343, 355, 110, 14);
		frame.getContentPane().add(lblCheckInDate);
		
		JCalendar j=new JCalendar();
		lblCheckInDate.add(j);
		Date d=new Date();
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(448, 355, 100, 20);
		try {
		frame.getContentPane().add(dateChooser);
		}
		catch(Exception e){
			
		}
		dateChooser.setMinSelectableDate(d);
		
		JLabel lblCheckOutDate = new JLabel("Check out date:");
		lblCheckOutDate.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblCheckOutDate.setBounds(328, 392, 110, 14);
		frame.getContentPane().add(lblCheckOutDate);
		
		dateChooser_1=new JDateChooser();
		dateChooser_1.setBounds(448, 386, 100, 20);
		dateChooser_1.setMinSelectableDate(d);
		frame.getContentPane().add(dateChooser_1);	
		
		JLabel lblNoofRooms = new JLabel("No.of rooms:");
		lblNoofRooms.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblNoofRooms.setBounds(355, 423, 92, 14);
		frame.getContentPane().add(lblNoofRooms);
		
		textField = new JTextField();
		textField.setBounds(448, 417, 83, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("No.of persons :");
		lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(343, 443, 105, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(448, 443, 83, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		btnSubmit.setBounds(401, 482, 89, 23);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setActionCommand("Submit");
		btnSubmit.addActionListener(this);
		
		Calendar cal=Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+6, cal.get(Calendar.DATE));
		Date d1=cal.getTime();
		try {
		dateChooser.setMaxSelectableDate(d1);
		dateChooser_1.setMaxSelectableDate(d1);
		}
		catch(Exception e) {
			
		}
		
		ivProfile = new JLabel("My Profile  ");
		ivProfile.setBounds(752,13,122,56);
		Image iprofile = new ImageIcon(this.getClass().getResource("/profile.png")).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
		ivProfile.setIcon(new ImageIcon(iprofile));
		ivProfile.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				//frame.dispose();
				ProfileUI window = new ProfileUI();
				window.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(ivProfile);
	}

	public void actionPerformed(ActionEvent e) {
		int flag=0;
		lblNewLabel_4.setText("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(23, 394, 250, 50);
		frame.getContentPane().add(lblNewLabel_4);
        String str=e.getActionCommand(); 
		if(str=="Submit") {
			if(city=="") {
		    lblNewLabel_4.setText("Please Select a city!");
			}
			else {
				if(dateChooser.getDate()==null) {
					//System.out.println("Inside first if"+dateChooser.getDate());
					
				lblNewLabel_4.setText("Please enter check in date");
				}
				else if(dateChooser_1.getDate()==null) {
					//System.out.println
				lblNewLabel_4.setText("Please enter check out date");
				}
				else if(dateChooser_1.getDate().getTime()<dateChooser.getDate().getTime())
					lblNewLabel_4.setText("Invalid in/out dates");
				else {
					try {
				 room=Integer.parseInt(textField.getText());
					flag=1;
				 person=Integer.parseInt(textField_1.getText());
					flag=2;
					}
					catch(Exception exp) {
						if(flag==0)
						lblNewLabel_4.setText("Enter valid no.of rooms");
						else
						lblNewLabel_4.setText("Enter valid no.of persons");
					}
					if(flag==2) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									ur = new UserRequirements(city,dateChooser.getDate().getTime(),dateChooser_1.getDate().getTime(),room,person);
									HotelListUI window = new HotelListUI(ur);
									portal.Main.userRequirements = ur;
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						frame.dispose();
					}
				}
			}	
		}
		else
			city=str;
		frame.repaint();
	}
}
