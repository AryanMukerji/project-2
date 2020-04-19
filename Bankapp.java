
public class Bankapp {

	public interface IntrestRate {
		// write a method that return the base rate
	}

	public abstract class Account implements IntrestRate {
		// List common properties for savings and checking accounts (name , social
		// security number, account type balance etc.)

		// Constructor to set base properties and initialize account

		// list common methods
	}

	public class checking extends Account {
		// list properties specific to a checking account

		// call the constructor to initialize checking account properties

		// list any methods specific to checking account
	}

	public class Savings extends Account {
		// list properties specific to a saving account account

		// call the constructor to initialize settings for the saving properties

		// list any methods specific to saving account

	}

	public static void main(String[] args) {

	}
}

