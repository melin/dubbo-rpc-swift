/**        
 *
 * SwiftScribe.java Create on 2013-5-24 上午11:57:07 
 */
package com.ustcinfo.swift;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author libinsong1204@gmail.com
 * 
 */
public class HelloServiceImpl implements HelloService {
	private final List<LogEntry> messages = new ArrayList<LogEntry>();

	@Override
	public ResultCode log(LogEntry log) {
		this.messages.addAll(messages);
		return ResultCode.OK;
	}
}