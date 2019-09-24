package com.test.mytest.dao;

import com.test.mytest.bean.Permission;
import com.test.mytest.bean.PermissionDto;
import com.test.mytest.bean.RoleDto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<PermissionDto> {
    List<PermissionDto> findPermissionByRole(RoleDto roleDto);
}