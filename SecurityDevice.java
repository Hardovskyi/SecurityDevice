import java.util.Scanner;
public class SecurityDevice {
public static int unlockState=6, lockState=7, currentState=0;
	
	public SecurityDevice() {
		setCurrentState(0);
	}
	//setters and getters
	public static int getCurrentState() {
		return currentState;
	}
	public static void setCurrentState(int currentState) {
		SecurityDevice.currentState = currentState;
	}

	public String output() {
	if(getCurrentState()==6) {
		return "Unlock";
	}
	else if(getCurrentState()==7) {
		return "Lock";
	}
	else{
		return "";
	}
}

//unlock code - 896471
//lock code - 896474
	public void input(int num) {
		try {
		if(num>=0) {
		if(getCurrentState()==0) {//go to state 1
			if(num==8) {
				setCurrentState(getCurrentState()+1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState()==1) {//go to state 2, num:8
			if(num==9) {
				setCurrentState(getCurrentState()+1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState()==2) {//go to state 3, num:89
			if(num==6) {
				setCurrentState(getCurrentState()+1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState()==3) {//go to state 4, num:896
			if(num==4) {
				setCurrentState(getCurrentState()+1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState()==4) {//go to state 5, num:8964
			if(num==7) {
				setCurrentState(getCurrentState()+1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState()==5) {//go to state 6 or 7, num:896471 or 896474
			if(num==1) {
				setCurrentState(6);
			}
			else if(num==4){
				setCurrentState(7);
			}
			else if(num==8){
				setCurrentState(1);
			}
			else {
				setCurrentState(0);
			}
		}
		else if(getCurrentState() == 6 || getCurrentState()==7) {
			if(num==8) {
				setCurrentState(1);
			}
			else {
				setCurrentState(0);
			}
		}
	}
		}
		catch(Exception a){
			setCurrentState(0);
		}
}


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
