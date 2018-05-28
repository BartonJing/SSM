package com.barton.security;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.barton.domain.entity.Permission;
import com.barton.domain.entity.User;
import com.barton.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 项目名称：ssm
 * 创建时间：2018-04-25
 * 描述: 认证、授权实现
 */
public class UserRealm extends AuthorizingRealm {

    private static final Log logger = LogFactory.get();

    private String name = "userRealm";

    @Autowired
    private UserService userService;

    /**
     * 权限认证，为当前登录的Subject授予角色和权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("权限认证");
        System.out.println("权限认证");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        String loginName = (String) super.getAvailablePrincipal(principalCollection);
       /* User user = userService.selectByUsername(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户角色的集合
//            prisoner.setRoles(new HashSet<String>());//TODO
            List<Permission> currentUserPermissions = userService.selectUserPermission(user.getId());
            for (Permission p : currentUserPermissions) {
                info.addStringPermission(p.getCode());
            }
            return info;
        }*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("aaaa");
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("登录认证");
        System.out.println("登录认证****");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        /*User user = userService.selectByUsername(token.getUsername());
        if (user == null) {
            // 抛出 帐号找不到异常
            throw new UnknownAccountException();
        }
        // 判断帐号是否锁定
        if (Boolean.TRUE.equals(user.getLocked())) {
            // 抛出 帐号锁定异常
            throw new LockedAccountException();
        }*/
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "ss", // 用户名
                "3896dd3af517209036c7bd627d25e839", // 密码
                ByteSource.Util.bytes("ss3585b8df6e4cef0cfaac30aae8a6eafc"),// salt=username+salt
                getName() // realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
