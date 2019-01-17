package xc.tools.excel;

import com.demo.common.model.Goods;

public class DBheplers {
	public int AddU(String str[]) {
		int a = 0;
		try {
			if (str != null) {
				String str1 = str[1];
				int temp;
				if(str1.equals("否")) {
					temp = 0;
				}
				else
					temp = 1;
					new Goods().set("name", str[0])
					.set("consumables", temp)
					.set("state", 0)
					.set("stortime", str[2])
					.set("orders", str[3]).save();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
}
