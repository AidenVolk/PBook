package controller;

import java.util.ArrayList;


import service.PBookService;
import view.PBookView;
import vo.PBookVO;



public class PBookController { // PBooK에 최상위 class
	PBookView pbv 	= new PBookView();
	
	public void selectAll() {
//		pbv 	= new PBookView();
//		pbsrv 	= new PBookService();
//	
//		pbv.selectAll(pbList);
//		pbsrv.selectAll();
	}
	
	public void insertPBook_PrintMnm() {
		pbv.insertPBook_Mnm();
	}
	public void insertPBook_PrintName() {
		pbv.insertPBooK_Name();
	}
	public void insertPBook_PrintNum() {
		pbv.insertPBooK_Num();
	}
	public void insertPBook_PrintLocation() {
		pbv.insertPBooK_Location();
	}
	public void insertPBook_PrintGroup() {
		pbv.insertPBook_Group();
	}
	
	public void insertPBook_EmptyError() {
		pbv.insertEmpty_Error();
	}
	public void insertEmpty_Error() {
		pbv.insertEmpty_Error();
	}
	public void insertLessNum_Error() {
		pbv.insertLessNum_Error();
	}
	public void insertCountNum_Error() {
		pbv.insertCountNum_Error();
	}
	
	
	public int insertPBook_result(){
		int rowcnt = pbv.insertPBook_result();
		
		return rowcnt;
	}
	
	public void insertPBook() {
		PBookService pbsrv = new PBookService();
		
		pbsrv.insertPBook();
	}
	
	public int inserPBook_Result() {
		PBookService pbsrv = new PBookService();
		
		int rowcnt = pbsrv.insertPBook_Result();
	
		return rowcnt;
	}
	
	
	public void deletePBook() {
		
	}
	
	public int deletePBook_reult() {
		PBookService pbsrv = new PBookService();
		
		int rowcnt = pbsrv.deletePBook_result();
		
		return rowcnt;
	}
	public void updatePBook() {
//		pbsrv = new PBookService();
//		pbv = new PBookView();
//		
//		int rowcnt = pbsrv.updatePBook(pbvo);
//		
//		return rowcnt;
	}
	
	public int updatePBook_result() {
		PBookService pbsrv = new PBookService();
		
		int rowcnt = pbsrv.updatePBook_result();
		
		return rowcnt;
	}
	public ArrayList<PBookVO> selectByName() {
//		pblist = new ArrayList<>();
//		pbsrv = new PBookService();
//		String name = null;
//		
//		//view에서 검색할 이름 출력하도록 가져오기
//		name = scanner.nextLine();
//		pbList = pbsrv.selectByName(name);
//		
//		return pbList;
//		
//		
	}
	
	public void printMenu(){
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
	public void start() {
		PBookService pbsrv = new PBookService();
		
		pbsrv.printMenu();
	}
	
	public void printMenu_Error() {
		pbv.printMenu_Error();
	}
	public void exit() {
		pbv.exit();
	}
	public void nobody() {
		pbv.nobody();
	}

	
	
//	public static void main(String[] args) {
//		PBookController pbcon 	= new PBookController();
//		pbcon.scanner			= new Scanner(System.in);
//		String kb 				= null;
//		
//		
//		while(true) {
//			pbcon.printMenu();
//			pbcon.startMenu();
//			kb = pbcon.scanner.nextLine();
//			
//			if(kb.equals("1")) {
//				pbcon.insertPBook();
//				
//			}else if(kb.equals("2")) {
//				pbcon.selectAll();
//			}else if(kb.equals("3")) {
//				pbcon.updatePBook();
//			}else if(kb.equals("4")) {
//				pbcon.deletePBook();
//			}else if(kb.equals("5")) {
//				pbcon.exit();
//				break;
//			}else {
//				pbcon.printMenu_Error();
//				continue;
//			}
//		}
//		
//	}
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