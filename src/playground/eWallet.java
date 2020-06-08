package playground;

public class eWallet {
private double account;	
private String pin;
private double balance;
eWallet(){
	setPin("0");
	balance=5000;
	account=0;
}

public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public void paymoney(double money) {
	if(balance<money)
		System.out.println("Your balance is less than the amount of withdrawl!");
	else
	balance-=money;
}
public void collectmoney(double money) {
	balance+=money;
}

public double getAccount() {
	return account;
}

public void setAccount(double account) {
	this.account = account;
}

public String getPin() {
	return pin;
}

public void setPin(String pin) {
	this.pin = pin;
}
}
