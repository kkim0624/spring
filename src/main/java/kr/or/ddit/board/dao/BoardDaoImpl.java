package kr.or.ddit.board.dao;

import org.springframework.stereotype.Repository;

// spring bean 이름 : 인트턴스 생성규칙 --> 클래스명에서 첫글자를 소문자로 : boardDaoImpl
// spring bean 이름을 임의로 주고싶은경우
@Repository("boardDao")
public class BoardDaoImpl implements IBoardDao {

	@Override
	public String sayHello() {
		return "boardDao sayHello";
	}

}
