package com.accp.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.accp.domain.stu;

@WebService
public interface StuService {
	
	@WebMethod
	List<stu> queryAll();
}
