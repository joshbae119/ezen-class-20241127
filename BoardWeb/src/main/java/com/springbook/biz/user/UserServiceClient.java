package com.springbook.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		
		vo.setId("1234");
		vo.setPassword("1234");
		vo.setName("123");
		vo.setRole("USER");
		
		userService.insertUser(vo);
		System.out.println("회원 가입이 완료되었습니다");
		
		/*
		
		vo.setId("123");
		vo.setPassword("123");
		
		UserVO user = userService.getUser(vo);
	
		if(user != null) {
			System.out.println(user.getName() + " 님 환영합니다");
		}else {
			System.out.println("저희 회원이 아니시네요");
		}*/
		container.close();
		
		
	}
}
