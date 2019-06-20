package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.IBoardDao;

@Service("boardService")
public class BoardServiceImpl implements IBoardService {

	// property or field
	@Resource(name = "boardDao")
	private IBoardDao boardDao;

	public BoardServiceImpl() {
		
	}
	
	public BoardServiceImpl(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public IBoardDao getBoardDao() {
		return boardDao;
	}
	
	public void setBoardDao(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public String sayHello() {
		return boardDao.sayHello();
	}
	
}
