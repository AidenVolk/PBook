package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PBookVO;

public class PBookDao {
	private static Connection getConnection() {		// 컨넥션을 만들기 위한 URL주소,ID/PW 저장 메소드
		Connection con 	= null;
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "ora_user";
		String pw 		= "hong";
		
		try { //URL,ID/PW 정상입력-> 로그인 성공 
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("로그인 성공");
		}catch(SQLException e) { // url,ID/PW 중 잘못 입력 또는 입력 오류로 인한 로그인 실패
			e.printStackTrace();
			System.out.println("로그인 실패");
		}
		return con;
	}
	
	private static void close(Connection con, PreparedStatement pstmt, ResultSet rs) { // con,pstmt,rs 3가지 값이 파라미터로 입력된 경우의 닫기 
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
	
	private static void close(Connection con, PreparedStatement pstmt) { // con, pstmt 2가지 의 파라미터 값이 들어왔을 경우의 닫기.
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

	public static void printPBook(ArrayList<PBookVO> pbList) { //ArrayList를 파라 미터로 받았을 때의 안의 내용 출력
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i).toString()); //VO에 toString을 정의 해놓았기 때문에 VO.toString()의 형식대로 출력
		}
		
	}
	
    
	public ArrayList<PBookVO> selectAll(){ // 연락처 목록 출력
		ArrayList<PBookVO> pbList 	= new ArrayList<>();
		Connection con 				= getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
	
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.mnm					");
		sql.append("	 , f.name					");
		sql.append("	 , f.num					");
		sql.append("	 , f.location				");
		sql.append("	 , f.gpno					");
		sql.append("	 , p.gpnm					"); 
		sql.append("  FROM PBookf f					");
		sql.append("	 , PBookp p					");	
		sql.append(" WHERE f.gpno = p.gpno			");
	
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBookVO pbk = new PBookVO();
				pbk.setMnm(rs.getString("mnm"));
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
	
	public static void selectByName(String name) { // 이름  검색
		Connection con 				= getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
		ArrayList<PBookVO> pbList 	= new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.mnm				");
		sql.append("  	 , f.name				");
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
				PBookVO pbk = new PBookVO();
				pbk.setName(rs.getString("name"));
				pbk.setNum(rs.getString("num"));
				pbk.setLocation(rs.getString("location"));
				pbk.setGpno(rs.getString("gpno"));
				pbk.setGpnm(rs.getString("gpnm"));
				pbList.add(pbk);
			}
			printPBook(pbList); 
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
	}
		
	public static void selectByMnm(String mnm) {
		Connection con 				= getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
		ArrayList<PBookVO> pbList 	= new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.mnm				");
		sql.append("  	 , f.name				");
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
			pstmt.setString(1, mnm);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBookVO pbk = new PBookVO();
				pbk.setMnm(rs.getString("mnm"));
				pbk.setName(rs.getString("name"));
				pbk.setNum(rs.getString("num"));
				pbk.setLocation(rs.getString("location"));
				pbk.setGpno(rs.getString("gpno"));
				pbk.setGpnm(rs.getString("gpnm"));
				pbList.add(pbk);
			}
			printPBook(pbList); 
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
	}
	
	public static void insertPBook(PBookVO pbk) { // 신규연락처 추가
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO PBookp(name"
								  + ", num"
								  + ", location"
								  + ", gpno)		");
		sql.append("			VALUES(?"
								   + ",?"
								   + ",?"
								   + ",?)			");
		
		int rowcnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbk.getMnm());
			pstmt.setString(2, pbk.getName());
			pstmt.setString(3, pbk.getNum());
			pstmt.setString(4, pbk.getLocation());
			pstmt.setString(5, pbk.getGpno());
			rowcnt = pstmt.executeUpdate();
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
	}

	public static void deletePBook(PBookVO pbk) { //연락처 삭제
		Connection con 			= getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
		
//		sql.append("DELETE PBookf (name"
//				  + ", num"
//				  + ", location"
//				  + ", gpno)		");
//		sql.append("	VALUES(?"
//				   + ",?"
//				   + ",?"
//				   + ",?)			");
		
		sql.append("DELETE PBookf					");
		sql.append("WHERE mnm = ?					");
		
		
		int rowcnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbk.getMnm());
			rowcnt = pstmt.executeUpdate();
			
			if(rowcnt > 0) {
				System.out.println("삭제가 완료되었습니다.");
			}else {
				System.out.println("삭제가 완료되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
	}
			
	
	public static void updatePBook(PBookVO pbk) { //연락처 수정
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE PBookf			");
		sql.append("SET	   name				");
		sql.append("	 , num				");
		sql.append("     , location			");
		sql.append("	 , gpno				");
		sql.append(";						");
	
		int rowcnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbk.getName());
			pstmt.setString(2, pbk.getNum());
			pstmt.setString(3, pbk.getLocation());
			pstmt.setString(4, pbk.getGpno());
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
	

