package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PBookVO;

public class PBookDao {
	private static Connection getConnection() {
		Connection con 	= null;
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "ora_user";
		String pw 		= "hong";
		
		try {
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("로그인 성공");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
		}
		return con;
	}
	
	private static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printPBook(ArrayList<PBookVO> pbList) {
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i).toString());
		}
		
	}
	
    // 전화번호 목록 출력
	private ArrayList<PBookVO> selectAll(){
		ArrayList<PBookVO> pbList 	= new ArrayList<>();
		Connection con 				= getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.name					");
		sql.append("	 , p.num					");
		sql.append("	 , p.location				");
		sql.append("	 , p.gpno					");
		sql.append("	 , f.gpnm					"); //// 수정요망
		sql.append("  FROM PBookp p					");
		sql.append("	 , PBookf f					");	
		sql.append(" WHERE p.gpno = f.gpno			");
	
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBookVO pbk = new PBookVO();
				pbk.setName(rs.getString("name"));
				pbk.setNum(rs.getString("num"));
				pbk.setLocation(rs.getString("location"));
				pbk.setGpno(rs.getString("gpno"));
				pbk.setGpnm(rs.getString("gpnm"));
			
				pbList.add(pbk);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return pbList;
	}
	
	// 이름 검색
	public static void selectByName(String name) {
		Connection con 			= getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		ArrayList<PBookVO> pbList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.name				");
		sql.append("  	 , f.num				");
		sql.append("	 , f.location			");
		sql.append("     , f.gpno				");
		sql.append("	 , p.gpnm				");
		sql.append("  FROM PBookf f				");
		sql.append("	 , PBOOkp p				");
		sql.append(" WHERE f.name = ?			"); 
		sql.append("   AND f.gpno = p.gpno		");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBookVO emp = new PBookVO();
				emp.setName(rs.getString("name"));
				emp.setNum(rs.getString("num"));
				emp.setLocation(rs.getString("location"));
				emp.setGpno(rs.getString("gpno"));
				emp.setGpnm(rs.getString("gpnm"));
				pbList.add(emp);
			}
			printPBook(pbList); // 화면 출력
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
	}
		
	
	// 전화번호부 추가
	public static void insertPBook(PBookVO pbk) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PBookp(name, num, location, gpno)	");
		sql.append("			VALUES(?,?,?,?)						");
		
		int rowcnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbk.getName());
			pstmt.setString(2, pbk.getNum());
			pstmt.setString(3, pbk.getLocation());
			pstmt.setString(3, pbk.getGpno());
			rowcnt = pstmt.executeUpdate();
			if(rowcnt > 0) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("정상적으로 수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
	}
}
	
	
	
	

