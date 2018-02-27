package com.ssh.cn.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Controller
@Scope("prototype")
public class HelloAction {
	@Resource
	private DemoService demoService;
	public String execute(){
		demoService.hello();
		System.out.println("Hello World!!!");
		return "success";
	}
}







