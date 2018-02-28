package controller;

import javax.json.JsonObject;

import log.Log;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import bean.UserLogin;

public class LoginContraller {
	@RequestMapping(value="/login",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	public String login(@RequestBody String s){
		Log.info(s);
		JSONObject jsonObject = JSONObject.fromObject(s);
		if(jsonObject.getString("username").equals("1234") && jsonObject.getString("password").equals("1234")){
			UserLogin user = new UserLogin();
			user.setToken("adfjaiwoefnione");
			user.setUserid("1234");
			user.setUsername("苗苗");
			return new JSONObject().fromObject(user).toString();
		}
		
		return "账号密码错误" ;
	}
}
