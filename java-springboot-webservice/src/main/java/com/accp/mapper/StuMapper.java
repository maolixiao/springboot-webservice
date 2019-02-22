package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.accp.domain.stu;
@Mapper
public interface StuMapper {

	List<stu> queryAll();
}
