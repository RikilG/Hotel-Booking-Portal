package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import definitions.EnvironmentVariables;
import definitions.Hotel;
import definitions.UserRequirements;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setBounds(200, 200, 900, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setBounds(0,0,frame.getWidth(),frame.getHeight()-40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, panel.getWidth()-5, 50);
		header.setBackground(new Color(255, 102, 0));
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
		
		txtVerificationno = new JTextField();
		txtVerificationno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtVerificationno.setHorizontalAlignment(SwingConstants.CENTER);
		txtVerificationno.setText("verificationNo");
		txtVerificationno.setBounds(225, 420, 450, 40);
		panel.add(txtVerificationno);
		txtVerificationno.setColumns(10);
		
		JPanel rbtnPanel = new JPanel();
		rbtnPanel.setBounds(225, 375, 450, 41);
		panel.add(rbtnPanel);
		rbtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnAadhaar = new JRadioButton("Aadhaar No");
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
		rdbtnPanCard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnPanCard.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnPanel.add(rdbtnPanCard);
		
		JButton btnBookNow = new JButton("Book Now");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookingDbManager bdb = new BookingDbManager(req);
				bdb.bookRoom();
				frame.dispose();
				ProfileUI window = new ProfileUI(EnvironmentVariables.BOOKING);
				window.frame.setVisible(true);
			}
		});
		btnBookNow.setBounds(380, 470, 140, 40);
		panel.add(btnBookNow);
		
		pnlHotelView = new JPanel();
		pnlHotelView.setBounds(12, 76, 868, 286);
		panel.add(pnlHotelView);
		pnlHotelView.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHotelName = new JPanel();
		pnlHotelView.add(pnlHotelName, BorderLayout.NORTH);
		pnlHotelName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHotelName = new JLabel("Hotel Name");
		lblHotelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlHotelName.add(lblHotelName);
		
		JPanel pnlHotelIv = new JPanel();
		pnlHotelView.add(pnlHotelIv, BorderLayout.WEST);
		pnlHotelIv.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel IvHotel = new JLabel("");
		pnlHotelIv.add(IvHotel);
		
		JPanel pnlUserReq = new JPanel();
		pnlHotelView.add(pnlUserReq, BorderLayout.CENTER);
	}
}
