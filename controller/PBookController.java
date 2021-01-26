package controller;



import service.PBookService;
import view.PBookView;



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
		System.out.println();
		System.out.println("원하시는 회원번호를 입력하세요(회원번호는 중복되지 않습니다)>> ");
		System.out.println();
	}
	public void insertPBook_PrintName() {
		System.out.println();
		System.out.println("이름을 입력하세요>> ");
		System.out.println();
	}
	public void insertPBook_PrintNum() {
		System.out.println();
		System.out.println("전화번호를 입력하세요>> ");
		System.out.println();
	}
	public void insertPBook_PrintLocation() {
		System.out.println();
		System.out.println("주소를 입력하세요>> ");
		System.out.println();
	}
	public void insertPBook_PrintGroup() {
		System.out.println();
		System.out.println("그룹을 입력하세요 ");
		System.out.println("1. 가족");
		System.out.println("2. 친구");
		System.out.println("3. 기타");
		System.out.println("원하시는 그룹번호로 입력하세요(숫자입력필요)>>");
		System.out.println();
	}
	
	public void insertEmpty_Error() {
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
	public void insertGroup_Error() {
		System.out.println();
		System.out.println("1,2,3 중 하나를 택해야합니다.");
		System.out.println();
	}

	public void start() {
	PBookService pbsrv = new PBookService();
	
	pbsrv.printMenu();
	}
	public void printMenu(){
	System.out.println(					 		 );
	System.out.println("-------------			");
	System.out.println("1. 회원추가    			");
	System.out.println("-------------			");
	System.out.println("2. 회원 목록				");
	System.out.println("-------------			");
	System.out.println("3. 연락처 수정    			");
	System.out.println("-------------			");
	System.out.println("4. 회원 삭제      			");
	System.out.println("-------------			");
	System.out.println("5. 프로그램 종료			");
	System.out.println("-------------			");
	System.out.println("원하시는 번호를 입력하세요(1-5)");
	System.out.println(							 );
}

	public void deletePBook_PrintSearchMnm() {
	System.out.println();
	System.out.println("삭제할 연락처의 회원번호를 입력해주세요.");
	System.out.println();
}
	public void updatePBook_PrintSearchMnm() {
	System.out.println();
	System.out.println("수정할 연락처의 회원번호를 입력해주세요.");
	System.out.println();
}

	public void printMenu_Error() {
	System.out.println();
	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요>>");
	System.out.println();
}
	public void exit() {
	System.out.println();
	System.out.println("프로그램을 종료합니다");
	System.out.println();
}
	public void nobody() {
	System.out.println();
	System.out.println("현재 저장된 연락처가 없습니다.");
	System.out.println();
}













	
//	public void insertPBook_Result(){
//		PBookService pbsrv = new PBookService();
//		PBookView pbv = new PBookView();
//		
//		int rowcnt = pbsrv.insertPBook();
//		
//		pbv.insertPBook_Result(rowcnt);
//		
//		
//	}
//	public void deletePBook_Result() {
//		PBookService pbsrv 	= new PBookService();
//		int rowcnt 			= pbsrv.deletePBook();
//
//		pbv.deletePBook_Result(rowcnt);
//
//	}
//public int updatePBook_result() {

	
//	public ArrayList<PBookVO> selectByName() {
//		pblist = new ArrayList<>();
//		pbsrv = new PBookService();
//		String name = null;
//		
//		//view에서 검색할 이름 출력하도록 가져오기
//		name = scanner.nextLine();
//		pbList = pbsrv.selectByName(name);
//		
//		return pbList;
//	}

	
	
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