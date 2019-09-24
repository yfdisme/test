package com.test.mytest.bean;

import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "user_role")
public class UserRoleDto extends UserRole implements Serializable {
    private static final long serialVersionUID = -3700773014777558805L;
}
