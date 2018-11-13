package dbManagers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import definitions.Customer;
import definitions.EnvironmentVariables;

public class CustomerDbManager implements EnvironmentVariables{
	
	File dbFile;
	
	public CustomerDbManager() {
		dbFile = new File(this.getClass().getResource("/"+EnvironmentVariables.USER_DB_NAME).getPath());
	}
	
	public CustomerDbManager(String filename) {
		dbFile = new File(this.getClass().getResource("/"+filename).getPath());
	}
	
	public int checkDB(Customer customer) {
		
		String temp;
		
		try(BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
			if(!dbFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String userInfo[] = temp.split(",");
				if(userInfo.length==USER_INFO_SIZE && userInfo[USERNAME_INDX].equals(customer.getUsername()) && userInfo[PASSWORD_INDX].equals(customer.getPassword())) {
					portal.Main.signInStatus = 1;
					return 1;
				}
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			fnfe.printStackTrace();
			return -1;
		}catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
		return 0;
		
	}
	
	public Customer getCustomerFromDB(Customer customer) {
		
		String temp;
		
		try(BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
			if(!dbFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String userInfo[] = temp.split(",");
				if(userInfo.length==USER_INFO_SIZE && userInfo[USERNAME_INDX].equals(customer.getUsername()) && userInfo[PASSWORD_INDX].equals(customer.getPassword())) {
					return new Customer(userInfo[ID_INDX],userInfo[USERNAME_INDX],userInfo[PASSWORD_INDX],userInfo[NAME_INDX],userInfo[DOB_INDX],userInfo[ADDRESS_INDX],userInfo[EMAIL_INDX],userInfo[MOBILE_INDX]);
				}
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			fnfe.printStackTrace();
		}catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return new Customer();
		
	}
	
	public Customer[] readDB() {
		List<Customer> customers = new ArrayList<>();
		String temp="";
		try(BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
			if(!dbFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String userInfo[] = temp.split(",");
				if(userInfo.length==USER_INFO_SIZE) {
					customers.add(new Customer(userInfo[ID_INDX],userInfo[USERNAME_INDX],userInfo[PASSWORD_INDX],userInfo[NAME_INDX],userInfo[DOB_INDX],userInfo[ADDRESS_INDX],userInfo[EMAIL_INDX],userInfo[MOBILE_INDX]));
				}
			}
		}catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			fnfe.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return customers.toArray(new Customer[customers.size()]);
	}
	
	public int writeDB(Customer customer) {
		String temp;
		int lastId = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(dbFile))) {
			if(!dbFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String userInfo[] = temp.split(",");
				if(userInfo.length==USER_INFO_SIZE) {
					lastId = Integer.parseInt(userInfo[ID_INDX]);
				}
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		lastId += 1;
		customer.setId(String.valueOf(lastId));
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbFile,true))){
			if(!dbFile.exists()) {
				bw.append(DB_HEADER);
			}
			bw.append(customer.toDbString());
			bw.newLine();
			return 1;
		}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
		
	}
	
}
