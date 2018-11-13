package portal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Scrollbar;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class SpecificHotelUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecificHotelUI frame = new SpecificHotelUI();
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
	public SpecificHotelUI() {
		getContentPane().setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 311, 654, 189);
		getContentPane().add(scrollPane);
		
		JLabel lblHotel = new JLabel("ABC  Hotel");
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotel.setBounds(27, 272, 159, 28);
		getContentPane().add(lblHotel);
		
		JButton btnBookNow = new JButton("BOOK NOW!!");
		btnBookNow.setForeground(Color.BLUE);
		btnBookNow.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBookNow.setBounds(549, 693, 135, 23);
		getContentPane().add(btnBookNow);
		
		JLabel lblHoursWater = new JLabel("24 hours water supply");
		lblHoursWater.setBounds(223, 568, 200, 14);
		getContentPane().add(lblHoursWater);
		
		JLabel lblSwimmingPool = new JLabel("swimming pool");
		lblSwimmingPool.setBounds(223, 593, 189, 14);
		getContentPane().add(lblSwimmingPool);
		
		JLabel lblSpaAndGarden = new JLabel("spa and garden");
		lblSpaAndGarden.setBounds(223, 623, 200, 14);
		getContentPane().add(lblSpaAndGarden);
		
		JLabel lblRoomServicesAnd = new JLabel("room services and room deliveries");
		lblRoomServicesAnd.setBounds(223, 653, 200, 14);
		getContentPane().add(lblRoomServicesAnd);
		
		JLabel label = new JLabel("1");
		label.setBounds(154, 559, 27, 23);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(154, 593, 27, 23);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(154, 623, 27, 23);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(154, 653, 27, 23);
		getContentPane().add(label_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		
		
		getContentPane().add(rdbtnNewRadioButton);
		
		JToggleButton tglbtnStandardRoom = new JToggleButton("Standard Room");
		tglbtnStandardRoom.setBounds(452, 535, 121, 23);
		getContentPane().add(tglbtnStandardRoom);
		
		JToggleButton tglbtnDeluxeRoom = new JToggleButton("Deluxe Room");
		tglbtnDeluxeRoom.setBounds(583, 535, 121, 23);
		getContentPane().add(tglbtnDeluxeRoom);
		
		JLabel lblOverallRatings = new JLabel("Overall Ratings  :");
		lblOverallRatings.setBounds(527, 593, 100, 14);
		getContentPane().add(lblOverallRatings);
		
		JLabel label_4 = new JLabel("4.0");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(638, 593, 46, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("5");
		label_5.setBounds(154, 693, 27, 23);
		getContentPane().add(label_5);
		
	
		
		
	}
}
