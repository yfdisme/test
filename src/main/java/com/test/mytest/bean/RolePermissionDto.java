package com.test.mytest.bean;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "role_permission")
public class RolePermissionDto extends RolePermission implements Serializable {
    private static final long serialVersionUID = -461349550066268809L;
}
