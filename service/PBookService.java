package service;

import java.util.ArrayList;

import dao.PBookDao;
import vo.PBookVO;


public class PBookService {
	public ArrayList<PBookVO> selectAll() { //전체 사원 출력
		PBookDao pbDao = new PBookDao();
		ArrayList<PBookVO> pbList = pbDao.selectAll();
		return pbList;
		
	}
	public static int insertPBook(PBookVO pbk) {
//		pb.setMnm("1");
//		pb.setGpnm("가족");
		int rowcnt = PBookDao.insertPBook(pbk);
		
		return rowcnt;
	}

	public static int deletePBook(PBookVO pbk) {
		
		int rowcnt = PBookDao.deletePBook(pbk);
		
		return rowcnt;
	}
	
	public static int updatePBook(PBookVO pbk) {
		
		int rowcnt = PBookDao.updatePBook(pbk);
		
		return rowcnt;
	}
	
	
}
	
	

