# test
springboot + jwt + shiro + mybatis 实现restful快速开发脚手架

1.jwt 无状态分布式授权

项目介绍

1. RESTful API
2. Maven集成Mybatis Generator(逆向工程)
3. Shiro + Java-JWT实现无状态鉴权机制(Token)
4. 密码加密(采用AES-128 + Base64的方式)
5. 集成Redis(Jedis)
6. 重写Shiro缓存机制(Redis)
7. Redis中保存RefreshToken信息(做到JWT的可控性)
8. 根据RefreshToken自动刷新AccessToken

表设计

首先就是建表，常见的五个表(不懂自行百度)

    drop database shirojwt;
    
    create database shirojwt;
    
    use shirojwt;
    
    create table user (
    id int primary key auto_increment COMMENT "ID",
    account varchar(20)  COMMENT "帐号",
    password varchar(20) COMMENT "密码",
    username varchar(20) COMMENT "昵称",
    reg_time datetime not null COMMENT "注册时间"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户表";
    
    CREATE TABLE role (
    id int primary key auto_increment COMMENT "ID",
    name varchar(128) not null unique COMMENT "角色名称"
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "角色表";
    
    
    CREATE TABLE permission (
    id int primary key auto_increment COMMENT "ID",
    name varchar(128) COMMENT '资源名称',
    per_code varchar(128) not null unique COMMENT '权限代码字符串'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "资源表";
    
    CREATE TABLE user_role (
    id int primary key auto_increment COMMENT "ID",
    user_id int COMMENT '用户id',
    role_id int COMMENT '角色id',
    foreign key (user_id) references user (id),
    foreign key (role_id) references role (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户角色表";
    
    CREATE TABLE role_permission (
    id int primary key auto_increment COMMENT "ID",
    role_id int COMMENT '角色id',
    permission_id int COMMENT '权限id',
    foreign key (role_id) references role (id),
    foreign key (permission_id) references permission (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "角色资源表";
    
    insert into user values(null, "admin", "admin", "admin", now());
    insert into user values(null, "wang", "wang", "wang", now());
    insert into user values(null, "guest", "guest", "guest", now());
    
    insert into role values(null, "admin");
    insert into role values(null, "customer");
    
    insert into user_role values(null, 1, 1);
    insert into user_role values(null, 2, 2);
    
    insert into permission values(null, "查看用户", "user:view");
    insert into permission values(null, "操作用户", "user:edit");
    
    insert into role_permission values(null, 1, 1);
    insert into role_permission values(null, 1, 2);
    insert into role_permission values(null, 2, 1);

这里我们新增了三个用户，一个管理员(读写权限)，一个普通用户(读权限)，一个游客(没有权限)



项目构建

generatorConfig.xml(逆向工程文件)

参考文章   https://blog.csdn.net/Destiny_strive/article/details/82915354

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE generatorConfiguration
            PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
            "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
    
    <generatorConfiguration>
    
        <context id="Mysql" targetRuntime="MyBatis3Simple" defaultModelType="flat">
            <property name="beginningDelimiter" value="`"/>
            <property name="endingDelimiter" value="`"/>
    
            <plugin type="tk.mybatis.mapper.generator.MapperPlugin">
                <property name="mappers" value="tk.mybatis.mapper.common.Mapper"/>
                <property name="caseSensitive" value="true"/>
            </plugin>
    
            <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                            connectionURL="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8"
                            userId="root"
                            password="123456">
            </jdbcConnection>
    
            <javaModelGenerator targetPackage="com.test.mytest.bean" targetProject="src/main/java"/>
    
            <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources"/>
    
            <javaClientGenerator targetPackage="com.test.mytest.dao" targetProject="src/main/java"
                                 type="XMLMAPPER"/>
    
            <table tableName="user">
                <generatedKey column="id" sqlStatement="JDBC"/>
            </table>
            <table tableName="role">
                <generatedKey column="id" sqlStatement="JDBC"/>
            </table>
            <table tableName="permission">
                <generatedKey column="id" sqlStatement="JDBC"/>
            </table>
            <table tableName="user_role">
                <generatedKey column="id" sqlStatement="JDBC"/>
            </table>
            <table tableName="role_permission">
                <generatedKey column="id" sqlStatement="JDBC"/>
            </table>
        </context>
    </generatorConfiguration>

![做如下操作可得到生成文件](https://github.com/yfdisme/test/blob/master/src/main/resources/static/images/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190924112757.png)

新建DTO



重写UserRealm(从数据库查询密码及权限)

