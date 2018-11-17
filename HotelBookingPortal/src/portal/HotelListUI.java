package portal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.*;

import dbManagers.BookingDbManager;
import dbManagers.HotelDbManager;
import definitions.Hotel;
import definitions.HotelCard;
import definitions.UserRequirements;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class HotelListUI {

	private HotelDbManager hotelDb;
	private Hotel hotelList[];
	private String cityName;
	
	public JFrame frame;
	private JPanel panel;
	private JPanel header;
	private JLabel title;
	private JScrollPane scrollPane;
	private UserRequirements req;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelListUI window = new HotelListUI("hyderabad");
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
	public HotelListUI(String cityName) {
		req = new UserRequirements( cityName, 543534,  232432, 5, 3);
		this.cityName = cityName;
		hotelDb = new HotelDbManager(cityName);
		hotelList = hotelDb.readDB();
		initialize();
	}
	
	public HotelListUI(UserRequirements ur) {
		req=ur;
		hotelDb = new HotelDbManager(ur.getCity());
		hotelList = hotelDb.readDB();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		scrollPane = new JScrollPane(panel);
		
		//frame.setResizable(false);
		frame.setBounds(100, 100, 900, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBounds(0, 0, frame.getBounds().width, frame.getBounds().height);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(0, 0, frame.getBounds().width, frame.getBounds().height);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(new Color(128, 128, 0));
		header.setPreferredSize(new Dimension(frame.getWidth()-18,50));
		header.setMinimumSize(new Dimension(frame.getWidth()-18,50));
		header.setMaximumSize(new Dimension(frame.getWidth(),50));
		panel.add(header);
		
		title = new JLabel("Available hotels based on User selection. Please select one to continue :");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		header.add(title,BorderLayout.CENTER);
		
		JLabel ivback = new JLabel("Go Back");
		Image iback = new ImageIcon(this.getClass().getResource("/back.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ivback.setIcon(new ImageIcon(iback));
		ivback.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
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
				frame.dispose();
			}
		});
		header.add(ivback, BorderLayout.WEST);
		
		JLabel ivProfile = new JLabel("My Profile          ");
		Image iprofile = new ImageIcon(this.getClass().getResource("/profile.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ivProfile.setIcon(new ImageIcon(iprofile));
		ivProfile.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				//frame.dispose();
				ProfileUI window = new ProfileUI();
				window.frame.setVisible(true);
			}
		});
		header.add(ivProfile,BorderLayout.EAST);
		
		for(Hotel h:hotelList) {
			BookingDbManager bdb1 = new BookingDbManager(h,"duplex",req);
			BookingDbManager bdb2 = new BookingDbManager(h,"standard",req);
			if(bdb1.getRooms()>0 || bdb2.getRooms()>0) {
				panel.add(new JPanel());
				panel.add(new HotelCard(h, HotelCard.BOOKING/*,(HotelListUI)this*/));
			}
		}
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(154, 205, 50));
		panel.add(panel_1);
		frame.getContentPane().add(scrollPane);
	}

}
