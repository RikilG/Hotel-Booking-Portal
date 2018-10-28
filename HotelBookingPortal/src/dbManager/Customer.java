package dbManager;

public class Customer {
	
	private int id;
	private String name;
	private String dob;
	private String address;
	private String email;
	private String username;
	private String password;
	
	Customer() {
		
	}
	
	Customer(int id, String name, String dob, String address, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
