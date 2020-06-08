package playground;

import java.util.ArrayList;

public class playground {
	private String name;
	private playgroundowner _owner;
	private String owner;
	private ArrayList<freeslots> freeslotlist=new ArrayList<freeslots>();
	private String location;
	private double size;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
public String display() {
	return 
			"Name: "+name+"\nlocation: "+location+"\nSize: "+size+"\nPrice: "+price+"\nOwner:"+owner+"\n";
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}

public playgroundowner get_owner() {
	return _owner;
}
public void set_owner(playgroundowner _owner) {
	this._owner = _owner;
}
public void getFreeslot() {
	for(int i=0;i<freeslotlist.size();i++) {
		if(freeslotlist.get(i).isBook()==true)
		System.out.println((i+1)+"- "+freeslotlist.get(i).getfreeslot()+"\t (is Booked)");
		else
			System.out.println((i+1)+"- "+freeslotlist.get(i).getfreeslot());
	}
}

public int freeslotsize() {
	return freeslotlist.size();
}
public boolean checking(int p) {
	return freeslotlist.get(p).isBook();
}
public void bookfree(int p) {
	freeslotlist.get(p).setBook(true);
}
public void setplayer(int p,player _player) {
	freeslotlist.get(p).set_player(_player);
}
public void searching(String free) {
	for(int i=0;i<freeslotlist.size();i++) {
		if(freeslotlist.get(i).getfreeslot().equals(free))
			freeslotlist.get(i).setBook(false);
		else
			continue;
	}
}

public void viewbooked() {
	int searching=0;
	for(int i=0;i<freeslotlist.size();i++) {
		if(freeslotlist.get(i).isBook()==true)
			searching++;
		else
			continue;
	}
	if(searching==0)
		System.out.println("There are no bookings!");
	else {
	for(int i=0;i<freeslotlist.size();i++) {
		if(freeslotlist.get(i).isBook()==true)
			System.out.println("Freeslot: "+freeslotlist.get(i).getfreeslot()+"\t Player: "+freeslotlist.get(i).get_player().getName());
		else
			continue;
	}
	}
}
public ArrayList<freeslots> getFreeslotlist() {
	return freeslotlist;
}
public void setFreeslotlist(ArrayList<freeslots> freeslotlist) {
	this.freeslotlist = freeslotlist;
}

}
