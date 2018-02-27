package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.DemoObj;

@Controller
public class ConverterContraller {
	public @ResponseBody DemoObj conver(@RequestBody DemoObj demoObj){
		return demoObj;
	}
}
