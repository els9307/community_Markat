package com.community.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("C_Login")
	public void Login() {
		logger.info("�α��� view ����");
	}
	@GetMapping("C_Join")
	public void Join() {
		logger.info("ȸ������ view ����");
	}
}
