package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Root Context (MyBatis, Service)
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MyBatisConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		// Web Context (Spring MVC)
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1); // 값이 1 이상이면 톰캣 실행 시 DispatcherServlet을 미리 메모리에 로드
        dispatcher.addMapping("/");
    }

}
