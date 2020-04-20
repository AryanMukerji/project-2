import java.util.LinkedList;
import java.util.List;

public class Bankapp {

	public interface IntrestRate {
		// write a method that return the base rate
		default double getbaserate() {
			return 2.5;
		}
	}

	public abstract static class Account implements IntrestRate {
		// List common properties for savings and checking accounts (name , social
		// security number, account type balance etc.)
		private String name;
		private String pin;
		private double balance;
		protected static int index = 2000;// shows error in csv reared file
		protected String Accountnumber;
		protected double rate;

		// Constructor to set base properties and initialize account
		public Account(String name, String pin, double initial_deposite) {
			this.name = name;
			this.pin = pin;
			balance = initial_deposite + 100;
//			System.out.println("NAME: " + name + "PIN: " + pin + "BALANCE:RS " + balance);
			// Generating the account number
			index++;
			this.Accountnumber = setaccountnumber();
			// System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
			// System.out.println(getbaserate());
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

		public void balance() {
			System.out.println("Current Balance: " + balance);
		}

		public void showifo() {
			System.out.println("NAME: " + name + "\nAccount number: " + Accountnumber + "\nBalance: " + balance
					+ "\nRate: " + rate);
		}
	}

	public class checking extends Account {
		// list properties specific to a checking account
		private int debitcardnumber;
		private int debitcardpin;

		// call the constructor to initialize checking account properties
		public checking(String name, String pin, double initial_deposite) {
			super(name, pin, initial_deposite);
			Accountnumber = "2" + Accountnumber;
//			System.out.println("NEW CHECKING ACCOUNT");
//			System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
			setdebitcard();
		}

		@Override // so that we can implement the unimplemented methods in savings account to
		public void setrate() {
			rate = getbaserate() * .15;
		}

		// list any methods specific to checking account

		private void setdebitcard() {
			debitcardnumber = (int) (Math.random() * Math.pow(10, 12));
			debitcardpin = (int) (Math.random() * Math.pow(10, 4));
		}

		public void showifo() {
			super.showifo();
			System.out.println("ACCOUNT TYPE: CHECKING ACCOUNT");
			System.out.println("Your debit card number: " + debitcardnumber + "\nyour debit card pin: " + debitcardpin);
		}
	}

	public class Savings extends Account {
		// list properties specific to a saving account account
		private int safteyid;
		private int safetykey;

		// call the constructor to initialize settings for the saving properties
		public Savings(String name, String pin, double initial_deposite) {
			super(name, pin, initial_deposite);
			Accountnumber = "1" + Accountnumber;
//			System.out.println("NEW SAVINGS ACCOUNT");
//			System.out.println("ACCOUNT NUMBER: " + this.Accountnumber);
			setsafetydepoitebox();

		}

		@Override
		public void setrate() {
			rate = getbaserate() * 1.5;

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
			System.out.println("Your savings account features" + "\nSaftey Box ID: " + safteyid + "\nSaftey Box Key: "
					+ safetykey);
		}

	}

	public static void main(String[] args) {
		List<Account> account = new LinkedList<Account>();
		// read a file and then create account related to that/based on that file
		String file = "C:\\Users\\hp\\Documents\\Downloads\\read.csv";
//		checking chacc1 = new checking("harshil bhardwaj", "23458976", 1234);
//		Savings savacc1 = new Savings("cookie bhardwaj", "76562378", 3457);
//		chacc1.showifo();
//		System.out.println("***********************");
//		savacc1.showifo();
//		savacc1.compoundintrest();
		List<String[]> newaccountholders = utility.read.read(file);
		for (String[] accountholder : newaccountholders) {
			String name = accountholder[0];
			String PIN = accountholder[1];
			String accounttype = accountholder[2];
			double initialdeposite = Double.parseDouble(accountholder[3]);
			// System.out.println(name + " " + PIN + " " + accounttype + " " +
			// initialdeposite);
			if (accounttype.equals("Savings")) {
				// System.out.println("OPEN NEW SAVINGS ACCOUNT");
				account.add(new Savings(name, PIN, initialdeposite));
			} else if (accounttype.equals("Checking")) {
				// System.out.println("OPEN A NEW CHECKINGS ACCOUNT");
				account.add(new Savings(name, PIN, initialdeposite));
			} else {
				System.out.println("boggy woggie boo you got fucked up find some errors solve them and run again");
			}

		}

		// account.get(5).showifo();

		for (Account acc : account) {
			System.out.println("\n***********");
			acc.showifo();
		}

	}

}

