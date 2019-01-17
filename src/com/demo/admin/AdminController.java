package com.demo.admin;


import java.io.File;
import java.util.List;

import com.demo.common.model.Goods;
import com.demo.common.model.Record;
import com.demo.common.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import xc.jfinal.interceptor.GlobalInterceptor;
import xc.jfinal.unitls.Preference;
import xc.tools.excel.DBheplers;
import xc.tools.excel.StuEntitys;
import xc.tools.excel.StuServices;


 @Before(GlobalInterceptor.class)

public class AdminController extends Controller {
	
	public void index() {
		Page<Goods> goods = Goods.dao.paginate(getParaToInt(0, 1), 10);
		setAttr("page",goods);
		render("goodsList.html");
	}

	public void add() {
		render("goodsAdd.html");
	}
	
	public void save() {
		int temp = 1;
		String str1 = getPara("consumables");
		if(str1.equals("是"))
			temp = 1;
		else if (str1.equals("否"))
		    temp = 0;
		new Goods().set("name", getPara("name"))
		.set("consumables", temp)
		.set("state", 0)
		.set("stortime", getPara("stortime"))
		.set("orders", getPara("order")).save();
		redirect("/admin");
	}
	
	public void edit() {
		String str = "";
		setAttr("goods", Goods.dao.findById(getParaToInt()));
		int temp = Goods.dao.findById(getParaToInt()).getConsumables();
		if(temp == 0) {
			str = "否";
			setAttr("str", str);
		}
		else {
			str = "是";
			setAttr("str", str);
		}
		render("goodsEdit.html");
	}
	
	public void update() {
		int temp = 1;
		String str = getPara("goods.consumables");
		if(str.equals("是")) {
			temp = 1;
		}
		else {
			temp = 0; 
		}
		Goods.dao.findById(getPara("goods.id")).set("name", getPara("goods.name"))
		.set("consumables", temp).set("stortime", getPara("goods.stortime"))
		.set("orders", getPara("goods.orders")).update();
		redirect("/admin");
	}
	
	public void delete() {
		Goods.dao.deleteById(getParaToInt());
		redirect("/admin");
	}
	
	public void hadGoods() {	
		List<Goods> goods = Goods.dao.findByStateHad();
		setAttr("goods",goods);
		setAttr("pageNum", 1);
		render("hadGoods.html");
	}


	public void lendGoods() {
		List<Record> record = Record.dao.findByBacktimesLend();
		setAttr("goods",record);
		setAttr("pageNum", 1);
		render("lendGoods.html");
	}
	

	public void changeLendPage() {
		List<Record> record = Record.dao.findByBacktimesLend();
		setAttr("goods", record);
		setAttr("pageNum",getParaToInt(0));
		render("lendGoods.html");
	}
	

	public void chageHadPage() {
		List<Goods> goods = Goods.dao.findByStateHad();
		setAttr("goods",goods);
		setAttr("pageNum",getParaToInt(0));
		render("hadGoods.html");
	}
	

//	public void addStud() {
//		render("addStud.html");
//	}
//	
//	public void saveStud() {
//		new User().set("name", getPara("name")).set("studId", getPara("studId")).set("passward", getPara("passward")).set("type", 2).save();
//		redirect("/admin");
//	}
	
	
	/**
	 * 注销是销毁session
	 */
	public void destroySession() {
		removeSessionAttr("nickname");
		redirect("/good/login");
	}
	
	/**
	 * 管理员审核
	 */
	public void Auditing() {
		List<User> user = User.dao.findByTypeAuditing();
		setAttr("user", user);
		render("Auditing.html");
	}
	
	public void AuditingThrough() {
		User.dao.findById(getParaToInt()).set("type", 2).update();
		redirect("/admin/Auditing");
	}
	
	public void AuditingDelete() {
		User.dao.deleteById(getParaToInt());
		redirect("/admin/Auditing");
	}
	
	/**
	 * 导出到Excel
	 */
	public void excelOutto() {
		try {
			WritableWorkbook wwb = null;
			   String path = getSession().getServletContext().getRealPath(Preference.UPLOAD_DEVICE_DIR);
			   String fileName = path+"/"+System.currentTimeMillis()/1000+".xlsx";
			   File file=new File(fileName);
			   if (!file.exists()) {
				   file.createNewFile();
			   }
			   wwb = Workbook.createWorkbook(file);
			   WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
			   List<Goods> list= new Goods().getList();
			   ws.setColumnView(0, 10); 
			   ws.setColumnView(1, 15);
			   ws.setColumnView(2, 15); 
			   ws.setColumnView(3, 15); 
			   ws.setColumnView(4, 25);
			   ws.setColumnView(5, 10);
			   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10); 
			   WritableFont BoldFont12 = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD);
			   WritableCellFormat wcf_title = new WritableCellFormat(BoldFont12); 
			   wcf_title.setBorder(Border.ALL, BorderLineStyle.THIN); 
			   wcf_title.setVerticalAlignment(VerticalAlignment.CENTRE);
			   wcf_title.setAlignment(Alignment.CENTRE);
			   wcf_title.setWrap(false); 
			   WritableCellFormat wcf_text = new WritableCellFormat(NormalFont); 
			   wcf_text.setBorder(Border.ALL, BorderLineStyle.THIN);
			   wcf_text.setVerticalAlignment(VerticalAlignment.CENTRE);
			   wcf_text.setAlignment(Alignment.CENTRE);
			   wcf_text.setWrap(true);	
			   ws.setRowView(0, 600); 
			   Label labelId = new Label(0, 0, "编号", wcf_title);
			   Label labelName = new Label(1, 0, "物品名称", wcf_title);
			   Label labelConsumables = new Label(2, 0, "是否消耗品", wcf_title);
			   Label labelState = new Label(3, 0, "状态", wcf_title);
			   Label labelStoretime = new Label(4, 0, "购入时间", wcf_title);
			   Label labelOrders = new Label(5, 0, "物品编号", wcf_title);
			   ws.addCell(labelId);
			   ws.addCell(labelName);
			   ws.addCell(labelConsumables);
			   ws.addCell(labelState);
			   ws.addCell(labelStoretime);
			   ws.addCell(labelOrders);
			   WritableFont wcf_font=(WritableFont) wcf_text.getFont(); 
			   WritableCellFormat wcf_numberfomart = new WritableCellFormat(wcf_font,NumberFormats.TEXT);
			   wcf_numberfomart.setBorder(Border.ALL, BorderLineStyle.THIN);
			   wcf_numberfomart.setVerticalAlignment(VerticalAlignment.CENTRE); 
			   wcf_numberfomart.setAlignment(Alignment.LEFT);
			   wcf_numberfomart.setWrap(true);
			   
			   for (int i = 0; i < list.size(); i++) {
				   ws.setRowView(i+1, 350); // 设置行高
				   int consumables = list.get(i).getConsumables();
				   int state = list.get(i).getState();
				   String str1 = "";
				   String str2 = "";
				   if(consumables == 1)
					   str1 = "是";
				   else 
					   str1 = "否";
				   if(state == 0)
					   str2 = "在库存";
				   else
					   str2 = "已借出";
				   Label labelId_i = new Label(0, i+1, i+1+"", wcf_text);
				   Label labelName_i = new Label(1, i+1, list.get(i).getName(), wcf_text);
				   Label labelConsumables_i = new Label(2, i+1, str1, wcf_text);
				   Label labelState_i = new Label(3, i+1, str2, wcf_text);
				   Label labelStoretime_i = new Label(4, i+1, list.get(i).getStortime()+"", wcf_text);
				   Label labelOrders_i = new Label(5, i+1, list.get(i).getOrders()+"", wcf_text);
				   ws.addCell(labelId_i);
				   ws.addCell(labelName_i);
				   ws.addCell(labelConsumables_i);
				   ws.addCell(labelState_i);
				   ws.addCell(labelStoretime_i);
				   ws.addCell(labelOrders_i);
			   }
			   wwb.write();
			   wwb.close();
			   
			   renderFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**导入Excel
	 * 
	 */
	public void  excelInto() {
		render("excelInto.html");
	}
	
	public void trueExcelInto() {
	
		String path = getSession().getServletContext().getRealPath(Preference.UPLOAD_DEVICE_DIR);
		UploadFile file = getFile("file", "/excel/");
		String type = file.getFileName().substring(file.getFileName().lastIndexOf("."));
		String fileName = System.currentTimeMillis() + type;
		String dest = path + "/" + fileName;
		file.getFile().renameTo(new File(dest));
        List<StuEntitys> listExcel = StuServices.getAllByExcel(dest);

		DBheplers db = new DBheplers();
		
		for (StuEntitys stuEntity : listExcel) {
				String[] str=new String[]{stuEntity.getName(),stuEntity.getConsumables(),stuEntity.getStortime()+"",stuEntity.getOrders()};
				db.AddU(str);
		}
		redirect("/admin");
	}
}
