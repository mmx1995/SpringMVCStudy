package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import Service.PushService;

/**
 * 异步任务的实现是通过控制器从另外一个线程返回一个DeferredResult
 * 
 * */


@Controller
public class AysncContraller {
	//定时任务类，用来返回DeferredResult 对象
	@Autowired
	PushService pushService;
	
	
	@RequestMapping(value="/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
	
}
