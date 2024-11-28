package jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Studentdb {
	private static Connection connection=null;
	private static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		
		Studentdb st=new Studentdb();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/jdbc";
			String username="root";
			String pass="@Run4277";
			connection=DriverManager.getConnection(dburl,username,pass);
			System.out.println("Connection Successful!");
			System.out.println("1.Insert");
			System.out.println("2.select");
			System.out.println("3.update");
			System.out.println("4.delete");
			System.out.println("5.Transaction");
			System.out.println("6.Batch");
		}
		catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
		}
//		finally {
//        	try {
//        		if(connection!=null&& !connection.isClosed()) {
//        			connection.close();
//        			System.out.println("connection closed");
//        		}
//        	}catch(Exception e) {
//        		System.out.println("Error closing connection");}
//		}
		int boi=sc.nextInt();
		switch(boi) {
		case 1:
			st.insert();
			break;
		case 2:
			st.select();
			break;
		case 3:
			st.update();
		case 4:
			st.delete();
		case 5:
			st.transaction();
		case 6:
			st.batch();
		default:
			break;	
		}
		
	}
	private void insert() throws SQLException{
		System.out.println("Insert name");
		System.out.println("enter name");
		String name=sc.nextLine();
		System.out.println("enter age");
		int age=sc.nextInt();
		String sql="insert into student(name, age) values(?,?);";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, age);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Records inerted successfully");
		}
	}
	private void select() throws SQLException{
		System.out.println("enter the number to be found");
		int num=sc.nextInt();
		String sql="select * from student where Rollno="+num;
		Statement stt=connection.createStatement();
		ResultSet res=stt.executeQuery(sql);
		if(!res.next()) {
			System.out.println("No records found");
		}
		else {
			int roll=res.getInt("Rollno");
			do {
			String name=res.getString("name");
			int age=res.getInt("age");
			System.out.println(roll);
			System.out.println(name);
			System.out.println(age);
			}
			while(res.next());
		}
	}
//	private void selectall() throws SQLException{
//		CallableStatement cb=connection.prepareCall("{call get_all}");
//		ResultSet res=cb.executeQuery();
//		
//		
//	}
	private void update() throws SQLException{
		System.out.println("update record");
		int roll=sc.nextInt();
		String sql="select * from student where rollno="+roll;
		Statement stt=connection.createStatement();
		ResultSet res=stt.executeQuery(sql);
		if(res.next()) {
			int rolll=res.getInt("Rollno");
			String name=res.getString("name");
			int age=res.getInt("age");
			System.out.println(rolll);
			System.out.println(name);
			System.out.println(age);
			System.out.println("What to be updated");
			System.out.println("1.name");
			System.out.println("2.age");
			String ssql="update student set ";
			int choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("name to be updated");
				System.out.println("enter new name");
				sc.nextLine();
				String neww=sc.nextLine();
				ssql=ssql+"name=? where rollno="+rolll;
				PreparedStatement ps=connection.prepareStatement(ssql);
				ps.setString(1,neww);
				int rows=ps.executeUpdate();
				if(rows>0) {
					System.out.println("records updated ");
				}
				break;
			case 2:
				System.out.println("age to be updated");
				System.out.println("enter new age");
				int num=sc.nextInt();
				ssql=ssql+"age=? where rollno="+rolll;
				PreparedStatement pps=connection.prepareStatement(ssql);
				pps.setInt(1, num);
				int rowss=pps.executeUpdate();
				if(rowss>0) {
					System.out.println("records updated");
				}
				break;
		}	
	}
}
	private void delete() throws SQLException{
		System.out.println("delete the record");
		int roll=sc.nextInt();
		String sql="delete from student where rollno="+roll;
		Statement st=connection.createStatement();
		int rows=st.executeUpdate(sql);
		if(rows>0) {
			System.out.println("deleted migga");
		}
	}
	private void transaction() throws SQLException{
		connection.setAutoCommit(false);
		String sql1="insert into student (name,age) values('vishva',100)";
		String sql2="insert into student (name,age) values('mufasa',11@##@!0)";
		PreparedStatement ps=connection.prepareStatement(sql1);
		ps=connection.prepareStatement(sql2);
		int roww=ps.executeUpdate();
		int row=ps.executeUpdate();
		if(row>0 && roww>0) {
			connection.commit();
			System.out.println("Success");
		}
		else {
			connection.rollback();
		}
	}
	private void batch() throws SQLException{
		connection.setAutoCommit(false);
		String sql1="insert into student (name,age) values('mustafa',200)";
		String sql2="insert into student (name,age) values('girish',1000)";
		String sql3="insert into student (name,age) values('mathi',0)";
		String sql4="insert into student (name,age) values('nigga',100)";
		String sql5="insert into student (name,age) values('whigga',100)";
		String sql6="delete from student where rollno=7";
		Statement st=connection.createStatement();
		st.addBatch(sql1);
		st.addBatch(sql2);
		st.addBatch(sql3);
		st.addBatch(sql4);
		st.addBatch(sql5);
		st.addBatch(sql6);
		int [] rows=st.executeBatch();
		for(int i:rows) {
			if(i>0) {
				continue;
			}else {
				connection.rollback();
				System.out.println("failed");
				connection.commit();
			}
		}
	}
}

