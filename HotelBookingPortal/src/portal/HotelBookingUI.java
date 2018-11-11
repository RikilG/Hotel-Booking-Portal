package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import definitions.Hotel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class HotelBookingUI {

	public JFrame frame;
	private Hotel hotel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelBookingUI window = new HotelBookingUI(new Hotel());
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
	public HotelBookingUI(Hotel hotel) {
		this.hotel = hotel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0,0,frame.getWidth()-18,frame.getHeight()-40);
		panel.setLayout(new GridLayout(4,0,10,10));
		frame.add(panel);
	}

}
