package service;

import java.util.ArrayList;
import java.util.Scanner;

import controller.PBookController;
import dao.PBookDao;
import vo.PBookVO;


public class PBookService { // Controller class 와 Dao의 중간다리 역할 class
	private Scanner scanner 	= new Scanner(System.in);
	PBookDao pbdao 				= new PBookDao();
	ArrayList<PBookVO> pbList 	= new ArrayList<>();
	PBookVO pbvo 				= new PBookVO();
	int rowcnt					= 0;
	
	public ArrayList<PBookVO> selectAll() { //전체 사원 출력
		pbdao 	= new PBookDao();
		pbList 	= new ArrayList<>();
		
		ArrayList<PBookVO> pbList = pbdao.selectAll();
		
		if(pbList.size() == 0) { // 0개의 연락처가 저장되어있을 떄.
			System.out.println();
			System.out.println("총 " + pbList.size() + "개 의 연락처가 있습니다 메인 메뉴 화면으로 돌아갑니다.");
			System.out.println();
			printMenu();
		}else{ // 1개 이상의 연락처가 있을 때 모든 연락처 출력 
			System.out.println();
			System.out.println("총 " + pbList.size() + "개 의 연락처가 있습니다.");
			System.out.println();
			for(int i = 0; i < pbList.size(); i++) {
				System.out.println(pbList.get(i));
			}
		}
		return pbList;
	}	

	public int insertPBook() { // 정상 추가 되었을 때 1개 이상의 값을 return하는 rowcnt 생성
		pbvo 					= new PBookVO(); // 사용을 위한 메소드 안에서의 초기화
		PBookController pbcon 	= new PBookController(); //사용을 위한 메소드 안에서의 초기화
		String mnm 				= null; // 키보드로 입력 받는 값을 넣어줄 변수 생성 및 초기화
		String name 			= null; // 키보드로 입력 받는 값을 넣어줄 변수 생성 및 초기화
		String num 				= null; // 키보드로 입력 받는 값을 넣어줄 변수 생성 및 초기화
		String location 		= null; // 키보드로 입력 받는 값을 넣어줄 변수 생성 및 초기화
		String gpno 			= null; // 키보드로 입력 받는 값을 넣어줄 변수 생성 및 초기화
	
		while(true) { // 회원번호 입력
			pbcon.insertPBook_PrintMnm(); // 회원번호 입력용 멘트 출력
			mnm = scanner.nextLine(); // 값을 입력받아 mnm 변수에 값을 넣는다
			if(mnm.isEmpty()) { // 입력하지 않고 엔터를 쳤을 때 에러 메세지 출력
				pbcon.insertEmpty_Error();
				continue; // 다시 while 문으로 돌아가기
			}else if(mnm.equals("exit")) { // exit를 입력하면 메인메뉴로 탈출
				printMenu();
			}else { // 정상 입력일 경우 값 입력하고 while문 탈출
				pbvo.setMnm(mnm);
				break;
			}
		}
		while(true) { // 이름 입력
			pbcon.insertPBook_PrintName(); // 이름 입력용 멘트 출력
			name = scanner.nextLine(); // 키보드로 값을 입력 받아 name 변수에 넣는다
			if(name.isEmpty()) { // 아무것도 입력하지 않은 에러
				pbcon.insertEmpty_Error();
				continue; // while문 처음으로 돌아가기
			}else if(name.equals("exit")) { // exit 입력시 메뉴로 탈출
				printMenu();
			}else if(name.length() <= 1){ // 이름 자리수가 1자리 이하 입력시 에러
				pbcon.insertLessNum_Error(); 
				continue; //while문 처음으로 돌아가기
			}else { // 정상적인 값 입력, while문 탈출
				pbvo.setName(name);
				break;
			 }
		}
		while(true) { // 번호 입력
			pbcon.insertPBook_PrintNum(); // 번호입력 멘트 출력
			num = scanner.nextLine(); // 키보드로 값을 입력 받아 num이라는 변수에 넣는다
			if(num.isEmpty()) { // 아무것도 입력하지 않고 엔터 입력 시 에러 출력
				pbcon.insertEmpty_Error();
				continue; // while문 처음으로 돌아가기
			}else if(num.equals("exit")) { //exit 입력 시 메인 메뉴로 탈
				printMenu();
			}else if(num.length() != 10 && num.length() != 11){ // 자리 수가 10-11자리 수가 아니면 에러 출력
				pbcon.insertCountNum_Error();
				continue; // while문 처음으로 돌아가기
			}else { //정상값 입력, while문 탈출
				pbvo.setNum(num); 
				break;
			}
		}
		while(true) { // 주소 입력 sql에서 NOT NULL을 걸지 않았기 때문에 값이 없어도 무관
			pbcon.insertPBook_PrintLocation(); //주소를 입력하라는 멘트 출력
			location = scanner.nextLine(); // 키보드로 값을 받아 location 변수에 넣음
			if(location.equals("exit")) { // exit 입력시 메인 메뉴로 탈출
				printMenu();
			}else { // 정상적인 값일 시, while문 탈출
				pbvo.setLocation(location);
				break;
			}
		}
		while(true) { // 그룹 입력
			pbcon.insertPBook_PrintGroup(); //그룹 입력용 멘트 출력
			gpno = scanner.nextLine(); // 입력 받은 값을 gpno의 변수에 넣는다
			if(gpno.isEmpty()) { // 그룹선택을 하지 않았을 시 에러 출력
				pbcon.insertEmpty_Error();
				continue; // 다시 값을 입력받기 위해 while문 처음으로 돌아간다
			}else if(gpno.equals("exit")) { // exit라는 값을 입력 받을 시 메인 메뉴로 탈출
				printMenu();
			}else if(gpno.equals("1")) { // 입력 받은 값이 "1"과 같을 경우 값을 입력하고 while문 탈출
				pbvo.setGpno(gpno);
				break;
			}else if(gpno.equals("2")) { // 입력 받은 값이 "2"과 같을 경우 값을 입력하고 while문 탈출
				pbvo.setGpno(gpno);
				break;
			}else if(gpno.equals("3")) { // 입력 받은 값이 "3"과 같을 경우 값을 입력하고 while문 탈출
				pbvo.setGpno(gpno);
				break;
			}else { // 1,2,3 중 하나라를 택해야한다는 멘트를 출력하여 3개중 하나의 값을 받는다
				pbcon.insertGroup_Error();
			}
		}
				
		int rowcnt = pbdao.insertPBook(pbvo);  

		
		return rowcnt;
		
	}


	public int deletePBook() {
		PBookController pbcon = new PBookController();
		String kb = null;
		
		selectAll();
		pbcon.deletePBook_PrintSearchMnm();
		kb = scanner.nextLine();
		
		int rowcnt = pbdao.deletePBook(kb);
		
		return rowcnt;
	}

	public int updatePBook() {
		PBookController pbcon = new PBookController();
		String kb = null;
		
		selectAll();
		pbcon.updatePBook_PrintSearchMnm();
		kb = scanner.nextLine();
		
		int rowcnt = pbdao.deletePBook(kb);
		if(rowcnt > 0) {
			insertPBook();
		}else {
			updatePBook();
		}
		
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
		pbList = pbdao.selectByName(name);
		
		name = scanner.nextLine();
		pbList = selectByName(name);
		
		return pbList;
	}
	
}
//public int deletePBooK_Result() {
//int rowcnt = pbdao.deletePBook(pbvo);
//
//return rowcnt;
//
//}
	

