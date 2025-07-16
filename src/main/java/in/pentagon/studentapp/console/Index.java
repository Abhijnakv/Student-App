package in.pentagon.studentapp.console;

import java.util.Scanner;

public class Index {
public static void main(String[] args) {
	try (Scanner sc = new Scanner(System.in)) {
		int choice=0;
		System.out.println("welcome to Student App:");
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGOT PASSWORD?");
			System.out.println("4. EXIT");
			choice=sc.nextInt();
			switch(choice) {
			case 1: Signup.signup();
				break;
			case 2: Login.login(); 
				break;
			case 3: Password.forgot();
				break;
			case 4: System.out.println("Thank You"); 
				break;
				default:System.out.println("Invalid choice! please enter a valid value!");
				break;
			}
		}
		while(choice!=4);
	}
}
}
