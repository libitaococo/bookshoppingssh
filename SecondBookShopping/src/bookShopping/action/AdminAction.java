package bookShopping.action;

import java.util.List;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Pro;
import bookShopping.service.IAdminService;
import bookShopping.tools.Pager;


//管理员的action类
@Controller
public class AdminAction extends BaseAction{
	private long id;
	private String adminname;
	private String adminpassword;
	private int index;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

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

	//注入业务层类
	private IAdminService adminService;
	
	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	@Override
	//管理员列表的执行方法
	public String list(){
        try{
        	List<Admin> list=adminService.list();
        	putContext("list", list);
        }catch(ShoppingException e){
        	putContext("errorInfo", "获取管理员列表失败！"+e.getMessage());
        	return ERROR;
        }
        return LIST;
	}
	
	//管理员列表分页的执行方法
		public String listByPage(){		
			int pageSize=4;			
			try {
				Pager<Admin> list=adminService.listByPage(index, pageSize);
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
	
	//管理员添加的执行方法
	public String add(){
		try{
			Admin a=new Admin();
			a.setAdminname(adminname);
			a.setAdminpassword(adminpassword);
			adminService.add(a);
		}catch(ShoppingException e){
			putContext("errorInfo", "添加管理员失败！"+e.getMessage());
			return ERROR;
		}
	   return RELOAD;
	}
	
	//管理员删除的执行方法
	public String delete(){
		try{
			adminService.delete(id);
		}catch(ShoppingException e){
			putContext("error", "删除管理员失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	
	//获取管理员的执行方法
	public String edit(){
		try {
			Admin a=adminService.load(id);
			putContext("a",a);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "获取管理员失败！"+e.getMessage());
			return ERROR;
		}
		return EDIT;
	}
	//管理员修改的执行方法
	public String save(){
		Admin a=new Admin();
		a.setAdminname(adminname);
		a.setAdminpassword(adminpassword);
		a.setId(id);
		try {
			adminService.update(a);
		} catch (ShoppingException e) {
			// TODO: handle exception
			putContext("errorInfo", "修改管理员失败！"+e.getMessage());
			return ERROR;
		}
		return RELOAD;
	}
	//登录执行的方法
	public String login(){
		Admin a=new Admin();
		a.setAdminname(adminname);
		a.setAdminpassword(adminpassword);
		//调用业务层的类
		Admin existAdmin=adminService.login(a);
		if(existAdmin==null){
			//登录失败
			this.addActionError("用户名或密码错误！");
		    return INPUT;
			
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existAdmin",existAdmin);
			return SUCCESS;
		}
	}
	
	//登录退出的执行方法
	public String logout(){
		 ActionContext.getContext().getSession().remove("existAdmin");
	     return INPUT;
	}
	
}
