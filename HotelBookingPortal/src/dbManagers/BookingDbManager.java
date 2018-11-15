package dbManagers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import definitions.Hotel;
import definitions.UserRequirements;

public class BookingDbManager {
 	/*public static void main(String []args) {
		UserRequirements g1=new UserRequirements("raj","taj","deluxe",3654763,5365453,3);
		UserRequirements g2=new UserRequirements("raj","taj","deluxe",5254763,5865453,1);
		UserRequirements g3=new UserRequirements("raj","taj","deluxe",3754763,5265453,17);
		BookingDbManager b=new BookingDbManager(g1,"deluxe",20);
		BookingDbManager b1=new BookingDbManager(g2,"ordinary",20);
		BookingDbManager b2=new BookingDbManager(g3,"normal",20);
		b.bookRoom();
		b2.bookRoom();
	    System.out.println(b1.getRooms());
	}*/
  UserRequirements ur;
  int totalrooms;
  Hotel hotel;
  BookingDbManager(UserRequirements ur,int totalrooms){
	  this.ur=ur;
	  this.totalrooms=totalrooms;
  }
  public BookingDbManager(Hotel hotel,String type,UserRequirements u) {
	  this.hotel = hotel;
	  ur = u;
	  if(type.equals("duplex")) {
		  totalrooms = Integer.parseInt(hotel.getDupRooms());
		  ur.setRoomtype("duplex");
	  }
	  else if(type.equals("standard")) {
		  totalrooms = Integer.parseInt(hotel.getRooms());
		  ur.setRoomtype("standard");
	  }
  }
  File bkng=new File(this.getClass().getResource("/bookingsDB.csv").getPath());

   public int getRooms() {
	   String tmp;
	   try(BufferedReader br = new BufferedReader(new FileReader(bkng))){
		   while((tmp=br.readLine())!=null) {
			 String binfo[]=tmp.split(",");
			 if(binfo[0].equals(ur.getHotelid())) {
				 System.out.println(binfo[2]);
				 System.out.println(ur.getRoomtype());
				 if(binfo[2].equals(ur.getRoomtype())) {
    if(((Long.parseLong(binfo[3])<=ur.getCheckin())&&(ur.getCheckin()<=Long.parseLong(binfo[4])))||
    		((Long.parseLong(binfo[3])<=ur.getCheckout()))&&(ur.getCheckout()<=Long.parseLong(binfo[4]))){
    	System.out.println((totalrooms));
             totalrooms=totalrooms-Integer.parseInt(binfo[5]);	
            }          
					  
				 }
			 }
		   }
	   }
	   catch(Exception e) {
		   
	   }
	   return totalrooms - ur.getRooms();
   }
  public void bookRoom() {
	  try(BufferedWriter bw=new BufferedWriter(new FileWriter(bkng,true))){
		  bw.append(ur.getHotelid()+","+ur.getUserid()+","+ur.getRoomtype()+","+ur.getCheckin()+","+ur.getCheckout()+","+ur.getRooms());
		  bw.newLine();
	  }
	  catch(Exception e) {
		  
	  }
  } 
  public void cancelRoom() {
	  String tmp;
	  int a;
	  ArrayList<String> bookings=new ArrayList<String>();
	  try(BufferedReader br = new BufferedReader(new FileReader(bkng))){
		  while((tmp=br.readLine())!=null) {
			  bookings.add(tmp);
		  }
		  BufferedWriter bw=new BufferedWriter(new FileWriter(bkng));
		  a=bookings.size();
		  System.out.println(a);
		  while(a!=0) {
			  if(!(bookings.get(a-1).equals((ur.getHotelid()+","+ur.getUserid()+","+ur.getRoomtype()+","+ur.getCheckin()+","+ur.getCheckout()+","+ur.getRooms()))))
			  { bw.append(bookings.get(a-1));
			    bw.newLine();
			  }
			  a--;
		  }
		  bw.close();
	  } catch (Exception e) {
		e.printStackTrace();
	}
  }
}


