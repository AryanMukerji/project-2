
public class checking extends Account {
	// list properties specific to a checking account
	int debitcardnumber;
	int debitcardpin;

	// call the constructor to initialize checking account properties
	public checking(String name, String pin, double initial_deposite) {
		super(name, pin, initial_deposite);
		Accountnumber = "2" + Accountnumber;
//		System.out.println("NEW CHECKING ACCOUNT");
//		System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
	}

	// list any methods specific to checking account
	public void showifo() {
		super.showifo();
		System.out.println("ACCOUNT TYPE: CHECKING ACCOUNT");
	}
}
