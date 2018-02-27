package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice // 声明一个控制器建言，此建言组合了@Component,所以自动注册为Spring的Bean
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value=Exception.class) //在此处定义全局处理，value值课过滤拦截的条件，此处拦截所有的Exception
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error"); //error页面
		modelAndView.addObject("errorMessage", exception.getMessage());
		System.out.println(exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute //此注解将键值对添加到全局，所有的注解@RequestMapping的方法可获得此值
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder  //此注解定制WebDateBinder  ， 屏蔽id属性
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id");
	}
	
}
