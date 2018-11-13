package portal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import definitions.Hotel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class SpecificHotelUI extends JFrame {
	
	final static int BOOKING = 1;
	final static int VIEWING = 0;

	Hotel hotel;
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
		this.hotel = hotel;
		getContentPane().setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(130, 130, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, getWidth()-18, 50);
		header.setBackground(new Color(255, 102, 0));
		header.setLayout(new BorderLayout(0, 0));
		getContentPane().add(header, BorderLayout.NORTH);
		
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
		
		JPanel scrollPane = new JPanel();
		scrollPane.setLayout(null);
		scrollPane.setBounds(55, 111, 654, 189);
		JLabel ivHotel = new JLabel();
		ivHotel.setHorizontalAlignment(SwingConstants.CENTER);
		ivHotel.setBounds(scrollPane.getWidth()*2/10,0,scrollPane.getWidth()*3/5,scrollPane.getHeight());
		Image ihotel = new ImageIcon(this.getClass().getResource("/HotelsDB/"+hotel.getId()+".jpg")).getImage().getScaledInstance(scrollPane.getWidth(), scrollPane.getHeight(), Image.SCALE_SMOOTH);
		ivHotel.setIcon(new ImageIcon(ihotel));
		scrollPane.add(ivHotel);
		getContentPane().add(scrollPane);
		
		JLabel lblHotel = new JLabel("ABC  Hotel");
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotel.setBounds(27, 62, 159, 28);
		lblHotel.setText(hotel.getName());
		getContentPane().add(lblHotel);
		
		if(viewStatus == BOOKING) {
			JButton btnBookNow = new JButton("BOOK NOW!!");
			btnBookNow.setForeground(Color.BLUE);
			btnBookNow.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBookNow.setBounds(549, 493, 135, 23);
			getContentPane().add(btnBookNow);
		}
		
		JLabel lblHoursWater = new JLabel("24 hours water supply");
		lblHoursWater.setBounds(223, 363, 200, 14);
		getContentPane().add(lblHoursWater);
		
		JLabel lblSwimmingPool = new JLabel("swimming pool");
		lblSwimmingPool.setBounds(223, 393, 189, 14);
		getContentPane().add(lblSwimmingPool);
		
		JLabel lblSpaAndGarden = new JLabel("spa and garden");
		lblSpaAndGarden.setBounds(223, 423, 200, 14);
		getContentPane().add(lblSpaAndGarden);
		
		JLabel lblRoomServicesAnd = new JLabel("room services and room deliveries");
		lblRoomServicesAnd.setBounds(223, 453, 200, 14);
		getContentPane().add(lblRoomServicesAnd);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		
		
		getContentPane().add(rdbtnNewRadioButton);
		
		JToggleButton tglbtnStandardRoom = new JToggleButton("Standard");
		tglbtnStandardRoom.setBounds(452, 335, 121, 23);
		getContentPane().add(tglbtnStandardRoom);
		
		JToggleButton tglbtnDeluxeRoom = new JToggleButton("Deluxe");
		tglbtnDeluxeRoom.setBounds(583, 335, 121, 23);
		getContentPane().add(tglbtnDeluxeRoom);
		
		JLabel lblOverallRatings = new JLabel("Overall Rating  :");
		lblOverallRatings.setBounds(527, 393, 100, 14);
		getContentPane().add(lblOverallRatings);
		
		JLabel label_4 = new JLabel("4.0");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(627, 393, 46, 14);
		label_4.setText(hotel.getRating());
		getContentPane().add(label_4);
		
		JLabel lblFeedbacks = new JLabel("No of Feedbacks :");
		lblFeedbacks.setBounds(527, 422, 111, 16);
		getContentPane().add(lblFeedbacks);
		
		JLabel lblFeedbackNo = new JLabel("50");
		lblFeedbackNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackNo.setBounds(637, 422, 36, 16);
		lblFeedbackNo.setText(hotel.getFeedbackNo());
		getContentPane().add(lblFeedbackNo);
		
	
		
		
	}
}
