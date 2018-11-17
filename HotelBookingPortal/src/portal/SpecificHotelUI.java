package portal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import definitions.Hotel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class SpecificHotelUI extends JFrame implements ActionListener {
	
	final static int BOOKING = 1;
	final static int VIEWING = 0;

	Hotel hotel;
	
	JButton btnStandardRoom;
	JButton btnDeluxeRoom;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecificHotelUI frame = new SpecificHotelUI(BOOKING,new Hotel());
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
	public SpecificHotelUI(int viewStatus,Hotel hotel) {
		getContentPane().setBackground(new Color(169, 169, 169));
		this.hotel = hotel;
		getContentPane().setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(130, 130, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, getWidth()-18, 50);
		header.setBackground(new Color(210, 105, 30));
		header.setLayout(new BorderLayout(0, 0));
		getContentPane().add(header, BorderLayout.NORTH);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(new Color(244, 164, 96));
		pnlContent.setBounds(10, 63, 760, 477);
		getContentPane().add(pnlContent);
		pnlContent.setLayout(new BorderLayout(0, 0));
		
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
				dispose();
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
		
		JPanel ivPane = new JPanel();
		ivPane.setBackground(new Color(244, 164, 96));
		ivPane.setLayout(null);
		ivPane.setSize(new Dimension(250,pnlContent.getHeight()));
		ivPane.setPreferredSize(new Dimension(250,pnlContent.getHeight()));
		ivPane.setMaximumSize(new Dimension(250,pnlContent.getHeight()));
		JLabel ivHotel = new JLabel();
		ivHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ivHotel.setBounds(0,50,250,300);
		Image ihotel = new ImageIcon(this.getClass().getResource("/HotelsDB/"+hotel.getId()+".jpg")).getImage().getScaledInstance(ivHotel.getWidth(), ivHotel.getHeight(), Image.SCALE_SMOOTH);
		ivHotel.setIcon(new ImageIcon(ihotel));
		ivPane.add(ivHotel);
		pnlContent.add(ivPane,BorderLayout.WEST);
		
		JPanel pnlHotelTitle = new JPanel();
		pnlHotelTitle.setBackground(new Color(184, 134, 11));
		pnlContent.add(pnlHotelTitle, BorderLayout.NORTH);
		
		JLabel lblHotel = new JLabel("ABC  Hotel");
		pnlHotelTitle.add(lblHotel);
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setPreferredSize(new Dimension(pnlContent.getWidth(),20));
		lblHotel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblHotel.setText(hotel.getName());
		
		JPanel pnlAmenities = new JPanel();
		pnlAmenities.setBackground(new Color(143, 188, 143));
		pnlContent.add(pnlAmenities, BorderLayout.CENTER);
		pnlAmenities.setLayout(null);
		
		JLabel lblHotelAmenities = new JLabel("24 hours water supply");
		lblHotelAmenities.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHotelAmenities.setVerticalAlignment(SwingConstants.TOP);
		lblHotelAmenities.setLocation(10, 10);
		lblHotelAmenities.setSize(350, 390);
		pnlAmenities.add(lblHotelAmenities);
		lblHotelAmenities.setText(hotel.getAmenitiesList());
		
		JPanel pnlReviews = new JPanel();
		pnlReviews.setBackground(new Color(169, 169, 169));
		pnlReviews.setForeground(new Color(0, 0, 0));
		pnlReviews.setPreferredSize(new Dimension(150, 400));
		pnlReviews.setMinimumSize(new Dimension(150, 400));
		pnlContent.add(pnlReviews, BorderLayout.EAST);
		pnlReviews.setLayout(new BoxLayout(pnlReviews, BoxLayout.Y_AXIS));
		
		JPanel pnlRating = new JPanel();
		pnlRating.setLayout(new BoxLayout(pnlRating, BoxLayout.Y_AXIS));
		pnlReviews.add(pnlRating);
		
		JLabel lblOverallRatings = new JLabel("Overall Rating ");
		lblOverallRatings.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlRating.add(lblOverallRatings);
		lblOverallRatings.setBounds(527, 393, 100, 14);
		
		JLabel lblRatingsNo = new JLabel("4.0");
		lblRatingsNo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 22));
//		String temp = " ";
//		for(int i=0;i<Integer.parseInt(hotel.getRating());i++) {
//			temp += "★";
//		}
		pnlRating.add(lblRatingsNo);
		lblRatingsNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRatingsNo.setBounds(627, 393, 46, 14);
		lblRatingsNo.setText(hotel.getRating());
//		lblRatingsNo.setText(temp);
		
		JPanel emptyPanel = new JPanel();
		pnlReviews.add(emptyPanel);
		
		JPanel pnlFeedbacks = new JPanel();
		pnlFeedbacks.setLayout(new BoxLayout(pnlFeedbacks, BoxLayout.Y_AXIS));
		pnlReviews.add(pnlFeedbacks);
		
		JLabel lblFeedbacks = new JLabel("No of Feedbacks    ");
		lblFeedbacks.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlFeedbacks.add(lblFeedbacks);
		lblFeedbacks.setBounds(527, 422, 111, 16);
		
		JLabel lblFeedbackNo = new JLabel("50");
		lblFeedbackNo.setFont(new Font("Tahoma", Font.BOLD, 22));
		pnlFeedbacks.add(lblFeedbackNo);
		lblFeedbackNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackNo.setBounds(637, 422, 36, 16);
		lblFeedbackNo.setText(hotel.getFeedbackNo());
		
		JPanel emptyPanel2 = new JPanel();
		pnlReviews.add(emptyPanel2);
		
		JPanel emptyPanel3 = new JPanel();
		pnlReviews.add(emptyPanel3);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(new Color(205, 133, 63));
		pnlContent.add(pnlButtons, BorderLayout.SOUTH);
		
		//if(viewStatus == BOOKING) {
			btnStandardRoom = new JButton("Book Standard");
			pnlButtons.add(btnStandardRoom);
			
			btnDeluxeRoom = new JButton("Book Deluxe");
			pnlButtons.add(btnDeluxeRoom);
			btnDeluxeRoom.addActionListener(this);
			btnStandardRoom.addActionListener(this);
		//}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		int result;
		if(btnStandardRoom.isFocusOwner()) {
			result = JOptionPane.showConfirmDialog(null, "Do You Want to Book a Standard room in this hotel?");
			if(result == JOptionPane.YES_OPTION) {
				portal.Main.userRequirements.setRoomtype("standard");
				portal.Main.userRequirements.setHotel(hotel);
				HotelBookingUI window = new HotelBookingUI(hotel);
				window.frame.setVisible(true);
				dispose();
			}
		}
		else if(btnDeluxeRoom.isFocusOwner()) {
			result = JOptionPane.showConfirmDialog(null, "Do You Want to Book a Deluxe room in this hotel?");
			if(result == JOptionPane.YES_OPTION) {
				portal.Main.userRequirements.setRoomtype("deluxe");
				portal.Main.userRequirements.setHotel(hotel);
				HotelBookingUI window = new HotelBookingUI(hotel);
				window.frame.setVisible(true);
				dispose();
			}
		}
	}
}
