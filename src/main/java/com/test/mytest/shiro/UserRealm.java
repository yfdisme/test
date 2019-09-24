package com.test.mytest.shiro;


import com.test.mytest.bean.UserDto;
import com.test.mytest.dao.PermissionMapper;
import com.test.mytest.dao.RoleMapper;
import com.test.mytest.dao.UserMapper;
import com.test.mytest.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * aaa
 */
@Service
public class UserRealm extends AuthorizingRealm {
    @Resource
    private  UserMapper userMapper;
   @Resource
   private  RoleMapper roleMapper;
   @Resource
   private  PermissionMapper permissionMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String)auth.getCredentials();
        String username = JWTUtil.getUsername(token);
        if(username == null){
            throw new AuthenticationException("token inbalid");
        }

        UserDto userDto = new UserDto();
        userDto.setAccount(username);
        userDto = userMapper.selectOne(userDto);
        if (userDto == null) {
            throw new AuthenticationException("该帐号不存在(The account does not exist.)");
        }
        if (! JWTUtil.verify(token, username, userDto.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
