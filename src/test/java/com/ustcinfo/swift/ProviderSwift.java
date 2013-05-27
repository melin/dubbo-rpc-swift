/**
 * Copyright (c) 2012,USTC E-BUSINESS TECHNOLOGY CO.LTD All Rights Reserved.
 */

package com.ustcinfo.swift;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author libinsong1204@gmail.com
 * @date 2012-11-3 上午10:49:49
 */
public class ProviderSwift {
	
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider-swift.xml"});
        context.start();
 
        System.out.println("Press any key to exit.");
        System.in.read();
    }
	
}
