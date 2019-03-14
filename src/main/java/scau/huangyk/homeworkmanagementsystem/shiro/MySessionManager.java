//package scau.huangyk.homeworkmanagementsystem.shiro;
//
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//import scau.huangyk.homeworkmanagementsystem.util.StringUtil;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.Serializable;
//
///**
// * 自定义sessionId获取
// * @author huangyk
// * @since 2019.01.22
// */
//public class MySessionManager extends DefaultWebSessionManager {
//    private static final String AUTHORIZATION="Authorization";
//    private static final String REFERENCED_SESSION_ID_SOURCE="Stateless request";
//
//    public MySessionManager(){
//
//    }
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response){
//        String sessionId=WebUtils.toHttp(request).getHeader(AUTHORIZATION);
//        if(!StringUtil.isEmpty(sessionId)){
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,sessionId);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
//            return sessionId;
//        }else{
//            return super.getSessionId(request,response);
//        }
//    }
//}
