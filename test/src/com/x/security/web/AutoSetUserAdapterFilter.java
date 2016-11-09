package com.x.security.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

public class AutoSetUserAdapterFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Enumeration<String> params = arg0.getAttributeNames();
		while (params.hasMoreElements()) {
			String key = params.nextElement();
			System.out.println(key + " : " + arg0.getAttribute(key));
		}
		HttpServletRequest hr = (HttpServletRequest) arg0;
		System.out.println("REMOTEUSER : " + hr.getRemoteUser());
		HttpServletResponse hs = (HttpServletResponse) arg1;
		for (String header : hs.getHeaderNames()) {
			System.out.println(header + " ---> " + hs.getHeader(header));
		}
		System.out.println("LOCATION : " + hs.getLocale());

		HttpSession session = hr.getSession(false);

		Assertion assertion = (Assertion) (session == null ? hr.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION)
				: session.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));
		System.out.println("Assertion  : " + assertion.getPrincipal().getName());
		System.out.println(AssertionHolder.getAssertion());
		Object object = session.getAttribute("_const_cas_assertion_");
		
		System.out.println(object+" <---");
		
		if (arg2 != null) {
			arg2.doFilter(arg0,arg1);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
