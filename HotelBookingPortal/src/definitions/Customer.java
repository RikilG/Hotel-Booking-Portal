package definitions;

public class Customer {
	
	private String id;
	private String username;
	private String password;
	private String name;
	private String dob;
	private String address;
	private String email;
	private String mobile;
	
	public Customer() {} //Empty Constructor to put all to null.
	
	public Customer(String username, String password) {
		this.username = username.toLowerCase();
		this.password = password;
		address = "";
	}
	
	public Customer(String id, String username, String password, String name, String dob, String address, String email, String mobile) {
		this.id = String.valueOf(id);
		this.username = username.toLowerCase();
		this.password = password;
		this.name = name;
		this.dob = "";
		for(int i=0;i<dob.length();i++) {
			if(dob.charAt(i) == ',') {
				this.dob += " /";
			}
			else {
				this.dob += dob.charAt(i);
			}
		}
		//this.address = address; address might contain ',' delimiter which alters data storage in csv file
		this.email = email;
		this.mobile = mobile;
		this.address = "<html>";
		for(int i=0;i<address.length();i++) {
			if(address.charAt(i) == ',') {
				this.address += '~';
			}
			else if(address.charAt(i) == '\n') {
				this.address += "<br>";
			}
			else {
				this.address += address.charAt(i);
			}
		}
		this.address += "</html>";
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String toDbString() {
		String temp = String.valueOf(id) + "," + username + "," + password + "," + name + "," + dob + ","
				 + address + "," + email + "," + mobile;
		return temp;
	}
	
}
