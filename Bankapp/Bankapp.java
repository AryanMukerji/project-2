
public class Bankapp {
	public static void main(String[] args) {
		// read a file and then create account related to that/based on that file

		checking chacc1 = new checking("harshil bhardwaj", "23458976", 1234);
		Savings savacc1 = new Savings("cookie bhardwaj", "76562378", 3457);
		chacc1.showifo();
		System.out.println("***********************");
		savacc1.showifo();

	}
}

