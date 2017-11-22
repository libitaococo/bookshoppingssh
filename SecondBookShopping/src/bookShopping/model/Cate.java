package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class Cate {
    private long cid;
    private String cname;
    //在一方定义一个多方的集合
    //private Set<Pro> pros;
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
