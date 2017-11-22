package bookShopping.model;

//管理员实体类
public class Admin {
   private long id;
   private String adminname;
   private String adminpassword;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getAdminpassword() {
	return adminpassword;
}
public void setAdminpassword(String adminpassword) {
	this.adminpassword = adminpassword;
}
}
