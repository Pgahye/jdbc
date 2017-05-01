package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			 // 2. connection 하기
			
			String url="jdbc:mysql://localhost:3306/employees";
			conn= DriverManager.getConnection(url,"hr","hr");
			
			System.out.println("연결성공!!!");
			
			//3. statement 생성(확장성 용이)
			
			stmt=conn.createStatement();
			
			//4. sql문 실행 ; 콜론 붙이지 않기 
			
			String sql="select dept_no,dept_name from departments";
			 rs= stmt.executeQuery(sql); //select 는executeQuery, insert , updete 는  excuteupdate 
			
			
			
			// 5. fetch row를 하나씩 가져오기 
			
			while(rs.next()){
				
				String deptno= rs.getString(1);
				String deptName=rs.getString(2);
				
				System.out.println(deptno + ","+ deptName);
				
				
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver을 찾을수 없습니다. ");
		} //드라이버 로드
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("error: " +e);
		}finally{
			
			//자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다. 
			
			try {
				
					if(rs !=null){
						rs.close();
					}
					if(stmt !=null){
						stmt.close();
					}
					if(conn !=null){
						conn.close();
					}
					
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		

	}

}
