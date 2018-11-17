package portal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import static javax.swing.ScrollPaneConstants.*;

import dbManagers.BookingDbManager;
import dbManagers.HotelDbManager;
import definitions.Customer;
import definitions.Hotel;
import definitions.HotelCard;
import definitions.UserRequirements;
import definitions.EnvironmentVariables;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;

public class ProfileUI {

	private HotelDbManager hotelDb;
	private ArrayList<UserRequirements> hotelList;
	private Customer user;
	
	public JFrame frame;
	private JPanel spanel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelLeft;
	private JPanel panelTop;
	private JPanel panelCenter;
	private JPanel panelRight;
	private JPanel panelBottom;
	private JButton btnlogout;
	private JButton btnBack;
	private JLabel Lblprofilepic;
	private JLabel lblProfilePage;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private int index;
	private JLabel lblname;
	private JLabel lblDOB;
	private JLabel lblEMail;
	private JLabel lblAddress;
	private JLabel lblDynamicName;
	private JLabel lblDynamicDOB;
	private JLabel lblDynamicAddress;
	private JLabel lblDynamicEmail;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private JButton btnBookHotel;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileUI window = new ProfileUI();
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
	public ProfileUI() {
		index = EnvironmentVariables.VIEWING;
		user = portal.Main.logInCustomer;
		initialize();
	}
	public ProfileUI(int status) {
		index = status;
		user = portal.Main.logInCustomer;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BookingDbManager bdb = new BookingDbManager();
		hotelList = bdb.userBookedHotels(portal.Main.logInCustomer.getId());
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 105, 30));
		spanel = new JPanel();
		spanel.setBackground(new Color(204, 153, 0));
		scrollPane = new JScrollPane(spanel);
		
		//frame.setResizable(false);
		frame.setBounds(100, 100, 900, 570);
		spanel.setLayout(new BoxLayout(spanel, BoxLayout.Y_AXIS));
		spanel.setBounds(0, 0, frame.getBounds().width, frame.getBounds().height);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(0, 0, frame.getBounds().width, frame.getBounds().height);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		if(index == EnvironmentVariables.BOOKING) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 153, 51));
		//scrollPane.setColumnHeaderView(panel);
		
		//panel.setBounds(0,0,frame.getBounds().width-16,500);
		panel.setPreferredSize(new Dimension(frame.getWidth()-38,360));
		panel.setMinimumSize(new Dimension(frame.getWidth()-38,200));
		panel.setMaximumSize(new Dimension(frame.getWidth()-38,500));
		panel.setLayout(new BorderLayout());
		
		spanel.add(panel);
		
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(153, 102, 51));
		panel.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		panelRight= new JPanel();
		panelRight.setBackground(new Color(153, 102, 51));
		panel.add(panelRight,BorderLayout.EAST);
		
		panelBottom= new JPanel();
		panel.add(panelBottom,BorderLayout.SOUTH);
		panelBottom.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 153, 0));
		panelBottom.add(panel_3);
		
		if(index != EnvironmentVariables.VIEWING) {
			btnBookHotel = new JButton("BOOK A HOTEL");
			btnBookHotel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
			btnBookHotel.setFont(new Font("Tahoma", Font.BOLD, 16));
			panel_3.add(btnBookHotel);
		}
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 102, 51));
		panelBottom.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("Booked Hotels");
		lblNewLabel_2.setBackground(new Color(204, 102, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("aaaaaaaaaaaaaaaaa");
		lblNewLabel_1.setVisible(false);
		panelRight.add(lblNewLabel_1);
		
		Lblprofilepic = new JLabel("");
		Lblprofilepic.setBackground(new Color(204, 102, 51));
		panelLeft.add(Lblprofilepic, BorderLayout.CENTER);
		Lblprofilepic.setHorizontalAlignment(SwingConstants.CENTER);
		Image profilemanpic=new ImageIcon(this.getClass().getResource("/profileman4.png")).getImage();
		Lblprofilepic.setIcon(new ImageIcon(profilemanpic));
		
		panelTop = new JPanel();
		panelTop.setBackground(new Color(102, 204, 204));
		panel.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		btnlogout = new JButton("Logout");
		Image logoutImg= new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		btnlogout.setIcon(new ImageIcon(logoutImg));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutOnClick();
			}
		});
		panelTop.add(btnlogout, BorderLayout.EAST);
		
		if(index != EnvironmentVariables.BOOKING) {
			btnBack = new JButton("Go Back");
			Image backImage= new ImageIcon(this.getClass().getResource("/back.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			btnBack.setIcon(new ImageIcon(backImage));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					frame.dispose();
				}
			});
			panelTop.add(btnBack, BorderLayout.WEST);
		}
		
		lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblProfilePage.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(lblProfilePage, BorderLayout.CENTER);
		
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(102, 204, 255));
		panel.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 102));
		panelCenter.add(panel_1, BorderLayout.NORTH);
		
//		if(index!=1)
//		{
//			lblNewLabel = new JLabel("Hello,"+user.getName());
//		}
//		else
//		{
//			lblNewLabel=new JLabel("Welcome"+user.getName());
//		}
		lblNewLabel =new JLabel("Hello,"+user.getUsername());
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		panelCenter.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(4,2,10,15));
		
		lblname = new JLabel("Name :");
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblname);
		
		lblDynamicName = new JLabel(user.getName());
		panel_2.add(lblDynamicName);
		
		lblDOB = new JLabel("Date Of Birth :");
		lblDOB.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblDOB);
		
		lblDynamicDOB = new JLabel(user.getDob());
		panel_2.add(lblDynamicDOB);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblAddress);
		
		lblDynamicAddress = new JLabel("<html><br>"+user.getAddress()+"</html>");
		panel_2.add(lblDynamicAddress);
		
		lblEMail = new JLabel("Email :");
		lblEMail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblEMail);
		
		lblDynamicEmail = new JLabel(user.getEmail());
		panel_2.add(lblDynamicEmail);
		
		if(hotelList.size() > 0) {
			for(UserRequirements h:hotelList) {
				spanel.add(new JPanel());
				spanel.add(new HotelCard(h.getHotel(),HotelCard.VIEWING,h));
			}
		}
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 102, 0));
		spanel.add(panel_5);
		frame.getContentPane().add(scrollPane);
	}
	
	private void logoutOnClick()
	{
		int a=JOptionPane.showConfirmDialog(null, "Do You sure want to Logout");
		if(a==JOptionPane.YES_OPTION)
		{
			//go to login page
			portal.Main.signInStatus = 0;
			Frame openWindows[] = Frame.getFrames();
			for(Frame f : openWindows) {
				f.dispose();
			}
			LoginUI objWindow=new LoginUI();
			objWindow.frame.setVisible(true);
		}
	}
	
//	public void refreshHotels() {
//		frame.revalidate();
//		BookingDbManager bdb = new BookingDbManager();
//		hotelList = bdb.userBookedHotels(portal.Main.logInCustomer.getId());
//		
//		if(hotelList.size() > 0) {
//			for(UserRequirements h:hotelList) {
//				spanel.add(new JPanel());
//				spanel.add(new HotelCard(h.getHotel(),HotelCard.VIEWING,(ProfileUI)this));
//			}
//		}
//		frame.revalidate();
//	}

}
