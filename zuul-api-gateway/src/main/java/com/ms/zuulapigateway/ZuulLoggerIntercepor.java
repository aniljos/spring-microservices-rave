package com.ms.zuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggerIntercepor extends ZuulFilter{

	
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		System.out.println("ZuulLoggerIntercepor.run()");
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		System.err.println("Request URI: " + request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
