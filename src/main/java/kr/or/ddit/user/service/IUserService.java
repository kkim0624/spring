package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IUserService {

	/**
	 * 
	* Method : userList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	List<UserVo> userList();
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC04
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	 */
	int insertUser(UserVo userVo);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC04
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC04
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVo getUser(String userId);
}
