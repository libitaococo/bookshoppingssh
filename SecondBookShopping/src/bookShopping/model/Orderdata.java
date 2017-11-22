package bookShopping.model;

public class Orderdata {
      private long odid;
      private Pro pro;
    //  private Order order;
      private Integer sum;
      private long oid;
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public long getOdid() {
		return odid;
	}
	public void setOdid(long odid) {
		this.odid = odid;
	}
	public Pro getPro() {
		return pro;
	}
	public void setPro(Pro pro) {
		this.pro = pro;
	}
	
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}

}
