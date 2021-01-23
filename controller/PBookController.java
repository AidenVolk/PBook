package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.PBookService;
import view.PBookView;
import vo.PBookVO;



public class PBookController { // PBooK에 최상위 class
	private Scanner scanner = new Scanner(System.in);
	PBookService pbsrv 		= new PBookService();
	PBookView pbv 			= new PBookView();
	PBookVO pbk 			= new PBookVO();
	
	public void selectAll() {
		ArrayList<PBookVO> pbList =  pbsrv.selectAll();
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i));
		}
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
		pbsrv = new PBookService();
		PBookVO pbk = new PBookVO();
		
		int rowcnt = pbsrv.deletePBook(pbk);
		
		return rowcnt;
	}
	
	public int updatePBook() {
		pbsrv = new PBookService();
		pbv = new PBookView();
		
		int rowcnt = pbsrv.updatePBook(pbk);
		
		return rowcnt;

	}
	
	public void selectByName() {
		
	}
	
	public void printMenu() {
		
	}
	public static void main(String[] args) {

		
		
	
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