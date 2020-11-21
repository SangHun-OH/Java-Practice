import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	private Formatter output;

	public void openfile() {
		try {
			output = new Formatter("formatted1.txt");
		} catch (SecurityException securityException) {
			System.err.println("Secure");
			System.exit(1);
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening");
			System.exit(1);
		}
	}

	public void addRecords() {
		AccountRecord record = new AccountRecord();
		Scanner input = new Scanner(System.in);
		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ",
				"when you are prompted to enter input.", "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
				"On Windows type <ctrl> z then press Enter");
		System.out.printf("%s %s%s", "Enter account number (>0),", "first, last, balance", " :");
		while (input.hasNext()) {
			try
			{
				record.setAccount(input.nextInt()); 
				record.setFirstName(input.next()); 
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				if (record.getAccount() > 0) {
					output.format("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(),
							record.getBalance());
				} else {
					System.out.println("Account number must be greater than 0.");
				} 
			} 
			catch (FormatterClosedException formatterClosedException) {
				System.err.println("Error writing to file.");
				return;
			}
			catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				input.nextLine(); 
			} 
			System.out.printf("%s %s%s", "Enter account number (>0),", "first, last, balance", " :");
		} 
	}

	public void closeFile() {
		if (output != null) {
			output.close();
		}
	}
}
