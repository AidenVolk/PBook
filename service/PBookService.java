package service;

import java.util.ArrayList;

import dao.PBookDao;
import vo.PBookVO;


public class PBookService {
	public void selectAll() { //전체 사원 출력
		PBookDao pbDao = new PBookDao();
		ArrayList<PBookVO> pbList = pbDao.selectAll();
		for(int i = 0; i < pbList.size(); i++) {
			System.out.println(pbList.get(i));
		}
	}
}
