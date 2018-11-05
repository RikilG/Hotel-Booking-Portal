package definitions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dbManagers.HotelDbManager;
import portal.HotelListUI;
import portal.HotelViewUI;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class HotelCard extends JPanel {
	
	private HotelListUI caller;
	private HotelDbManager hotelDb;
	private Hotel hotel;
//	String hotelId;
	String cityName;
	private int dimX;
	private int dimY;
	static int padding=12;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JLabel lblHotelcontent;
	private JLabel lblHotelname;
	private JButton btnViewHotel;

	/**
	 * @wbp.parser.constructor 
	 */
	public HotelCard(String cityName, Hotel hotel, HotelListUI caller) {
		this.cityName = cityName;
		this.hotel = hotel;
		this.caller = caller;
		dimX = 800;dimY = 150;
		setMeasures();
	}
	
//	public HotelCard(String cityName, String hotelId) {
//		hotelDb = new HotelDbManager(cityName);
//		hotel = hotelDb.getHotelFromDB(hotelId);
//		this.cityName = cityName;
//		this.hotelId = hotelId;
//		dimX = 800;dimY = 150;
//		setMeasures();
//	}
//	
//	public HotelCard(String cityName, String hotelId ,int width) {
//		hotelDb = new HotelDbManager(cityName);
//		hotel = hotelDb.getHotelFromDB(hotelId);
//		this.cityName = cityName;
//		this.hotelId = hotelId;
//		dimX = width;dimY = 150;
//		setMeasures();
//	}
//	
//	public HotelCard(String cityName, String hotelId ,int width, int height) {
//		hotelDb = new HotelDbManager(cityName);
//		hotel = hotelDb.getHotelFromDB(hotelId);
//		this.cityName = cityName;
//		this.hotelId = hotelId;
//		dimX = width;dimY = height;
//		setMeasures();
//	}
	
	private void setMeasures() {
		setPreferredSize(new Dimension(dimX, dimY));
		setMinimumSize(new Dimension(dimX, dimY));
		setMaximumSize(new Dimension(dimX, dimY));
		setBackground(new Color(211,211,211));
		setBorder(new LineBorder(Color.WHITE, 5, true));
		setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setLocation(padding, padding);
		leftPanel.setSize(new Dimension((int)(dimX*0.3), dimY - 2*padding));
		leftPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				openHotelViewPage();
			}
		});
		setImage(leftPanel, hotel.getId());
		add(leftPanel);
		rightPanel = new JPanel();
		rightPanel.setLocation((int)(dimX*0.3 + 2*padding), padding);
		rightPanel.setSize(new Dimension((int)(dimX*0.7 - 3*padding), dimY-2*padding));
		rightPanel.setLayout(null);
		rightPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				openHotelViewPage();
			}
		});
		add(rightPanel);
		
		lblHotelname = new JLabel(hotel.getName());
		lblHotelname.setBounds(0, 0, rightPanel.getSize().width - 102, 33);
		lblHotelname.setFont(new Font("Dialog", Font.BOLD, 20));
		rightPanel.add(lblHotelname);
		
		lblHotelcontent = new JLabel(hotel.getAmenities());
		lblHotelcontent.setVerticalAlignment(SwingConstants.TOP);
		lblHotelcontent.setBounds(0, 36, rightPanel.getSize().width, rightPanel.getSize().height - lblHotelname.getSize().height - padding/2);
		rightPanel.add(lblHotelcontent);
		
		btnViewHotel = new JButton("View Hotel");
		btnViewHotel.setBounds(rightPanel.getSize().width - 102, 2, 100, 33);
		btnViewHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openHotelViewPage();
			}
		});
		rightPanel.add(btnViewHotel);
	}

	private void setImage(JPanel jp, String hotelId) {
		String url = "/hotelsDB/" + hotelId + ".jpg";
	    JLabel jl=new JLabel();
	    Image image = new ImageIcon(this.getClass().getResource(url)).getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_DEFAULT);
	    jl.setIcon(new ImageIcon(image));
	    jp.add(jl);
	}
	
	private void openHotelViewPage() {
		setBackground(new Color((int)(Math.random() * 0x1000000)));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelViewUI window = new HotelViewUI(cityName, hotel);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		caller.frame.dispose();
	}
}
