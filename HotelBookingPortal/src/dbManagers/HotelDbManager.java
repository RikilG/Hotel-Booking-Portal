package dbManagers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import definitions.Hotel;

public class HotelDbManager implements definitions.EnvironmentVariables{
	
	File hotelFile;
	
	public HotelDbManager(String cityName) {
		hotelFile = new File(this.getClass().getResource("/"+cityName.toLowerCase().trim()+".csv").getPath());
	}
	
	public Hotel[] readDB() {
		List<Hotel> hotels = new ArrayList<>();
		String temp="";
		try(BufferedReader br = new BufferedReader(new FileReader(hotelFile))) {
			if(!hotelFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String hotelInfo[] = temp.split(",");
				if(hotelInfo.length==5) {
					hotels.add(new Hotel(hotelInfo[H_ID_INDX],hotelInfo[H_NAME_INDX],hotelInfo[H_ADDRESS_INDX],hotelInfo[H_ROOMS_INDX],hotelInfo[H_AMENITIES_INDX]));
				}
			}
		}catch(FileNotFoundException fnfe) {
		}catch(Exception e) {
		}
		return hotels.toArray(new Hotel[hotels.size()]);
	}
	
	public Hotel getHotelFromDB(String hotelId) { //to return hotel from corresponding hotel id.
		
		String temp;
		
		try(BufferedReader br = new BufferedReader(new FileReader(hotelFile))) {
			if(!hotelFile.exists()) {
				throw new FileNotFoundException();
			}
			while((temp=br.readLine())!=null) {
				String hotelInfo[] = temp.split(",");
				if(hotelInfo.length==5 && hotelInfo[H_ID_INDX].equals(hotelId)) {
					return new Hotel(hotelInfo[H_ID_INDX],hotelInfo[H_NAME_INDX],hotelInfo[H_ADDRESS_INDX],hotelInfo[H_ROOMS_INDX],hotelInfo[H_AMENITIES_INDX]);
				}
			}
		}
		catch(FileNotFoundException fnfe) {
		}catch(IOException e) {
		}
		return new Hotel();
		
	}
	
}