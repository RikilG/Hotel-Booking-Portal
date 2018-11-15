package portal;

import java.awt.EventQueue;

import definitions.*;

public class Main {
	
	public static int signInStatus;
	public static Customer logInCustomer;
	public static UserRequirements userRequirements;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		signInStatus = 0;
		//DatabaseIO dbio = new DatabaseIO(EnvironmentVariables.USER_DB_NAME);
		//System.out.println(dbio.checkDB(new Customer("hello","world")));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrance window = new Entrance();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
