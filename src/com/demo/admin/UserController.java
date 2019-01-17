package com.demo.admin;

import java.util.ArrayList;
import java.util.List;

import com.demo.common.model.Goods;
import com.demo.common.model.User;
import com.jfinal.core.Controller;


public class UserController extends Controller{
	public void index()
	{
		//setAttr("state", "false");
		//renderJson();
	}
	/**
	 * 用户登录
	 */
	public void doLogin() {          //微信小程序通过post请求发送过来一个学号，是否匹配数据库验证登录
		String stuId = getPara("stuId").trim();  //获取前端发送过来的学号
		String passward = getPara("stuPswd").trim();
		User user = User.dao.checkStuId(stuId);
		User password = User.dao.checkPassward(stuId, passward);
		if(user == null) {
			setAttr("state", "1");
			renderJson();
		}
		else {
			if(user.getType() == 1) { //管理员
				setAttr("state", "2");
				renderJson();
			}
			else {
				if(user.getType() == 0) { //未审核
					setAttr("state", "3");
					renderJson();
				}
				else{
					if(password == null) {
						setAttr("state", "4");
						renderJson();
					}
					else {
						setSessionAttr("sessionId", stuId);
						setAttr("state", "5");
						renderJson();
					}
				}
			}
		}
	}
	
	public void getGoodsList()
	{
		List<Goods> goodsList = Goods.dao.findAll();
		List<String> goodsNames = new ArrayList<String>();
		for(int i=0;i<goodsList.size();i++)
		{
			goodsNames.add(goodsList.get(i).getStr("name"));
		}
		setAttr("list",goodsNames);
		renderJson();
	}
	
	/**
	 * 用户注册
	 */
	public void register() {
		String studId = getPara("StudId").trim();
		String password1 = getPara("password1").trim();
		String password2 = getPara("password2").trim();
		String username = getPara("username").trim();
		User user = User.dao.checkStuId(studId);
		if(user != null) {
			setAttr("state", "1");
			renderJson();
		}
		else {
			if(!password1.equals(password2)) {
				setAttr("state", "2");
				renderJson();
			}
			else {
				setAttr("state", "true");
				new User().set("studId", studId).set("passward", password1).set("name", username).set("type", 0).save();
				renderJson();
			}
		}
	}
}

