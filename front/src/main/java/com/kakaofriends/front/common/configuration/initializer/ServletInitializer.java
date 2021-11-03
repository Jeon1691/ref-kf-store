package com.kakaofriends.front.common.configuration.initializer;

import com.kakaofriends.front.common.configuration.RootConfig;
import com.kakaofriends.front.common.filter.FriendsCharacterEncodingFilter;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.File;

import static org.springframework.web.context.ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM;

@Slf4j
@Order(value = 1)
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static final String DEFAULT_SERVLET_NAME = "kakaofriends";
	private static int maxUploadSizeInMb = 10 * 1024 * 1024;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected String getServletName() {
		return DEFAULT_SERVLET_NAME;
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new XssEscapeServletFilter()};
	}

	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		servletContext.setInitParameter(CONTEXT_INITIALIZER_CLASSES_PARAM, ApplicationContextInitializerImpl.class.getName());
		super.registerContextLoaderListener(servletContext);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		CharacterEncodingFilter characterEncodingFilter = new FriendsCharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);

		MultipartFilter multipartFilter = new MultipartFilter();
		multipartFilter.setMultipartResolverBeanName("multipartResolver");

		servletContext.addFilter("encodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");
		servletContext.addFilter("multipartFilter", multipartFilter).addMappingForUrlPatterns(null, false, "/*");

		//servletContext.addListener(new HttpSessionEventPublisher());
		//servletContext.addListener(new SessionListener());

		super.onStartup(servletContext);
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		File uploadDirectory = new File("/tmp");
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getAbsolutePath(), maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}