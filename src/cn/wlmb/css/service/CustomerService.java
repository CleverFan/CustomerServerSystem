package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Customer;
import cn.wlmb.css.po.CustomerExample;


public interface CustomerService {

	/**
	 * 查找在线客户列表
	 * @param example
	 * @return 
	 */
	List<Customer> findCustomerList(CustomerExample example);
	
	/**
	 * 根据id查询客户
	 * @param id customer的id
	 * @return 一个customer的对象
	 */
	Customer findCustomerById(String id);
	
	/**
	 * 在数据库中添加一个用户
	 * @param customer 一个customer对象
	 */
	int insertCustomer(Customer customer);
	
	/**
	 * 是否某客户已经存在存在
	 * @param object
	 * @return 是否存在
	 */
	boolean isExistCustomer(Object object);

	/**
	 * 根据id修改用户的在线状态
	 * @param customer 用户的对象，必须设置id
	 */
	int updateStatusById(Customer customer);
}
