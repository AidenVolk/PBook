package view;

import java.util.ArrayList;

import controller.PBookController;
import service.PBookService;
import vo.PBookVO;

public class PBookView { // 화면 출력을 위한 class
	PBookVO pbvo 				= new PBookVO();
	PBookService pbsrv 			= new PBookService();
	ArrayList<PBookVO> pbList 	= new ArrayList<>(); 
	
	
	public void insertPBook_result() {
		pbvo = new PBookVO();
		
		int rowcnt = pbsrv.insertPBook(pbvo);
		
		if(rowcnt > 0) {
			System.out.println("추가가 완료되었습니다.");
		}else {
			System.out.println("추가 오류");
		}
	}
	
	
	
	public void insertPBook_Mnm() {
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
		System.out.println("그룹을 입력하세요 ");
		System.out.println("1. 가족");
		System.out.println("2. 친구");
		System.out.println("3. 기타");
		System.out.println("원하시는 그룹번호로 입력하세요(숫자입력필요)>>");
	}

	public void insertEmpty_Error(){
		System.out.println();
		System.out.println("입력된 값이 없습니다.");
		System.out.println();
	}
	public void insertLessNum_Error() {
		System.out.println();
		System.out.println("이름의 자리수가 너무 적습니다.");
		System.out.println();
	}
	public void insertCountNum_Error() {
		System.out.println();
		System.out.println("전화번호 자리수가 길거나 적습니다.(10-11자리 입력 필요)");
		System.out.println();
	}
	public void deletePBook_Result() {
		pbvo = new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbvo);
		
		if(rowcnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제 오류");
		}
	}
	
	public void updatePBook_result() {
		
		int rowcnt = pbsrv.updatePBook(pbvo);
		
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
	public void exit() {
		System.out.println("프로그램을 종료합니다");
		System.out.println();
	}
	public void printMenu_Error() {
		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요>>");
		System.out.println();
	}
	
	public void nobody() {
		System.out.println("현재 저장된 연락처가 없습니다.");
	}
	
	
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
}	

