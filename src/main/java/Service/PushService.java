package Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;


// 定时任务
@Service
public class PushService {
	private DeferredResult<String> deferredResult ;
	
	public DeferredResult<String> getAsyncUpdate(){
		deferredResult = new DeferredResult<String>();
		return deferredResult ;
	}
	
	@Scheduled(fixedDelay = 5000)
	public void refersh(){
		if(deferredResult != null){
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}
	
}
