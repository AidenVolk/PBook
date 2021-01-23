package service;

import java.util.ArrayList;

import dao.PBookDao;
import vo.PBookVO;


public class PBookService { // Controller class 와 Dao의 중간다리 역할 class
	PBookDao pbDao = new PBookDao();
	
	public ArrayList<PBookVO> selectAll() { //전체 사원 출력
		pbDao = new PBookDao();
		
		ArrayList<PBookVO> pbList = pbDao.selectAll();
		return pbList;
		
	}
	
	public int insertPBook(PBookVO pbk) {
//		pb.setMnm("1");
//		pb.setGpnm("가족");
		
		int rowcnt = pbDao.insertPBook(pbk);
		
		return rowcnt;
	}

	public int deletePBook(PBookVO pbk) {
		
		int rowcnt = pbDao.deletePBook(pbk);
		
		return rowcnt;
	}
	
	public int updatePBook(PBookVO pbk) {
		
		int rowcnt = pbDao.updatePBook(pbk);
		
		return rowcnt;
	}
	
	
	public String selectByName(String name) {
		
//		String sbn = pbDao.selectByName(); ///파라미터에 어떤 값을 넣어주어야할지 잘 모르곘음
		
		return name;
	}
	
}
	
	

