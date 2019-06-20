package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@Configuration
public class ApplicationIocConfig {

//	<!-- IBoardDao boardDao = new BoardDaoImpl(); -->
//	<bean id="boardDao" class="kr.or.ddit.board.dao.BoardDaoImpl"/>
	
	@Bean
	public BoardDaoImpl boardDao() {
		return new BoardDaoImpl();
	}
	
//	<bean id="boardServiceConstructor" class="kr.or.ddit.board.service.BoardServiceImpl">
//	<!-- constructor injection(생성자) -->
//	<constructor-arg ref="boardDao"/>
//	</bean>
	
	@Bean
	public BoardServiceImpl boardService() {
		BoardServiceImpl boardServie = new BoardServiceImpl();
		boardServie.setBoardDao(boardDao());
		return boardServie;
		
	}
	
}
