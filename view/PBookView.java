package view;

import java.util.Scanner;

import service.PBookService;
import vo.PBookVO;

public class PBookView {
	static Scanner scanner = new Scanner(System.in);
	PBookVO pbk = new PBookVO();
	
	public void insertPBook_Mnm() {
		pbk = new PBookVO();
		System.out.println("원하시는 회원번호를 입력하세요(회원번호는 중복되지 않습니다)>> ");
//		pbk.setMnm(scanner.nextLine());
//		pbk.setName(scanner.nextLine());
//		pbk.setNum(scanner.nextLine());
//		pbk.setLocation(scanner.nextLine());
		
		int rowcnt = PBookService.insertPBook(pbk);
		rightState(rowcnt);
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
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
	}	
}
