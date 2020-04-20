
public abstract class Account implements IntrestRate {
	// List common properties for savings and checking accounts (name , social
	// security number, account type balance etc.)
	String name;
	String pin;
	double balance;
	static int index = 2000;
	String Accountnumber;
	double rate;

	// Constructor to set base properties and initialize account
	public Account(String name, String pin, double initial_deposite) {
		this.name = name;
		this.pin = pin;
		balance = initial_deposite + 100;
//		System.out.println("NAME: " + name + "PIN: " + pin + "BALANCE:RS " + balance);
		// Generating the account number
		index++;
		this.Accountnumber = setaccountnumber();
		// System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
		 setrate();// polymorfism acchived
	}
	public abstract void setrate();// becuse we can not define the rate from just account class sop we have to make
									// methods available in checking and savings class too

	private String setaccountnumber() {
		String lasttwopin = pin.substring(pin.length() - 3, pin.length());
		int uniqueID = index;
		int randnum = (int) ((int) Math.random() * Math.pow(10, 3));
		return lasttwopin + uniqueID + randnum;
	}
	public void compoundintrest() {
		double intrest = balance * (rate / 100);
		balance = balance + intrest;
		System.out.println("Intrest: " + intrest);
		balance();
	}

	// list common methods
	public void deposite(double amount) {
		balance = balance + amount;
		System.out.println("Depositing: " + amount);
		balance();
	}

	public void withdraw(double amount) {
		balance = balance = amount;
		System.out.println("Withdrawing: " + amount);
		balance();

	}

	public void transfer(String destination, double amount) {
		balance = balance - amount;
		System.out.println("Transfering: " + amount + " " + "TO: " + destination);
		balance();
	}

	public void showifo() {
		System.out.println("NAME: " + name + "\nAccount number: " + Accountnumber + "\nBalance: " + balance+ "\nRate: " + rate);
	}
}

