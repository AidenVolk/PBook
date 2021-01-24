package controller;

import java.util.ArrayList;
import java.util.Scanner;


import service.PBookService;
import view.PBookView;
import vo.PBookVO;



public class PBookController { // PBooK에 최상위 class
	private Scanner scanner 	= new Scanner(System.in);
	PBookService pbsrv 			= new PBookService();
	PBookView pbv 				= new PBookView();
	PBookVO pbvo 				= new PBookVO();
	ArrayList<PBookVO> pbList	= new ArrayList<>(); 
	
	public void selectAll() {
		pbv 	= new PBookView();
		pbsrv 	= new PBookService();
	
		pbv.selectAll(pbList);
		pbsrv.selectAll();
	}
	
	public int insertPBook() {
		pbsrv 			= new PBookService();
		pbvo 			= new PBookVO();
		pbv 			= new PBookView();
		String mnm 		= null;
		String name 	= null;
		String num 		= null;
		String location = null;
		String gpno 	= null;
	
		while(true) { // 회원번호 입력
			pbv.insertPBook_Mnm();
			mnm = scanner.nextLine();
			if(mnm.isEmpty()) {
				pbv.insertEmpty_Error();
				continue;
			}else if(mnm.equals("exit")) {
				printMenu();
			}else {
				pbvo.setMnm(mnm);
				break;
			}
		}
		while(true) { // 이름 입력
			pbv.insertPBooK_Name();
			name = scanner.nextLine();
			if(name.isEmpty()) { // 아무것도 입력하지 않은 에러
				pbv.insertEmpty_Error();
				continue;
			}else if(name.equals("exit")) { // exit 입력시 메뉴로 탈출
				printMenu();
			}else if(name.length() <= 1){ // 이름 자리수가 1자리 입력시 에러
				pbv.insertLessNum_Error();
				continue;
			}else {
				pbvo.setName(name);
				break;
			 }
		}
		while(true) { // 번호 입력
			pbv.insertPBooK_Num();
			num = scanner.nextLine();
			if(num.isEmpty()) {
				pbv.insertEmpty_Error();
				continue;
			}else if(num.equals("exit")) {
				printMenu();
				
			}else if(num.length() != 10 && num.length() != 11){
				pbv.insertCountNum_Error();
				continue;
			}else {
				pbvo.setNum(num);
				break;
			}
		}
		while(true) { // 주소 입력
			pbv.insertPBooK_Location();
			location = scanner.nextLine();
			if(location.isEmpty()) {
				pbv.insertEmpty_Error();
				continue;
			}else if(location.equals("exit")) {
				printMenu();
			}else {
				pbvo.setLocation(location);
				break;
			}
		}
		while(true) { // 그룹 입력
			pbv.insertPBook_Group();
			gpno = scanner.nextLine();
			if(gpno.isEmpty()) {
				pbv.insertEmpty_Error();
				continue;
			}else if(gpno.equals("exit")) {
				printMenu();
			}else {
				pbvo.setGpno(gpno);
				break;
			}
		}

		int rowcnt = pbsrv.insertPBook(pbvo);
		
		return rowcnt;
	}

	public void insertEmpty_Error() {
		pbv.insertEmpty_Error();
	}
	
	public int deletePBook() {
		pbsrv 	= new PBookService();
		pbvo 	= new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbvo);
		
		return rowcnt;
	}
	
	public int updatePBook() {
		pbsrv = new PBookService();
		pbv = new PBookView();
		
		int rowcnt = pbsrv.updatePBook(pbvo);
		
		return rowcnt;

	}
	
	public ArrayList<PBookVO> selectByName() {
		pbList = new ArrayList<>();
		pbsrv = new PBookService();
		String name = null;
		
		//view에서 검색할 이름 출력하도록 가져오기
		name = scanner.nextLine();
		pbList = pbsrv.selectByName(name);
		
		return pbList;
		
		
	}
	
	public void printMenu() {
		String kb = null;
		
		pbv.printMenu();
		startMenu();
		
		while(true) {
			kb = scanner.nextLine();
			
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
				printMenu_Error();
				continue;
			}
		}
	}
	
	public void startMenu() {
		pbv.startMenu();
	}

	public void printMenu_Error() {
		pbv.printMenu_Error();
	}
	public void exit() {
		pbv.exit();
	}
	public void nobody() {
		pbv.nobody();
	}

	
	
//	public static void main(String[] args) {
//		PBookController pbcon 	= new PBookController();
//		pbcon.scanner			= new Scanner(System.in);
//		String kb 				= null;
//		
//		
//		while(true) {
//			pbcon.printMenu();
//			pbcon.startMenu();
//			kb = pbcon.scanner.nextLine();
//			
//			if(kb.equals("1")) {
//				pbcon.insertPBook();
//				
//			}else if(kb.equals("2")) {
//				pbcon.selectAll();
//			}else if(kb.equals("3")) {
//				pbcon.updatePBook();
//			}else if(kb.equals("4")) {
//				pbcon.deletePBook();
//			}else if(kb.equals("5")) {
//				pbcon.exit();
//				break;
//			}else {
//				pbcon.printMenu_Error();
//				continue;
//			}
//		}
//		
//	}
}



//	public static void insertPBook() {
//----- 뷰
//		PBookVO pb = new PBookVO();
//		System.out.println("");
//		pb.setGpno("1");
//		System.out.println("");
//		pb.setName("편도훈");
//		System.out.println("");
//		pb.setLocation("성남");
//		System.out.println("");
//		pb.setNum("01087564576");
//		
//		int rowcnt =PBookService.insertPBook(pb);
//		
//		if(rowcnt > 0) {
//			System.out.println("정상적으로 추가되었습니다.");
//		}else {
//			System.out.println("정상적으로 추가되지 않았습니다.");
//		}
//----- 뷰
//	}