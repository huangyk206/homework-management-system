package scau.huangyk.homeworkmanagementsystem.shiro;//package scau.huangyk.homeworkmanagementsystem.shiro;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import scau.huangyk.homeworkmanagementsystem.model.SysPermission;
//import scau.huangyk.homeworkmanagementsystem.model.SysRole;
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        SimpleAuthorizationInfo authenticationInfo=new SimpleAuthorizationInfo();
//        UserInfo userInfo=(UserInfo)principalCollection.getPrimaryPrincipal();
//        for(SysRole role:userInfo.getRoleList()){
//            authenticationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermission()){
//                authenticationInfo.addObjectPermission(p.getPermission());
//            }
//        }
//        return authenticationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String userName=(String)authenticationToken.getPrincipal();
//        UserInfo userInfo=userInfoService.findByUserName(userName);
//
//        if(userInfo==null){
//            return null;
//        }
//        if(userInfo.getState()==1){
//            throw new LockedAccountException();
//        }
//        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo(
//                userInfo,
//                userInfo.getPassword(),
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
//                getName()
//        );
//        return authorizationInfo;
//    }
//}
