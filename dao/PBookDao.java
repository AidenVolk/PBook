package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PBookVO;

public class PBookDao {
	private  Connection getConnection() { // 컨넥션을 만들기 위한 URL주소,ID/PW 저장 메소드
		Connection con 	= null;
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "ora_user";
		String pw 		= "hong";
		
		try { //URL,ID/PW 정상입력-> 로그인 성공 
			con = DriverManager.getConnection(url,user,pw);
			System.out.println();
			System.out.println("DB 로그인 성공");
			System.out.println();
		}catch(SQLException e) { // URL2,ID/PW 중 잘못 입력 또는 입력 오류로 인한 로그인 실패
			e.printStackTrace();
			System.out.println();
			System.out.println("DB 로그인 실패");
			System.out.println();
		}
		return con;
	}
	
	private  void close(Connection con, PreparedStatement pstmt, ResultSet rs) { // con,pstmt,rs 3가지 값이 파라미터로 입력된 경우의 닫기 
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
	
	private  void close(Connection con, PreparedStatement pstmt) { // con, pstmt 2가지 의 파라미터 값이 들어왔을 경우의 닫기.
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

	public  void printPBook(ArrayList<PBookVO> pbList) { //ArrayList를 파라 미터로 받았을 때의 안의 내용 출력
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
				PBookVO pbvo = new PBookVO();
				pbvo.setMnm(rs.getString("mnm"));
				pbvo.setName(rs.getString("name"));
				pbvo.setNum(rs.getString("num"));
				pbvo.setLocation(rs.getString("location"));
				pbvo.setGpno(rs.getString("gpno"));
				pbvo.setGpnm(rs.getString("gpnm"));
			
				pbList.add(pbvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return pbList;
	}
	
	public ArrayList<PBookVO> selectByName(String name) { // 이름  검색
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
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PBookVO pbvo = new PBookVO();
				pbvo.setName(rs.getString("name"));
				pbvo.setNum(rs.getString("num"));
				pbvo.setLocation(rs.getString("location"));
				pbvo.setGpno(rs.getString("gpno"));
				pbList.add(pbvo);
			}
			printPBook(pbList); 
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
		return pbList;
	}
		
	public  String selectByMnm(String mnm) { // 회원 번호 검색
		Connection con 				= getConnection();
		PreparedStatement pstmt 	= null;
		ResultSet rs 				= null;
		ArrayList<PBookVO> pbList 	= new ArrayList<>();
		PBookVO pbvo = new PBookVO();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f.mnm				");
		sql.append("  	 , f.name				");
		sql.append("  	 , f.num				");
		sql.append("	 , f.location			");
		sql.append("     , f.gpno				");
		sql.append("	 , p.gpnm				");
		sql.append("  FROM PBookf f				");
		sql.append("	 , PBOOkp p				");
		sql.append(" WHERE f.mnm = ?			"); 
		sql.append("   AND f.gpno = p.gpno		");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mnm);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pbvo.setMnm(rs.getString("mnm"));
				pbList.add(pbvo);
			}
			printPBook(pbList); 
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
			
		}
		
		return mnm;
	}
	
	public  int insertPBook(PBookVO pbvo) { // 신규연락처 추가
		Connection con 			= getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql 		= new StringBuilder();
		int rowcnt 				= 0;
			
		sql.append("INSERT INTO PBookf( mnm		");
		sql.append("	              , name	");
		sql.append("	              , num		");
		sql.append("	  			  , location");
		sql.append("	 			  , gpno)	");
		sql.append("VALUES ( ?					");
		sql.append("	   , ?					");
		sql.append("	   , ?					");	
		sql.append("	   , ?					");	
		sql.append("	   , ?)					");	
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbvo.getMnm());
			pstmt.setString(2, pbvo.getName());
			pstmt.setString(3, pbvo.getNum());
			pstmt.setString(4, pbvo.getLocation());
			pstmt.setString(5, pbvo.getGpno());
			rowcnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return rowcnt;
		
	}

	public  int deletePBook(String mnm) { //연락처 삭제
		Connection con 			= getConnection();
		PreparedStatement pstmt = null;
		int rowcnt 				= 0;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE PBookf					");
		sql.append("WHERE mnm = ?					");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mnm);
			rowcnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return rowcnt;
	}
			// where절과  value쓰기
	public  int updatePBook(PBookVO pbvo) { //연락처 수정
		
		Connection con 			= getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql 		= new StringBuilder();
		
		sql.append("UPDATE PBookf			");
		sql.append("   SET mnm				");
		sql.append("	 , name				");
		sql.append("	 , num				");
		sql.append("     , location			");
		sql.append("	 , gpno				");
		sql.append("VALUES ( ?				");
		sql.append("		,?				");
		sql.append("		,?				");
		sql.append("		,?				");
		sql.append("		,?)				");
		sql.append(" WHERE f.gpno = p.gpno	");
		sql.append("   AND f.mnm = ?	 	");
	
		int rowcnt = 0;
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pbvo.getMnm());
			pstmt.setString(2, pbvo.getName());
			pstmt.setString(3, pbvo.getNum());
			pstmt.setString(4, pbvo.getLocation());
			pstmt.setString(5, pbvo.getGpno());
			rowcnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return rowcnt;
	
	}
}
	

