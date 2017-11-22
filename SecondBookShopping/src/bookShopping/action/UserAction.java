package bookShopping.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.model.User;
import bookShopping.service.IUserService;
import bookShopping.tools.Pager;

//用户的action类
@Controller
public class UserAction extends BaseAction {
	private long uid;
	private String user;
    private String password;
    private String email;
    private String name;
    private int index;
  public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	//注入业务层类
    private IUserService userService;
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
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
    //用户列表的执行方法
	public String list(){
		 try{
	        	List<User> list=userService.list();
	        	putContext("list", list);
	        }catch(ShoppingException e){
	        	putContext("errorInfo", "获取用户列表失败！"+e.getMessage());
	        	return ERROR;
	        }
	        return LIST;
	}
	
	//用户列表分页的执行方法
			public String listByPage(){		
				int pageSize=4;			
				try {
					Pager<User> list=userService.listByPage(index, pageSize);
					double tc=list.getTotal();
					double num=Math.ceil(tc/pageSize);
					int totalpage=(int) num;
					putContext("list", list.getDatas());
					putContext("lists", list);
					putContext("index", index);
					putContext("totalpage", totalpage);
				} catch (ShoppingException e) {
					// TODO: handle exceptio
					putContext("errorInfo", "获取商品列表失败！"+e.getMessage());
		        	return ERROR;
				}
				return LIST;
			}
	
	//用户删除的执行方法
	public String delete(){
		try {
			userService.delete(uid);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "用户删除失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//获取用户的执行方法
	public String edit(){
		try {
			User u=userService.load(uid);
			putContext("u",u);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取用户失败！"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	
	//修改用户的执行方法
	public String save(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		u.setEmail(email);
		u.setUid(uid);
		try {
			userService.update(u);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "修改管理员失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//用户的登录执行的方法
	public String login(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		//调用业务层的类
		User existUser=userService.login(u);
		if(existUser==null){
			//登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
		
	}
	
	//用户注册的执行方法
	public String register(){
		User u=new User();
		u.setUser(user);
		u.setPassword(password);
		u.setEmail(email);
		u.setName(name);
		System.out.print(password);
		//调用业务层的类
		User existUser=userService.register(u);
		if(existUser==null){
			//注册成功
			userService.add(u);
			return INPUT;
		}else{
			//注册失败
			this.addActionError("用户名已存在！");
			return ERROR1;
		}
	}
	
	//登录退出的执行方法
	public String logout(){
		    ActionContext.getContext().getSession().remove("existUser");
			return INPUT;
	}
	

}
