package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-collection.xml")
public class SpringIocCollectionTest {
	
	@Resource(name = "collectingBean")
	IocCollection ic;

	@Test
	public void springIocCollectionTest() {
		/***Given***/
		List<String> list = ic.getList();
		Map<String, String> map = ic.getMap();
		Set<String> set = ic.getSet();
		Properties properties = ic.getProperties();
		/***When***/

		/***Then***/
		assertNotNull(ic);
		assertNotNull(list);
		assertNotNull(map);
		assertNotNull(set);
		assertNotNull(properties);
		assertEquals(3, list.size());
		assertEquals(2, map.size());
		assertEquals(3, set.size());
		assertEquals(2, properties.size());
		assertEquals("brown", list.get(0));
		assertEquals("brown", map.get("name"));
		assertEquals(true, set.contains("brown"));
		assertTrue(set.contains("cony"));
		assertEquals("brown", properties.get("userId"));
	}

}
