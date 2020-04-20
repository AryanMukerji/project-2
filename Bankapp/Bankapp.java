import java.util.LinkedList;
import java.util.List;

public class Bankapp {
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

