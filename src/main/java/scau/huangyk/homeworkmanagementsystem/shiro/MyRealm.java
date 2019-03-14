///**
// * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
// *
// * Copyright 2017 © yangxiaobing, 873559947@qq.com
// *
// * This file is part of contentManagerSystem.
// * contentManagerSystem is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Lesser General Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * contentManagerSystem is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Lesser General Public License for more details.
// *
// * You should have received a copy of the GNU Lesser General Public License
// * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
// *
// * 这个文件是contentManagerSystem的一部分。
// * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
// * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
// * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
// * 关于GPL协议的细则请参考COPYING文件，
// * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
// * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
// *
// * - Author: yangxiaobing
// * - Contact: 873559947@qq.com
// * - License: GNU Lesser General Public License (GPL)
// * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
// */
//package scau.huangyk.homeworkmanagementsystem.shiro;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import scau.huangyk.homeworkmanagementsystem.model.SysPermission;
//import scau.huangyk.homeworkmanagementsystem.model.SysRole;
//import scau.huangyk.homeworkmanagementsystem.model.User;
//import scau.huangyk.homeworkmanagementsystem.service.ResourceService;
//import scau.huangyk.homeworkmanagementsystem.service.SysPermissionService;
//import scau.huangyk.homeworkmanagementsystem.service.SysRoleService;
//import scau.huangyk.homeworkmanagementsystem.service.UserService;
//import scau.huangyk.homeworkmanagementsystem.util.StringUtil;
//import java.util.List;
//
//
///**
// * 自定义Realm 实现Shiro权限验证
// *
// * @author yangxiaobing
// * @date 2017/7/10
// */
//
//public class MyRealm extends AuthorizingRealm {
//
//
//    @Autowired
//    @Lazy
//    private UserService userService;
//    @Autowired
//    @Lazy
//    private ResourceService resourceService;
//    @Autowired
//    @Lazy
//    private SysPermissionService sysPermissionService;
//
//    @Autowired
//    @Lazy
//    private SysRoleService sysRoleService;
//
//    /**
//     *  userRealm.cachingEnabled：启用缓存，默认false；
//     *  userRealm.authenticationCachingEnabled：启用身份验证缓存，即缓存AuthenticationInfo信息，默认false；
//     *  userRealm.authenticationCacheName：缓存AuthenticationInfo信息的缓存名称；
//     *  userRealm. authorizationCachingEnabled：启用授权缓存，即缓存AuthorizationInfo信息，默认false；
//     *  userRealm. authorizationCacheName：缓存AuthorizationInfo信息的缓存名称；
//     */
//    public MyRealm() {
//        this.setCachingEnabled(true);
//        this.setAuthenticationCachingEnabled(true);
//        this.setAuthenticationCacheName("authenticationCache");
//        this.setAuthorizationCachingEnabled(true);
//        this.setAuthorizationCacheName("authorizationCache");
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        //查出是否有此用户
//        User user;
//        try {
//            user = userService.getByAccount(token.getUsername());
//        } catch (Exception e) {
//            user = null;
//        }
//        if (user == null) {
////            错误的帐号，没有这个账号
//            throw new UnknownAccountException("账号或者密码错误");
//        }
//        if (!user.getPassword().equals(new String(token.getPassword()))) {
//            throw new IncorrectCredentialsException("账号或者密码错误");
//        }
//
//        if (user != null) {
//            //若存在，将此用户存放到登录认证info中
//            return new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
//        }
//        return null;
//    }
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        //获取登录时输入的用户名
//        String loginName = (String) principals.fromRealm(getName()).iterator().next();
//        if (StringUtils.isBlank(loginName)) {
//            return null;
//        }
//        User user;
//
//        try {
//            user = userService.getByAccount(loginName);
//        } catch (Exception e) {
//            user = null;
//        }
//        if (user != null) {
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SysRole role = null;
//            try {
//                role = sysRoleService.selectById(user.getRoleId());
//            } catch (Exception e) {
//                role = null;
//            }
//            if (role != null) {
//                info.addRole(role.getName());
//            }
//            List<SysPermission> permissionList = sysRoleService.getPermissions(role.getId());
//            if (permissionList != null) {
//                permissionList.forEach(permission -> {
//                    if (!StringUtil.isEmpty(permission.getKeyCode()))
//                        info.addStringPermission(permission.getKeyCode());
//                });
//            }
//            return info;
//        }
//        return null;
//    }
//    /**
//     * 清除某个用户的账号密码缓存
//     *
//     * @param principals
//     */
//    @Override
//    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthenticationInfo(principals);
//    }
//    /**
//     * 清除某个用户的角色权限缓存
//     *
//     * @param principals
//     */
//    @Override
//    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthorizationInfo(principals);
//    }
//
//    /**
//     * 清除某个用户的所有缓存
//     *
//     * @param principals
//     */
//    @Override
//    public void clearCache(PrincipalCollection principals) {
//        super.clearCache(principals);
//    }
//
//    /**
//     * 清除所有用户的账号密码缓存
//     */
//    public void clearAllCachedAuthenticationInfo() {
//        getAuthenticationCache().clear();
//    }
//
//    /**
//     * 清除所有用户的角色权限缓存
//     */
//    public void clearAllCachedAuthorizationInfo() {
//        getAuthorizationCache().clear();
//    }
//
//    /**
//     * 清除所有用户缓存
//     */
//    public void clearAllCache() {
//        clearAllCachedAuthenticationInfo();
//        clearAllCachedAuthorizationInfo();
//    }
//}
