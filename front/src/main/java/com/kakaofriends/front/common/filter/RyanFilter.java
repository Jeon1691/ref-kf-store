package com.kakaofriends.front.common.filter;

import com.google.common.collect.Lists;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RyanFilter extends GenericFilterBean {

	private PortResolver portResolver = new PortResolverImpl();

	private List<String> patterns = Lists.newArrayList("/signin/**", "/popup/**", "/*/products/recentProducts","/resources/**");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpServletRequest.getSession(false);
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		if (null != httpSession && !patterns.stream().anyMatch(e -> antPathMatcher.match(e, httpServletRequest.getServletPath()))) {
			httpSession.setAttribute("RYAN_SAVED_REQUEST", new DefaultSavedRequest(httpServletRequest, portResolver));
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}