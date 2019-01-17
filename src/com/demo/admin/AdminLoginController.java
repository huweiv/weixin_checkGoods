package com.demo.admin;

import com.demo.common.model.User;
import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class AdminLoginController extends Controller {
	
	public void login() {
		render("login.html");
	}

	@ActionKey("/yzm")
	public void verifycode(){
		render(new CaptchaRender());
	}
	

	public void dologin() {
		String username = getPara("username").trim();
		String password = getPara("password").trim();	 
		String inputRandomCode = getPara("yzm");    //验证验证码
		User usernames = User.dao.checkStuId(username);
		User passward = User.dao.checkPassward(username, password);
		boolean loginSuccess = CaptchaRender.validate(this, inputRandomCode.toUpperCase());
		if(!loginSuccess) {
			setAttr("state", "1");
			renderJson();
		}
		else {
			if(usernames == null) {
				setAttr("state", "2");
				renderJson();
			}
			else {
				if(usernames.getType() == 0 || usernames.getType() == 2) {
					setAttr("state", "3");
					renderJson();
				}
				else {
					if(passward == null) {
						setAttr("state", "4");
						renderJson();
					}
					else {
						getSession().setAttribute("nickname", username);
						//String sessionId = SessionIdKit.me().generate(getRequest());	// 生成唯一标识
						setSessionAttr("sessionId", username);// 设置服务器端session
						//setCookie("cuser", sessionId, 60000);// 设置用户端cookie
						renderJson();
					}
				}
			}
		}
	}
	
	public void changePass() {
		render("changePass.html");
	}
	
	public void doChangePass() {
		String username = getPara("username").trim();
		String password1 = getPara("password1").trim();
		String password2 = getPara("password2").trim();
		String inputRandomCode = getPara("yzm");  
		User user = User.dao.checkStuId(username);
		boolean loginSuccess = CaptchaRender.validate(this, inputRandomCode.toUpperCase());
		if(!loginSuccess) {
			setAttr("state", "1");
			renderJson();
		}
		else {
			if(user == null) {
				setAttr("state", "2");
				renderJson();
			}
			else {
				if(!password1.equals(password2)) {
					setAttr("state", "3");
					renderJson();
				}
				else {
					User.dao.findById(user.getId()).set("passward", password1).update();
					renderJson();
				}
			}
		}
	}

}
