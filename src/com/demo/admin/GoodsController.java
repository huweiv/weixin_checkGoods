package com.demo.admin;

import java.util.Date;
import java.util.List;
import com.demo.common.model.Goods;
import com.demo.common.model.Record;
import com.demo.common.model.User;
import com.jfinal.core.Controller;

public class GoodsController extends Controller{
	public void index()
	{
		
	}
	/**
	 * 用户进入后获取库存已有物品
	 */
	public void hadGoods() {
		List<Goods> goods = Goods.dao.findByStateHad();
		setAttr("goods", goods);
		renderJson();
	}
	
	//借物品
	public void lendGoods() {
		String order = getPara("order");
		Goods goods = Goods.dao.findByOrder(order);
		String name = goods.getName();
		Integer consumables = goods.getConsumables();
		if(consumables == 1) {
		Goods.dao.findById(goods.getId()).delete();
		}
		else {
			Goods.dao.findById(goods.getId()).set("state", 1).update();
		}
		String s = get_user_session();
		User user = User.dao.findByStudId(s);
		String studName = user.getName();
		if(consumables == 0) {
			new Record().set("studIds", s).set("loantimes", new Date()).set("orders", order).set("goodsname", name).set("stunames", studName).save();
		}
		else {
			new Record().set("studIds", s).set("loantimes", new Date()).set("backtimes", new Date()).set("orders", order).set("goodsname", name).set("stunames", studName).save();
		}
		setAttr("goods", goods);
		renderJson();
	}
	
	//还物品
	public void backGoods() {
		String order = getPara("order");
		Goods goods = Goods.dao.findByOrder(order);
		Goods.dao.findById(goods.getId()).set("state", 0).update();
		Record record = Record.dao.findByOrder(order);
		Record.dao.findById(record.getId()).set("backtimes", new Date()).update();
		setAttr("goods", goods);
		renderJson();
	}
	
	//查询一个人借了多少东西
	public void checkUserLend() {
		String s = get_user_session();
		List<Record> record = Record.dao.findByStudIdLend(s);
		setAttr("record", record);
		renderJson();
	}

	//查询一个人还了多少东西
	public void checkUserBack() {
		String s = get_user_session();
		List<Record> record = Record.dao.findByStuIdBack(s);
		setAttr("record", record);
		renderJson();
	}
	
	//查询一个人未还多少东西
	public void checkUserNotBack() {
		String s = get_user_session();
		List<Record> record = Record.dao.findByStuIdNotBack(s);
		setAttr("record", record);
		renderJson();
	}
	
	//得到session 用户登录学号
	public String get_user_session(){
		return getSessionAttr("sessionId");
	}
}
