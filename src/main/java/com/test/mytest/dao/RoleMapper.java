package com.test.mytest.dao;

import com.test.mytest.bean.Role;
import com.test.mytest.bean.RoleDto;
import com.test.mytest.bean.UserDto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<RoleDto> {
    List<RoleDto> findRoleByUser(UserDto userDto);
}