package xc.tools.excel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class StuServices {

	public static List<StuEntitys> getAllByExcel(String file){
		
		List<StuEntitys> list=new ArrayList<StuEntitys>();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Workbook rwb=Workbook.getWorkbook(new File(file));
			Sheet rs=rwb.getSheet("Test Shee 1");
			int clos=rs.getColumns();
			int rows=rs.getRows();
			
			System.out.println(clos+" rows:"+rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 1; j < clos; j++) {

					String name=rs.getCell(j++, i).getContents();
					String consumables=rs.getCell(j++, i).getContents();
					String stortime=rs.getCell(j++, i).getContents();
					String orders=rs.getCell(j++, i).getContents();
					stortime = "20" + stortime;
					java.util.Date d1 = null;
					java.sql.Date date1;
					try {
						d1 = format.parse(stortime);
					} catch (Exception e) {
						
					}
					date1 = new java.sql.Date(d1.getTime()); 
					System.out.println(" name:"+name+" consumables:"+consumables +" stortime:"+stortime+" orders:"+orders);
					list.add(new StuEntitys(name, consumables, date1, orders));
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} 
		return list;
		
	}
	
	
}

