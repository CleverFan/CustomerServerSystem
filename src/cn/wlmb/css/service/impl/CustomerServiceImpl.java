package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.CustomerMapper;
import cn.wlmb.css.po.Customer;
import cn.wlmb.css.po.CustomerExample;
import cn.wlmb.css.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> findCustomerList(CustomerExample example) {
		return customerMapper.selectByExample(example);
	}

	@Override
	public int insertCustomer(Customer customer) {
		return customerMapper.insert(customer);
	}

	@Override
	public boolean isExistCustomer(Object object) {
		return false;
	}

	@Override
	public Customer findCustomerById(String id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateStatusById(Customer customer) {
		return customerMapper.updateByPrimaryKey(customer);	
	}

}
