package definitions;

public interface EnvironmentVariables {

	String USER_DB_NAME = "user_database.csv";
	String DB_HEADER = "Id,Username,Password,Name,DOB,Address,Email";
	
	//Customer class
	int USER_INFO_SIZE = 7;
		int ID_INDX = 0;
		int USERNAME_INDX = 1;
		int PASSWORD_INDX = 2;
		int NAME_INDX = 3;
		int DOB_INDX = 4;
		int ADDRESS_INDX = 5;
		int EMAIL_INDX = 6;
	
	//Hotel class
	int HOTEL_INFO_SIZE = 5;
		int H_ID_INDX = 0;
		int H_NAME_INDX = 1;
		int H_ADDRESS_INDX = 2;
		int H_ROOMS_INDX = 3;
		int H_AMENITIES_INDX = 4;
}
