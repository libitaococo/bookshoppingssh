package bookShopping.model;

public class Cart {
    private long ctid;
    private Integer cnum;
    private Pro pro;
    private User user;
	public long getCtid() {
		return ctid;
	}
	public void setCtid(long ctid) {
		this.ctid = ctid;
	}
	
	
	public Integer getCnum() {
		return cnum;
	}
	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}
	public Pro getPro() {
		return pro;
	}
	public void setPro(Pro pro) {
		this.pro = pro;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
}
