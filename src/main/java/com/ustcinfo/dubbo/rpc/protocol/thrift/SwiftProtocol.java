/**        
 *
 * ThriftProtocol.java Create on 2013-5-24 下午5:05:22 
 */    
package com.ustcinfo.dubbo.rpc.protocol.thrift;

import org.apache.thrift.TProcessor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.AbstractProxyProtocol;
import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftClientManager;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServerConfig;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.net.HostAndPort;

/**    
 *    
 * @author libinsong1204@gmail.com
 *  
 */
public class SwiftProtocol extends AbstractProxyProtocol {
	public static final int DEFAULT_PORT = 40880;

    public static final String NAME = "thrift";

	@Override
	public int getDefaultPort() {
		return DEFAULT_PORT;
	}

	@Override
	protected <T> Runnable doExport(T impl, Class<T> type, URL url)
			throws RpcException {
		TProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(), impl);
		final ThriftServer server = new ThriftServer(processor, new ThriftServerConfig().setPort(url.getPort()));
		server.start();

		return new Runnable() {
            public void run() {
                try {
                	server.close();
                } catch (Throwable e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        };
	}

	@Override
	protected <T> T doRefer(Class<T> type, URL url) throws RpcException {
		FramedClientConnector connector = new FramedClientConnector(HostAndPort.fromParts(url.getHost(), url.getPort()));
		try {
			ThriftClientManager clientManager = new ThriftClientManager();
			T ref = clientManager.createClient(connector, type).get();
			
			return ref;
		} catch (Exception e) {
			 throw new RpcException( "Fail to create remoting client for service(" + url + "): " + e.getMessage(), e );
		}
	}
}
