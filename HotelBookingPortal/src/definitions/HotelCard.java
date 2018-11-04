package definitions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dbManagers.HotelDbManager;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class HotelCard extends JPanel {
	
	HotelDbManager hotelDb;
	Hotel hotel;
//	String hotelId;
//	String cityName;
	int dimX;
	int dimY;
	static int padding=12;
	
	JPanel leftPanel;
	JPanel rightPanel;
	private JLabel lblHotelcontent;
	private JLabel lblHotelname;

	/**
	 * @wbp.parser.constructor 
	 */
	public HotelCard(Hotel hotel) {
		this.hotel = hotel;
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
	
	private void setImage(JPanel jp, String hotelId) {
		String url = "/" + hotelId + ".jpg";
	    JLabel jl=new JLabel();
	    Image image = new ImageIcon(this.getClass().getResource(url)).getImage();
	    jl.setIcon(new ImageIcon(image));
	    jp.add(jl);
	}
	
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
		//setImage(leftPanel, hotel.getId());
		add(leftPanel);
		rightPanel = new JPanel();
		rightPanel.setLocation((int)(dimX*0.3 + 2*padding), padding);
		rightPanel.setSize(new Dimension((int)(dimX*0.7 - 3*padding), dimY-2*padding));
		add(rightPanel);
		rightPanel.setLayout(null);
		
		lblHotelname = new JLabel(hotel.getName());
		lblHotelname.setBounds(0, 0, rightPanel.getSize().width, 33);
		lblHotelname.setFont(new Font("Dialog", Font.BOLD, 20));
		rightPanel.add(lblHotelname);
		
		lblHotelcontent = new JLabel(hotel.getAmenities());
		lblHotelcontent.setVerticalAlignment(SwingConstants.TOP);
		lblHotelcontent.setBounds(0, 36, rightPanel.getSize().width, rightPanel.getSize().height - lblHotelname.getSize().height - padding/2);
		rightPanel.add(lblHotelcontent);
	}
}
