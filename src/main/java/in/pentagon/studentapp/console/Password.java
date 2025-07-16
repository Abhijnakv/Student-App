package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
public static void forgot() {
	StudentDAO sdao= new StudentDAOImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the phone number:");
	long phone=sc.nextLong();
	System.out.println("Enter the mail ID:");
	String mail=sc.next();
	Student s=sdao.getStudent(phone,mail);
	if(s!=null) {
		System.out.println("Set a new password");
		String password=sc.next();
		System.out.println("Confirm the new password");
		String confirm=sc.next();
		if(password.equals(confirm)) {
			s.setPassword(password);
			boolean res=sdao.updateStudent(s);
			if(res) {
				System.out.println("Password updated!");
			}
			else {
				System.out.println("Failed to update the password!");
			}
		}
		else {
			System.out.println("Password mismatch");
		}
	}
	else{
			System.out.println("Student not found!");
		}
	}
}