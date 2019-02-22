package com.accp.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accp.service.StuService;

/**从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，
 * 被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext 
 * 或 AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
 */
@Configuration
@SuppressWarnings("all")
public class WebServiceConfig {

	/*
	 * http://localhost:8080/webservice/userservice?wsdl
	 * 页面访问路径*/	
	@Autowired
	public StuService stuService;
	
	@Bean(name="cxfservlet")
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
	}
	
	@Bean(name=Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	@Bean(name="UserServiceEndpoint")
	public Endpoint sweptPayEndpoint() {
		EndpointImpl endpointImpl=new EndpointImpl(springBus(), stuService);
		endpointImpl.publish("/userservice");
		return endpointImpl;
	}
}
