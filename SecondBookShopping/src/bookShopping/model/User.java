package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class User {
   private long uid;
   private String user;
   private String password;
   private String email;
   private String name;
   
   //表示该用户下的所以购物车
   private Set<Cart> carts=new HashSet<Cart>();

 
	
public Set<Cart> getCarts() {
	return carts;
}
public void setCarts(Set<Cart> carts) {
	this.carts = carts;
}
public long getUid() {
	return uid;
}
public void setUid(long uid) {
	this.uid = uid;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
