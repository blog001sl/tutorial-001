package org.sl.tutorial.web.sample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * <p>Title: 示例interceptor代码</p>
 * <p>Description: </p>
 * <p>Company: http://blog.singlem1905.cn</p> 
 * @author singlem1905
 * @date 2018年4月15日
 */
public class SampleInterceptor extends HandlerInterceptorAdapter{

	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
		logger.info("this is interceptor[aftercompletion]");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
		logger.info("this is interceptor[afterConcurrentHandlingStarted]");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		logger.info("this is interceptor[postHandle]");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("this is interceptor[preHandle]");
		return super.preHandle(request, response, handler);
	}

	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor.class);
}
