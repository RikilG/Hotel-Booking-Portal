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

import dbManagers.HotelDbManager;
import definitions.Hotel;
import definitions.HotelCard;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelListUI window = new HotelListUI("chennai");
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
		this.cityName = cityName;
		hotelDb = new HotelDbManager(cityName);
		hotelList = hotelDb.readDB();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
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
		header.setBackground(new Color(255, 102, 0));
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
				
			}
		});
		header.add(ivProfile,BorderLayout.EAST);
		
		for(Hotel h:hotelList) {
			panel.add(new JPanel());
			panel.add(new HotelCard(cityName, h, HotelCard.BOOKING/*,(HotelListUI)this*/));
		}
		panel.add(new JPanel());
		frame.getContentPane().add(scrollPane);
	}

}
