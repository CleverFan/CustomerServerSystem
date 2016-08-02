package cn.wlmb.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "online")
public class OnlineController {
	

	@RequestMapping(value = "customer", method = RequestMethod.GET)
	public String customerOnline() {
		System.out.println("----------------请求成功----------------");
		return "resources/customer.html";
	}
	
	@RequestMapping(value = "server", method = RequestMethod.GET)
	public String serverOnline() {
		System.out.println("----------------请求成功----------------");
		return "resources/server1.html";
	}
	
}
