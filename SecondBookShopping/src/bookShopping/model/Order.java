package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class Order {
	private long oid;
	//private Integer oid;
	private float oprice;

	private Integer onum;
	private User user;
	
	//表示该订单下的订单详情
	//public Set<Order_data> getOrder_datas() {
		//return order_datas;
	//}
	//public void setOrder_datas(Set<Order_data> order_datas) {
	//	this.order_datas = order_datas;
	//}
	//Set<Order_data> order_datas=new HashSet<Order_data>();


	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public float getOprice() {
		return oprice;
	}
	public void setOprice(float oprice) {
		this.oprice = oprice;
	}


	public Integer getOnum() {
		return onum;
	}
	public void setOnum(Integer onum) {
		this.onum = onum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
