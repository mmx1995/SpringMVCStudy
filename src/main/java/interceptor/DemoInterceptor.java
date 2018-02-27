package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//继承HandlerInterceptorAdapter 来实现自定义的拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter{
	// 请求发生前执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
	// 请求发生后执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		Long endTime = System.currentTimeMillis();
		System.out.println("本次请求的处理时间是" + new Long(endTime - startTime));
		request.setAttribute("handlingTime", endTime - startTime);
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
