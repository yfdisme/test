package com.test.mytest.dao;

import com.test.mytest.bean.UserRole;
import com.test.mytest.bean.UserRoleDto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

public interface UserRoleMapper extends Mapper<UserRoleDto> {
}