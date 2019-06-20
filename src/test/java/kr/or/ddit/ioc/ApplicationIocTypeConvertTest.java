package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-convert.xml")
public class ApplicationIocTypeConvertTest {
	
	// UserVo라는 이름의 스프링 빈이 정상적으로 생성되었는지 확인
	@Resource(name = "userVo")
	private UserVo userVo;
	
	
	@Test
	public void typeInjectionTest() {
		/***Given***/
		
		/***When***/
		Date birth = userVo.getBirth();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birth_str = sdf.format(birth);
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals(birth_str, "2019-08-08");
	}
	
	// customProperty editor와 conversionService를 동시에 적용하면 뭐가 적용 될까?
	// 1. 에러가 날거 같다.
	// 2. customProperty editor 적용이 됐다면 우리가 알수 있는 방법?
	// 3. 
	
}
