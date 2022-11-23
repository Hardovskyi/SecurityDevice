import java.util.ArrayList;
import java.util.Random;
public class testrandom {

	//constructor
	public testrandom() {
		
	}
	
	//counts the tries to guess the password
	public int guess() {
		SecurityDevice user = new SecurityDevice();
		int count =0;
		Random num = new Random();
	
		while(user.getCurrentState()!=6) {
			int random = num.nextInt(10);	
			user.input(random);
			count++;
			if(user.output().equals("Unlock")) {
				System.out.println(user.output()+"ed");
				System.out.println("Numbers inputed to unlock: "+count);
			}
		}
		return count;//number of digits generated
	}
	
	public String average(int tries) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();//array with all counts
		
		//getting counts
		for(int i = 0; i<tries; i++) {
		SecurityDevice user = new SecurityDevice();
		Random num = new Random();	
		int count =0;
		
		while(user.getCurrentState()!=6) {//generating counts
			int random = num.nextInt(10);	
			user.input(random);
			count++;
		}
		array.add(count);
	}
		
		int size = array.size();
		int min = array.get(0);
		int max = array.get(0);
		//find minimum
        for (int i = 1; i < size; i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
		
		//find maximum
        for (int i = 1; i < size; i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        
		//find average
      		int sum=0;
			int average;  
		for(int i=0; i<size; i++) {
			sum = array.get(i)+sum;
		}
		average = sum/size;
		//output
		String output = "Min: "+min+"    Max: "+max+"    Average:"+average;
		return output;
	}
	
	
	public static void main(String[] args) {
		testrandom test = new testrandom();
		test.guess();
		System.out.println(test.average(20));
	}
	
	
	
	
	
}
