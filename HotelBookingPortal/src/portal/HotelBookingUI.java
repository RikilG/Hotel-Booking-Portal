package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import definitions.EnvironmentVariables;
import definitions.Hotel;
import definitions.UserRequirements;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dbManagers.BookingDbManager;

import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class HotelBookingUI {

	public JFrame frame;
	private Hotel hotel;
	private UserRequirements req;
	private JPanel panel;
	private JTextField txtVerificationno;
	private JRadioButton rdbtnAadhaar;
	private JRadioButton rdbtnPanCard;
	private JPanel pnlHotelView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelBookingUI window = new HotelBookingUI(new Hotel());
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
	public HotelBookingUI(Hotel hotel) {
		this.req = portal.Main.userRequirements;
		this.hotel = hotel;
		Frame openWindows[] = Frame.getFrames();
		for(Frame f : openWindows) {
			if(!f.equals(this.frame)) {
				f.dispose();
			}
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(200, 200, 900, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0,0,frame.getWidth(),frame.getHeight()-40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, panel.getWidth()-5, 50);
		header.setBackground(new Color(123, 104, 238));
		header.setLayout(new BorderLayout(0, 0));
		panel.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Hotel Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel ivback = new JLabel("Close");
		Image iback = new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(header.getHeight()-20, header.getHeight()-20, Image.SCALE_DEFAULT);
		ivback.setIcon(new ImageIcon(iback));
		ivback.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							HotelListUI window = new HotelListUI(cityName);
//							window.frame.setVisible(true);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				frame.dispose();
			}
		});
		header.add(ivback, BorderLayout.WEST);
		
		JLabel ivProfile = new JLabel("My Profile  ");
		Image iprofile = new ImageIcon(this.getClass().getResource("/profile.png")).getImage().getScaledInstance(header.getHeight()-10, header.getHeight()-10, Image.SCALE_DEFAULT);
		ivProfile.setIcon(new ImageIcon(iprofile));
		ivProfile.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				ProfileUI window = new ProfileUI();
				window.frame.setVisible(true);
			}
		});
		header.add(ivProfile,BorderLayout.EAST);
		
		JPanel rbtnPanel = new JPanel();
		rbtnPanel.setBackground(new Color(50, 205, 50));
		rbtnPanel.setBounds(225, 375, 450, 41);
		panel.add(rbtnPanel);
		rbtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnAadhaar = new JRadioButton("Aadhaar No");
		rdbtnAadhaar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPanCard.setSelected(false);
			}
		});
		rdbtnAadhaar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAadhaar.setSelected(true);
		rdbtnAadhaar.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnPanel.add(rdbtnAadhaar);
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setSize(new Dimension(40,10));
		emptyLabel.setPreferredSize(new Dimension(40,10));
		emptyLabel.setMinimumSize(new Dimension(40,10));
		rbtnPanel.add(emptyLabel);
		
		rdbtnPanCard = new JRadioButton("Pan Card No");
		rdbtnPanCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAadhaar.setSelected(false);
			}
		});
		rdbtnPanCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnPanCard.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnPanel.add(rdbtnPanCard);
		
		JButton btnBookNow = new JButton("Book Now");
		btnBookNow.setBackground(new Color(244, 164, 96));
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnPanCard.isSelected()) {
					String s = txtVerificationno.getText().trim(); // get your editext value here
					Pattern pattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
					Matcher matcher = pattern.matcher(s);
					if (!matcher.matches()) {
						JOptionPane.showMessageDialog(null,"Invalid Pan Card Number");
					}
					else {
						contBooking();
					}
				}
				else {
					String s1 = txtVerificationno.getText().trim(); // get your editext value here
					Pattern pattern1 = Pattern.compile("^[1-9]{1}[0-9]{11}$");
					Matcher matcher1 = pattern1.matcher(s1);
					if (!matcher1.matches()) {
						JOptionPane.showMessageDialog(null,"Invalid Aadhar Number");
					}
					else {
						contBooking();
					}
				}

			}
		});
		btnBookNow.setBounds(380, 470, 140, 40);
		panel.add(btnBookNow);
		
		pnlHotelView = new JPanel();
		pnlHotelView.setBackground(new Color(218, 165, 32));
		pnlHotelView.setBounds(12, 76, 868, 286);
		panel.add(pnlHotelView);
		pnlHotelView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHotelName = new JPanel();
		pnlHotelName.setBackground(new Color(152, 251, 152));
		pnlHotelView.add(pnlHotelName, BorderLayout.NORTH);
		pnlHotelName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHotelName = new JLabel("Hotel Name");
		lblHotelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlHotelName.add(lblHotelName);
		
		JPanel pnlHotelIv = new JPanel();
		pnlHotelIv.setBackground(new Color(152, 251, 152));
		pnlHotelView.add(pnlHotelIv, BorderLayout.WEST);
		pnlHotelIv.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel IvHotel = new JLabel("");
		pnlHotelIv.add(IvHotel);
		
		JPanel pnlUserReq = new JPanel();
		pnlUserReq.setBackground(new Color(152, 251, 152));
		pnlHotelView.add(pnlUserReq, BorderLayout.CENTER);
		pnlUserReq.setLayout(new BoxLayout(pnlUserReq, BoxLayout.Y_AXIS));
		
		JPanel pnlCity = new JPanel();
		pnlCity.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlCity);
		
		JLabel lblCity = new JLabel("City Name : ");
		pnlCity.add(lblCity);
		
		JLabel lblScity = new JLabel("Scity");
		pnlCity.add(lblScity);
		
		JPanel pnlRoomType = new JPanel();
		pnlRoomType.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlRoomType);
		
		JLabel lblRoomType = new JLabel("Room Type : ");
		pnlRoomType.add(lblRoomType);
		
		JLabel lblSroomType = new JLabel("sroomType");
		pnlRoomType.add(lblSroomType);
		
		JPanel pnlChkIn = new JPanel();
		pnlChkIn.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlChkIn);
		
		JLabel lblChkin = new JLabel("Check In Date : ");
		pnlChkIn.add(lblChkin);
		
		JLabel lblSchkin = new JLabel("schkin");
		pnlChkIn.add(lblSchkin);
		
		JPanel pnlChkOut = new JPanel();
		pnlChkOut.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlChkOut);
		
		JLabel lblChkout = new JLabel("Check Out Date : ");
		pnlChkOut.add(lblChkout);
		
		JLabel lblSchkout = new JLabel("schkout");
		pnlChkOut.add(lblSchkout);
		
		JPanel pnlRooms = new JPanel();
		pnlRooms.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlRooms);
		
		JLabel lblRooms = new JLabel("Rooms : ");
		pnlRooms.add(lblRooms);
		
		JLabel lblSrooms = new JLabel("srooms");
		pnlRooms.add(lblSrooms);
		
		JPanel pnlPersons = new JPanel();
		pnlPersons.setBackground(new Color(152, 251, 152));
		pnlUserReq.add(pnlPersons);
		
		JLabel lblPersons = new JLabel("No of Persons : ");
		pnlPersons.add(lblPersons);
		
		JLabel lblSpersons = new JLabel("spersons");
		pnlPersons.add(lblSpersons);
		
		JPanel pnlVerfNo = new JPanel();
		pnlVerfNo.setBackground(new Color(152, 251, 152));
		pnlVerfNo.setBounds(0, 423, frame.getWidth()-5, 40);
		panel.add(pnlVerfNo);
		
		JLabel lblEnterAadharpanHere = new JLabel("Enter Aadhar/Pan Here : ");
		lblEnterAadharpanHere.setFont(new Font("Tahoma", Font.ITALIC, 15));
		pnlVerfNo.add(lblEnterAadharpanHere);
		
		txtVerificationno = new JTextField();
		txtVerificationno.setBackground(new Color(240, 255, 240));
		pnlVerfNo.add(txtVerificationno);
		txtVerificationno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVerificationno.setHorizontalAlignment(SwingConstants.CENTER);
		txtVerificationno.setSize(new Dimension(400,pnlVerfNo.getHeight()-4));
		txtVerificationno.setPreferredSize(new Dimension(500, 36));
		txtVerificationno.setMinimumSize(new Dimension(500, 36));
		txtVerificationno.setColumns(25);
		
		lblScity.setText(req.getCity());
		lblSroomType.setText(req.getRoomtype());
		Date chkin = new Date(req.getCheckin());
		Date chkiout = new Date(req.getCheckout());
		Format format = new SimpleDateFormat("yyyy MM dd ");
		lblSchkin.setText(format.format(chkin));
		lblSchkout.setText(format.format(chkiout));
		lblSrooms.setText(Integer.toString(req.getRooms()));
		lblSpersons.setText(Integer.toString(req.getPersons()));
		
	}
	
	private void contBooking() {
		long refId = new Date().getTime()/1000;
		JOptionPane.showMessageDialog(null, "<html>Booking reference no : " + Long.toString(refId)+"<br>Thank you.");
		req.setRefId(refId);
		BookingDbManager bdb = new BookingDbManager(req);
		bdb.bookRoom();
		frame.dispose();
		ProfileUI window = new ProfileUI(EnvironmentVariables.BOOKING);
		window.frame.setVisible(true);
	}
}
