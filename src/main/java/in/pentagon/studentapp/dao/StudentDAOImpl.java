package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.student.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection con; 
	public StudentDAOImpl() { 
		  this.con=Connector.requestConnection(); 
		    System.out.println("Connection success? " + (con != null));
}
	@Override 
	 public boolean insertStudent(Student s) { 
	 String query = "INSERT INTO STUDENT (name, phone, mail, branch, location, password) VALUES (?, ?, ?, ?, ?, ?)";
	  try(PreparedStatement ps=con.prepareStatement(query)) { 
	   ps.setString(1, s.getName()); 
	   ps.setLong(2, s.getPhone()); 
	   ps.setString(3,s.getMail()); 
	   ps.setString(4, s.getBranch()); 
	   ps.setString(5, s.getLoc()); 
	   ps.setString(6, s.getPassword()); 
	   int rows=ps.executeUpdate(); 
	   return rows>0;
	  } 
	  catch (SQLException e) 
	  { 
	   e.printStackTrace();
	   return false; 
	  } 
	}
	
	
	 @Override 
	 public boolean updateStudent(Student s) { 
	  PreparedStatement ps=null; 
	  String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?"; 
	  int i=0; 
	  try { 
	   ps=con.prepareStatement(query); 
	   ps.setString(1,s.getName()); 
	   ps.setLong(2, s.getPhone()); 
	   ps.setString(3,s.getMail()); 
	   ps.setString(4,s.getBranch()); 
	   ps.setString(5, s.getLoc()); 
	   ps.setString(6, s.getPassword()); 
	   ps.setInt(7, s.getId()); 
	   i=ps.executeUpdate(); 
	  } catch (SQLException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	  if(i>0) 
	  { 
	   return true; 
	  } 
	  else { 
	   return false; 
	  } 
	 } 
	 
	 @Override 
		 public boolean deleteStudent(int id) {
			    PreparedStatement ps = null;
			    String query = "DELETE FROM STUDENT WHERE ID=? AND ID!=1";
			    int res = 0;
			    try {
			        ps = con.prepareStatement(query);
			        ps.setInt(1, id);
			        System.out.println("Executing delete for ID: " + id);  // DEBUG
			        res = ps.executeUpdate();
			        System.out.println("Rows affected: " + res); // DEBUG
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    if (res > 0) {
			        return true;
			    } else {
			        return false;
			    }
			}
	 
	 @Override 
	 public Student getStudent(String mail, String password) { 
	  PreparedStatement ps=null; 
	  String query="SELECT * FROM student WHERE mail=? AND password=?"; 
	  Student s=null; 
	  try { 
	   ps=con.prepareStatement(query); 
	   ps.setString(1, mail); 
	   ps.setString(2, password); 
	   ResultSet rs=ps.executeQuery();
	   if(rs.next()) { 
	    s=new Student(); 
 
	    s.setId(rs.getInt("id")); 
	    s.setName(rs.getString("name")); 
	    s.setPhone(rs.getLong("phone")); 
	    s.setMail(rs.getString("mail")); 
	    s.setBranch(rs.getString("branch")); 
	    s.setLoc(rs.getString("location")); 
	    s.setPassword(rs.getString("password")); 
	    s.setDate(rs.getString("date")); 
	   } 
	  } catch (SQLException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	   
	  return s; 
	 } 
	 
	 @Override 
	 public Student getStudent(long phone, String mail) { 
	  PreparedStatement ps=null; 
	  String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?"; 
	  Student s=null; 
	  try { 
	   ps=con.prepareStatement(query);
	   ps.setLong(1, phone); 
	   ps.setString(2, mail); 
	   ResultSet rs=ps.executeQuery(); 
	   while(rs.next()) { 
	    s=new Student(); 
	    s.setId(rs.getInt("id")); 
	    s.setName(rs.getString("name")); 
	    s.setPhone(rs.getLong("phone")); 
	    s.setMail(rs.getString("mail")); 
	    s.setBranch(rs.getString("branch")); 
	    s.setLoc(rs.getString("location")); 
	    s.setPassword(rs.getString("password")); 
	    s.setDate(rs.getString("date")); 
	   } 
	  } catch (SQLException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	  return s; 
	 } 
	 
	 @Override 
	 public ArrayList<Student> getStudent() { 
	  PreparedStatement ps=null; 
	  ArrayList<Student> studentsList=new ArrayList<Student>(); 
	  Student s=null; 
	  String query="SELECT * FROM STUDENT WHERE ID!=1"; 
	  try {
	   ps=con.prepareStatement(query); 
	   ResultSet rs=ps.executeQuery(); 
	   while(rs.next()) { 
	    s=new Student(); 
	    s.setId(rs.getInt("id")); 
	    s.setName(rs.getString("name")); 
	    s.setPhone(rs.getLong("phone")); 
	    s.setMail(rs.getString("mail")); 
	    s.setBranch(rs.getString("branch")); 
	    s.setLoc(rs.getString("location")); 
	    s.setPassword(rs.getString("password")); 
	    s.setDate(rs.getString("date")); 
	    studentsList.add(s); 
	   } 
	    
	  } catch (SQLException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  }  
	  return studentsList; 
	 } 
	 
	 @Override 
	 public ArrayList<Student> getStudent(String name) { 
	  ArrayList<Student> students=new ArrayList<>(); 
	  Student s=null; 
	  PreparedStatement ps=null; 
	  String query="SELECT * FROM STUDENT WHERE NAME=?"; 
	  try { 
	   ps=con.prepareStatement(query); 
	   ps.setString(1,name); 
	   ResultSet rs=ps.executeQuery(); 
	   while(rs.next()) { 
	    s=new Student(); 
	    s.setId(rs.getInt("id")); 
	    s.setName(rs.getString("name")); 
	    s.setPhone(rs.getLong("phone")); 
	    s.setMail(rs.getString("mail")); 
	    s.setBranch(rs.getString("branch")); 
	    s.setLoc(rs.getString("location")); 
	    s.setPassword(rs.getString("password")); 
	    s.setDate(rs.getString("date")); 
	    students.add(s);      
	   } 
	  } catch (SQLException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	  return students; 
	 }
	 
	 @Override
	 public boolean updatePassword(String mail, String newPassword) {
	     String query = "UPDATE STUDENT SET PASSWORD = ? WHERE MAIL = ?";
	     try (PreparedStatement ps = con.prepareStatement(query)) {
	         ps.setString(1, newPassword);
	         ps.setString(2, mail);
	         int rows = ps.executeUpdate();
	         return rows > 0;
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return false;
	 }	 
	} 