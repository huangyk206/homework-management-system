package scau.huangyk.homeworkmanagementsystem.shiro;//package scau.huangyk.homeworkmanagementsystem.shiro;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.crazycake.shiro.RedisCacheManager;
//import org.crazycake.shiro.RedisManager;
//import org.crazycake.shiro.RedisSessionDAO;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * shiro配置
// * @author huangyk
// * @since 2019.01.22
// */
//@Configuration
//@Slf4j
//public class ShiroConfig {
//    @Value("${spring.redis.shiro.host}")
//    private String host;
//    @Value("${spring.redis.shiro.port}")
//    private int port;
//    @Value("${spring.redis.shiro.timeout}")
//    private int timeout;
//    @Value("${spring.redis.shiro.password}")
//    private String password;
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//        log.info("创建shiro过滤器");
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
//        //注意过滤器配置顺序，不能颠倒
//        //配置退出过滤器，其中的具体代码shiro已实现，登出后跳转至配置的loginUrl
//        filterChainDefinitionMap.put("/logout","logout");
//        //配置不会被拦截
//        filterChainDefinitionMap.put("/static/**","anno");
//        filterChainDefinitionMap.put("/login","anno");
//        filterChainDefinitionMap.put("/**","authc");
//        shiroFilterFactoryBean.setLoginUrl("/unauth");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法
//        hashedCredentialsMatcher.setHashIterations(2);//散列次数
//        return hashedCredentialsMatcher;
//    }
//
//    @Bean
//    public MyShiroRealm myshiroRealm(){
//        MyShiroRealm myshiroRealm=new MyShiroRealm();
//        myshiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myshiroRealm;
//    }
//
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//        securityManager.setRealm(myshiroRealm());
//        securityManager.setSessionManager(securityManager());
//        securityManager.setCacheManager(cacheManager());
//        return securityManager;
//    }
//
//    @Bean
//    public SessionManager sessionManager(){
//        MySessionManager mySessionManager=new MySessionManager();
//        mySessionManager.setSessionDAO(redisSessionDAO());
//        return mySessionManager;
//    }
//
//    @Bean
//    public RedisManager redisManager(){
//        RedisManager redisManager=new RedisManager();
//        redisManager.setHost(host);
//        redisManager.setPort(port);
//        redisManager.setTimeout(1800);
//        redisManager.setPassword(password);
//        return redisManager;
//    }
//
//    @Bean
//    public RedisCacheManager cacheManager(){
//        RedisCacheManager redisCacheManager=new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisManager());
//        return redisCacheManager;
//    }
//
//    @Bean
//    public RedisSessionDAO redisSessionDAO(){
//        RedisSessionDAO redisSessionDAO=new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisManager());
//        return redisSessionDAO;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//
//
//}
