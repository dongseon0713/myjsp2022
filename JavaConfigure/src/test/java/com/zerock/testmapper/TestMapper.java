package com.zerock.testmapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("select sysdate from dual")		//xml을 대신하여 @Select어노테이션 사용...
	public String getTime();
	
}
