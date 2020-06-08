package playground;

import java.util.ArrayList;

public class player  extends user{
private ArrayList<player> team=new ArrayList<player>();
private ArrayList<bookings> booking=new ArrayList<bookings>();
private boolean book;
player(){
	book=false;
}

public boolean isBook() {
	return book;
}

public void setBook(boolean book) {
	this.book = book;
}
public void addplayer(player _player ) {
	if(team.size()==5)
		System.out.println("The team is full");
	else
		team.add(_player);
	}
public void getplayer() {
	if(team.size()==0)
		System.out.println("There is no favourite team!");
	else {
	for(int i=0;i<team.size();i++) {
		System.out.print((i+1)+"- ");
		System.out.println("Email: "+team.get(i).getEmail());
		System.out.println("\n ");
	}
	}
}
public boolean searching(String email) {
	 boolean searching=false;
	for(int i=0;i<team.size();i++) {
		if(team.get(i).getEmail().equals(email))
				{System.out.println("This player is invited");
				searching=true;
				break;
			   }
		else
			searching=false;
	}
	return searching;
		
}
public int teamnum() {
	return team.size();
}
public void removeplayer(int p) {
	team.remove(p);
}

public ArrayList<bookings> getBooking() {
	return booking;
}

public void setBooking(ArrayList<bookings> booking) {
	this.booking = booking;
}
public int bookingsize() {
	return booking.size();
}
public void getbooking() {
	for(int i=0;i<booking.size();i++) {
		System.out.print((i+1)+"- ");
		System.out.println("Freeslot: "+booking.get(i).getFree()+"\t"+"Playground: "+booking.get(i).get_playground().getName());
	}
}
}

