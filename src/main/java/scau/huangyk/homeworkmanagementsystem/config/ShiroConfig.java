//package scau.huangyk.homeworkmanagementsystem.config;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.filter.authc.LogoutFilter;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import scau.huangyk.homeworkmanagementsystem.shiro.MyRealm;
//
//import javax.servlet.Filter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * shiro配置类
// * Created by Mankind on 2018/1/31.
// */
//@Configuration
//@Slf4j
//public class ShiroConfig {
//    /**
//     * Shiro Web过滤器Factory
//     * @param securityManager 安全管理Bean
//     * @return
//     */
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
//        log.info("注入Shiro的Web过滤器-->shiroFilter");
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //Shiro的核心安全接口,这个属性是必须的
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String,Filter> filters=new LinkedHashMap<>();
//        LogoutFilter logoutFilter=new LogoutFilter();
//        logoutFilter.setRedirectUrl("/login.html");
//        filters.put("logout",logoutFilter);
//        shiroFilterFactoryBean.setFilters(filters);
//
//        //要求登录时的链接(可根据项目的URL进行替换),非必须的属性,默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setLoginUrl("/login.html");
////        //登录成功后要跳转的连接,逻辑也可以自定义，例如返回上次请求的页面
////        shiroFilterFactoryBean.setSuccessUrl("/main.do");
////        //用户访问未对其授权的资源时,所显示的连接
//         shiroFilterFactoryBean.setUnauthorizedUrl("/front/404");
//         /*定义shiro过滤链 Map结构 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的 *
//         anon：它对应的过滤器里面是空的,什么都没做,这里 .do和.jsp后面的*表示参数,比方说login.jsp?main这种 *
//         authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter */
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/console/logout", "logout");
//        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
//        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/", "anon");//anon 可以理解为不拦截
//        filterChainDefinitionMap.put("/checkLogin", "anon");
//        filterChainDefinitionMap.put("/login.html", "anon");
//        filterChainDefinitionMap.put("/front/index", "anon");
//        filterChainDefinitionMap.put("/student/front/index", "anon");
//        filterChainDefinitionMap.put("/article-*.html", "anon");
//        filterChainDefinitionMap.put("/code/get", "anon");
//        filterChainDefinitionMap.put("/console/login", "anon");
//        filterChainDefinitionMap.put("/console/user/accountCheck", "anon");
//        filterChainDefinitionMap.put("/console/user/register", "anon");
//        filterChainDefinitionMap.put("/register", "anon");
//        filterChainDefinitionMap.put("/commend_article.json", "anon");
//        filterChainDefinitionMap.put("/comment.json", "anon");
//        filterChainDefinitionMap.put("/upload/**", "anon");
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/image/**", "anon");
//        filterChainDefinitionMap.put("/json/**", "anon");
//        filterChainDefinitionMap.put("/layui/**", "anon");
//        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//
//    }
//
//    /**
//     * shiro缓存管理器,配置Shiro 缓存
//     * @return
//     */
//    @Bean(name = "cacheManager")
//    public EhCacheManager ehCacheManager(){
//        EhCacheManager cacheManager = new EhCacheManager();
//        //cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
//        return cacheManager;
//    }
//
//
//    /**
//     * 配置核心安全事务管理器
//     * @param myRealm       自定义权限bean
//     * @param cacheManager 缓存
//     * @return
//     */
//    @Bean(name = "securityManager")
//    public SecurityManager securityManager(MyRealm myRealm, @Qualifier("cacheManager") EhCacheManager cacheManager) {
//        log.info("--------------加载securityManager----------------");
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myRealm);
//        //注入缓存管理器;
//        //注意:开发时请先关闭，如不关闭热启动会报错
//        //securityManager.setCacheManager(cacheManager);
//        //注入记住我管理器;
//        //securityManager.setRememberMeManager(rememberMeManager());
//        return securityManager;
//    }
//    /**
//     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
//     */
//    @Bean
//    public MyRealm myShiroRealm() {
//        MyRealm myShiroRealm = new MyRealm();
//        return myShiroRealm;
//    }
//
//    /**
//     * Shiro生命周期处理器 * @return
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//
//    /**
//     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
//     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
//     * @return
//     */
//    @Bean
//    @DependsOn({"lifecycleBeanPostProcessor"})
//    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        advisorAutoProxyCreator.setProxyTargetClass(true);
//        return advisorAutoProxyCreator;
//    }
//
//    /**
//     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//    /**
//     * cookie对象;
//     * @return
//     * */
//    @Bean
//    public SimpleCookie rememberMeCookie(){
//        //System.out.println("ShiroConfiguration.rememberMeCookie()");
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }
//    /**
//     * cookie管理对象;
//     * @return
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager(){
//        //System.out.println("ShiroConfiguration.rememberMeManager()");
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        return cookieRememberMeManager;
//    }
//}
