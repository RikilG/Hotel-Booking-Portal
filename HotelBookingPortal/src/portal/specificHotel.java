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

public class specificHotel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					specificHotel frame = new specificHotel();
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
	public specificHotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(0, 103, 107, 22);
		contentPane.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("btn1");
		mnNewMenu.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("btn2");
		mnNewMenu.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		mnNewMenu.add(btnNewButton_1);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("New check item");
		chckbxmntmNewCheckItem.setBounds(30, 178, 129, 22);
		contentPane.add(chckbxmntmNewCheckItem);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(430, 310, 17, 50);
		contentPane.add(scrollbar);
		
		JLabel lblDafkjdsfla = new JLabel("dafkjdsfla");
		lblDafkjdsfla.setBounds(109, 373, 92, 14);
		contentPane.add(lblDafkjdsfla);
		
		JLabel lblDfndfkljdaf = new JLabel("dfndfkljdaf");
		lblDfndfkljdaf.setBounds(0, 422, 92, 14);
		contentPane.add(lblDfndfkljdaf);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
