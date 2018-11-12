package definitions;

public class Hotel {
	private String id;
	private String name;
	private String address;
	private String rooms;
	private String amenities;
	private String info;
	private String persons; // persons per room.
	private String rating;
	private String cost;
	private String noOfFeedbacks;
	
	public Hotel() {} //Empty constructor to keep all to null.
	
	public Hotel(String id, String name, String address, String rooms, String amenities, String info, String persons, String rating, String cost, String feedbacks) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.rooms = rooms;
		this.amenities = amenities;
		this.info = info;
		this.rating = rating;
		this.persons = persons;
		this.cost = cost;
		this.noOfFeedbacks = feedbacks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		String temp = "";
		for(int i=0;i<address.length();i++) {
			if(address.charAt(i) == '~') {
				temp += ',';
			}
			else {
				temp += address.charAt(i);
			}
		}
		return temp;
	}

	public void setAddress(String address) {
		this.address = "";
		for(int i=0;i<address.length();i++) {
			if(address.charAt(i) == ',') {
				this.address += '~';
			}
			else {
				this.address += address.charAt(i);
			}
		}
	}
	
	public String getAmenities() {
		String temp = "";
		for(int i=0;i<amenities.length();i++) {
			if(amenities.charAt(i) == '~') {
				temp += ',';
			}
			else {
				temp += amenities.charAt(i);
			}
		}
		return temp;
	}
	
	public void setAmenities(String amenities) {
		this.amenities = "";
		for(int i=0;i<amenities.length();i++) {
			if(amenities.charAt(i) == ',') {
				this.amenities += '~';
			}
			else {
				this.amenities += amenities.charAt(i);
			}
		}
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
	public String getInfo() {
		String temp = "";
		for(int i=0;i<info.length();i++) {
			if(info.charAt(i) == '~') {
				temp += ',';
			}
			else {
				temp += info.charAt(i);
			}
		}
		return temp;
	}
	
	public String getPersons() {
		return persons;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getCost() {
		return cost;
	}
	
	public String getFeedbackNo() {
		return noOfFeedbacks;
	}
	
	public String toDbString() {
		String temp = String.valueOf(id) + "," + name + "," + address + "," + rooms;
		return temp;
	}
	
}
