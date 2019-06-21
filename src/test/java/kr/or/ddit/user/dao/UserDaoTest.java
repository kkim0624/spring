package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestEnv {
	
	@Resource(name = "userDaoImpl")
	private IUserDao userDao;
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void userListTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> userList = userDao.userList();
		
		/***Then***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100);
		assertEquals(111, userList.size());
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() {
		/***Given***/
		// 사용자 정보를 담고 있는 vo객체 준비
		
//		public UserVo(String name, String userId, String alias, String pass,
//		String addr1, String addr2, String zipcd, Date birth) {
//}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		
		try {
			userVo = new UserVo("김경호", "kksddfsdf", "kkang", "kkh123", "궁동", "빌라", "1234", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
//		userDao.insertUser();
		int insertCnt = userDao.insertUser(userVo);
		
		/***Then***/
//		insertCnt(1);
		assertEquals(1, insertCnt);
				
		// data 삭제
		userDao.deleteUser(userVo.getUserId());
		
	}
	
	

}
