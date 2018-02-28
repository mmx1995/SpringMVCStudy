package controller;

import javax.json.JsonObject;

import log.Log;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.ResponseBody;

import bean.UserLogin;
@Controller
public class LoginContraller {
	@RequestMapping(value="/login",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	public @ResponseBody  String login(@RequestBody String s){
		Log.info(s);
		JSONObject jsonObject = JSONObject.fromObject(s);
		if(jsonObject.getString("username").equals("1234") && jsonObject.getString("password").equals("1234")){
			UserLogin user = new UserLogin();
			user.setToken("adfjaiwoefnione");
			user.setUserid("1234");
			user.setUsername("苗苗");
			String ss = new JSONObject().fromObject(user).toString();
			System.out.println(ss);
			return ss;
		}
		
		return "账号密码错误" ;
	}
}
