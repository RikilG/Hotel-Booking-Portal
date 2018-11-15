package definitions;

public interface EnvironmentVariables {

	String USER_DB_NAME = "user_database.csv";
	String DB_HEADER = "Id,Username,Password,Name,DOB,Address,Email";
	
	//Disable buttons
	int BOOKING = 1;
	int VIEWING = 0;
	
	//Customer class
	int USER_INFO_SIZE = 8;
		int ID_INDX = 0;
		int USERNAME_INDX = 1;
		int PASSWORD_INDX = 2;
		int NAME_INDX = 3;
		int DOB_INDX = 4;
		int ADDRESS_INDX = 5;
		int EMAIL_INDX = 6;
		int MOBILE_INDX = 7;
	
	//Hotel class
	int HOTEL_INFO_SIZE = 10;
		int H_ID_INDX = 0;
		int H_NAME_INDX = 1;
		int H_ADDRESS_INDX = 2;
		int H_ROOMS_INDX = 3;
		int H_AMENITIES_INDX = 4;
		int H_DUPROOMS_INDX = 5;
		int H_PERSONS_INDX = 6;
		int H_RATING_INDX = 7;
		int H_COST_INDX = 8;
		int H_FEEDBACKS_INDX = 9;
}
