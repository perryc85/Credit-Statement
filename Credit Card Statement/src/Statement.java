
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statement {

	public static void main(String[] args) {
		List<String[]>transactions = new ArrayList<String[]>();
		String fileName = "C:\\Users\\Charles\\Documents\\SDET\\files\\user accounts.csv";
		String dataRow;
		double balance = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((dataRow = br.readLine()) != null) {
				String [] line = dataRow.split(",");
				transactions.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String [] transaction : transactions) {
			String date = transaction[0];
			String type = transaction[1];
			String vendor = transaction[2];
			double amount = Double.parseDouble(transaction[3]);
			System.out.print(date + " " + type + " " + vendor + " $" + amount);
			
			if(type.equalsIgnoreCase("credit")) {
				//System.out.println("Add to balance");
				balance = balance + amount;
			}else if(type.equalsIgnoreCase("debit")) {
				//System.out.println("Subtract from balance");
				balance = balance - amount;
			}else {
				//System.out.println("Some other transaction");
			}
			System.out.println(" " +  balance + "\n");
		}
		
		//check balance
		if(balance > 0) {
			System.out.println("You have a balance of: " + balance);
			System.out.println("You are charged a 10% fee of " + balance * .10);
			System.out.println("Your new balance is: " + balance * 1.1);
		}else if(balance < 0) {
			System.out.println("Thanks for your  payments."); 
			System.out.println("You have a overpayment of -" + balance);
		}else{
			System.out.println("Thank you for your payment");
		}
		
	}
}

