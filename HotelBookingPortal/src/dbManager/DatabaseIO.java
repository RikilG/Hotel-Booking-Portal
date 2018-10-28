package dbManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseIO implements EnvironmentVariables{
	
	File dbFile;
	
	public DatabaseIO(String filename) {
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
				if(userInfo.length==7 && userInfo[USERNAME_INDX].equals(customer.getUsername()) && userInfo[PASSWORD_INDX].equals(customer.getPassword())) {
					portal.Main.signInStatus = 1;
					return 1;
				}
			}
		}
		catch(FileNotFoundException fnfe) {
			return -1;
		}catch(IOException e) {
			return -1;
		}
		return 0;
		
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
				if(userInfo.length==7) {
					customers.add(new Customer(userInfo[ID_INDX],userInfo[USERNAME_INDX],userInfo[PASSWORD_INDX],userInfo[NAME_INDX],userInfo[DOB_INDX],userInfo[ADDRESS_INDX],userInfo[EMAIL_INDX]));
				}
			}
		}catch(FileNotFoundException fnfe) {
		}catch(Exception e) {
		}
		return customers.toArray(new Customer[customers.size()]);
	}
	
	public int writeDB(Customer customer) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbFile,true))){
			if(!dbFile.exists()) {
				bw.append(DB_HEADER);
			}
			bw.append(customer.toDbString());
			bw.newLine();
			return 1;
		}
		catch (IOException e){
			return -1;
		}
		
	}
	
}
