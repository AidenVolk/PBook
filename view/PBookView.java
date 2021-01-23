package view;

import java.util.Scanner;

import service.PBookService;
import vo.PBookVO;

public class PBookView { // 화면 출력을 위한 class
	PBookVO pbk = new PBookVO();
	PBookService pbsrv = new PBookService();
	
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
			System.out.println("삭제가 완료되지 않았습니다.");
		}
	}
	
	public void updatePBook() {
		
		int rowcnt = pbsrv.updatePBook(pbk);
		
		if(rowcnt > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("정상적으로 수정되지 않았습니다.");
		}
	}
	
	public void selectByName() {
		
	}
	
	
	
	
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
}	

