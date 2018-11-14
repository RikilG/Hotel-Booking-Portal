package dbManagers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import definitions.UserRequirements;

public class BookingDbManager {
	/*public static void main(String []args) {
		UserRequirements g1=new UserRequirements("raj","taj","deluxe",3654763,5365453,3);
		BookingDbManager b=new BookingDbManager(g1,"deluxe",20);
		b.bookRoom();
		System.out.println(b.getRooms());
	}*/
  UserRequirements ur;
  String roomtype;
  int totalrooms;
  BookingDbManager(UserRequirements ur,String roomtype,int totalrooms){
	  this.ur=ur;
	  this.roomtype=roomtype;
	  this.totalrooms=totalrooms;
  }
  File bkng=new File(this.getClass().getResource("/bookingsDB.csv").getPath());

   public int getRooms() {
	   String tmp;
	   try(BufferedReader br = new BufferedReader(new FileReader(bkng))){
		   while((tmp=br.readLine())!=null) {
			 String binfo[]=tmp.split(",");
			 if(binfo[0].equals(ur.getHotelid())) {
				 if(binfo[2].equals(ur.getRoomtype())) {
    if(((Long.parseLong(binfo[3])<=ur.getCheckin())&&(ur.getCheckin()<=Long.parseLong(binfo[4])))||
    		((Long.parseLong(binfo[3])<=ur.getCheckout()))&&(ur.getCheckout()<=Long.parseLong(binfo[4]))){
             totalrooms=totalrooms-Integer.parseInt(binfo[5]);	
            }          
					  
				 }
			 }
		   }
	   }
	   catch(Exception e) {
		   
	   }
	   return totalrooms;
   }
  public void bookRoom() {
	  try(BufferedWriter bw=new BufferedWriter(new FileWriter(bkng,true))){
		  bw.append(ur.getHotelid()+","+ur.getUserid()+","+roomtype+","+ur.getCheckin()+","+ur.getCheckout()+","+ur.getRooms());
		  bw.newLine();
	  }
	  catch(Exception e) {
		  
	  }
  } 
  public void cancelRoom() {
	  String tmp;
	  int a;
	  ArrayList<String> bookings=new ArrayList<String>();
	  try(BufferedWriter bw=new BufferedWriter(new FileWriter(bkng));BufferedReader br = new BufferedReader(new FileReader(bkng))){
		  while((tmp=br.readLine())!=null) {
			  bookings.add(tmp);
		  }
		  a=bookings.size();
		  while(a!=0) {
			  if(bookings.get(a)!=(ur.getHotelid()+","+ur.getUserid()+","+roomtype+","+ur.getCheckin()+","+ur.getCheckout()+","+ur.getRooms()))
			  { bw.append(bookings.get(a));
			  bw.newLine();
			  }
			  a--;
		  }
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}


