package domain;

public class ZhangWu {
	private int zwid;			    // id
	private String flname;			// 分类名称
	private double money;			// 账户名称
	private String zhanghu;			// 金额
	private String createtime;		// 创建时间
	private String description;		// 说明
	public ZhangWu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZhangWu(int zwid, String flname, double money, String zhanghu, String createtime, String description) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}
	public int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getZhangHu() {
		return zhanghu;
	}
	public void setZhangHu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return zwid+"\t\t"+flname+"\t\t"+money+"\t\t"+zhanghu+"\t\t"+createtime+"\t"+description;	 
	}
}
