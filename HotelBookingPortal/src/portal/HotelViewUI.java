package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;

import definitions.Hotel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotelViewUI {

	private Hotel hotel;
	private String cityName;
	
	public JFrame frame;
	private JPanel header;
	private JPanel panel;
	private JLabel ivback;
	private JLabel ivHotelImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelViewUI window = new HotelViewUI("chennai", new Hotel());
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
	public HotelViewUI(String cityName, Hotel hotel) {
		this.cityName = cityName;
		this.hotel = hotel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 882, 523);
		panel.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel);
		
		header = new JPanel();
		header.setBounds(0, 0, frame.getWidth()-18, 50);
		header.setBackground(Color.GRAY.brighter());
		header.setLayout(new BorderLayout(0, 0));
		panel.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lblNewLabel, BorderLayout.CENTER);
		
		ivback = new JLabel("Go Back");
		Image iback = new ImageIcon(this.getClass().getResource("/back.png")).getImage().getScaledInstance(header.getHeight()-10, header.getHeight()-10, Image.SCALE_DEFAULT);
		ivback.setIcon(new ImageIcon(iback));
		ivback.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HotelListUI window = new HotelListUI(cityName);
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
		
		ivHotelImage = new JLabel();
		ivHotelImage.setPreferredSize(new Dimension(200,200));
		Image hotelImage = new ImageIcon(this.getClass().getResource("/hotelsDB/" + hotel.getId().trim() + ".jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ivHotelImage.setIcon(new ImageIcon(hotelImage));
		panel.add(ivHotelImage, BorderLayout.WEST);
		
	}
}
