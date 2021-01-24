package service;

import java.util.ArrayList;

import dao.PBookDao;
import vo.PBookVO;


public class PBookService { // Controller class 와 Dao의 중간다리 역할 class
	PBookDao pbDao = new PBookDao();
	ArrayList<PBookVO> pbList = new ArrayList<>();
	
	
	public ArrayList<PBookVO> selectAll() { //전체 사원 출력
		pbDao 	= new PBookDao();
		pbList 	= new ArrayList<>();
		
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
	
	public void printMenu() {
		
	}
	
	
	public ArrayList<PBookVO> selectByName(String name) {
		
		pbList = pbDao.selectByName(name);
		
		return pbList;
	}
	
}
	
	

