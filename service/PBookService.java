package service;

import java.util.ArrayList;
import java.util.Scanner;

import controller.PBookController;
import dao.PBookDao;
import view.PBookView;
import vo.PBookVO;


public class PBookService { // Controller class 와 Dao의 중간다리 역할 class
	private Scanner scanner = new Scanner(System.in);
	PBookDao pbdao = new PBookDao();
	
	ArrayList<PBookVO> pblist = new ArrayList<>();
	PBookVO pbvo = new PBookVO();
	
	public ArrayList<PBookVO> selectAll() { //전체 사원 출력
		pbdao 	= new PBookDao();
		pblist 	= new ArrayList<>();
		
		ArrayList<PBookVO> pbList = pbdao.selectAll();
		return pbList;
		
	}
	

	public int insertPBook() {
		pbvo 					= new PBookVO();
		PBookController pbcon 	= new PBookController();
		String mnm 				= null;
		String name 			= null;
		String num 				= null;
		String location 		= null;
		String gpno 			= null;
	
		while(true) { // 회원번호 입력
			pbcon.insertPBook_PrintMnm();
			mnm = scanner.nextLine();
			if(mnm.isEmpty()) {
				pbcon.insertEmpty_Error();
				continue;
			}else if(mnm.equals("exit")) {
				printMenu();
			}else {
				pbvo.setMnm(mnm);
				break;
			}
		}
		while(true) { // 이름 입력
			pbcon.insertPBook_PrintName();
			name = scanner.nextLine();
			if(name.isEmpty()) { // 아무것도 입력하지 않은 에러
				pbcon.insertEmpty_Error();
				continue;
			}else if(name.equals("exit")) { // exit 입력시 메뉴로 탈출
				printMenu();
			}else if(name.length() <= 1){ // 이름 자리수가 1자리 입력시 에러
				pbcon.insertLessNum_Error();
				continue;
			}else {
				pbvo.setName(name);
				break;
			 }
		}
		while(true) { // 번호 입력
			pbcon.insertPBook_PrintNum();
			num = scanner.nextLine();
			if(num.isEmpty()) {
				pbcon.insertEmpty_Error();
				continue;
			}else if(num.equals("exit")) {
				printMenu();
				
			}else if(num.length() != 10 && num.length() != 11){
				pbcon.insertCountNum_Error();
				continue;
			}else {
				pbvo.setNum(num);
				break;
			}
		}
		while(true) { // 주소 입력
			pbcon.insertPBook_PrintLocation();
			location = scanner.nextLine();
			if(location.isEmpty()) {
				pbcon.insertEmpty_Error();
				continue;
			}else if(location.equals("exit")) {
				printMenu();
			}else {
				pbvo.setLocation(location);
				break;
			}
		}
		while(true) { // 그룹 입력
			pbcon.insertPBook_PrintGroup();
			gpno = scanner.nextLine();
			if(gpno.isEmpty()) {
				pbcon.insertEmpty_Error();
				continue;
			}else if(gpno.equals("exit")) {
				printMenu();
			}else {
				pbvo.setGpno(gpno);
				break;
			}
		}
		int rowcnt = pbdao.insertPBook(pbvo);
		
		return rowcnt;
	}

	public int insertPBook_Result() {
		
		int rowcnt = pbdao.insertPBook(pbvo);
		
		return rowcnt;
	}
	
	public int deletePBook() {
		
		int rowcnt = pbdao.deletePBook(pbvo);
		
		return rowcnt;
	}
	
	public int deletePBook_result() {
		int rowcnt = pbdao.deletePBook(pbvo);
		
		return rowcnt;
	}
	
	public int updatePBook() {
		
		int rowcnt = pbdao.updatePBook(pbvo);
		
		return rowcnt;
	}
	
	public int updatePBook_result() {
		int rowcnt = pbdao.updatePBook(pbvo);
		
		return rowcnt;
	}
	
	public void printMenu() {
		PBookController pbcon = new PBookController();
		
		while(true) {
			pbcon.printMenu();
			String kb = scanner.nextLine();
			
			if(kb.equals("1")) {
				insertPBook();
			}else if(kb.equals("2")) {
				selectAll();
			}else if(kb.equals("3")) {
				updatePBook();
			}else if(kb.equals("4")) {
				deletePBook();
			}else if(kb.equals("5")) {
				exit();
				break;
			}else {
				pbcon.printMenu_Error();
				continue;
			}
		}
	}
	
	public void exit() {
		PBookController pbcon = new PBookController();
		
		pbcon.exit();
	}
	

	
	public ArrayList<PBookVO> selectByName(String name) {
//		pblist = pbdao.selectByName(name);
		pblist = new ArrayList<>();

//		String name = null;
		
		//view에서 검색할 이름 출력하도록 가져오기
		name = scanner.nextLine();
//		pbList = pbsrv.selectByName(name);
		
		
		
		
		return pblist;
		
		
	}
	
}
	
	

