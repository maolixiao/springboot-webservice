package com.accp.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.stu;
import com.accp.mapper.StuMapper;
import com.accp.service.StuService;

@Service
@WebService(
		serviceName="StuService",
		targetNamespace="http://impl.service.accp.com",
		endpointInterface="com.accp.service.StuService"
)
public class StuServiceImpl implements StuService{
	
	@Autowired
	StuMapper mapper;

	@Override
	public List<stu> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}
	
}
