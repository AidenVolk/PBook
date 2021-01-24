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
	PBookVO pbk 				= new PBookVO();
	ArrayList<PBookVO> pbList	= new ArrayList<>(); 
	
	public void selectAll() {
		pbv 	= new PBookView();
		pbsrv 	= new PBookService();
	
		pbv.selectAll(pbList);
		pbsrv.selectAll();
	}
	
	public int insertPBook() {
		pbsrv = new PBookService();
		pbk = new PBookVO();
		pbv = new PBookView();
		
		pbv.insertPBook_Mnm();
		pbk.setMnm(scanner.nextLine());
		pbv.insertPBooK_Name();
		pbk.setName(scanner.nextLine());
		pbv.insertPBooK_Num();
		pbk.setNum(scanner.nextLine());
		pbv.insertPBooK_Location();
		pbk.setLocation(scanner.nextLine());
		pbv.insertPBook_Group();
		pbk.setGpno(scanner.nextLine());
		
		
		int rowcnt = pbsrv.insertPBook(pbk);
		
		return rowcnt;
	}
	
	public int deletePBook() {
		pbsrv 	= new PBookService();
		pbk 	= new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbk);
		
		return rowcnt;
	}
	
	public int updatePBook() {
		pbsrv = new PBookService();
		pbv = new PBookView();
		
		int rowcnt = pbsrv.updatePBook(pbk);
		
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
		pbv.printMenu();
	}
	
	public void startMenu() {
		pbv.startMenu();
	}
	public void startMenu_one() {
		pbv.startMenu_one();
	}
	public void startMenu_two() {
		pbv.startMenu_two();
	}
	public void startMenu_three() {
		pbv.startMenu_three();
	}
	public void startMenu_four() {
		pbv.startMenu_four();
	}
	public void startMenu_five() {
		pbv.startMenu_five();
	}
	public void printError() {
		pbv.printError();
	}
	
	
	
	public static void main(String[] args) {
		PBookController pbcon = new PBookController();
		pbcon.scanner = new Scanner(System.in);

		pbcon.printMenu();	
		pbcon.startMenu();
		pbcon.scanner.nextLine();
		while(true) {
			if(pbcon.scanner.nextLine() == "1") {
				pbcon.startMenu_one();
			}else if(pbcon.scanner.nextLine() == "2") {
				pbcon.startMenu_two();
			}else if(pbcon.scanner.nextLine() == "3") {
				pbcon.startMenu_three();
			}else if(pbcon.scanner.nextLine() == "4") {
				pbcon.startMenu_four();
			}else if(pbcon.scanner.nextLine() == "5") {
				pbcon.startMenu_five();
			}else {
				pbcon.printError();
			}
			
		}
	
	}
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