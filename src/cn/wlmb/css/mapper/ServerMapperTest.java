package cn.wlmb.css.mapper;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wlmb.css.po.Server;

public class ServerMapperTest {

	private ClassPathXmlApplicationContext applicationContext;
	private ServerMapper serverMapper;

	@Before
	public void setup() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		serverMapper = (ServerMapper) applicationContext.getBean("serverMapper");
	}
	
	@Test
	public void testInsert() {
		Server server = new Server();
		server.setHeadimg("qwweqe");
		server.setName("hhh");
		server.setServerid("222");
		server.setState(1);
		serverMapper.insert(server);
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

}
