package portal;

import java.awt.EventQueue;

import definitions.*;

public class Main {
	
	public static int signInStatus;
	public static Customer logInCustomer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		signInStatus = 0;
		//DatabaseIO dbio = new DatabaseIO(EnvironmentVariables.USER_DB_NAME);
		//System.out.println(dbio.checkDB(new Customer("hello","world")));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
