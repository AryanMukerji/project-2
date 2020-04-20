
public class Savings extends Account {
	// list properties specific to a saving account account
	int safteyid;
	int safetykey;

	// call the constructor to initialize settings for the saving properties
	public Savings(String name, String pin, double initial_deposite) {
		super(name, pin, initial_deposite);
		Accountnumber = "1" + Accountnumber;
//		System.out.println("NEW SAVINGS ACCOUNT");
//		System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
		setsafetydepoitebox();

	}

	private void setsafetydepoitebox() {
		safteyid = (int) (Math.random() * Math.pow(10, 3));
		// System.out.println(safteyid);
		safetykey = (int) (Math.random() * Math.pow(10, 5));
		// System.out.println(safetykey);
	}

	// list any methods specific to saving account
	public void showifo() {
		super.showifo();
		System.out.println("ACCOUNT TYPE:SAVINGS ACCOUNT");
		System.out.println(
				"Your savings account features" + "\nSaftey Box ID: " + safteyid + "\nSaftey Box Key: " + safetykey);
	}

}
