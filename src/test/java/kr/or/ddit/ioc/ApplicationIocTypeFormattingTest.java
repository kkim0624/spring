package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.typeConvert.model.FormattingVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")
public class ApplicationIocTypeFormattingTest {

	@Resource(name = "formattingVo")
	FormattingVo formattingVo;
	
	@Test
	public void formattingConversionServiceTest() {
		
		/***Given***/
		
		/***When***/
		Date reg_dt = formattingVo.getReg_dt();
		Date mod_dt = formattingVo.getMod_dt();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reg_str = sdf.format(reg_dt);
		String mod_str = sdf.format(mod_dt);
		
		/***Then***/
		assertEquals(reg_str, "2019-06-21");
		assertEquals(mod_str, "2019-06-21");
		assertEquals(6000, formattingVo.getNumber()); // "6,000" --> 6000
	}

}
