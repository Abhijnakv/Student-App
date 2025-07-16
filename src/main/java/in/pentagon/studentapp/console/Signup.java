package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc = new Scanner(System.in);
		Student s = new Student(); //CREATION OF POJO CLASS OBJECT
		StudentDAO sdao = new StudentDAOImpl();
		
		//Collecting data from user
		System.out.println("---------->Welcome to SignUp page---------->");
		System.out.println("Enter the name:");
		//String name=sc.next();
		//s.setName(name);
		s.setName(sc.next());
		
		System.out.println("Enter the phone number:");
		s.setPhone(sc.nextLong());
		
		System.out.println("Enter the mail Id:");
		s.setMail(sc.next());
		
		System.out.println("Enter the branch:");
		s.setBranch(sc.next());
		
		System.out.println("Enter the location:");
		s.setLoc(sc.next());
		
		System.out.println("Set a new password");
		String password = sc.next();
		
		System.out.println("Confirm the password");
		String confirmPassword = sc.next();
		
		if(password.equals(confirmPassword)) {
		   s.setPassword(confirmPassword);
		   boolean res = sdao.insertStudent(s);
		   if(res) {
			   System.out.println("Data added sucessfully!!");
		   }
		   else {
			   System.out.println("Failed to add data");
		   }
		}
		else {
			System.out.println("Password mismatch!");
		}
		
		
	}

}
