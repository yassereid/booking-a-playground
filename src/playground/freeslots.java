package playground;

public class freeslots {
private boolean book;
private String _freeslot;
private player _player;
private playground _playground;
freeslots(){
	_freeslot=null;
	setBook(false);
}

public void set_freeslot(String _freeslot) {
	this._freeslot = _freeslot;
}
public String getfreeslot() {
	return _freeslot;
}
public playground get_playground() {
	return _playground;
}
public void set_playground(playground _playground) {
	this._playground = _playground;
}
public player get_player() {
	return _player;
}
public void set_player(player _player) {
	this._player = _player;
}
public boolean isBook() {
	return book;
}
public void setBook(boolean book) {
	this.book = book;
}
}
