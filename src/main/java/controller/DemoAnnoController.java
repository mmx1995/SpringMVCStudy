package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	//produces可以定制返回值的类型， 当前为json对象或者媒体类型
	@RequestMapping(produces = "text/plain;charset=UTF-8") //为注明路径，拦截路径还是/anno
	public @ResponseBody String index(HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access";
	}
	
	//接受路径，结合@PathVariable 访问路径为/anno/pathvar/xx
	// 类似与http://localhost:8080/mmx/anno/pathvar/xx.yy
	//但此处的.yy会被str忽略
	//在MyMvcConfig中重写configurePathMatch 之后，可以不被忽略
	@RequestMapping(value = "/pathvar/{str}", produces="text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access, str:" + str;
	}
	//解释对象到参数，访问路径为/requestParam?id=1
	@RequestMapping(value="/requestParam", produces="text/plain; charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access, id = " + id;
	}
	
	//解释对象到参数，访问路径为/obj?id=1&name=xx
	@RequestMapping(value="/obj", produces="applicetion/json;charset=UTF-8")
	 // 此注解也可用于方法
	public @ResponseBody String passobj(DemoObj obj, HttpServletRequest request){
		return "url: " + request.getRequestURL() + "can access,obj id = " + obj.getId() + "obj name:"
				+ obj.getName();
	}
	
	// 不同的路径映射相同的方法
	@RequestMapping(value={"/name1","/name2"}, produces="text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access";
	}
}
