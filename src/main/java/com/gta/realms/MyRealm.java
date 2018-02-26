package com.gta.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/24
 * Time: 16:44
 */
public class MyRealm extends AuthorizingRealm{

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 2. 从 UsernamePasswordToken 获取 username
        String username = upToken.getUsername();

        // 3. 调用操作数据库方法, 从数据库查询出 username 对应记录
        System.out.println("从数据库中获取 username: " + username + " 所对应的用户信息.");

        // 4. 若用户不存在, 则抛出 UnknownAccountException 异常
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在！");
        }

        // 5. 判断是否需要抛出其他异常
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户已被锁定！");
        }

        // 6. 根据用户信息构建 AuthenticationInfo 对象并返回

        /** 以下信息从数据库中获取 */
        // 6-1). principal: 认证的实体信息, 可以是 username, 也可以是数据库表信息对应的实体对象
        Object principal = username;
        // 6-2). credentials: 密码(从数据库中获取密码)
        Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
        // 6-3). realmName: 当前 Realm 对象的 name, 调用父类的 getName() 即可
        String realmName = getName();
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

}
