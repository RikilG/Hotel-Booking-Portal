package definitions;


public class UserRequirements {
 private String hotelid;
 private String userid;
 private String roomtype;	
 private String city;
 private long checkin;
 private long checkout;
 private int rooms;
 private int persons;
 public UserRequirements(String city,long check_in,long  check_out,int rooms,int persons){
	 this.city=city;
	 this.checkin=check_in;
	 this.checkout=check_out;
	 this.rooms=rooms;
	 this.persons=persons;
  }
 public UserRequirements(String usr,String hoid,String rtyp,long cin,long cout,int nor) {
	 userid=usr;
     hotelid=hoid;
	 roomtype=rtyp;
	 checkin=cin;
	 checkout=cout;
	  rooms=nor;
 }
 public UserRequirements(String hoid,String rtyp,long cin,long cout,int nor) {
     hotelid=hoid;
	 roomtype=rtyp;
	 checkin=cin;
	 checkout=cout;
	 rooms=nor;
 }
public String getHotelid() {
	return hotelid;
}
public void setHotelid(String hotelid) {
	this.hotelid = hotelid;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getRoomtype() {
	return roomtype;
}
public void setRoomtype(String roomtype) {
	this.roomtype = roomtype;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getCheckin() {
	return checkin;
}
public void setCheckin(long checkin) {
	this.checkin = checkin;
}
public long getCheckout() {
	return checkout;
}
public void setCheckout(long checkout) {
	this.checkout = checkout;
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