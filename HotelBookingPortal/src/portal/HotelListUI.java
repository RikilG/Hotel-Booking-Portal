package portal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.*;

import dbManagers.HotelDbManager;
import definitions.Hotel;
import definitions.HotelCard;
import javax.swing.BoxLayout;

public class HotelListUI {

	private HotelDbManager hotelDb;
	private Hotel hotelList[];
	private String cityName;
	
	public JFrame frame;
	private JPanel panel;
	private JPanel header;
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
		header.setBackground(Color.GRAY);
		header.setPreferredSize(new Dimension(frame.getWidth(),100));
		header.setMinimumSize(new Dimension(frame.getWidth(),100));
		panel.add(header);
		
		for(Hotel h:hotelList) {
			panel.add(new JPanel());
			panel.add(new HotelCard(cityName, h,(HotelListUI)this));
		}
		panel.add(new JPanel());
		frame.add(scrollPane);
	}

}
