package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.PBookController;
import service.PBookService;
import vo.PBookVO;

public class PBookView { // 화면 출력을 위한 class
	PBookVO pbk 				= new PBookVO();
	PBookService pbsrv 			= new PBookService();
	ArrayList<PBookVO> pbList 	= new ArrayList<>(); 
	
	public void insertPBook_Mnm() {
		pbk = new PBookVO();
		pbsrv = new PBookService();
		System.out.println("원하시는 회원번호를 입력하세요(회원번호는 중복되지 않습니다)>> ");
	}
	public void insertPBooK_Name() {
		System.out.println("이름을 입력하세요>> ");
	}
	public void insertPBooK_Num() {
		System.out.println("번호를 입력하세요>> ");
	}
	public void insertPBooK_Location() {
		System.out.println("주소를 입력하세요>> ");
	}
	public void insertPBook_Group() {
		System.out.println("그룹을 입력하세요>> ");
	}
	
	public void deletePBook() {
		pbk = new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbk);
		
		if(rowcnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제 오류");
		}
	}
	
	public void updatePBook() {
		
		int rowcnt = pbsrv.updatePBook(pbk);
		
		if(rowcnt > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("수정 오류");
		}
	}
	
	public void selectByName() {
		PBookController pbcon = new PBookController();
		pbList = new ArrayList<>();
		ArrayList<PBookVO> pbList = pbcon.selectByName();
		System.out.println(pbList);
		
	}
	
	public void selectAll(ArrayList<PBookVO> pbList) {
	
		System.out.println("전체 목록을 표시합니다");
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i));
		}
	}
	
	public void printMenu() {
		System.out.println("-------------");
		System.out.println("1. 회원추가        ");
		System.out.println("-------------");
		System.out.println("2. 회원 목록       ");
		System.out.println("-------------");
		System.out.println("3. 연락처 수정    ");
		System.out.println("-------------");
		System.out.println("4. 회원 삭제       ");
		System.out.println("-------------");
		System.out.println("5. 프로그램 종료 ");
		System.out.println("-------------");
	}
	public void startMenu() {
		System.out.println("원하시는 번호를 입력하세요(1-5)");
	}
	public void startMenu_one() {
	
	}
	public void startMenu_two() {
	}
	public void startMenu_three() {
	}
	public void startMenu_four() {
	}
	public void startMenu_five() {
		System.out.println("프로그램을 종료합니다");
	}
	public void printError() {
		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요>>");
	}
	
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
}	

