package com.zerock.testmapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {
	
	@Select("select sysdate from dual")		//xml�� ����Ͽ� @Select������̼� ���...
	public String getTime();
	
}
