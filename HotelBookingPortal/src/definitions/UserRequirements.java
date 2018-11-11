package definitions;

public class UserRequirements {
 String city;
 String userid;
 int check_in;
 int check_out;
 int rooms;
 int persons;
  UserRequirements(String city,String userid,int check_in,int check_out,int rooms,int persons){
	 this.city=city;
	 this.userid=userid;
	 this.check_in=check_in;
	 this.check_out=check_out;
	 this.rooms=rooms;
	 this.persons=persons;
  }
}
