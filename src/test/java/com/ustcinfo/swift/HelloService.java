/**        
 *
 * Scribe.java Create on 2013-5-24 上午11:56:24 
 */
package com.ustcinfo.swift;

import org.apache.thrift.TException;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 * 
 * @author libinsong1204@gmail.com
 * 
 */
@ThriftService("scribe")
public interface HelloService {
	@ThriftMethod("Log")
	ResultCode log(LogEntry log) throws TException;
}