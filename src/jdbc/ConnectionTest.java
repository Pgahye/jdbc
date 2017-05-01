package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			 // 2. connection 하기
			
			String url="jdbc:mysql://localhost:3306/employees";
			Connection conn= DriverManager.getConnection(url,"hr","hr");
			
			System.out.println("연결성공!!!");
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver을 찾을수 없습니다. ");
		} //드라이버 로드
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("error: " +e);
			}
	}

}
