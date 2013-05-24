/**
 * Copyright (c) 2012,USTC E-BUSINESS TECHNOLOGY CO.LTD All Rights Reserved.
 */

package com.ustcinfo.swift;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author libinsong1204@gmail.com
 * @date 2012-11-3 上午10:55:26
 */
public class Consumer {

	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
 
        HelloService helloService = (HelloService)context.getBean("helloService"); // get service invocation proxy
 
        List<LogEntry> list = new ArrayList<>();
		list.add(new LogEntry("sd", "hello world"));
		ResultCode code = helloService.log(list);
		System.out.println(code);
    }
	
}
