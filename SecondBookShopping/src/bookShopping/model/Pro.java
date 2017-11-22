package bookShopping.model;




import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

import com.mysql.jdbc.Blob;
import com.sun.mail.handlers.image_gif;


public class Pro {
     private long pid;
     private String pname;
     private String psn;
     private String pnum;
     private float mprice;
     private float vprice;
     private String pdesc;
     private Date pubtime;
     private String image;
  
	//表示商品所属的分类
     private Cate cate;
     
   //表示该商品下的所以评论
     private Set<Comment> comments=new HashSet<Comment>();
  
     public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	

     

	public Cate getCate() {
		return cate;
	}
	public void setCate(Cate cate) {
		this.cate = cate;
	}

	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsn() {
		return psn;
	}
	public void setPsn(String psn) {
		this.psn = psn;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public float getMprice() {
		return mprice;
	}
	public void setMprice(float mprice) {
		this.mprice = mprice;
	}
	public float getVprice() {
		return vprice;
	}
	public void setVprice(float vprice) {
		this.vprice = vprice;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
     
}
