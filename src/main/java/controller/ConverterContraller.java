package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.DemoObj;

@Controller
public class ConverterContraller {
	@RequestMapping(value="/converter",produces={"application/x-wisely"},method=RequestMethod.POST)
	public @ResponseBody DemoObj conver(@RequestBody DemoObj demoObj){
		return demoObj;
	}
	@RequestMapping(value="/converter",method=RequestMethod.GET)
	public String conver(){
		return "converter";
	}
}
