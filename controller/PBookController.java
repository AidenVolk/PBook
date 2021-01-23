package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.PBookService;
import view.PBookView;
import vo.PBookVO;



public class PBookController {
	PBookService pbsrv = new PBookService();
	private Scanner scanner = new Scanner(System.in);
	PBookView pbview = new PBookView();
	
	public void selectAll() {
		ArrayList<PBookVO> pbList =  pbsrv.selectAll();
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i));
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
	public int insertPBook() {
		pbsrv = new PBookService();
		PBookVO pbk = new PBookVO();
		
		pbview.insertPBooK_Name();
		pbk.setName(scanner.nextLine());
		pbview.insertPBooK_Num();
		pbview.insertPBooK_Location();
		pbview.insertPBook_Group();
		
		PBookService pbsrv = new PBookService();
		PBookVO pbk = new PBookVO();
		
		int rowcnt = pbsrv.insertPBook(pbk);
		
		return rowcnt;
	}
	
	public int deletePBook() {
//		PBookService pbsrv = new PBookService();
		PBookVO pbk = new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbk);
		
		return rowcnt;
	}
	

	public static void main(String[] args) {
		PBookService pbsrv = new PBookService();
		
		
	
	}
}
