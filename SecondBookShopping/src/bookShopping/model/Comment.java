package bookShopping.model;

public class Comment {
 private long coid;
 private String content;
 private int score;
 //��ʾ�����������û�
 private User user;
 //��ʾ������������Ʒ
  private Pro pro;
  
public long getCoid() {
	return coid;
}
public void setCoid(long coid) {
	this.coid = coid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Pro getPro() {
	return pro;
}
public void setPro(Pro pro) {
	this.pro = pro;
}
 

}
