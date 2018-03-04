package webInitializer;

import java.util.List;

import interceptor.DemoInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import HttpMessageConverter.MyMessageConverter;


@Configuration
@EnableWebMvc
@ComponentScan("controller,test,Service")
@EnableScheduling    //开启计划任务的支持
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	// 配置视图管理工具
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	// 配置资源管理器
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	//配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	// 获取拦截器
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	//此处无任何业务处理，只有一个简单页面的转向
	// 快捷的ViewController
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/indexs").setViewName("/index");
		registry.addViewController("/uploads").setViewName("/upload");
		registry.addViewController("/see").setViewName("/see");
		registry.addViewController("/async").setViewName("/async");
		
	}
	
	//此处配置可以将忽略.的默认操作去掉
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
	
	//使用MultipartResolver 接受上传的文件
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		multipartResolver.setDefaultEncoding("utf-8");
		return multipartResolver;
	}
	//配置自定义的HttpMessageConverter 
	// configureMessageConverter 重载会覆盖掉Spring MVC 默认注册的多个HttpMessageConverter
	//extendMessageConverter仅添加一个自定义的
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}
	@Bean
	public MyMessageConverter converter(){
		return new MyMessageConverter();
	}
}
