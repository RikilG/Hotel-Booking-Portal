package portal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dbManagers.BookingDbManager;
import definitions.EnvironmentVariables;
import definitions.UserRequirements;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ModifyHotelUI extends JFrame {
	private JPanel panel;
	private JTextField tfRoom;
	private JTextField tfPeople;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModifyHotelUI frame = new ModifyHotelUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ModifyHotelUI(UserRequirements req) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 430);
		getContentPane().setLayout(null);
		
		JLabel lblModifyBookedHotel = new JLabel("Modify Booked Hotel");
		lblModifyBookedHotel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblModifyBookedHotel.setBounds(12, 13, 285, 60);
		getContentPane().add(lblModifyBookedHotel);
		
		JLabel lblChangeTheDates = new JLabel("change the dates of booked date :");
		lblChangeTheDates.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChangeTheDates.setBounds(12, 86, 233, 41);
		getContentPane().add(lblChangeTheDates);
		
		JLabel lblChangeTheNumber = new JLabel("change the  number of rooms booked  :");
		lblChangeTheNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChangeTheNumber.setBounds(12, 199, 255, 14);
		getContentPane().add(lblChangeTheNumber);
		
		JLabel lblChangeNumberOf = new JLabel("change number of incoming people  :  ");
		lblChangeNumberOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChangeNumberOf.setBounds(12, 255, 245, 14);
		getContentPane().add(lblChangeNumberOf);
		
		JDateChooser checkin = new JDateChooser();
		checkin.setBounds(499, 99, 113, 20);
		getContentPane().add(checkin);
		checkin.setVisible(false);
		
		JDateChooser checkout = new JDateChooser();
		checkout.setBounds(499, 144, 113, 20);
		getContentPane().add(checkout);
		checkout.setVisible(false);
		JLabel lblNewCheckinDate = new JLabel("New Checkin Date :");
		lblNewCheckinDate.setBounds(360, 99, 123, 14);
		getContentPane().add(lblNewCheckinDate);
		
		JLabel lblNewCheckoutDate = new JLabel("New Checkout Date  :");
		lblNewCheckoutDate.setBounds(360, 144, 130, 14);
		getContentPane().add(lblNewCheckoutDate);
		lblNewCheckoutDate.setVisible(false);
		lblNewCheckinDate.setVisible(false);
		
		Calendar cal=Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		Date d1=cal.getTime();
		Calendar cal1=Calendar.getInstance();
		cal1.set(cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE)+1);
		Date d2=cal1.getTime();
		try {
			checkin.setMinSelectableDate(d1);
		checkout.setMinSelectableDate(d2);
		}
		catch(Exception e) {	
		}
		
		JCheckBox btnDate = new JCheckBox("YES");
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkin.setVisible(true);
				checkout.setVisible(true);
				lblNewCheckoutDate.setVisible(true);
				lblNewCheckinDate.setVisible(true);
			}
		});
		btnDate.setBounds(275, 95, 89, 23);
		getContentPane().add(btnDate);
		
			
		JLabel lblNumberOfRooms = new JLabel("number of rooms to be booked   :");
		lblNumberOfRooms.setBounds(345, 203, 206, 14);
		getContentPane().add(lblNumberOfRooms);
		
		tfRoom = new JTextField();
		tfRoom.setBounds(547, 200, 86, 20);
		getContentPane().add(tfRoom);
		tfRoom.setColumns(10);
		tfRoom.setVisible(false);
		lblNumberOfRooms.setVisible(false);
		
		JCheckBox btnRoom = new JCheckBox("YES");
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfRoom.setVisible(true);
				lblNumberOfRooms.setVisible(true);
			}
		});

		btnRoom.setBounds(275, 199, 89, 23);
		getContentPane().add(btnRoom);
		
		JLabel lblPleaeEnterNumber = new JLabel("no of incomming people   :");
		lblPleaeEnterNumber.setBounds(345, 255, 169, 14);
		getContentPane().add(lblPleaeEnterNumber);
		
		tfPeople = new JTextField();
		tfPeople.setBounds(515, 252, 86, 20);
		getContentPane().add(tfPeople);
		tfPeople.setColumns(10);
		tfPeople.setVisible(false);
		lblPleaeEnterNumber.setVisible(false);
	
		
		JCheckBox btnPeople = new JCheckBox("YES");
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfPeople.setVisible(true);
				lblPleaeEnterNumber.setVisible(true);
			}
		});
		btnPeople.setBounds(275, 251, 89, 23);
		getContentPane().add(btnPeople);
		
		JButton btnConfirmChanges = new JButton("Confirm Changes");
		
		btnConfirmChanges.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirmChanges.setBounds(141, 340, 206, 30);
		getContentPane().add(btnConfirmChanges);
		
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BookingDbManager bdb = new BookingDbManager(req);
							bdb.bookRoom();
							Frame openWindows[] = Frame.getFrames();
							for(Frame f : openWindows) {
								f.dispose();
							}
							ProfileUI window = new ProfileUI();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}});
		
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGoBack.setBounds(372, 340, 130, 30);
		getContentPane().add(btnGoBack);
		
		JLabel lblChangeTypeOf = new JLabel("change type of room   ;");
		lblChangeTypeOf.setBounds(35, 303, 222, 16);
		getContentPane().add(lblChangeTypeOf);
		
		JRadioButton rdbtnStanardRoom = new JRadioButton("Stanard Room");
		
		rdbtnStanardRoom.setBounds(406, 299, 127, 25);
		getContentPane().add(rdbtnStanardRoom);
		
		JRadioButton rdbtnDeluxeRoom = new JRadioButton("Deluxe Room");
		rdbtnDeluxeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnStanardRoom.setSelected(false);
			}
		});
		
		rdbtnStanardRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDeluxeRoom.setSelected(false);
			}
		});
		rdbtnDeluxeRoom.setBounds(546, 299, 127, 25);
		getContentPane().add(rdbtnDeluxeRoom);
		rdbtnStanardRoom.setVisible(false);
		rdbtnDeluxeRoom.setVisible(false);
		
		JCheckBox typeRoom = new JCheckBox("YES");
		typeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnStanardRoom.setVisible(true);
				rdbtnDeluxeRoom.setVisible(true);
			}
		});
		btnConfirmChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnDate.isSelected()) {
					Date chkin = checkin.getDate();
					Date chkout = checkout.getDate();
					if(chkin.getTime() < chkout.getTime() && chkin.getTime()>(new Date().getTime())) {
						req.setCheckin(chkin.getTime());
						req.setCheckout(chkout.getTime());
					}
					else {
						JOptionPane.showMessageDialog(null, "Please choose proper dates.");
					}
				}
				if(btnRoom.isSelected()) {
					req.setRooms(Integer.parseInt(tfRoom.getText()));
				}
				if(btnPeople.isSelected()) {
					req.setPersons(Integer.parseInt(tfPeople.getText()));
				}
				if(typeRoom.isSelected()) {
			        if(rdbtnDeluxeRoom.isSelected()) {
			        req.setRoomtype("deluxe");
			        }
			        else if(rdbtnStanardRoom.isSelected())
			        req.setRoomtype("Standard");	
			        else {
			        	JOptionPane.showMessageDialog(null, "Please select type of room.");
			        }
				}
				portal.Main.userRequirements = req;
				BookingDbManager bdb = new BookingDbManager(req);
				bdb.bookRoom();
				Frame openWindows[] = Frame.getFrames();
				for(Frame f : openWindows) {
					f.dispose();
				}
				ProfileUI window = new ProfileUI(EnvironmentVariables.BOOKING);
				window.frame.setVisible(true);
				//dispose();
			}
		});
		typeRoom.setBounds(275, 299, 113, 25);
		getContentPane().add(typeRoom);
		
		
	}
}
