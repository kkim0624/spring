package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDao;
	
	/** 
	 * Method   : userList
	 * 작성자 : PC04
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 전체 사용자 리스트 조회 
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	/** 
	 * Method   : insertUser
	 * 작성자 : PC04
	 * 변경이력 : 
	 * @param userVo
	 * @return 
	 * Method 설명 : 사용자 입력
	 */
	@Override
	public int insertUser(UserVo userVo) {
		int insertCnt = 0;
		//정상적으로 입력
		insertCnt += userDao.insertUser(userVo);
		
		//동일한데이터를 재입력 했으니까 => ORA-00001 (unique constraint)
		//insertCnt += userDao.insertUser(userVo);
		
		//첫번째 useDao.insertUser(userVo)에서 입력된 데이터도 rollback이 되어 있어야 한다
		return insertCnt;
	}

	/** 
	 * Method   : deleteUser
	 * 작성자 : PC04
	 * 변경이력 : 
	 * @param userId 
	 * Method 설명 : 사용자 삭제 
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	/** 
	 * Method   : getUser
	 * 작성자 : PC04
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : 사용자 정보 조회 
	 */
	@Override
	public UserVo getUser(String userId) {
		return userDao.getUser(userId);
	}
	
	/**
	 * 
	* Method : updateDataUser
	* 작성자 : PC04
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 업데이트
	 */
	@Override
	public int updateDateUser(UserVo userVo) {
		return userDao.updateDateUser(userVo);
	}
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		int usersCnt = userDao.usersCnt();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int encryptPassAllUser() {
		return 0;
	}
}
