package definitions;

public class Hotel {
	private String id;
	private String name;
	private String address;
	private String rooms;
	private String amenities;
	
	public Hotel() {} //Empty constructor to keep all to null.
	
	public Hotel(String id, String name, String address, String rooms, String amenities) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.rooms = rooms;
		this.amenities = amenities;
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
			if(address.charAt(i) == '~') {
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
	
	public String toDbString() {
		String temp = String.valueOf(id) + "," + name + "," + address + "," + rooms;
		return temp;
	}
	
}
