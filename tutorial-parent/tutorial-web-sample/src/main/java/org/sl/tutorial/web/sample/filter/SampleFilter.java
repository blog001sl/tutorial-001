package org.sl.tutorial.web.sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleFilter implements Filter{

	@Override
	public void destroy() {

		logger.info("destroying............");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		logger.info("enter filter");
		arg2.doFilter(arg0, arg1);
		
		logger.info("out filter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("initializing............");		
	}

	private static final Logger logger = LoggerFactory.getLogger(SampleFilter.class);
	
}
