package view;

import java.util.ArrayList;

import controller.PBookController;
import vo.PBookVO;

public class PBookView { // 화면 출력을 위한 class
	PBookVO pbvo 				= new PBookVO();
	ArrayList<PBookVO> pbList 	= new ArrayList<>(); 
	
	
	public void insertPBook_Result() {
		pbvo 					= new PBookVO();
		PBookController pbcon 	= new PBookController();
		
		int rowcnt = pbcon.insertPBook();
		
		if(rowcnt > 0) {
			System.out.println("추가가 완료되었습니다.");
		}else {
			System.out.println("추가 오류");
		}
		
	}
	public void deletePBook_Result() {
		pbvo 					= new PBookVO();
		PBookController pbcon  	= new PBookController();
		
		int rowcnt = pbcon.deletePBook_Result();
		
		if(rowcnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제 오류");
		}
	}
	
	public void updatePBook_result() {
		PBookController pbcon  = new PBookController();
		
		int rowcnt = pbcon.updatePBook_result();
		
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
		System.out.println("원하시는 번호를 입력하세요(1-5)");
	}
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
}	

