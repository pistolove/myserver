//package myserver.api.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//public class SampleSpringInterceptor extends HandlerInterceptorAdapter {
//
//    private static final Logger log = LoggerFactory.getLogger(SampleSpringInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.debug(this.getClass().getName() + " preHandle.");
//
//        return true;
//    }
//}
