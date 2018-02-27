package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.DemoObj;

@Controller
public class AcviceController {
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
		Logger.getInstance(Log.class).info("");
		throw new IllegalArgumentException("Sorry , 参数有误" + "来自@ModelAttribute" + msg);
	}
}

