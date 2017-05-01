package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.AuthorVo;

public class AuthorDao {

	private Connection getConnection() throws SQLException {

		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// 2. connection 하기

			String url = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "dev", "dev");

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver을 찾을수 없습니다. ");

		} // 드라이버 로드
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
		}

		return conn;

	}

	public boolean insert(AuthorVo authorVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. statement 준비

			String sql = "insert into author values( null,? , ?)";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getBio());

			// 5. sql 실행

			int count = pstmt.executeUpdate(); // select 는executeQuery,
												// insert , updete 는
												// excuteupdate , update는
												// 갯수로 반환이 됨

			return (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);

			return false;
		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public List<AuthorVo> getList() {

		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			stmt = conn.createStatement();

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "select no, name, bio from author";
			rs = stmt.executeQuery(sql); // select 는executeQuery, insert ,
											// updete 는 excuteupdate

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {

				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String bio = rs.getString(3);

				AuthorVo authorVo = new AuthorVo();
				authorVo.setNo(no);
				authorVo.setName(name);
				authorVo.setBio(bio);

				list.add(authorVo);

			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return list;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
	}

	public AuthorVo get(Long no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		AuthorVo authorVo = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "select no, name, bio from author where no=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			// 5. fetch row를 하나씩 가져오기

			while (rs.next()) {

				authorVo = new AuthorVo();

				authorVo.setNo(rs.getLong(1));
				authorVo.setName(rs.getString(2));
				authorVo.setBio(rs.getString(3));

			}

			return authorVo;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();
					return authorVo;
				}
				if (pstmt != null) {
					pstmt.close();
					return authorVo;
				}
				if (conn != null) {
					conn.close();
					return authorVo;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return authorVo;

	}

	public AuthorVo get(String name) {

		return null;

	}

	public boolean delete(Long no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		AuthorVo authorVo = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

	

			String sql = "delete from author where no=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setLong(1, no);
			
			// 4. sql문 실행 ; 콜론 붙이지 않기
			int count=pstmt.executeUpdate();
			return (count==1);

		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return false;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();

				}
				if (conn != null) {
					conn.close();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



	}

	public boolean update(AuthorVo authorVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			conn = getConnection();

			// 3. statement 생성(확장성 용이)

			// 4. sql문 실행 ; 콜론 붙이지 않기

			String sql = "update author set name=?, bio=? where no=?";
			pstmt = conn.prepareStatement(sql);// select 는executeQuery, insert ,
												// updete 는 excuteupdate

			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getBio());
			pstmt.setLong(3, authorVo.getNo());
			// 5. fetch row를 하나씩 가져오기

		
			int count = pstmt.executeUpdate(); // select 는executeQuery,
			// insert , updete 는
			// excuteupdate , update는
			// 갯수로 반환이 됨

			return (count == 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			return false;

		} finally {

			// 자원 정리 , 정상적으로 실행되지 않았을경우를 대비해서 finally에서 자원정리를 해준다.

			try {

				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();

				}
				if (conn != null) {
					conn.close();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



	}

}
