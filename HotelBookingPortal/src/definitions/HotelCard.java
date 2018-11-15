package definitions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dbManagers.BookingDbManager;
import dbManagers.HotelDbManager;
import portal.HotelBookingUI;
import portal.HotelListUI;
import portal.ProfileUI;
import portal.SpecificHotelUI;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class HotelCard extends JPanel {
	
	public static final int BOOKING=1;
	public static final int VIEWING=0;
	
//	private HotelListUI caller;
	private HotelDbManager hotelDb;
	private Hotel hotel;
	private int bookingStatus;
	private UserRequirements req;
//	String hotelId;
//	String cityName;
	private int dimX;
	private int dimY;
	static int padding=12;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JLabel lblHotelcontent;
	private JLabel lblHotelname;
	private JButton btnViewHotel;
	private JButton btnModifyHotel;
	private JPanel pnlHotelCost;
	private JPanel pnlCost;
	private JPanel pnlCostNo;
	private JLabel lblHotelCost;
	private JLabel lblHotelCostNo;
	private JLabel lblDupHotelCostNo;
	private JLabel lblPerNight;
	private JLabel lblDupPerNight;
	private JPanel pnlDupCost;
	private JPanel pnlDupCostNo;
	private JLabel lblHotelDupCost;
	private JPanel pnlStandard;
	private JPanel pnlDeluxe;
	private JPanel pnlHotelName;

	/**
	 * @wbp.parser.constructor 
	 */
	public HotelCard(Hotel hotel,int bookingStatus/*, HotelListUI caller*/) {
//		this.cityName = cityName;
		this.hotel = hotel;
		this.bookingStatus = bookingStatus;
		//this.caller = caller;
		dimX = 800;dimY = 150;
		setMeasures();
	}
	
	public HotelCard(Hotel hotel,int bookingStatus,UserRequirements req/*, HotelListUI caller*/) {
		this.req = req;
//		this.cityName = cityName;
		this.hotel = hotel;
		this.bookingStatus = bookingStatus;
		//this.caller = caller;
		dimX = 800;dimY = 150;
		setMeasures();
	}
	
	public HotelCard() {
		dimX = 800;dimY = 150;
		setMeasures();
	}
	
	private void setMeasures() {
		setPreferredSize(new Dimension(dimX, dimY));
		setMinimumSize(new Dimension(dimX, dimY));
		setMaximumSize(new Dimension(dimX, dimY));
		setBackground(new Color(211,211,211));
		setBorder(new LineBorder(Color.BLUE, 2, true));
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
		rightPanel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				openHotelViewPage();
			}
		});
		add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		pnlHotelName = new JPanel();
		rightPanel.add(pnlHotelName, BorderLayout.NORTH);
		pnlHotelName.setLayout(new BoxLayout(pnlHotelName, BoxLayout.X_AXIS));
		
		lblHotelname = new JLabel(hotel.getName());
		pnlHotelName.add(lblHotelname);
		lblHotelname.setFont(new Font("Dialog", Font.BOLD, 20));
		
		lblHotelcontent = new JLabel();
		lblHotelcontent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		if(bookingStatus == EnvironmentVariables.VIEWING) {
			Date checkin = new Date(req.getCheckin());
			Date checkout = new Date(req.getCheckout());
			Format format = new SimpleDateFormat("yyyy/MM/dd ");
			String temp = "<html><br>";
			temp += " City : " + req.getCity() + "<br>";
			temp += " Check in Date : " + format.format(checkin) + "<br>";
			temp += " Check out Date : " + format.format(checkout) + "<br>";
			temp += " Booking Reference No : " + req.getRefId() + "<br>";
			temp+="</html>";
			lblHotelcontent.setText(temp);
		}
		else {
			lblHotelcontent.setText("<html>"+hotel.getAmenities()+"</html>");
		}
		lblHotelcontent.setVerticalAlignment(SwingConstants.TOP);
		lblHotelcontent.setMaximumSize(new Dimension(rightPanel.getSize().width, rightPanel.getSize().height - padding/2));
		rightPanel.add(lblHotelcontent, BorderLayout.CENTER);
		
		pnlHotelCost = new JPanel();
		pnlHotelCost.setLayout(new BoxLayout(pnlHotelCost, BoxLayout.X_AXIS));
		rightPanel.add(pnlHotelCost,BorderLayout.EAST);
		
		if(bookingStatus == EnvironmentVariables.BOOKING) {
			stdPnl();
			JPanel pnlLine = new JPanel();
			pnlLine.setBackground(Color.GRAY);
			pnlLine.setMaximumSize(new Dimension(2,60));
			pnlLine.setPreferredSize(new Dimension(2,60));
			pnlHotelCost.add(pnlLine);
			dupPnl();
		}
		else {
			if(req.getRoomtype().equals("deluxe")) {
				dupPnl();
			}
			else {
				stdPnl();
			}
		}
		
		if(bookingStatus == BOOKING) {
			pnlHotelName.add(new JPanel());
			btnViewHotel = new JButton("View Deal");
			btnViewHotel.setBounds(rightPanel.getSize().width - 152, 2, 150, 33);
			btnViewHotel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openHotelViewPage();
				}
			});
			pnlHotelName.add(btnViewHotel,BorderLayout.NORTH);
		}
		else if(bookingStatus == VIEWING) {
			pnlHotelName.add(new JPanel());
			btnViewHotel = new JButton("Cancel Booking");
			btnViewHotel.setBounds(rightPanel.getSize().width - 152, 2, 150, 33);
			btnViewHotel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bookingCancel();
				}
			});
			pnlHotelName.add(btnViewHotel,BorderLayout.NORTH);
			
			btnModifyHotel = new JButton("Modify Booking");
			btnModifyHotel.setBounds(rightPanel.getSize().width - 152, 2, 150, 33);
			btnModifyHotel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bookingModify();
				}
			});
			pnlHotelName.add(btnModifyHotel,BorderLayout.NORTH);
		}
	}
	
	private void stdPnl() {
		pnlStandard = new JPanel();
		pnlHotelCost.add(pnlStandard);
		pnlStandard.setLayout(new BoxLayout(pnlStandard, BoxLayout.Y_AXIS));
		
		pnlCost = new JPanel();
		pnlStandard.add(pnlCost);
		pnlCost.setLayout(new BoxLayout(pnlCost, BoxLayout.Y_AXIS));
		
		lblHotelCost = new JLabel("Price ");
		lblHotelCost.setForeground(new Color(204, 0, 0));
		lblHotelCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlCost.add(lblHotelCost);
		
		lblPerNight = new JLabel("-Standard/Night ");
		lblPerNight.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPerNight.setForeground(new Color(204, 0, 0));
		pnlCost.add(lblPerNight);
		
		pnlCostNo = new JPanel();
		pnlStandard.add(pnlCostNo);
		pnlCostNo.setLayout(new BoxLayout(pnlCostNo, BoxLayout.Y_AXIS));
		
		lblHotelCostNo = new JLabel("CostNo");
		lblHotelCostNo.setForeground(new Color(51, 204, 0));
		lblHotelCostNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblHotelCostNo.setText("\u20B9 " + hotel.getCost() + " ");
		pnlCostNo.add(lblHotelCostNo);
	}
	private void dupPnl() {
		pnlDeluxe = new JPanel();
		pnlHotelCost.add(pnlDeluxe);
		pnlDeluxe.setLayout(new BoxLayout(pnlDeluxe, BoxLayout.Y_AXIS));
		
		pnlDupCost = new JPanel();
		pnlDeluxe.add(pnlDupCost);
		pnlDupCost.setLayout(new BoxLayout(pnlDupCost, BoxLayout.Y_AXIS));
		
		lblHotelDupCost = new JLabel("Price");
		lblHotelDupCost.setForeground(new Color(204, 0, 0));
		lblHotelDupCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlDupCost.add(lblHotelDupCost);
		
		lblDupPerNight = new JLabel("-Deluxe/Night ");
		lblDupPerNight.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDupPerNight.setForeground(new Color(204, 0, 0));
		pnlDupCost.add(lblDupPerNight);
		
		pnlDupCostNo = new JPanel();
		pnlDeluxe.add(pnlDupCostNo);
		pnlDupCostNo.setLayout(new BoxLayout(pnlDupCostNo, BoxLayout.Y_AXIS));
		
		lblDupHotelCostNo = new JLabel("CostNo");
		pnlDupCostNo.add(lblDupHotelCostNo);
		lblDupHotelCostNo.setForeground(new Color(51, 204, 0));
		lblDupHotelCostNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDupHotelCostNo.setText("\u20B9 " + hotel.getDupCost() + " ");
	}

	private void setImage(JPanel jp, String hotelId) {
		String url = "/hotelsDB/" + hotelId + ".jpg";
	    JLabel jl=new JLabel();
	    Image image = new ImageIcon(this.getClass().getResource(url)).getImage().getScaledInstance(leftPanel.getWidth(), leftPanel.getHeight(), Image.SCALE_DEFAULT);
	    jl.setIcon(new ImageIcon(image));
	    jp.add(jl);
	}
	
	private void openHotelViewPage() {
		//setBackground(new Color((int)(Math.random() * 0x1000000)));
		setBackground(Color.LIGHT_GRAY);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecificHotelUI window = new SpecificHotelUI(BOOKING, hotel);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//caller.frame.dispose();
	}
	
	protected void bookingCancel() {
		if(req.getCheckin() - (new Date().getTime()) > 259200000) {
			int ans = JOptionPane.showConfirmDialog(null,"Do you really want to cancel this booking?");
			if(ans == JOptionPane.YES_OPTION) {
				// delete corresponding hotel for this user (portal.Main.LogInUser)
				BookingDbManager bdb = new BookingDbManager(req);
				bdb.cancelRoom();
				Frame openWindows[] = Frame.getFrames();
				for(Frame f : openWindows) {
					f.dispose();
				}
				ProfileUI window = new ProfileUI(EnvironmentVariables.BOOKING);
				window.frame.setVisible(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Cannot cancel as check in date is less than 3 days away.");
		}
	}
	
	protected void bookingModify() {
		if(req.getCheckin() - (new Date().getTime()) > 259200000) {
			int ans = JOptionPane.showConfirmDialog(null,"Do you really want to modify this booking?");
			if(ans == JOptionPane.YES_OPTION) {
				// delete and add corresponding hotel for this user (portal.Main.LogInUser)
				BookingDbManager bdb = new BookingDbManager(req);
				bdb.cancelRoom();
				//call edit options frame here.
				bdb = new BookingDbManager(req);
				bdb.bookRoom();
				Frame openWindows[] = Frame.getFrames();
				for(Frame f : openWindows) {
					f.dispose();
				}
				ProfileUI window = new ProfileUI(EnvironmentVariables.BOOKING);
				window.frame.setVisible(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Cannot cancel as check in date is less than 3 days away.");
		}
	}
	
//	private void openHotelBookPage() {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				HotelBookingUI window = new HotelBookingUI(hotel);
//				window.frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}
}
