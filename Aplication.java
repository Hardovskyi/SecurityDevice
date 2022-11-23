import java.util.Scanner;

public class Aplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SecurityDevice user = new SecurityDevice();
		
		while(true) {
			String Input=scan.nextLine().toString();
			try {
			user.input(Integer.parseInt(Input));
			}
			catch(Exception b){
			}
			if(user.output().equals("Lock")||user.output().equals("Unlock")) {
					System.out.println(user.output());	
			}
		}
	}
}
