package com.test.mytest.utils;

public enum AcctResultCode {
    SUCCESS(200,"SUCCESS")
    ,NORMAL_ERROR(500,"通用错误")
    // 参数错误
    ,PARAMS_IS_NULL(100001,"参数为空")
    ,PARAMS_NOT_COMPLETE(100002,"参数不全")
    ,PARAMS_TYPE_ERROR(100003,"参数类型错误")
    ,PARAMS_IS_INVALID(100004,"参数无效")
    // 用户错误
    ,USER_NOT_EXIST(200001,"用户不存在")
    ,USER_NOT_LOGGED_IN(200002,"用户未登陆")
    ,USER_ACCOUNT_ERROR(200003,"用户名或密码错误")
    ,USER_ACCOUNT_FORBIDDEN(200004,"用户账户已被禁用")
    ,USER_HAS_EXIST(200005,"用户已存在")
    // 业务错误
    ,BUSINESS_ERROR(300001,"系统业务出现问题")
    // 系统错误
    ,SYSTEM_INNER_ERROR(400001,"系统内部错误")
    // 数据错误
    ,DATA_NOT_FOUND(500001,"数据未找到")
    ,DATA_IS_WRONG(500002,"数据有误")
    ,DATA_ALREADY_EXISTED(500003,"数据已存在")
    // 接口错误
    ,INTERFACE_INNER_INVOKE_ERROR(600001,"系统内部接口调用异常")
    ,INTERFACE_OUTER_INVOKE_ERROR(600002,"系统外部接口调用异常")
    ,INTERFACE_FORBIDDEN(600003,"接口禁止访问")
    ,INTERFACE_ADDRESS_INVALID(600004,"接口地址无效")
    ,INTERFACE_REQUEST_TIMEOUT(600005,"接口请求超时")
    ,INTERFACE_EXCEED_LOAD(600006,"接口负载过高")
    // 权限错误
    ,PERMISSION_NO_ACCESS(700001,"没有访问权限");

    AcctResultCode(Integer status,String msg){
        this.status = status ;
        this.msg = msg ;
    }

    private Integer status ;
    private String msg ;
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
