package view;

import java.util.ArrayList;

import controller.PBookController;
import vo.PBookVO;

public class PBookView { // 화면 출력을 위한 class
	PBookVO pbvo 				= new PBookVO();
	ArrayList<PBookVO> pbList 	= new ArrayList<>(); 
	
	
	public void insertPBook_Result(int rowcnt) {
		pbvo 					= new PBookVO();
		
		if(rowcnt > 0) {
			System.out.println("추가가 완료되었습니다.");
		}else {
			System.out.println("추가 오류");
		}
		
	}
	public void deletePBook_Result(int rowcnt) {
		pbvo 					= new PBookVO();
		
		if(rowcnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("삭제 오류");
		}
	}
	public void updatePBook_Result(int rowcnt) {
		
		if(rowcnt > 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("수정 오류");
		}
	}
	
	public void selectAll(ArrayList<PBookVO> pbList) {
	
		System.out.println("전체 목록을 표시합니다");
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i));
		}
	}
	
	public void rightState(int rowcnt) {
			if(rowcnt > 0) {
				System.out.println("정상적으로 추가되었습니다.");
			}else {
				System.out.println("정상적으로 추가되지 않았습니다.");
			}
		}
		
	
	
}	

