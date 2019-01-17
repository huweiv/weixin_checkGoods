package xc.tools.excel;

import java.util.Date;

public class StuEntitys {
	private int id;
	private String name;
	private String consumables;
	private Date stortime;
	private String orders;
	
	
	public StuEntitys() {
		
	}
	public StuEntitys(String name, String consumables, Date stortime, String orders) {
		this.name = name;
		this.consumables = consumables;
		this.stortime = stortime;
		this.orders = orders;
	}
	
	public String toString() {
		return "StuEntity [id=" + id + ", name=" + name + ", consumables=" + consumables + ", stortime=" + stortime + ", orders=" + orders + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getConsumables() {
		return consumables;
	}
	public void setConsumables(String consumables) {
		this.consumables= consumables;
	}

	public Date getStortime() {
		return stortime;
	}
	public void setStortime(Date stortime) {
		this.stortime = stortime;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}
	public String getOrders() {
		return orders;
	}

}
