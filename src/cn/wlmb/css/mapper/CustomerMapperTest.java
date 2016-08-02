package cn.wlmb.css.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wlmb.css.po.Customer;
import cn.wlmb.css.po.CustomerExample;

public class CustomerMapperTest {
	
	private ClassPathXmlApplicationContext applicationContext;
	private CustomerMapper customerMapper;

	@Before
	public void setup() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		customerMapper = (CustomerMapper) applicationContext.getBean("customerMapper");
	}
	
	@Test
	public void testInsert() {
		Customer customer = new Customer();
		customer.setCustomerid("1");
		customer.setIp("127.0.0.1");
		customer.setLocation("杭州");
		customer.setState(1);
		
		Date d = new Date();
		customer.setCuCreatime(d);
		customerMapper.insert(customer);
		System.out.println("ok");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Customer customer = customerMapper.selectByPrimaryKey("7iqwxrohw7hnnrk9");
		
		customer.setState(0);
		
		customerMapper.updateByPrimaryKey(customer);
	}
	
	@Test
	public void testfindByExample() {
		CustomerExample example = new CustomerExample();
		example.createCriteria().andCuCreatimeEqualTo(new Date());
		List<Customer> li = customerMapper.selectByExample(example);
		
		System.out.println(li);
		
		
	}

}
