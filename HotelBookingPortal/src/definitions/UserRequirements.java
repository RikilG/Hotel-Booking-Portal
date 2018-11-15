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
 private Hotel hotel;
 private long refId;
 public UserRequirements(String city,long check_in,long  check_out,int rooms,int persons){
	 this.city=city;
	 this.checkin=check_in;
	 this.checkout=check_out;
	 this.rooms=rooms;
	 this.persons=persons;
	 this.userid = portal.Main.logInCustomer.getId();
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
	 this.userid = portal.Main.logInCustomer.getId();
 }
 public UserRequirements(String details[],Hotel hotel) {
	 //ur.getHotelid()+","+ur.getUserid()+","+ur.getRoomtype()+","+ur.getCheckin()+","+ur.getCheckout()+","+ur.getRooms()+","+ur.getCity()
	 hotelid = details[0];
	 userid = details[1];
	 roomtype = details[2];
	 checkin = Long.parseLong(details[3]);
	 checkout = Long.parseLong(details[4]);
	 rooms = Integer.parseInt(details[5]);
	 city = details[6];
	 this.hotel = hotel;
	 this.refId = Integer.parseInt(details[7]);
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
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
	this.hotelid = hotel.getId();
}
public long getRefId() {
	return refId;
}
public void setRefId(long refId) {
	this.refId = refId;
}
 
}