package com.test.mytest.bean;

import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "permission")
public class PermissionDto extends Permission implements Serializable {
    private static final long serialVersionUID = -1700497935602702350L;
}
