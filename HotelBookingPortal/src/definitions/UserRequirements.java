package definitions;

public class UserRequirements {
 private String city;
 private long check_in;
 private long check_out;
 private int rooms;
 private int persons;
 public UserRequirements(String city,long check_in,long  check_out,int rooms,int persons){
	 this.city=city;
	 this.check_in=check_in;
	 this.check_out=check_out;
	 this.rooms=rooms;
	 this.persons=persons;
  }
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getCheck_in() {
	return check_in;
}
public void setCheck_in(long check_in) {
	this.check_in = check_in;
}
public long getCheck_out() {
	return check_out;
}
public void setCheck_out(long check_out) {
	this.check_out = check_out;
}
public int getRooms() {
	return rooms;
}
public void setRooms(int rooms) {
	this.rooms = rooms;
}
public int getPersons() {
	return persons;
}
public void setPersons(int persons) {
	this.persons = persons;
}
  
  
}
