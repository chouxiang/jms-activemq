package com.xzhang.controller.activemq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zx
 * desc: 进入MQ主页的controller
 *
 */
@Controller
@RequestMapping("/welcomeController")
public class WelcomeController {
	
	@RequestMapping("/welcome.do")
	public String welcome(){
		System.out.println("------------welcome");
		return "/activemq/welcome";
	}

}
