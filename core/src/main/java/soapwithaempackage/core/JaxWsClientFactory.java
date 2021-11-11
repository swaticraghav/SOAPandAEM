package soapwithaempackage.core;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class JaxWsClientFactory {

	public static <T> T create(Class<T> clazz, String portUrl) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(clazz);
		factory.setAddress(portUrl);
		return (T) factory.create();
	}
}
